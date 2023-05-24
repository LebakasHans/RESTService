package net.htlgkr.wintersteigerj.controller;

import net.htlgkr.wintersteigerj.dataservices.ServiceDataService;
import net.htlgkr.wintersteigerj.dtos.ServiceDTO;
import net.htlgkr.wintersteigerj.resourceclasses.ServiceResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/serviceBackend")
public class ServiceRestController {

    @Autowired
    private ServiceDataService serviceDataService;

    @GetMapping("/services")
    public ResponseEntity<List<ServiceDTO>> getAllServices() {
        ResponseEntity responseEntity = ResponseEntity.ok(serviceDataService.getAllServices());
        return responseEntity;
    }

    @PostMapping("/services")
    public ResponseEntity<ServiceResource> createNewService(@RequestBody ServiceDTO serviceDTO) {
        ServiceResource serviceResource = serviceDataService.createNewService(serviceDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(serviceResource);
    }

    @PutMapping("/services/{serviceId}")
    public ResponseEntity<ServiceResource> updateService(@PathVariable String serviceId, @RequestBody ServiceDTO serviceDTO) {
        ServiceResource serviceResource = ServiceDataService.convertDTOToResource(Integer.parseInt(serviceId), serviceDTO);
        boolean successfullyUpdated = serviceDataService.updateService(Integer.parseInt(serviceId), serviceResource);
        ResponseEntity<ServiceResource> responseEntity;
        if (successfullyUpdated) {
            responseEntity = ResponseEntity.status(HttpStatus.OK).body(serviceResource);
        } else {
            responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return responseEntity;
    }

    @DeleteMapping("/services/{serviceId}")
    public ResponseEntity<String> deleteService(@PathVariable String serviceId) {
        boolean successfullyDeleted = serviceDataService.deleteService(Integer.parseInt(serviceId));
        ResponseEntity<String> responseEntity;
        if (successfullyDeleted) {
            responseEntity = ResponseEntity.status(HttpStatus.OK).body("Resource successfully deleted");
        } else {
            responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource not found");
        }
        return responseEntity;
    }

    @GetMapping("/services/{serviceId}")
    public ResponseEntity<ServiceResource> getServiceById(@PathVariable String serviceId) {
        ServiceResource serviceResource = serviceDataService.getServiceById(Integer.parseInt(serviceId));
        ResponseEntity<ServiceResource> responseEntity;
        if (serviceResource != null) {
            responseEntity = ResponseEntity.status(HttpStatus.OK).body(serviceResource);
        } else {
            responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return responseEntity;
    }
}

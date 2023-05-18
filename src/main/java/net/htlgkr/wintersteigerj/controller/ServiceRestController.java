package net.htlgkr.wintersteigerj.controller;

import net.htlgkr.wintersteigerj.dataservices.ServiceDataService;
import net.htlgkr.wintersteigerj.dtos.ServiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @PostMapping(name = "/services",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void createNewService(@RequestBody ServiceDTO serviceDTO){

    }

    @PutMapping("/services/{serviceId}")
    public List<ServiceDTO> updateService() {
        return null;
    }

    @DeleteMapping("/services/{serviceId}")
    public List<ServiceDTO> deleteService() {
        return null;
    }

    @GetMapping("/services/{serviceId}")
    public ServiceDTO getServiceById() {
        return null;
    }


}

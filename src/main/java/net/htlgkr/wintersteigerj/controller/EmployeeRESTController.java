package net.htlgkr.wintersteigerj.controller;

import net.htlgkr.wintersteigerj.dataservices.EmployeeDataService;
import net.htlgkr.wintersteigerj.dtos.EmployeeDTO;
import net.htlgkr.wintersteigerj.resourceclasses.EmployeeResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/serviceBackend")
public class EmployeeRESTController {
    @Autowired
    private EmployeeDataService employeeDataService;

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeResource>> getAllEmployees() {
        ResponseEntity responseEntity = ResponseEntity.ok(employeeDataService.getAllEmployees());
        return responseEntity;
    }

    @PostMapping("/employees")
    public ResponseEntity<EmployeeResource> createNewEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeResource employeeResource = employeeDataService.createNewEmployee(employeeDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(employeeResource);
    }
}

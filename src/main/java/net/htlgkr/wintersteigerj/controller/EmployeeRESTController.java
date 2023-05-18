package net.htlgkr.wintersteigerj.controller;

import net.htlgkr.wintersteigerj.dataservices.EmployeeDataService;
import net.htlgkr.wintersteigerj.dtos.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/serviceBackend")
public class EmployeeRESTController {
    @Autowired
    private EmployeeDataService employeeDataService;

    @GetMapping("/employees")
    public List<EmployeeDTO> getAllEmployees() {
        return null;
    }

    @PostMapping("/employees")
    public List<EmployeeDTO> createNewEmployee() {
        return null;
    }
}

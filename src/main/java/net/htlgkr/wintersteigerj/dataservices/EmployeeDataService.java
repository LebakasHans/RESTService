package net.htlgkr.wintersteigerj.dataservices;

import net.htlgkr.wintersteigerj.dtos.EmployeeDTO;
import net.htlgkr.wintersteigerj.resourceclasses.EmployeeResource;

import java.util.Collection;
import java.util.HashMap;

public class EmployeeDataService {
    private final HashMap<Integer, EmployeeResource> employeeResources = new HashMap<>();

    public Collection<EmployeeResource> getAllEmployees() {
        return employeeResources.values();
    }

    public EmployeeResource createNewEmployee(EmployeeDTO employeeDTO) {
        int id = employeeResources.keySet().stream().max(Integer::compareTo).orElse(0) + 1;
        EmployeeResource createdRessource = convertDTOToResource(id, employeeDTO);
        employeeResources.put(id, createdRessource);
        return createdRessource;
    }

    private EmployeeResource convertDTOToResource(int id, EmployeeDTO employeeDTO) {
        return new EmployeeResource(id,
                employeeDTO.getName(),
                employeeDTO.getLongitude(),
                employeeDTO.getLatitude());
    }
}

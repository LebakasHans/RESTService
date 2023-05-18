package net.htlgkr.wintersteigerj.resourceclasses;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.htlgkr.wintersteigerj.dtos.EmployeeDTO;

@AllArgsConstructor
@Data
public class EmployeeResource {
    private int id;
    private String name;
    private String longitude;
    private String latitude;

    public EmployeeDTO convertToEmployeeDTO() {
        return new EmployeeDTO(name, longitude, latitude);
    }
}

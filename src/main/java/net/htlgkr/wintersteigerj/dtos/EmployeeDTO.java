package net.htlgkr.wintersteigerj.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EmployeeDTO {
    private String name;
    private String longitude;
    private String latitude;
}

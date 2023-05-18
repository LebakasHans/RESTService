package net.htlgkr.wintersteigerj.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ServiceDTO {
    private String name;
    private int employeeId;
    private String date;
    private String address;
}

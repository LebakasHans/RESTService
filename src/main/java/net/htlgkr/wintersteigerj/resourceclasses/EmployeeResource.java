package net.htlgkr.wintersteigerj.resourceclasses;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EmployeeResource {
    private int id;
    private String name;
    private String longitude;
    private String latitude;
}

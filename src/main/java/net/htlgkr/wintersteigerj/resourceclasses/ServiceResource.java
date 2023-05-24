package net.htlgkr.wintersteigerj.resourceclasses;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ServiceResource {
    private int id;
    private String name;
    private int employeeId;
    private String date;
    private String longitude;
    private String latitude;
}

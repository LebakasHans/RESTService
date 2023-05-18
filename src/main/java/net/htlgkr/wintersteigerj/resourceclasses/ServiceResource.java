package net.htlgkr.wintersteigerj.resourceclasses;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.htlgkr.wintersteigerj.dtos.ServiceDTO;

@AllArgsConstructor
@Data
public class ServiceResource {
    private int id;
    private String name;
    private int employeeId;
    private String date;
    private String longitude;
    private String latitude;

    public ServiceDTO convertToServiceDTO() {
        String address = "lat: " + latitude + ", long: " + longitude; //TODO reverse Geocoding(probably not needed)
        return new ServiceDTO(name, employeeId, date, address);

    }
}

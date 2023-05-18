package net.htlgkr.wintersteigerj.dataservices;

import net.htlgkr.wintersteigerj.dtos.ServiceDTO;
import net.htlgkr.wintersteigerj.resourceclasses.ServiceResource;

import java.util.HashMap;
import java.util.List;

public class ServiceDataService {
    HashMap<Integer, ServiceResource> serviceResources = new HashMap<>();

    public List<ServiceDTO> getAllServices() {
        return serviceResources.values().stream().map(ServiceResource::convertToServiceDTO).toList();
    }

    public List<ServiceDTO> createNewService() {
        return null;
    }

}

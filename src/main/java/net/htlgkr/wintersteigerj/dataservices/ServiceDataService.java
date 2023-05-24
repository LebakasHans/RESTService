package net.htlgkr.wintersteigerj.dataservices;

import net.htlgkr.wintersteigerj.dtos.ServiceDTO;
import net.htlgkr.wintersteigerj.resourceclasses.ServiceResource;

import java.util.Collection;
import java.util.HashMap;

public class ServiceDataService {
    private final HashMap<Integer, ServiceResource> serviceResources = new HashMap<>();

    public Collection<ServiceResource> getAllServices() {
        return serviceResources.values();
    }

    public ServiceResource createNewService(ServiceDTO serviceDTO) {
        int id = serviceResources.keySet().stream().max(Integer::compareTo).orElse(0) + 1;
        ServiceResource createdRessource = convertDTOToResource(id, serviceDTO);
        serviceResources.put(id, createdRessource);
        return createdRessource;
    }

    public static ServiceResource convertDTOToResource(int id, ServiceDTO serviceDTO) {
        return new ServiceResource(id,
                serviceDTO.getName(),
                serviceDTO.getEmployeeId(),
                serviceDTO.getDate(),
                serviceDTO.getAddress().split(",")[0], //TODO geocoding (probably not needed)
                serviceDTO.getAddress().split(",")[1]);
    }

    public static ServiceDTO convertResourceToDTO(ServiceResource serviceResource) {
        String address = serviceResource.getLatitude() + "," + serviceResource.getLongitude(); //TODO reverse Geocoding(probably not needed)
        return new ServiceDTO(serviceResource.getName(), serviceResource.getEmployeeId(), serviceResource.getDate(), address);
    }

    public boolean updateService(int serviceId, ServiceResource serviceResource) {
        if (serviceResources.containsKey(serviceId)) {
            serviceResources.put(serviceId, serviceResource);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteService(int serviceId) {
        if (serviceResources.containsKey(serviceId)) {
            serviceResources.remove(serviceId);
            return true;
        } else {
            return false;
        }
    }

    public ServiceResource getServiceById(int serviceId) {
        return serviceResources.get(serviceId);
    }
}

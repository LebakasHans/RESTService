package net.htlgkr.wintersteigerj;

import net.htlgkr.wintersteigerj.dataservices.EmployeeDataService;
import net.htlgkr.wintersteigerj.dataservices.ServiceDataService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public EmployeeDataService employeeDataService() {
        return new EmployeeDataService(); //TODO maybe make global static variable instead idk
    }

    @Bean
    public ServiceDataService serviceDataService() {
        return new ServiceDataService(); //TODO maybe make global static variable instead idk
    }
}

package org.ibs.example.config;

import lombok.extern.slf4j.Slf4j;
import org.ibs.example.bussines.GreetingService;
import org.ibs.example.bussines.GreetingServiceImpl;
import org.ibs.example.domain.Employee;
import org.ibs.example.repository.EmployeeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Slf4j
public class GreetingServiceConfig {

// Dependency Injection (внедрение зависимости) -
// этот класс является бином, который имплементирует интерфейс GreetingService
// Мы сами написали бин
    @Bean
    @Profile("!test")
    GreetingService getGrSerImpl() {
        return new GreetingServiceImpl(log);
    }

    @Bean
    @Profile("test")
    GreetingService getGrSerImpl2() {
        return new GreetingServiceImpl(log);
    }

    @Bean
    Employee makeDefEmpl() {
        return new Employee(null,"Саня", null, null, null, null, null, null);
    }
}

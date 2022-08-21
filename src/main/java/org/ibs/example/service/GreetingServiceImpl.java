package org.ibs.example.service;

import org.ibs.example.entity.Employee;
import org.slf4j.Logger;

public class GreetingServiceImpl implements GreetingService {

    private Logger log;

    public GreetingServiceImpl(Logger log) {
        this.log = log;
    }

    @Override
    public void sayHello(Employee employee) {
        log.info("Hello" + employee.getFirstName());
    }
}

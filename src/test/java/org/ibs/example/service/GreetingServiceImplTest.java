package org.ibs.example.service;

import org.ibs.example.entity.Employee;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
class GreetingServiceImplTest {

    @Autowired
    GreetingService gs;

    @Autowired
    Employee employee;


    @Test
    void sayHello() {
        gs.sayHello(employee);
    }
}
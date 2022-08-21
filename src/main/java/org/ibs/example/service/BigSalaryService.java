package org.ibs.example.service;

import org.ibs.example.entity.Employee;
import org.ibs.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BigSalaryService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Iterable<Employee> getBigSalary() {
        List<Employee> list = new ArrayList<>();
        for (Employee employee : employeeRepository.findAll()) {
            list.add(employee);
        }
        return list.stream().filter(i -> i.getBoss() != null && (i.getMonthSalary() > i.getBoss().getMonthSalary())).collect(Collectors.toList());
    }
}

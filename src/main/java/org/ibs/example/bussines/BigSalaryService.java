package org.ibs.example.bussines;

import org.ibs.example.domain.Employee;
import org.ibs.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BigSalaryService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Iterable<Employee> getBigSalary() {
        List<Employee> list = new ArrayList<>();
        for (Employee employee : employeeRepository.findAll()) {
            try {
                if ((employee.getMonthSalary() > employeeRepository.findById(employee.getBoss().getId()).get().getMonthSalary())
                        && (employeeRepository.findById(employee.getBoss().getId()).get() != null)) {
                    list.add(employee);
                }
            } catch (NullPointerException exception) {
                System.out.println(exception);
            }
        }
        return list;
    }
}

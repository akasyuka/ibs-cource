package org.ibs.example.service;

import org.ibs.example.entity.Department;
import org.ibs.example.entity.Employee;
import org.ibs.example.entity.dto.mapper.EmployeeMapper;
import org.ibs.example.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SalaryService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    public Optional<org.ibs.example.entity.dto.Employee> maxSalaryEmployeeInDepartment(Integer departmentId) {
        Optional<Department> departmentOptional = departmentRepository.findById(departmentId);
        if (departmentOptional.isEmpty() || departmentOptional.get().getEmployees().isEmpty()) {
            return Optional.empty();
        }

        Employee employee = departmentOptional.get().getEmployees().stream()
                .max((e1,e2) -> e1.getMonthSalary().compareTo(e2.getMonthSalary())).get();
        return Optional.of(employeeMapper.toDto(employee));
    }
}

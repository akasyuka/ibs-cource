package org.ibs.example.rest.v2;

import org.ibs.example.domain.Employee;
import org.ibs.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;


@RestController("emp v2")
@RequestMapping("/v2/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    //////Практическое задание
    ////получить список непосредственных подчиненных сотрудника
    //16
    @GetMapping("/subordinates/{id}")
    Iterable<Employee> getSubordinates(@PathVariable Integer id) {
        return employeeRepository.findAllByBossId(id);
    }

    ////получить непосредственного руководителя сотрудника
    //17 work!
    @GetMapping("/supervisor/{id}")
    Employee getBoss(@PathVariable Integer id) {
        return employeeRepository.findById(employeeRepository.findById(id).get().getBoss().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    ////список сотрудников получающих больший месячный оклад, чем их руководители (зарплатный сервис)
    @GetMapping("/bigsalary")
    Iterable<Employee> getSubordinatesMaxSalary() {
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
    //////

    @GetMapping
    Iterable<Employee> getAll(@RequestParam(required = false) String firstName) {
        if (firstName == null) {
            return employeeRepository.findAll();
        } else
            return employeeRepository.findAllByFirstName(firstName);
    }

    @PostMapping
    Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/{id}")
    Employee getById(@PathVariable Integer id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    void deleteEmployee(@PathVariable Integer id) {
        employeeRepository.deleteById(id);
    }

}

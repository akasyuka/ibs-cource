package org.ibs.example.controller.v2;

import org.ibs.example.service.BigSalaryService;
import org.ibs.example.entity.Employee;
import org.ibs.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController("emp v2")
@RequestMapping("/v2/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BigSalaryService bigsalaryService;

    @GetMapping("/{id}/subordinates")
    Iterable<Employee> getSubordinates(@PathVariable Integer id) {
        return employeeRepository.findAllByBossId(id);
    }

    @GetMapping("/{id}/supervisor")
    Employee getBoss(@PathVariable Integer id) {

        return employeeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Boss не найден"));
    }

    @GetMapping("/bigsalary")
    Iterable<Employee> getSubordinatesMaxSalary() {
        return bigsalaryService.getBigSalary();
    }

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

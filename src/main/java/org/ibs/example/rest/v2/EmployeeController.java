package org.ibs.example.rest.v2;

import org.ibs.example.domain.Employee;
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

    //////Практическое задание
    ////получить список непосредственных подчиненных сотрудника
    //находим сотрудника по id, узнаем boss_id
    //находим всех сотрудников у кого boss_id такой же
    @GetMapping("/subordinates/{id}")
    Iterable<Employee> getSubordinates(@PathVariable Integer id) {
        Integer bossId = employeeRepository.findById(id).get().getBoss().getId();
        if (bossId == null) {
            return null;
        } else {
            return employeeRepository.findAllByBoss(bossId);
        }
    }
    ////получить непосредственного руководителя сотрудника
    //находим по boss_id равному id сотрудника

    ////список сотрудников получающих больший месячный оклад, чем их руководители (зарплатный сервис)
    //если зарплата выше чем зарплата (находим по boss_id равному id сотрудника) значит сохраняем в список

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

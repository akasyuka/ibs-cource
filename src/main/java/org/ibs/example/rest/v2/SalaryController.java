package org.ibs.example.rest.v2;

import org.ibs.example.bussines.SalaryService;
import org.ibs.example.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/v2/salary/max/")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @GetMapping("department/{departmentId}")
    Employee maxSalaryEmployeeDepartmentId(@PathVariable Integer departmentId) {
        return salaryService.maxSalaryEmployeeInDepartment(departmentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Department or employee not found"));
    }

}

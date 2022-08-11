package org.ibs.example.repository;

import org.ibs.example.domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    Optional<Employee> findByFirstName(String firstName);
    List<Employee> findAllByFirstName(String firstName);

    //получить список непосредственных подчиненных сотрудника
    List<Employee> findAllByBoss(Integer boss);
    //получить непосредственного руководителя сотрудника
    //список сотрудников получающих больший месячный оклад, чем их руководители (зарплатный сервис)

}

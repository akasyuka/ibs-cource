package org.ibs.example.repository;

import org.ibs.example.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    Optional<Employee> findByFirstName(String firstName);

    Optional<Employee> findByBoss(int boss);

    List<Employee> findAllByFirstName(String firstName);

    //получить список непосредственных подчиненных сотрудника
    List<Employee> findAllByBossId(Integer boss);
    //получить непосредственного руководителя сотрудника
    //список сотрудников получающих больший месячный оклад, чем их руководители (зарплатный сервис)

}

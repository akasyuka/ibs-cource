package org.ibs.example;

import org.ibs.example.entity.Course;
import org.ibs.example.entity.Department;
import org.ibs.example.entity.Employee;
import org.ibs.example.repository.EmployeeRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(value = false)
@ActiveProfiles("test")
class DbTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    EmployeeRepository employeeRepository;

    @BeforeEach
    void setup() {
        Department department = new Department(null, "IT", null);
        Course course = new Course(null,"REST service");
        Employee employee = new Employee(null, "а", "б", LocalDate.now(),
                                            department, 500,null, List.of(course));
        em.persist(department);
        em.persist(course);
        em.persist(employee);
    }

    @Test
    void test() {
        Assert.assertEquals(1, em.createQuery("From Department").getResultList().size());
        Employee employee = em.createQuery("From Employee",Employee.class).setMaxResults(1).
                                                                                  getResultList().
                                                                                  get(0);
        Assert.assertEquals("REST service", employee.getCourses().get(0).getName());
    }

    @Test
    void test2() {
        Employee employee = employeeRepository.findByFirstName("а").get();
        Assert.assertEquals("REST service", employee.getCourses().get(0).getName());
    }
}

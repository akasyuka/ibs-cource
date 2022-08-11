package org.ibs.example;

import org.ibs.example.domain.Course;
import org.ibs.example.domain.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(value = false)
class DbTest {

    @PersistenceContext
    EntityManager em;

    @BeforeEach
    void setup() {
        Department department = new Department(null, "IT");
        Course course = new Course(null,"REST service");
        em.persist(department);
        em.persist(course);
    }

    @Test
    void test() {}
}

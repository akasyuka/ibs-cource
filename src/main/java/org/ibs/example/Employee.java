package org.ibs.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ibs.example.domain.Course;
import org.ibs.example.domain.Department;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Lob
    @Column(name = "first_name")
    private String firstName;

    @Lob
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birthday")
    private LocalDate birthday;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(name = "month_salary")
    private Integer monthSalary;

    @Column(name = "boss_id")
    private Integer bossId;

    @ManyToMany
    @JoinTable(name = "employee_course",
                joinColumns = @JoinColumn(name="employee_id"),
                inverseJoinColumns = @JoinColumn(name="course_id"))
    private List<Course> courses;


}
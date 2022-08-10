package org.ibs.example.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "course")
public class Course {
    @Id
    @Column(name = "id")
    private Integer id;

    @Lob
    @Column(name = "name")
    private String name;

}
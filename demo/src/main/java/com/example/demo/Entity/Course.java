package com.example.demo.Entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Course")
@NamedQueries(value = {
        @NamedQuery(name = "get_all_courses",query = "SELECT c FROM Course c"),
        @NamedQuery(name = "get_courses_like_a",query = "SELECT c FROM Course c WHERE c.name like '%a%'")
})
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name",nullable = false)
    private  String name;

    @UpdateTimestamp
    private LocalDate lastUpdate;

    @CreationTimestamp
    private LocalDate createDate;

    public Course(String name) {
        this.name=name;
    }
}

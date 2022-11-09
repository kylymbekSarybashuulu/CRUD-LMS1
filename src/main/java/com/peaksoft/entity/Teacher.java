package com.peaksoft.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "teacher")
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column
    private String email;

    @OneToOne(cascade = {CascadeType.REFRESH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.DETACH},fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @Transient
    private Long courseId;
}

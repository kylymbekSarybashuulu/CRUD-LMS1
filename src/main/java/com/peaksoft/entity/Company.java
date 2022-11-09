package com.peaksoft.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "company")
@Getter
@Setter
@ToString
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "")
    @SequenceGenerator(name = "company_generator",
    sequenceName = "company_sequence",
    allocationSize = 1)
    private long id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "locate_Country")
    private String locateCountry;

    @OneToMany(cascade = {CascadeType.ALL},
    mappedBy = "company")
    private List<Course> courseList;

    public Company() {
    }

    public Company(String companyName, String locateCountry) {
        this.companyName = companyName;
        this.locateCountry = locateCountry;
    }


}

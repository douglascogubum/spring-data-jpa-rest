package com.genekz.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "unity")
public class Unity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String address;

    @ManyToMany(mappedBy = "unities", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Employee> employees;
}

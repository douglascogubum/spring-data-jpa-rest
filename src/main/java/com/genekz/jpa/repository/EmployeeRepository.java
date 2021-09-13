package com.genekz.jpa.repository;

import com.genekz.jpa.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    //devirated query
    Optional<List<Employee>> findByName(final String name);
}

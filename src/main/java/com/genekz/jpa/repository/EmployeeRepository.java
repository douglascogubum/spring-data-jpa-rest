package com.genekz.jpa.repository;

import com.genekz.jpa.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    //derived query
    List<Employee> findByName(final String name);

    //jpql
    @Query("SELECT e FROM Employee e WHERE e.name = :name AND e.salary >= :salary AND e.hiringDate = :hiringDate")
    List<Employee> findNameSalaryGreaterHiringDate(final String name, final BigDecimal salary, final LocalDate hiringDate);

    //native query
    @Query(value = "SELECT * FROM employees e WHERE e.hiring_date >= :hiringDate",
            nativeQuery = true)
    List<Employee> findHiringDate(final LocalDate hiringDate);
}

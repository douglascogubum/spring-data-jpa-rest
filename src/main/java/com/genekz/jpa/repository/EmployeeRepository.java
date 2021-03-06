package com.genekz.jpa.repository;

import com.genekz.jpa.model.Employee;
import com.genekz.jpa.model.EmployeeProjection;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {

    //derived query
    List<Employee> findByName(final String name);

    //jpql
    @Query("SELECT e FROM Employee e WHERE e.name = :name AND e.salary >= :salary AND e.hiringDate = :hiringDate")
    List<Employee> findNameSalaryGreaterHiringDate(final String name, final BigDecimal salary, final LocalDate hiringDate);

    //native query
    @Query(value = "SELECT * FROM employees e WHERE e.hiring_date >= :hiringDate",
            nativeQuery = true)
    List<Employee> findHiringDate(final LocalDate hiringDate);

    @Query(value = "SELECT e.id, e.name, e.salary FROM employees e", nativeQuery = true)
    List<EmployeeProjection> findEmployeeSalary();
}

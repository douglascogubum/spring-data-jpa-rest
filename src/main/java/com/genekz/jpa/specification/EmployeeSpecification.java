package com.genekz.jpa.specification;

import com.genekz.jpa.model.Employee;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeSpecification {

    public static Specification<Employee> name (final String name) {
        return ((root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get("name"), "%" + name + "¨%"));
    }

    public static Specification<Employee> cpf (final String cpf) {
        return ((root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("cpf"), cpf ));
    }

    public static Specification<Employee> salary (final BigDecimal salary) {
        return ((root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.greaterThan(root.get("salary"), salary));
    }

    public static Specification<Employee> hiringDate (final LocalDate hiringDate) {
        return ((root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.greaterThan(root.get("hiringDate"), hiringDate));
    }
}

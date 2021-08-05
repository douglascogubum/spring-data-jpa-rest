package com.genekz.jpa.service;

import com.genekz.jpa.domain.RoleExceptionCode;
import com.genekz.jpa.exception.RoleException;
import com.genekz.jpa.model.Roles;
import com.genekz.jpa.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository repository;

    public Roles saveOrUpdate(final Roles role) {
        return repository.save(role);
    }

    public Roles findById(final Long id) {
        return repository.findById(id).orElseThrow(() -> new RoleException(RoleExceptionCode.ROLE_EXCEPTION_CODE001.getDescription()));
    }
}

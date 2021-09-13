package com.genekz.jpa.service;

import com.genekz.jpa.domain.enums.RoleExceptionCode;
import com.genekz.jpa.exception.RoleException;
import com.genekz.jpa.model.Role;
import com.genekz.jpa.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository repository;

    public Role saveOrUpdate(final Role role) {
        return repository.save(role);
    }

    public Role findById(final Long id) {
        return repository.findById(id).orElseThrow(() -> new RoleException(RoleExceptionCode.ROLE_EXCEPTION_CODE001.getDescription()));
    }

    public void deleteById(final Long id) {
        try {
            repository.deleteById(id);
        } catch(Exception ex) {
            throw new RoleException(RoleExceptionCode.ROLE_EXCEPTION_CODE002.getDescription());
        }
    }
}

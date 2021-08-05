package com.genekz.jpa.service;

import com.genekz.jpa.model.Roles;
import com.genekz.jpa.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository repository;

    public Roles save(final Roles role) {
        return repository.save(role);
    }
}

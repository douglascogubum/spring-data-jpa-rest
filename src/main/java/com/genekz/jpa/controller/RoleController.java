package com.genekz.jpa.controller;

import com.genekz.jpa.model.Roles;
import com.genekz.jpa.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RoleController {

    private final RoleService roleService;

    @PostMapping("/role/save")
    public ResponseEntity<Roles> save(@RequestBody Roles role) {
        return ResponseEntity.ok(roleService.save(role));
    }
}

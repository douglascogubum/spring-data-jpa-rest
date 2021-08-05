package com.genekz.jpa.controller;

import com.genekz.jpa.model.Roles;
import com.genekz.jpa.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RoleController {

    private final RoleService roleService;

    @PostMapping("/role/save")
    public ResponseEntity<Roles> saveOrUpdate(@RequestBody Roles role) {
        return ResponseEntity.ok(roleService.saveOrUpdate(role));
    }

    @GetMapping("/role/find/{id}")
    public ResponseEntity<Roles> findById(@PathVariable final String id) {
        return ResponseEntity.ok(roleService.findById(Long.parseLong(id)));
    }
}

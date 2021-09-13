package com.genekz.jpa.controller;

import com.genekz.jpa.model.Role;
import com.genekz.jpa.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("role")
public class RoleController {

    private final RoleService roleService;

    @PostMapping("/save")
    public ResponseEntity<Role> saveOrUpdate(@RequestBody Role role) {
        return ResponseEntity.ok(roleService.saveOrUpdate(role));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Role> findById(@PathVariable final Long id) {
        return ResponseEntity.ok(roleService.findById(id));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable final Long id) {
        roleService.deleteById(id);
    }
}

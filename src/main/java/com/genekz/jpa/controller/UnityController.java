package com.genekz.jpa.controller;

import com.genekz.jpa.model.Unity;
import com.genekz.jpa.service.UnityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("unity")
public class UnityController {

    private final UnityService unityService;

    @PostMapping("/save")
    public ResponseEntity<Unity> saveOrUpdate(@RequestBody Unity unity) {
        return ResponseEntity.ok(unityService.saveOrUpdate(unity));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Unity> findById(@PathVariable final Long id) {
        return ResponseEntity.ok(unityService.findById(id));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable final Long id) {
        unityService.deleteById(id);
    }
}

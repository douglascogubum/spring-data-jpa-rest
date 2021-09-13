package com.genekz.jpa.service;

import com.genekz.jpa.domain.enums.UnityExceptionCode;
import com.genekz.jpa.exception.UnityException;
import com.genekz.jpa.model.Unity;
import com.genekz.jpa.repository.UnityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UnityService {

    private final UnityRepository repository;

    public Unity saveOrUpdate(final Unity unity) {
        return repository.save(unity);
    }

    public Unity findById(final Long id) {
        return repository.findById(id).orElseThrow(() -> new UnityException(UnityExceptionCode.UNITY_EXCEPTION_CODE001.getDescription()));
    }

    public void deleteById(final Long id) {
        try {
            repository.deleteById(id);
        } catch(Exception ex) {
            throw new UnityException(UnityExceptionCode.UNITY_EXCEPTION_CODE002.getDescription());
        }
    }
}

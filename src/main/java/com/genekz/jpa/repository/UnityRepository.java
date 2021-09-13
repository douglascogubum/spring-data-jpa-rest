package com.genekz.jpa.repository;

import com.genekz.jpa.model.Unity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnityRepository extends CrudRepository<Unity, Long> {
}

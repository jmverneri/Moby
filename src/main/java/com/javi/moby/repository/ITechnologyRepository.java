package com.javi.moby.repository;

import com.javi.moby.entity.model.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITechnologyRepository extends JpaRepository<Technology, Long> {
}

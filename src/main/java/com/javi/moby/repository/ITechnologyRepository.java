package com.javi.moby.repository;

import com.javi.moby.entity.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITechnologyRepository extends JpaRepository<Technology, Long> {
}

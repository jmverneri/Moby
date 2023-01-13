package com.javi.moby.repository;

import com.javi.moby.entity.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICandidateRepository extends JpaRepository<Candidate, Long> {
    Candidate findByIdNumber(String dni);
}

package com.javi.moby.repository;

import com.javi.moby.entity.CandidateXTechnology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICandidateXTechnologyRepository extends JpaRepository<CandidateXTechnology, Long> {
    @Query(value = "SELECT cxt.id_candidate_x_tec, cxt.id_candidate, cxt.id_technology, cxt.experience"
            + " FROM candidate_x_tec cxt "
            + " INNER JOIN technologies t ON cxt.id_technology = t.id_technology"
            + " WHERE t.tecnamre LIKE ?", nativeQuery = true)
    List<CandidateXTechnology> findCandidatesXTecByTecName(String technologyName);
}

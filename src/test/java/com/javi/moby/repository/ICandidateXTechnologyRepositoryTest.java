package com.javi.moby.repository;

import com.javi.moby.entity.model.Candidate;
import com.javi.moby.entity.model.CandidateXTechnology;
import com.javi.moby.entity.model.Technology;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class ICandidateXTechnologyRepositoryTest {

    @Autowired
    private ICandidateXTechnologyRepository underTest;
    @Autowired
    private ICandidateRepository underTestCandidate;
    @Autowired
    private ITechnologyRepository underTestTechnology;

    @Test
    void findCandidatesXTecByTecNameTest() {

        Candidate candidate = new Candidate(1L, "Javier", "Martinez",
                "DNI", "32482903", null);
        underTestCandidate.save(candidate);

        Technology technology = new Technology(1L, "Java", "3.0");
        underTestTechnology.save(technology);

        CandidateXTechnology candidateXTechnology = new CandidateXTechnology(1L,
                candidate, technology, 8);

        underTest.save(candidateXTechnology);

        List<CandidateXTechnology> result = underTest.findCandidatesXTecByTecName("Ja");

        assertThat(result).isNotNull();
    }

    @Test
    void notFindCandidatesXTecByTecNameTest() {

        Candidate candidate = new Candidate(1L, "Javier", "Martinez",
                "DNI", "32482903", null);
        underTestCandidate.save(candidate);

        Technology technology = new Technology(1L, "Java", "3.0");
        underTestTechnology.save(technology);

        CandidateXTechnology candidateXTechnology = new CandidateXTechnology(1L,
                candidate, technology, 8);

        underTest.save(candidateXTechnology);

        List<CandidateXTechnology> result = underTest.findCandidatesXTecByTecName("Python");

        assertThat(result).isNull();
    }
}
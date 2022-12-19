package com.javi.moby;

import com.javi.moby.entity.Candidate;
import com.javi.moby.repository.ICandidateRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class CandidateRepositoryTest {
    private ICandidateRepository iCandidateRepository;

    @Test
    public void saveCandidateTest(){
        Candidate candidate = new Candidate();

        candidate.setFirstName("Javier");
        candidate.setSurname("Martinez");
        candidate.setIdentityType("DNI");
        candidate.setIdNumber("32444777");

        iCandidateRepository.save(candidate);

        Assertions.assertThat(candidate.getIdCandidate()).isGreaterThan(0);
    }

    public void getCandidateTest(){
        Candidate candidate = iCandidateRepository.findById(1L).get();

        Assertions.assertThat(candidate.getIdCandidate()).isEqualTo(1L);
    }
}

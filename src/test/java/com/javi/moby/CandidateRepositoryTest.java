package com.javi.moby;

import com.javi.moby.entity.Candidate;
import com.javi.moby.repository.ICandidateRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class CandidateRepositoryTest {
    private ICandidateRepository iCandidateRepository;

    @Test
    public void saveCandidateTest(){
        Candidate candidate = new Candidate();
    }
}

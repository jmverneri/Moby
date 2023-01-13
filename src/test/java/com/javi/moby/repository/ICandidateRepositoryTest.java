package com.javi.moby.repository;

import com.javi.moby.entity.model.Candidate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class ICandidateRepositoryTest {

    @Autowired
    private ICandidateRepository underTest;

    @Test
    void itShouldFindByIdNumber() {

        //given
        String idNum = "32482903";
        Candidate candidate = new Candidate(1L,
                "Javier",
                "Martinez",
                "DNI",
                "32482903",
                null);

        underTest.save(candidate);
        //when
        Candidate result = underTest.findByIdNumber(idNum);

        //then
        assertThat(result).isEqualTo(candidate);
    }

    @Test
    void itShouldNotFindByIdNumber() {

        //given
        String idNum = "32482903";

        //when
        Candidate result = underTest.findByIdNumber(idNum);

        //then
        assertThat(result).isNull();
    }
}
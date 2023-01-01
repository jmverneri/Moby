package com.javi.moby.serviceImpl;

import com.javi.moby.entity.CandidateXTechnology;
import com.javi.moby.entity.Technology;
import com.javi.moby.repository.ICandidateXTechnologyRepository;
import com.javi.moby.repository.ITechnologyRepository;
import com.javi.moby.service.ICandidateXTecService;
import com.javi.moby.service.ITechnologyService;
import com.javi.moby.service.impl.CandidateXTecServiceImpl;
import com.javi.moby.service.impl.TechnologyServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.List;

import static com.javi.moby.testUtils.TestEntityFactory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = CandidateXTecServiceImplTest.class)
public class CandidateXTecServiceImplTest {
    @InjectMocks
    CandidateXTecServiceImpl candidateXTecServiceImpl;

    @Mock
    ICandidateXTechnologyRepository candidateXTechnologyRepository;

    @MockBean
    ICandidateXTecService candidateXTecService;

    @Test
    @WithMockUser
    void saveTechnologyTest(){
        CandidateXTechnology candidateXTechnology = candidateXTecServiceImpl
                .saveCandidateXTec(getCandidateXTechnology());

        assertEquals(getCandidateXTechnology(), candidateXTechnology);
    }

    @Test
    @WithMockUser
    void listTechnologiesTest(){
        when(candidateXTechnologyRepository.findAll()).thenReturn(getCandidateXTechnologyList());

        List<CandidateXTechnology> list = candidateXTecServiceImpl.listCandidatesXTec();

        assertEquals(getCandidateXTechnologyList(), list);
    }

}

package com.javi.moby.serviceImpl;

import com.javi.moby.entity.Candidate;
import com.javi.moby.entity.CandidateXTechnology;
import com.javi.moby.repository.ICandidateRepository;
import com.javi.moby.repository.ICandidateXTechnologyRepository;
import com.javi.moby.service.ICandidateService;
import com.javi.moby.service.impl.CandidateServiceImpl;

import org.junit.jupiter.api.Test;

import org.mockito.*;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.ArrayList;
import java.util.List;

import static com.javi.moby.testUtils.TestEntityFactory.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@WebMvcTest(controllers = CandidateServiceImpl.class)
public class CandidateServiceImplTest {
    @InjectMocks
    CandidateServiceImpl candidateServiceImpl;

    @Mock
    ICandidateRepository candidateRepository;

    @Mock
    ICandidateXTechnologyRepository candidateXTechnologyRepository;

    @MockBean
    ICandidateService candidateService;

    /********************It fails******************************/
    @Test
    @WithMockUser
    void saveCandidateTest(){

        Candidate candidate = candidateServiceImpl.saveCandidate(getCandidateWithoutId());

        assertEquals(getCandidateWithId(), candidate);

    }

    @Test
    @WithMockUser
    void listCandidatesTest(){
        when(candidateRepository.findAll()).thenReturn(getCandidateListWithId());

        List<Candidate> list = candidateServiceImpl.listCandidates();

        assertEquals(getCandidateListWithId(), list);
    }

    @Test
    @WithMockUser
    void deleteByIdTest(){
        candidateServiceImpl.deleteById(ID_CANDIDATE);
        verify(candidateRepository, times(1)).deleteById(ID_CANDIDATE);
    }

    /********************It fails******************************/
    @Test
    @WithMockUser
    void listCandidatesByTecTest(){
        when(candidateXTechnologyRepository.findCandidatesXTecByTecName(TEC_NAME))
                .thenReturn(getCandidateXTechnologyList());

        List<CandidateXTechnology> list = candidateServiceImpl.listCandidatesByTec(TEC_NAME);
    }

    /********************It fails******************************/
    @Test
    @WithMockUser
    void searchCandidateByIdNumberTest(){
        Candidate candidate = candidateServiceImpl.searchCandidateByIdNumber(DNI_CANDIDATE);

        assertEquals(getCandidateWithId(), candidate);
    }
}

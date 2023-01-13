package com.javi.moby.serviceImpl;

import com.javi.moby.entity.model.Candidate;
import com.javi.moby.entity.model.CandidateXTechnology;
import com.javi.moby.repository.ICandidateRepository;
import com.javi.moby.repository.ICandidateXTechnologyRepository;
import com.javi.moby.service.ICandidateService;
import com.javi.moby.service.impl.CandidateServiceImpl;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.List;

import static com.javi.moby.testUtils.TestEntityFactory.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;


@WebMvcTest(controllers = CandidateServiceImpl.class)
@ExtendWith(MockitoExtension.class)
public class CandidateServiceImplTest {
    @InjectMocks
    private CandidateServiceImpl underTest;

    @Mock
    private ICandidateRepository candidateRepository;

    @Mock
    private ICandidateXTechnologyRepository candidateXTechnologyRepository;

    @MockBean
    private ICandidateService candidateService;

    @Test
    @WithMockUser
    void saveCandidateTest(){

        //given
        Candidate candidate = getCandidateWithoutId();

        //when
        underTest.saveCandidate(candidate);

        //then
        ArgumentCaptor<Candidate> candidateArgumentCaptor = ArgumentCaptor.forClass(Candidate.class);

        verify(candidateRepository).save(candidateArgumentCaptor.capture());

        Candidate capturedCandidate = candidateArgumentCaptor.getValue();

        assertThat(capturedCandidate).isEqualTo(candidate);

    }

    @Test
    void listCandidatesTest(){
        /*when(candidateRepository.findAll()).thenReturn(getCandidateListWithId());

        List<Candidate> list = candidateServiceImpl.listCandidates();

        assertEquals(getCandidateListWithId(), list);*/
        //when
        underTest.listCandidates();

        //then
        verify(candidateRepository).findAll();
    }

    @Test
    @WithMockUser
    void deleteByIdTest(){
        underTest.deleteById(ID_CANDIDATE);
        verify(candidateRepository, times(1)).deleteById(ID_CANDIDATE);
    }

    /********************It fails******************************/
    @Test
    @WithMockUser
    void listCandidatesByTecTest(){
        when(candidateXTechnologyRepository.findCandidatesXTecByTecName(TEC_NAME))
                .thenReturn(getCandidateXTechnologyList());

        List<CandidateXTechnology> list = underTest.listCandidatesByTec(TEC_NAME);
    }

    /********************It fails******************************/
    @Test
    void searchCandidateByIdNumberTest(){
        //given
        String dni = DNI_CANDIDATE;
        Candidate candidate = getCandidateWithoutId();
        underTest.saveCandidate(candidate);

        //when
        underTest.searchCandidateByIdNumber(dni);

        //then
        ArgumentCaptor<String> candidateArgumentCaptor = ArgumentCaptor.forClass(String.class);

        verify(candidateRepository).findByIdNumber(candidateArgumentCaptor.capture());

        String capturedDni = candidateArgumentCaptor.getValue();

        assertThat(dni).isEqualTo(capturedDni);
    }
}

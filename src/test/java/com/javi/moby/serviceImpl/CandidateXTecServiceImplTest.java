package com.javi.moby.serviceImpl;

import com.javi.moby.entity.model.CandidateXTechnology;
import com.javi.moby.repository.ICandidateXTechnologyRepository;
import com.javi.moby.service.ICandidateXTecService;
import com.javi.moby.service.impl.CandidateXTecServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.List;

import static com.javi.moby.testUtils.TestEntityFactory.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = CandidateXTecServiceImplTest.class)
@ExtendWith(MockitoExtension.class)
public class CandidateXTecServiceImplTest {
    @InjectMocks
    private CandidateXTecServiceImpl underTest;

    @Mock
    private ICandidateXTechnologyRepository candidateXTechnologyRepository;

    @Mock
    private ICandidateXTecService candidateXTecService;

    @Test
    void saveTechnologyTest(){
        //given
        CandidateXTechnology candidateXTechnology = getCandidateXTechnology();

        //when
        underTest.saveCandidateXTec(candidateXTechnology);

        //then
        ArgumentCaptor<CandidateXTechnology> technologyArgumentCaptor =
                ArgumentCaptor.forClass(CandidateXTechnology.class);

        verify(candidateXTechnologyRepository).save(technologyArgumentCaptor.capture());

        CandidateXTechnology capturedCandidateXTechnology = technologyArgumentCaptor.getValue();

        assertThat(capturedCandidateXTechnology).isEqualTo(candidateXTechnology);
    }

    @Test
    @WithMockUser
    void listTechnologiesTest(){
        when(candidateXTechnologyRepository.findAll()).thenReturn(getCandidateXTechnologyList());

        List<CandidateXTechnology> list = underTest.listCandidatesXTec();

        assertEquals(getCandidateXTechnologyList(), list);
    }

}

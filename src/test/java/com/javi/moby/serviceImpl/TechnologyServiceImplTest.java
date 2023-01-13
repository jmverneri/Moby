package com.javi.moby.serviceImpl;

import com.javi.moby.entity.model.Technology;
import com.javi.moby.repository.ITechnologyRepository;
import com.javi.moby.service.ITechnologyService;
import com.javi.moby.service.impl.TechnologyServiceImpl;

import org.junit.jupiter.api.Test;

import org.mockito.*;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.List;

import static com.javi.moby.testUtils.TestEntityFactory.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@WebMvcTest(controllers = TechnologyServiceImpl.class)
public class TechnologyServiceImplTest {

    @InjectMocks
    private TechnologyServiceImpl underTest;

    @Mock
    private ITechnologyRepository technologyRepository;

    @MockBean
    private ITechnologyService technologyService;

    @Test
    @WithMockUser
    void saveTechnologyTest(){
        //given
        Technology technology = getTechnologyWithoutId();

        //when
        underTest.saveTechnology(technology);

        //then
        ArgumentCaptor<Technology> technologyArgumentCaptor = ArgumentCaptor.forClass(Technology.class);

        verify(technologyRepository).save(technologyArgumentCaptor.capture());

        Technology capturedTechnology = technologyArgumentCaptor.getValue();

        assertThat(capturedTechnology).isEqualTo(technology);
    }

    @Test
    void listTechnologiesTest(){
        when(technologyRepository.findAll()).thenReturn(getTechnologyList());

        List<Technology> list = underTest.listTechnologies();

        assertEquals(getTechnologyList(), list);
    }

    @Test
    void deleteByIdTest(){
        underTest.deleteById(ID_TECHNOLOGY);
        verify(technologyRepository, times(1)).deleteById(ID_TECHNOLOGY);
    }
}

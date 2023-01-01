package com.javi.moby.serviceImpl;

import com.javi.moby.entity.Candidate;
import com.javi.moby.entity.Technology;
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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@WebMvcTest(controllers = TechnologyServiceImpl.class)
public class TechnologyServiceImplTest {

    @InjectMocks
    TechnologyServiceImpl technologyServiceImpl;

    @Mock
    ITechnologyRepository technologyRepository;

    @MockBean
    ITechnologyService technologyService;

    @Test
    @WithMockUser
    void saveTechnologyTest(){
        Technology technology = technologyServiceImpl.saveTechnology(getTechnologyWithoutId());

        assertEquals(getTechnologyWithId(), technology);
    }

    @Test
    @WithMockUser
    void listTechnologiesTest(){
        when(technologyRepository.findAll()).thenReturn(getTechnologyList());

        List<Technology> list = technologyServiceImpl.listTechnologies();

        assertEquals(getTechnologyList(), list);
    }

    @Test
    @WithMockUser
    void deleteByIdTest(){
        technologyServiceImpl.deleteById(ID_TECHNOLOGY);
        verify(technologyRepository, times(1)).deleteById(ID_TECHNOLOGY);
    }
}

package com.javi.moby.controller;

import com.javi.moby.service.ICandidateService;
import com.javi.moby.service.ITechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = TechnologyController.class)
public class TechnologyControllerTest {
    @MockBean
    ITechnologyService technologyService;

    @Autowired
    private MockMvc mockMvc;


}

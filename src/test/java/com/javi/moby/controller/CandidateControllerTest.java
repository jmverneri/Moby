package com.javi.moby.controller;

import com.javi.moby.exception.DNIDontExistException;
import com.javi.moby.service.ICandidateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.RequestBuilder;

import static com.javi.moby.testUtils.TestEntityFactory.*;
import static org.mockito.Mockito.*;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CandidateController.class)
public class CandidateControllerTest {

    @MockBean
    ICandidateService candidateService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    void addCandidateTest() throws Exception{
        when(candidateService.saveCandidate(getCandidateWithoutId())).thenReturn(getCandidateWithId());
        mockMvc.perform(post("/api/candidate/add-candidate", getCandidateWithIdJson())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getCandidateWithIdJson()))
                .andExpect(status().isCreated());
    }

    @Test
    @WithMockUser
    void addCandidateFailTest() throws Exception{

        when(candidateService.saveCandidate(getCandidateWithoutIdOrDni()))
                .thenThrow(DNIDontExistException.class);
        mockMvc.perform((RequestBuilder) post("/api/candidate/add-candidate", getCandidateWithoutIdOrDni()))
                .andExpect(status().isBadRequest());
    }


}

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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CandidateController.class)
public class CandidateControllerTest {

    @MockBean
    ICandidateService candidateService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    void listCandidatesTest() throws Exception {
        mockMvc.perform(get("/api/candidate/candidates"))
                .andExpect(status().isOk());
    }

   /* @Test
    @WithMockUser
    void saveCandidateTest(){
        mockMvc.perform(post("/api/candidate/add-candidate", getCandidateWithIdJson())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getCandidateWithIdJson()))
                .andExpect(status().isCreated());
    }*/
    @Test
    @WithMockUser
    void deleteTest() throws Exception {
        mockMvc.perform(delete("/api/candidate/remove-candidate/{id}", ID_CANDIDATE))
                .andExpect(status().isOk());
        verify(candidateService, times(1)).deleteById(ID_CANDIDATE);
    }

    @Test
    @WithMockUser
    void getCandidateByIdTest() throws Exception {
        mockMvc.perform(get("/api/candidate/get-candidate/{id}", ID_CANDIDATE))
                .andExpect(status().isOk());
    }
}

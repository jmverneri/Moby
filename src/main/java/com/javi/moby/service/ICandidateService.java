package com.javi.moby.service;

import com.javi.moby.entity.model.Candidate;
import com.javi.moby.entity.model.CandidateXTechnology;

import java.util.List;

public interface ICandidateService {
    Candidate fetchCandidateById(Long id);

    Candidate saveCandidate(Candidate candidate);

    List<Candidate> listCandidates();

    void deleteById(Long id);

    List<CandidateXTechnology> listCandidatesByTec(String name);

    Candidate searchCandidateByIdNumber(String dni);
}

package com.javi.moby.service;

import com.javi.moby.entity.Candidate;
import java.util.List;

public interface ICandidateService {
    Candidate fetchCandidateById(Long id);

    Candidate saveCandidate(Candidate candidate);

    List<Candidate> listCandidates();

    void deleteById(Long id);
}

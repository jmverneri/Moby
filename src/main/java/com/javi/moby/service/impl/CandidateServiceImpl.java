package com.javi.moby.service.impl;

import com.javi.moby.entity.Candidate;
import com.javi.moby.exception.IdNotFoundException;
import com.javi.moby.repository.ICandidateRepository;
import com.javi.moby.service.ICandidateService;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Log
@Service
public class CandidateServiceImpl implements ICandidateService {

    private ICandidateRepository candidateRepository;

    public CandidateServiceImpl(ICandidateRepository repository) {
        this.candidateRepository = repository;
    }

    @Override
    public Candidate fetchCandidateById(Long id) {
        if(candidateRepository.findById(id).isEmpty())
            throw new IdNotFoundException();
        return candidateRepository.findById(id).get();
    }

    @Override
    public Candidate saveCandidate(Candidate candidate) {
        Candidate toSave= candidateRepository.save(candidate);
        log.info("The candidate has been successfully saved");
        return toSave;
    }

    @Override
    public List<Candidate> listCandidates() {
        return candidateRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        candidateRepository.deleteById(id);
        log.info("The candidate has been successfully deleted");
    }
}

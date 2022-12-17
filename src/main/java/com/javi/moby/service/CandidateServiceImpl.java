package com.javi.moby.service;

import com.javi.moby.entity.Candidate;
import com.javi.moby.exception.ResourceNotFoundEx;
import com.javi.moby.repository.ICandidateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateServiceImpl implements ICandidateService{

    private ICandidateRepository repository;

    public CandidateServiceImpl(ICandidateRepository repository) {
        this.repository = repository;
    }

    @Override
    public Candidate fetchCandidateById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundEx("Candidate", "Id", id));
    }

    @Override
    public Candidate saveCandidate(Candidate candidate) {
        return repository.save(candidate);
    }

    @Override
    public List<Candidate> listCandidates() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

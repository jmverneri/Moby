package com.javi.moby.service;

import com.javi.moby.entity.Candidate;
import com.javi.moby.exception.ResourceNotFoundException;
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
        if(repository.findById(id).isEmpty())
            throw new ResourceNotFoundException("The candidate can not be found by the Id provided");
        return repository.findById(id).get();
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

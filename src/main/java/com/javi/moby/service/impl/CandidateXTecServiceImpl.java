package com.javi.moby.service.impl;

import com.javi.moby.entity.CandidateXTechnology;
import com.javi.moby.repository.ICandidateXTechnologyRepository;
import com.javi.moby.service.ICandidateXTecService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log
@Service
public class CandidateXTecServiceImpl implements ICandidateXTecService {

    @Autowired
    ICandidateXTechnologyRepository candidateXTechnologyRepository;

    @Override
    public CandidateXTechnology saveCandidateXTec(CandidateXTechnology candidateXTechnology) {
        CandidateXTechnology toSave= candidateXTechnologyRepository.save(candidateXTechnology);
        log.info("The candidate for the technology has been successfully saved");
        return toSave;
    }

    @Override
    public CandidateXTechnology updateCandidateXTec(CandidateXTechnology candidateXTechnology) {
        return null;
    }

    @Override
    public List<CandidateXTechnology> listCandidatesXTec() {
        return candidateXTechnologyRepository.findAll();
    }
}

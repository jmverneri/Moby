package com.javi.moby.controller;

import com.javi.moby.entity.Candidate;
import com.javi.moby.entity.CandidateXTechnology;
import com.javi.moby.service.ICandidateXTecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/candidate-x-tec")
public class CandidateXTecController {

    private ICandidateXTecService candidateXTecService;

    public CandidateXTecController(ICandidateXTecService candidateXTecService){
        this.candidateXTecService = candidateXTecService;
    }

    @GetMapping("/candidates-x-tec")
    public List<CandidateXTechnology> listCandidatesXTec(){
        return candidateXTecService.listCandidatesXTec();
    }

    @PostMapping("/add-candidate-x-tec")
    public CandidateXTechnology saveCandidateXTec(@Valid @RequestBody CandidateXTechnology candidateXTechnology){
        return candidateXTecService.saveCandidateXTec(candidateXTechnology);
    }
}

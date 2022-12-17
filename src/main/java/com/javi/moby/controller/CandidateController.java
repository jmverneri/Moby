package com.javi.moby.controller;

import com.javi.moby.entity.Candidate;
import com.javi.moby.service.ICandidateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CandidateController {

    private ICandidateService iCandidateService;

    public CandidateController(ICandidateService iCandidateService) {
        this.iCandidateService = iCandidateService;
    }

    @GetMapping("candidates")
    public List<Candidate> listCandidates(){
        return iCandidateService.listCandidates();
    }

    /*@PostMapping
    public ResponseEntity<Candidate> saveCandidate(@RequestBody Candidate candidate){
        return new ResponseEntity<Candidate>(iCandidateService, HttpStatus.CREATED);
    }*/

    @GetMapping("/get-candidate/{id}")
    public ResponseEntity<Candidate> getCandidateById(@PathVariable("id") Long id){
        return new ResponseEntity<Candidate>(iCandidateService.fetchCandidateById(id), HttpStatus.OK);
    }

    @DeleteMapping("/remove-candidate/{id}")
    public boolean delete(@PathVariable("id") Long id){
        if(!iCandidateService.fetchCandidateById(id).equals(Optional.empty())){
            iCandidateService.deleteById(id);
            return true;
        }
        return false;
    }
}

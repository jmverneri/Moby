package com.javi.moby.controller;

import com.javi.moby.entity.Candidate;
import com.javi.moby.service.ICandidateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
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

    @PostMapping("/add")
    public Candidate saveCandidate(@RequestBody Candidate candidate){
        return iCandidateService.saveCandidate(candidate);
    }

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

    @PutMapping("/update/{id}")
    public Candidate updateCandidate(@PathVariable("id") Long id, @RequestBody Map<String, String> body){
        Candidate current = iCandidateService.fetchCandidateById(id);
        current.getFirstName(body.get("firstName"));
        current.getFirstName(body.get("surname"));
        current.getFirstName(body.get("identityType"));
        current.getFirstName(body.get("idNumber"));
        current.getFirstName(body.get("birthDate"));
        iCandidateService.saveCandidate(current);
        return current;
    }
}

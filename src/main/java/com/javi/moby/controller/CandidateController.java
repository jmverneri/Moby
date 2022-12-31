package com.javi.moby.controller;

import com.javi.moby.entity.Candidate;
import com.javi.moby.entity.CandidateXTechnology;
import com.javi.moby.service.ICandidateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/candidate")
public class CandidateController {

    private ICandidateService candidateService;

    public CandidateController(ICandidateService iCandidateService) {
        this.candidateService = iCandidateService;
    }

    @GetMapping("candidates")
    public List<Candidate> listCandidates(){
        return candidateService.listCandidates();
    }

    @PostMapping("/add-candidate")
    public Candidate saveCandidate(@Valid @RequestBody Candidate candidate){
        return candidateService.saveCandidate(candidate);
    }

    @GetMapping("/get-candidate/{id}")
    public ResponseEntity<Candidate> getCandidateById(@PathVariable("id") Long id){
        return new ResponseEntity<Candidate>(candidateService.fetchCandidateById(id), HttpStatus.OK);
    }

    @DeleteMapping("/remove-candidate/{id}")
    public boolean delete(@PathVariable("id") Long id){
        if(!candidateService.fetchCandidateById(id).equals(Optional.empty())){
            candidateService.deleteById(id);
            return true;
        }
        return false;
    }

    @PutMapping("/update-candidate/{id}")
    public Candidate updateCandidate(@PathVariable("id") Long id, @RequestBody Map<String, String> body){
        Candidate current = candidateService.fetchCandidateById(id);
        current.setFirstName(body.get("firstName"));
        current.setSurname(body.get("surname"));
        current.setIdentityType(body.get("identityType"));
        current.setIdNumber(body.get("idNumber"));
        //current.setBirthDate(body.get("birthDate"));
        candidateService.saveCandidate(current);
        return current;
    }

    @GetMapping(value = "/listCandidateXTechnology/{technologyName}")
    public ResponseEntity<List<CandidateXTechnology>> listCandidateXTechnology(@PathVariable String
                                                                                           technologyName){
        return new ResponseEntity<>(candidateService.listCandidatesByTec(technologyName), HttpStatus.OK);
    }
}

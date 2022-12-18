package com.javi.moby.controller;


import com.javi.moby.entity.Candidate;
import com.javi.moby.entity.Technology;
import com.javi.moby.service.ITechnologyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class TechnologyController {
    private ITechnologyService iTechnologyService;

    public TechnologyController(ITechnologyService iTechnologyService) {
        this.iTechnologyService = iTechnologyService;
    }

    @GetMapping("technologies")
    public List<Technology> listTechnologies(){
        return iTechnologyService.listTechnologies();
    }

    @PostMapping("/add-technology")
    public Technology saveTechnology(@Valid @RequestBody Technology technology){
        return iTechnologyService.saveTechnology(technology);
    }

    @GetMapping("/get-technology/{id}")
    public ResponseEntity<Technology> getTechnologyById(@PathVariable("id") Long id){
        return new ResponseEntity<Technology>(iTechnologyService.fetchTechnologyById(id), HttpStatus.OK);
    }

    @DeleteMapping("/remove-technology/{id}")
    public boolean delete(@PathVariable("id") Long id){
        if(!iTechnologyService.fetchTechnologyById(id).equals(Optional.empty())){
            iTechnologyService.deleteById(id);
            return true;
        }
        return false;
    }

    @PutMapping("/update-technology/{id}")
    public Technology updateTechnology(@PathVariable("id") Long id, @RequestBody Map<String, String> body){
        Technology current = iTechnologyService.fetchTechnologyById(id);
        current.getName(body.get("tecName"));
        current.getVersion(body.get("version"));
        iTechnologyService.saveTechnology(current);
        return current;
    }

    /*@GetMapping("/{name}/candidates")
    public ResponseEntity<Collection<Candidate>> listCandidatesByTec(@PathVariable("name") String techName){
        Technology technology = iTechnologyService.fetchTechnologyByName(techName);
        if(technology != null){
            return new ResponseEntity<>(technology.getCandidateList(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }*/
}

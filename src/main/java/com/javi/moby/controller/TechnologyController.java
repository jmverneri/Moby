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
@RequestMapping(value = "/api/technology")
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
        current.setName(body.get("tecName"));
        current.setVersion(body.get("version"));
        iTechnologyService.saveTechnology(current);
        return current;
    }
}

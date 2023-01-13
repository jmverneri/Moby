package com.javi.moby.controller;


import com.javi.moby.entity.model.Technology;
import com.javi.moby.service.ITechnologyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping
    public List<Technology> listTechnologies(){
        return iTechnologyService.listTechnologies();
    }

    @PostMapping
    public Technology saveTechnology(@Valid @RequestBody Technology technology){
        return iTechnologyService.saveTechnology(technology);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Technology> getTechnologyById(@PathVariable("id") Long id){
        return new ResponseEntity<Technology>(iTechnologyService.fetchTechnologyById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id){
        if(!iTechnologyService.fetchTechnologyById(id).equals(Optional.empty())){
            iTechnologyService.deleteById(id);
            return true;
        }
        return false;
    }

    @PutMapping("/{id}")
    public Technology updateTechnology(@PathVariable("id") Long id, @RequestBody Map<String, String> body){
        Technology current = iTechnologyService.fetchTechnologyById(id);
        current.setTecName(body.get("tecName"));
        current.setVersion(body.get("version"));
        iTechnologyService.saveTechnology(current);
        return current;
    }
}

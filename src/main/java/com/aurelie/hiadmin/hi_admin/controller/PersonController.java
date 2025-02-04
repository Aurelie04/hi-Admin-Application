package com.aurelie.hiadmin.hi_admin.controller;

import com.aurelie.hiadmin.hi_admin.dto.PersonDto;
import com.aurelie.hiadmin.hi_admin.exception.ResourceNotFoundException;
import com.aurelie.hiadmin.hi_admin.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {

        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<PersonDto> createPerson(@RequestBody PersonDto personDto) {
        PersonDto savedPerson = personService.createPerson(personDto);
        return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPersonById(@PathVariable Long id) {
        try {
            PersonDto personDto = personService.getPersonById(id);
            return ResponseEntity.ok(personDto);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> getAllPersons(){
        List<PersonDto> persons = personService.getAllpersons();
        return ResponseEntity.ok(persons);
    }


}

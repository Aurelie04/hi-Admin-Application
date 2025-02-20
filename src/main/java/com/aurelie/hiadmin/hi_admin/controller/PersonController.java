package com.aurelie.hiadmin.hi_admin.controller;

import com.aurelie.hiadmin.hi_admin.dto.PersonDto;
import com.aurelie.hiadmin.hi_admin.exception.ResourceNotFoundException;
import com.aurelie.hiadmin.hi_admin.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
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
    public ResponseEntity<List<PersonDto>> getAllPersons() {
        List<PersonDto> persons = personService.getAllpersons();
        return ResponseEntity.ok(persons);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDto> updatePerson(@PathVariable("id") Long id,
                                                  @RequestBody PersonDto updatePerson) {

        PersonDto personDto = personService.updatePerson(id,updatePerson);

        return ResponseEntity.ok(personDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable("id") Long id){
        personService.deletePerson(id);
        return ResponseEntity.ok("The person has been successfully deleted in the record.");

    }

}

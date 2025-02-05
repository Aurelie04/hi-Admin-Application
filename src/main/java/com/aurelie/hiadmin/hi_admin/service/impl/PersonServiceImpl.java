package com.aurelie.hiadmin.hi_admin.service.impl;

import com.aurelie.hiadmin.hi_admin.mapper.PersonMapper;
import com.aurelie.hiadmin.hi_admin.dto.PersonDto;
import com.aurelie.hiadmin.hi_admin.entity.Person;
import com.aurelie.hiadmin.hi_admin.exception.ResourceNotFoundException;
import com.aurelie.hiadmin.hi_admin.repository.PersonRepository;
import com.aurelie.hiadmin.hi_admin.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {  // Explicit constructor
        this.personRepository = personRepository;
    }


    @Override
    public PersonDto createPerson(PersonDto personDto) {
        Person person = PersonMapper.mapToPerson(personDto);
        Person savedPerson = personRepository.save(person);
        return PersonMapper.mapToPersonDto(savedPerson);
    }

    @Override
    public PersonDto getPersonById(Long id) {
        return personRepository.findById(id)
                .map(PersonMapper::mapToPersonDto)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found with ID: " + id));
    }

    @Override
    public List<PersonDto> getAllpersons() {

       List<Person> persons = personRepository.findAll();
        return persons.stream().map((person) -> PersonMapper.mapToPersonDto(person))
                .collect(Collectors.toList());
    }

    @Override
    public PersonDto updatePerson(Long id, PersonDto updatePerson) {

       Person person = personRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("The person has been successfully updated: " + id)
        );

       person.setFirstName(updatePerson.getFirstName());
       person.setLastName(updatePerson.getLastName());
       person.setEmail(updatePerson.getEmail());
       person.setPhone_number(updatePerson.getPhone_number());
       person.setDescription(updatePerson.getDescription());
       person.setAmount(updatePerson.getAmount());

       Person personUpdated = personRepository.save(person);

       return PersonMapper.mapToPersonDto(personUpdated);
    }

    @Override
    public void deletePerson(Long id) {
        Person person = personRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Person does not exist:" + id)
        );

        personRepository.deleteById(id);
    }


}

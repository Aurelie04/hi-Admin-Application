package com.aurelie.hiadmin.hi_admin.service;

import com.aurelie.hiadmin.hi_admin.dto.PersonDto;

import java.util.List;

public interface PersonService {

    PersonDto createPerson(PersonDto personDto);
    PersonDto getPersonById(Long personId);

    List<PersonDto>getAllpersons();

    PersonDto updatePerson(Long id, PersonDto updatePerson);

    void deletePerson(Long id);

}

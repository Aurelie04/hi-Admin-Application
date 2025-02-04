package com.aurelie.hiadmin.hi_admin.mapper;

import com.aurelie.hiadmin.hi_admin.dto.PersonDto;
import com.aurelie.hiadmin.hi_admin.entity.Person;

public class PersonMapper {

    public static PersonDto mapToPersonDto(Person person){
        return new PersonDto(
                person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getEmail(),
                person.getDescription(),
                person.getPhone_number(),
                person.getAmount()
        );
    }

    public static Person mapToPerson(PersonDto personDto){
        return new Person(
                personDto.getId(),
                personDto.getFirstName(),
                personDto.getLastName(),
                personDto.getEmail(),
                personDto.getDescription(),
                personDto.getPhone_number(),
                personDto.getAmount()
        );
    }
}

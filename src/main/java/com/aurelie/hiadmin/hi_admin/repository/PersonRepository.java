package com.aurelie.hiadmin.hi_admin.repository;

import com.aurelie.hiadmin.hi_admin.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}

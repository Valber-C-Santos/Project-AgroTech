package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.dto.PersonCreationDto;
import com.betrybe.agrix.ebytr.staff.dto.PersonDto;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Person Controller.
 */
@RestController
@RequestMapping("/persons")
public class PersonController {

  private final PersonService personService;

  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  /**
   * Create a new User.
   *
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PersonDto createUser(@RequestBody PersonCreationDto newUser) {
    return PersonDto.fromEntity(personService
        .create(
            newUser.toEntity()
        ));
  }
}

package com.betrybe.agrix.ebytr.staff.dto;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.security.Role;

/**
 * Person dto.
 */
public record PersonDto(Long id,
      String username, Role role) {
  /**
   * Person Dto.
   *
   */
  public static PersonDto fromEntity(Person person) {
    return new PersonDto(person.getId(),
        person.getUsername(),
        person.getRole()
    );
  }
}
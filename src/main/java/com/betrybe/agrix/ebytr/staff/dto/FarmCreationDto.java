package com.betrybe.agrix.ebytr.staff.dto;


import com.betrybe.agrix.ebytr.staff.entity.Farm;

/**
 * Farm Creation Dto.
 */

public record FarmCreationDto(String name, Double size) {

  public Farm toEntity() {
    return new Farm(name, size);
  }
}
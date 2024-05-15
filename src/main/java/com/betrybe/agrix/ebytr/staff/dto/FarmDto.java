package com.betrybe.agrix.ebytr.staff.dto;

import com.betrybe.agrix.ebytr.staff.entity.Farm;

/**
 * Farm DTo.
 */

public record FarmDto(Long id, String name, Double size) {

  /**
   * Farm DTo.
   */

  public static FarmDto fromEntity(Farm farm) {
    return new FarmDto(
        farm.getId(),
        farm.getName(),
        farm.getSize()
    );
  }
}

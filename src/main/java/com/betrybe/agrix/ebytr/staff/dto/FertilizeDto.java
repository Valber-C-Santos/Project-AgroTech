package com.betrybe.agrix.ebytr.staff.dto;

import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;

/**
 * Fertilize dto.
 */
public record FertilizeDto(
    Long id,
    String name,
    String brand,
    String composition) {

  /**
   * Fertilize dto.
   */
  public static FertilizeDto fromEntity(Fertilizer fertilizer) {
    return new FertilizeDto(
        fertilizer.getId(),
        fertilizer.getName(),
        fertilizer.getBrand(),
        fertilizer.getComposition()
    );
  }
}
package com.betrybe.agrix.ebytr.staff.dto;

import com.betrybe.agrix.ebytr.staff.entity.Crop;
import java.time.LocalDate;

/**
 * Crop Creation DTo.
 */

public record CropCreationDto(String name, double plantedArea,
         LocalDate plantedDate, LocalDate harvestDate) {

  public Crop toEntity() {
    return new Crop(name, plantedArea, plantedDate, harvestDate);
  }
}
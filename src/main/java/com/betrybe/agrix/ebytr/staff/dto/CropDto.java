package com.betrybe.agrix.ebytr.staff.dto;

import com.betrybe.agrix.ebytr.staff.entity.Crop;
import java.time.LocalDate;

/**
 * Crop DTo.
 */

public record CropDto(Long id, String name, double plantedArea,
      LocalDate plantedDate, LocalDate harvestDate, Long farmId) {

  /**
  * Crop DTo.
  */

  public static CropDto fromEntity(Crop crop) {
    return new CropDto(
        crop.getId(),
        crop.getName(),
        crop.getPlantedArea(),
        crop.getPlantedDate(),
        crop.getHarvestDate(),
        crop.getFarm().getId());
  }
}
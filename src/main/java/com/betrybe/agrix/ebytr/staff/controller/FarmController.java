package com.betrybe.agrix.ebytr.staff.controller;


import com.betrybe.agrix.ebytr.staff.dto.CropCreationDto;
import com.betrybe.agrix.ebytr.staff.dto.CropDto;
import com.betrybe.agrix.ebytr.staff.dto.FarmCreationDto;
import com.betrybe.agrix.ebytr.staff.dto.FarmDto;
import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Farm;
import com.betrybe.agrix.ebytr.staff.exception.FarmNotFoundException;
import com.betrybe.agrix.ebytr.staff.service.CropService;
import com.betrybe.agrix.ebytr.staff.service.FarmService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/**
 * Farm Controller.
 */

@RestController
@RequestMapping(value = "/farms")
public class FarmController {

  private final FarmService farmService;
  private final CropService cropService;

  @Autowired
  public FarmController(FarmService farmService, CropService cropService) {
    this.farmService = farmService;
    this.cropService = cropService;
  }

  /**
   * Create a Farm.
   */

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public FarmDto createFarm(@RequestBody FarmCreationDto farmCreationDto) {
    return FarmDto.fromEntity(
        farmService.create(farmCreationDto.toEntity())
    );
  }

  /**
   * Create a Farm Crop.
   */

  @PostMapping(value = "/{farmId}/crops")
  @ResponseStatus(HttpStatus.CREATED)
  public CropDto createCrop(@PathVariable Long farmId,
         @RequestBody CropCreationDto cropCreationDto) throws FarmNotFoundException {
    return CropDto.fromEntity(cropService
        .create(farmId, cropCreationDto.toEntity()));
  }

  /**
   * Get All Farms.
   */

  @GetMapping
  @PreAuthorize("hasAuthority('ROLE_ADMIN')"
      + " or hasAuthority('ROLE_MANAGER') or hasAuthority('ROLE_USER')")
  public List<FarmDto> getAllfarms() {
    List<Farm> allFarms = farmService.findAll();
    return allFarms.stream()
        .map(FarmDto::fromEntity)
        .toList();
  }

  /**
   * Find By ID.
   */

  @GetMapping("/{id}")
  public FarmDto getFarmById(@PathVariable Long id) throws FarmNotFoundException {
    return FarmDto.fromEntity(
        farmService.findById(id)
    );
  }

  /**
   * get All Crops By Id.
   */

  @GetMapping(value = "/{farmId}/crops")
  public List<CropDto> getAllCropsById(@PathVariable Long farmId) throws FarmNotFoundException {
    List<Crop> cropFarmId = farmService.findById(farmId).getCrops();
    return cropFarmId.stream()
        .map(CropDto::fromEntity)
        .toList();
  }
}

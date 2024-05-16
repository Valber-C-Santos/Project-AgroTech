package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.controller.advice.GlobalControllerAdvice;
import com.betrybe.agrix.ebytr.staff.dto.CropDto;
import com.betrybe.agrix.ebytr.staff.dto.FertilizeDto;
import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.exception.CropNotFoundException;
import com.betrybe.agrix.ebytr.staff.exception.FertilizeNotFoundException;
import com.betrybe.agrix.ebytr.staff.service.CropService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Crop controller.
 */
@RestController
@RequestMapping(value = "/crops")
public class CropController {

  private final CropService cropService;


  @Autowired
  public CropController(CropService cropService) {
    this.cropService = cropService;
  }

  /**
   * Get all Crops.
   */
  @GetMapping
  @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_MANAGER')")
  public List<CropDto> getAllCrops() {
    List<Crop> allCrops = cropService.findAll();
    return allCrops.stream()
        .map(CropDto::fromEntity)
        .toList();
  }

  /**
   * Get Crops ID.
   */
  @GetMapping(value = "{id}")
  public CropDto getCropId(@PathVariable Long id) throws CropNotFoundException {
    return CropDto.fromEntity(cropService.findById(id));
  }

  /**
   * Get search crops date.
   */
  @GetMapping("/search")
  public List<CropDto> findCropsByHarvestDate(
      @RequestParam LocalDate start, @RequestParam LocalDate end) {
    List<Crop> allCrops = cropService.searchCropsByDate(start, end);
    return allCrops.stream()
        .map(CropDto::fromEntity)
        .toList();
  }

  /**
   * Connect Crop with fertilizer.
   */
  @PostMapping("/{cropId}/fertilizers/{fertilizerId}")
  public ResponseEntity<String> connectCropWithFertilizer(@PathVariable Long cropId,
      @PathVariable Long fertilizerId)
      throws FertilizeNotFoundException, CropNotFoundException {

    cropService.connectCropWithFertilizer(cropId, fertilizerId);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body("Fertilizante e plantação associados com sucesso!");
  }

  /**
   * get All Fertilizers By Crop Id.
   */
  @GetMapping("{cropId}/fertilizers")
  public List<FertilizeDto> getAllFertilizersByCropId(@PathVariable Long cropId)
      throws CropNotFoundException {

    return
        cropService.getFertilizersByCropId(cropId).stream()
        .map(FertilizeDto::fromEntity)
        .toList();
  }
}


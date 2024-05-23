package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.dto.FertilizeCreationDto;
import com.betrybe.agrix.ebytr.staff.dto.FertilizeDto;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.exception.FertilizeNotFoundException;
import com.betrybe.agrix.ebytr.staff.service.FertilizeService;
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
 * Fertilize Controller.
 */
@RestController
@RequestMapping(value = "/fertilizers")
public class FertilizeController {

  private final FertilizeService fertilizeService;

  @Autowired
  public FertilizeController(FertilizeService fertilizeService) {
    this.fertilizeService = fertilizeService;
  }

  /**
   * Post fertilize.
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public FertilizeDto create(@RequestBody FertilizeCreationDto fertilizerCreationDto) {
    return FertilizeDto.fromEntity(
        fertilizeService.create(fertilizerCreationDto.toEntity())
    );
  }

  /**
   * Get all fertilize.
   */
  @GetMapping
  @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
  public List<FertilizeDto> getAllFertilizer() {
    List<Fertilizer> allCrops = fertilizeService.findAll();
    return allCrops.stream()
        .map(FertilizeDto::fromEntity)
        .toList();
  }

  /**
   * Get Fetilize ID.
   */
  @GetMapping(value = "{id}")
  public FertilizeDto getCropId(@PathVariable Long id) throws FertilizeNotFoundException {
    return FertilizeDto.fromEntity(
        fertilizeService.findById(id)
    );
  }

}

package com.betrybe.agrix.ebytr.staff.service;

import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Farm;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.exception.CropNotFoundException;
import com.betrybe.agrix.ebytr.staff.exception.FarmNotFoundException;
import com.betrybe.agrix.ebytr.staff.exception.FertilizeNotFoundException;
import com.betrybe.agrix.ebytr.staff.repository.CropRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Crop service.
 */

@Service
public class CropService {


  private final CropRepository cropRepository;
  private final FarmService farmService;
  private final FertilizeService fertilizeService;

  /**
   * Contructos crop.
   */
  @Autowired
  public CropService(CropRepository cropRepository, FarmService farmService,
      FertilizeService fertilizeService) {
    this.cropRepository = cropRepository;
    this.farmService = farmService;
    this.fertilizeService = fertilizeService;
  }

  /**
   * Create Crop service.
   */

  public Crop create(Long farmId, Crop crop) throws FarmNotFoundException {
    Farm newFarm = farmService.findById(farmId);
    crop.setFarm(newFarm);

    return cropRepository.save(crop);
  }

  public List<Crop> findAll() {
    return cropRepository.findAll();
  }

  public Crop findById(Long id) throws CropNotFoundException {
    return cropRepository.findById(id)
        .orElseThrow(CropNotFoundException::new);
  }

  /**
   * Create Crop service.
   */
  public List<Crop> searchCropsByDate(LocalDate start, LocalDate end) {
    List<Crop> allCropsDates = cropRepository.findAllByHarvestDateBetween(start, end);

    return allCropsDates.stream().toList();
  }

  /**
   * connect crop with fertilize.
   */
  public void connectCropWithFertilizer(Long cropId, Long fertilizerId)
      throws CropNotFoundException, FertilizeNotFoundException {

    Crop crop = cropRepository.findById(cropId).orElseThrow(CropNotFoundException::new);
    Fertilizer fertilizer = fertilizeService.findById(fertilizerId);

    crop.getFertilizers().add(fertilizer);
    cropRepository.save(crop);
  }

  /**
   * get Fertilizers By Crop Id.
   */
  public List<Fertilizer> getFertilizersByCropId(Long cropId) throws CropNotFoundException {
    Crop crop = cropRepository.findById(cropId)
        .orElseThrow(CropNotFoundException::new);
    return crop.getFertilizers();
  }
}


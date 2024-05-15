package com.betrybe.agrix.ebytr.staff.service;


import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.exception.FertilizeNotFoundException;
import com.betrybe.agrix.ebytr.staff.repository.FertilizeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Fertilize service.
 */
@Service
public class FertilizeService {
  private final FertilizeRepository fertilizeRepository;

  @Autowired
  public FertilizeService(FertilizeRepository fertilizeRepository) {
    this.fertilizeRepository = fertilizeRepository;
  }

  public Fertilizer create(Fertilizer fertilizer) {
    return fertilizeRepository.save(fertilizer);
  }

  public List<Fertilizer> findAll() {
    return fertilizeRepository.findAll();
  }

  public Fertilizer findById(Long id) throws FertilizeNotFoundException {
    return fertilizeRepository.findById(id)
        .orElseThrow(FertilizeNotFoundException::new);
  }
}

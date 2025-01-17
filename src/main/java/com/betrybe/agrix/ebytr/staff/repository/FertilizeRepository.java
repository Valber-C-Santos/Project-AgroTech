package com.betrybe.agrix.ebytr.staff.repository;

import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Fertilize repository.
 */
@Repository
public interface FertilizeRepository extends JpaRepository<Fertilizer, Long> {
}
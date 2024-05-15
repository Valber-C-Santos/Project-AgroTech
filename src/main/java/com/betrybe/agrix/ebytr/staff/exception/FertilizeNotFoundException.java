package com.betrybe.agrix.ebytr.staff.exception;

/**
 * Fetilize not Found Exception.
 */
public class FertilizeNotFoundException extends NotFoundException {
  public FertilizeNotFoundException() {
    super("Fertilizante não encontrado!");
  }
}

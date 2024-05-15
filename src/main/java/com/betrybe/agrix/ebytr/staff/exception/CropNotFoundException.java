package com.betrybe.agrix.ebytr.staff.exception;

/**
 * Crop Not Found Exception.
 */

public class CropNotFoundException extends NotFoundException {
  public CropNotFoundException() {
    super("Plantação não encontrada!");
  }
}

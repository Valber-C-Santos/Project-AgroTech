package com.betrybe.agrix.ebytr.staff.exception;

/**
 * Farm Not Found Exception.
 */

public class FarmNotFoundException extends NotFoundException {
  public FarmNotFoundException() {
    super("Fazenda não encontrada!");
  }
}

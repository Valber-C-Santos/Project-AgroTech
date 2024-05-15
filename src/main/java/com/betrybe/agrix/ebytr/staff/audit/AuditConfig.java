package com.betrybe.agrix.ebytr.staff.audit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * AuditConfig.
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class AuditConfig {
  @Bean
  public AuditorAware<String> auditorAware() {
    return new AuditorAwareUser();
  }
}
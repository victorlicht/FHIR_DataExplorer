package com.victorlicht.backendjava.config;

import ca.uhn.fhir.context.FhirContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FHIRServerConfiguration {
    @Bean
    public FhirContext fhirContext() {
        return FhirContext.forR5();
    }
}

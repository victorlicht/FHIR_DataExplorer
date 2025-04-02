package com.victorlicht.backendjava.controller;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;
import org.hl7.fhir.r5.model.Enumerations;
import org.hl7.fhir.r5.model.Patient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("fhir/patient")
public class PatientController {
    private final FhirContext fhirContext;

    public PatientController(FhirContext fhirContext) {
        this.fhirContext = fhirContext;
    }

    @GetMapping
    public String getPatient() {
        Patient patient = new Patient();
        patient.addName().setFamily("Doe").addGiven("John");
        patient.setId("1");
        patient.setGender(Enumerations.AdministrativeGender.MALE);

        IParser jsonParser = fhirContext.newJsonParser();
        return jsonParser.setPrettyPrint(true).encodeResourceToString(patient);
    }
}

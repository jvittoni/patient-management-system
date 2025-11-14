package com.jvittoni.patientservice.mapper;

import com.jvittoni.patientservice.dto.PatientResponseDTO;
import com.jvittoni.patientservice.model.Patient;

public class PatientMapper {
    public static PatientResponseDTO toDTO(Patient patient) {
        PatientResponseDTO patientDTO = new PatientResponseDTO();
        patientDTO.setId(patient.getId().toString());
        patientDTO.setName(patientDTO.getName());
        patientDTO.setEmail(patientDTO.getEmail());
        patientDTO.setAddress(patientDTO.getAddress());
        patientDTO.setDateOfBirth(patientDTO.getDateOfBirth().toString());

        return patientDTO;
    }
}

package com.jvittoni.patientservice.service;

import com.jvittoni.patientservice.dto.PatientResponseDTO;
import com.jvittoni.patientservice.mapper.PatientMapper;
import com.jvittoni.patientservice.model.Patient;
import com.jvittoni.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream().map(PatientMapper::toDTO).toList();
    }
}

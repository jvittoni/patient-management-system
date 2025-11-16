package com.jvittoni.patientservice.service;

import com.jvittoni.patientservice.dto.PatientRequestDTO;
import com.jvittoni.patientservice.dto.PatientResponseDTO;
import com.jvittoni.patientservice.exception.EmailAlreadyExistsException;
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

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {
        if(patientRepository.existsByEmail(patientRequestDTO.getEmail())) {
        throw new EmailAlreadyExistsException("A patient with this email " + "already exists " + patientRequestDTO.getEmail());
        }
        Patient newPatient = patientRepository.save(PatientMapper.toModel(patientRequestDTO));
        return PatientMapper.toDTO(newPatient);
    }
}

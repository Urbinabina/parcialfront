package com.example.backend.doctor;

import com.example.backend.clinica.Clinica;
import com.example.backend.clinica.ClinicaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepo;
    private final ClinicaRepository clinicaRepo;

    public List<Doctor> listar() {
        return doctorRepo.findAll();
    }

    public List<Doctor> listarPorClinica(Long clinicaId) {
        return doctorRepo.findByClinica_Identificador(clinicaId);
    }

    public Doctor obtener(Long id) {
        return doctorRepo.findById(id).orElse(null);
    }

    public Doctor crear(Doctor doctor, Long clinicaId) {
        Clinica c = clinicaRepo.findById(clinicaId).orElse(null);
        if (c == null) return null;

        doctor.setClinica(c);
        return doctorRepo.save(doctor);
    }

    public Doctor actualizar(Long id, Doctor nuevo) {
        Doctor existente = doctorRepo.findById(id).orElse(null);
        if (existente == null) return null;

        existente.setNombre(nuevo.getNombre());
        existente.setEspecialidad(nuevo.getEspecialidad());
        existente.setEmail(nuevo.getEmail());
        existente.setTelefono(nuevo.getTelefono());
        existente.setFecha_contratacion(nuevo.getFecha_contratacion());

        if (nuevo.getClinica() != null) {
            existente.setClinica(nuevo.getClinica());
        }

        return doctorRepo.save(existente);
    }

    public void eliminar(Long id) {
        doctorRepo.deleteById(id);
    }
}

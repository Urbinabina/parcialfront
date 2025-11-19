package com.example.backend.clinica;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClinicaService {

    private final ClinicaRepository repository;

    public List<Clinica> listar() {
        return repository.findAll();
    }

    public Clinica obtener(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Clinica crear(Clinica clinica) {
        return repository.save(clinica);
    }

    public Clinica actualizar(Long id, Clinica clinica) {
        Clinica existente = repository.findById(id).orElse(null);
        if (existente == null) return null;

        existente.setNombre(clinica.getNombre());
        existente.setDireccion(clinica.getDireccion());
        existente.setCantidad_camas(clinica.getCantidad_camas());
        existente.setTelefono(clinica.getTelefono());
        existente.setCiudad(clinica.getCiudad());
        existente.setFecha_creacion(clinica.getFecha_creacion());

        return repository.save(existente);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}

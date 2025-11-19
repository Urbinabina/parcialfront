package com.example.backend.doctor;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctores")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class DoctorController {

    private final DoctorService service;

    @GetMapping("/list")
    public List<Doctor> listar() {
        return service.listar();
    }

    @GetMapping("/clinica/{clinicaId}")
    public List<Doctor> listarPorClinica(@PathVariable Long clinicaId) {
        return service.listarPorClinica(clinicaId);
    }

    @GetMapping("/get/{id}")
    public Doctor obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @PostMapping("/create/{clinicaId}")
    public Doctor crear(@RequestBody Doctor doctor, @PathVariable Long clinicaId) {
        return service.crear(doctor, clinicaId);
    }

    @PutMapping("/update/{id}")
    public Doctor actualizar(@PathVariable Long id, @RequestBody Doctor doctor) {
        return service.actualizar(id, doctor);
    }

    @DeleteMapping("/delete/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}

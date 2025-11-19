package com.example.backend.clinica;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clinicas")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ClinicaController {

    private final ClinicaService service;

    @GetMapping("/list")
    public List<Clinica> listar() {
        return service.listar();
    }

    @GetMapping("/get/{id}")
    public Clinica obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @PostMapping("/create")
    public Clinica crear(@RequestBody Clinica clinica) {
        return service.crear(clinica);
    }

    @PutMapping("/update/{id}")
    public Clinica actualizar(@PathVariable Long id, @RequestBody Clinica clinica) {
        return service.actualizar(id, clinica);
    }

    @DeleteMapping("/delete/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}

package org.acme.controllers;

import org.acme.models.Alumno;
import org.acme.repositories.AlumnoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlumnoController {

    private final AlumnoRepository repository;

    AlumnoController(AlumnoRepository alumnoRepository) {
        this.repository = alumnoRepository;
    }

    @GetMapping("/alumnos")
    List<Alumno> getAll() {
        return repository.findAll();
    }

    @GetMapping("/alumnos/{id}")
    Alumno getById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping("/alumnos")
    Alumno create(@RequestBody Alumno alumno) {
        return repository.save(alumno);
    }

    @PutMapping("/alumnos/{id}")
    Alumno replaceAlumno(@RequestBody Alumno newAlumno, @PathVariable Long id) {
        return repository.findById(id)
                .map(alumno -> {
                    alumno.setNombre(newAlumno.getNombre());
                    alumno.setApPaterno(newAlumno.getApPaterno());
                    alumno.setApMaterno(newAlumno.getApMaterno());
                    alumno.setActivo(newAlumno.getActivo());
                    return repository.save(alumno);
                }).orElseThrow();
    }

    @DeleteMapping("/alumnos/{id}")
    void deleteAlumno(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

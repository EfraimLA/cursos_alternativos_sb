package org.acme.controllers;

import org.acme.models.Materia;
import org.acme.repositories.MateriaRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MateriaController {

    private final MateriaRepository repository;

    MateriaController(MateriaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/materias")
    List<Materia> getAll() {
        return repository.findAll();
    }

    @GetMapping("/materias/{id}")
    Materia getById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping("/materias")
    Materia create(@RequestBody @Valid Materia materia) {
        return repository.save(materia);
    }

    @PutMapping("/materias/{id}")
    Materia replaceMateria(@RequestBody @Valid Materia newMateria, @PathVariable Long id) {
        return repository.findById(id)
                .map(materia -> {
                    materia.setNombre(newMateria.getNombre());
                    materia.setActivo(newMateria.getActivo());
                    return repository.save(materia);
                }).orElseThrow();
    }

    @DeleteMapping("/materias/{id}")
    void deleteMateria(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

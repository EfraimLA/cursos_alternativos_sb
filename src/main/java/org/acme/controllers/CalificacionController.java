package org.acme.controllers;

import org.acme.models.Calificacion;
import org.acme.models.CalificacionResponse;
import org.acme.models.CalificacionesMaterias;
import org.acme.models.Response;
import org.acme.repositories.CalificacionRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CalificacionController {

    private final CalificacionRepository repository;

    CalificacionController(CalificacionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/calificaciones")
    List<Calificacion> getAll() {
        return repository.findAll();
    }

    @GetMapping("/calificaciones/{id}")
    List<Calificacion> getByAlumnoId(@PathVariable Long id) {
        var result = repository.findByAlumnoId(id);

        var response = new CalificacionResponse();
        response.id_t_alumno = result.get(0).getAlumno().getId();
        response.nombre = result.get(0).getAlumno().getNombre();
        response.apellido = result.get(0).getAlumno().getApPaterno() + " " + result.get(0).getAlumno().getApMaterno();


        result.forEach(cal -> {
            var calificacionesMaterias = new CalificacionesMaterias();
            calificacionesMaterias.materia = cal.getMateria().getNombre();
            calificacionesMaterias.calificacion = cal.getCalificacion();
            response.calificaciones.add(calificacionesMaterias);
        });

        response.promedio = result.stream().mapToDouble(Calificacion::getCalificacion).sum() / result.size();

        return repository.findByAlumnoId(id);
    }

    @PostMapping("/calificaciones")
    Response create(@RequestBody @Valid Calificacion calificacion) {
        calificacion = repository.save(calificacion);

        return new Response("ok", "calificacion registrada", calificacion);
    }

    @PutMapping("/calificaciones/{id}")
    Calificacion replaceCalificacion(@RequestBody @Valid Calificacion newCalificacion, @PathVariable Long id) {
        return repository.findById(id)
                .map(calificacion -> {
                    calificacion.setCalificacion(newCalificacion.getCalificacion());
                    calificacion.setMateria(newCalificacion.getMateria());
                    calificacion.setAlumno(newCalificacion.getAlumno());
                    return repository.save(calificacion);
                }).orElseThrow();
    }

    @DeleteMapping("/calificaciones/{id}")
    void deleteCalificacion(@PathVariable Long id) {
        repository.deleteById(id);
    }

}

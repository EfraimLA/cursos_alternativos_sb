package org.acme.controllers;

import org.acme.models.Calificacion;
import org.acme.models.CalificacionResponse;
import org.acme.models.CalificacionesMaterias;
import org.acme.models.Response;
import org.acme.repositories.CalificacionRepository;
import org.jboss.logging.Logger;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
public class CalificacionController {

    private final CalificacionRepository repository;

    private static final String DATE_FORMAT = "dd/MM/yyyy";

    private static final Logger LOGGER = Logger.getLogger(CalificacionController.class);

    private final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

    CalificacionController(CalificacionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/calificaciones")
    List<Calificacion> getAll() {
        return repository.findAll();
    }

    @GetMapping("/calificaciones/{id}")
    CalificacionResponse getByAlumnoId(@PathVariable Long id) {
        var result = repository.findByAlumnoId(id);

        var response = new CalificacionResponse();
        response.id_t_alumno = result.get(0).getAlumno().getId();
        response.nombre = result.get(0).getAlumno().getNombre();
        response.apellido = result.get(0).getAlumno().getApPaterno() + " " + result.get(0).getAlumno().getApMaterno();


        result.forEach(cal -> {
            var calificacionesMaterias = new CalificacionesMaterias();
            calificacionesMaterias.materia = cal.getMateria().getNombre();
            calificacionesMaterias.calificacion = cal.getCalificacion();
            calificacionesMaterias.fecha_registro = sdf.format(cal.getFechaRegistro());
            response.calificaciones.add(calificacionesMaterias);
        });

        response.promedio = result.stream().mapToDouble(Calificacion::getCalificacion).sum() / result.size();

        return response;
    }

    /*
    @GetMapping("/calificaciones/{id}/pdf")
    CalificacionResponse getByAlumnoIdPdfReport(@PathVariable Long id) {
        var result = repository.findByAlumnoId(id);

        var response = new CalificacionResponse();
        response.id_t_alumno = result.get(0).getAlumno().getId();
        response.nombre = result.get(0).getAlumno().getNombre();
        response.apellido = result.get(0).getAlumno().getApPaterno() + " " + result.get(0).getAlumno().getApMaterno();


        result.forEach(cal -> {
            var calificacionesMaterias = new CalificacionesMaterias();
            calificacionesMaterias.materia = cal.getMateria().getNombre();
            calificacionesMaterias.calificacion = cal.getCalificacion();
            calificacionesMaterias.fecha_registro = sdf.format(cal.getFechaRegistro());
            response.calificaciones.add(calificacionesMaterias);
        });

        response.promedio = result.stream().mapToDouble(Calificacion::getCalificacion).sum() / result.size();

        return response;
    }
     */

    @PostMapping("/calificaciones")
    Response create(@RequestBody @Valid Calificacion calificacion) {
        calificacion = repository.save(calificacion);

        return new Response("ok", "calificacion registrada", calificacion);
    }


    @PutMapping("/calificaciones/{id}")
    Response replaceCalificacion(@RequestBody  Calificacion newCalificacion, @PathVariable Long id) {
        LOGGER.info("||||| ACTUALIZANDO CALIFICACION ||||||");

        repository.findById(id)
                .map(calificacion -> {
                    calificacion.setCalificacion(newCalificacion.getCalificacion());
                    return repository.save(calificacion);
                }).orElseThrow();

        return new Response("ok", "calificacion actualizada", newCalificacion);
    }

    @DeleteMapping("/calificaciones/{id}")
    Response deleteCalificacion(@PathVariable Long id) {
        repository.deleteById(id);

        return new Response("ok", "calificacion eliminada", null);
    }

}

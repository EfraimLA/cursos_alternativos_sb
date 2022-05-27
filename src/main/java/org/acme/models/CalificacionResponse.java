package org.acme.models;

import java.util.ArrayList;
import java.util.List;

public class CalificacionResponse {

    public Long id_t_alumno;

    public String nombre;

    public String apellido;

    public Double promedio;

    public List<CalificacionesMaterias> calificaciones = new ArrayList<>();
}

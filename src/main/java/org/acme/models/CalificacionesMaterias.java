package org.acme.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
public class CalificacionesMaterias {

    public String materia;

    public Float calificacion;

    public Date fecha_registro;

    public String fecha;
}

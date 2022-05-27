package org.acme.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "calificaciones")
@DynamicUpdate
@Data
@NoArgsConstructor
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Alumno alumno;

    @ManyToOne
    private Materia materia;

    @Column(columnDefinition = "decimal(10, 2)")
    private Float calificacion;

    @CreationTimestamp
    private Date fechaRegistro;

}

package org.acme.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "t_calificaciones")
@DynamicUpdate
@Data
@NoArgsConstructor
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_t_calificaciones")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_t_alumnos", nullable = false)
    @NotNull
    private Alumno alumno;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_t_materias", nullable = false)
    @NotNull
    private Materia materia;

    @Column(columnDefinition = "decimal(10, 2)")
    @NotNull
    private Float calificacion;

    @CreationTimestamp
    private Date fechaRegistro;

}

package org.acme.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "alumnos")
@DynamicUpdate
@Data
@NoArgsConstructor
public class Alumno {

    public Alumno(String nombre, String apPaterno, String apMaterno, Integer activo) {
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.activo = activo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 80)
    private String nombre;

    @Column(length = 80)
    private String apPaterno;

    @Column(length = 80)
    private String apMaterno;

    @Column(columnDefinition = "int(1)")
    private Integer activo;

    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL)
    private List<Calificacion> calificaciones;

}

package org.acme.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "materias")
@DynamicUpdate
@Data
@NoArgsConstructor
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 80)
    private String nombre;

    @Column(columnDefinition = "int(1)")
    private Integer activo;

    @OneToMany(mappedBy = "materia", cascade = CascadeType.ALL)
    private List<Calificacion> calificaciones;

}

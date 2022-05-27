package org.acme.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_alumnos")
@DynamicUpdate
@Data
@NoArgsConstructor
public class Alumno {

    public Alumno(String nombre, String apPaterno, String apMaterno, Boolean activo) {
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.activo = activo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_t_usuarios")
    private Long id;

    @Column(length = 80)
    private String nombre;

    @Column(name = "ap_paterno", length = 80)
    @JsonProperty("ap_paterno")
    private String apPaterno;

    @Column(name = "ap_materno", length = 80)
    @JsonProperty("ap_materno")
    private String apMaterno;

    private Boolean activo;

}

package org.acme.repositories;

import org.acme.models.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalificacionRepository extends JpaRepository<Calificacion, Long> {

    List<Calificacion> findByAlumnoId(Long id);

}

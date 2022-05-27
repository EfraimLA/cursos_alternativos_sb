package org.acme.repositories;

import org.acme.models.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}

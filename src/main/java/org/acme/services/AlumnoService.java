package org.acme.services;

import org.acme.models.Alumno;
import org.acme.repositories.AlumnoRepository;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

@Service
public class AlumnoService {

    private static final Logger LOGGER = Logger.getLogger(AlumnoService.class);

    @Autowired
    private AlumnoRepository repository;

    private List<Alumno> alumnoList = new LinkedList<>();

    @PostConstruct
    public void init() {
        LOGGER.info("||||| INITIALIZING ALUMNO SERVICE BEAN |||||");

        alumnoList = repository.findAll();
    }

    public List<Alumno> findAll() {
        return repository.findAll();
    }

    public List<Alumno> search(String keyword) {
        List<Alumno> result = new LinkedList<>();

        if (keyword == null || "".equals(keyword)) {
            result = alumnoList;
        } else {
            for (Alumno alumno : alumnoList) {
                if (alumno.getNombre().toLowerCase().contains(keyword.toLowerCase())
                        || alumno.getApPaterno().toLowerCase().contains(keyword.toLowerCase())
                        || alumno.getApMaterno().toLowerCase().contains(keyword.toLowerCase())) {
                    result.add(alumno);
                }
            }
        }

        return result;
    }
}

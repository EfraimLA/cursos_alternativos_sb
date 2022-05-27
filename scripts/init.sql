CREATE TABLE t_alumnos
(
    id_t_usuarios SERIAL,
    nombre        VARCHAR(80),
    ap_paterno    VARCHAR(80),
    ap_materno    VARCHAR(80),
    activo        BOOLEAN,
    PRIMARY KEY (id_t_usuarios)
);

INSERT INTO t_alumnos(id_t_usuarios, nombre, ap_paterno, ap_materno, activo)
VALUES (default, 'John', 'Dow', 'Down', true);

CREATE TABLE t_materias
(
    id_t_materias SERIAL,
    nombre        VARCHAR(80),
    activo        BOOLEAN,
    PRIMARY KEY (id_t_materias)
);

INSERT INTO t_materias(id_t_materias, nombre, activo)
VALUES (default, 'Matematicas', true);
INSERT INTO t_materias
VALUES (default, 'Programacion I', true);
INSERT INTO t_materias
VALUES (default, 'Ingenieria de Software', true);

CREATE TABLE t_calificaciones
(
    id_t_calificaciones SERIAL,
    id_t_materias       INT NOT NULL,
    id_t_alumnos        INT NOT NULL,
    calificacion        DECIMAL(10, 2),
    fecha_registro      DATE DEFAULT NOW(),
    PRIMARY KEY (id_t_calificaciones),
    FOREIGN KEY (id_t_materias) REFERENCES t_materias (id_t_materias),
    FOREIGN KEY (id_t_alumnos) REFERENCES t_alumnos (id_t_usuarios)
);
create table t_alumnos
(
    id_t_usuarios int not null auto_increment,
    nombre        varchar(80),
    ap_paterno    varchar(80),
    ap_materno    varchar(80),
    activo        int(1),
    primary key (id_t_usuarios)
) ENGINE=INNODB;

insert into t_alumnos
values (default, "John", "Dow", "Down", 1);

create table t_materias
(
    id_t_materias int not null auto_increment,
    nombre        varchar(80),
    activo        int(1),
    primary key (id_t_materias)
) ENGINE=INNODB;

insert into t_materias
values (default, "Matematicas", 1);
insert into t_materias
values (default, "Programacion 1", 1);
insert into t_materias
values (default, "Ingenieria de Software", 1);

create table t_calificaciones
(
    id_t_calificaciones int not null auto_increment,
    id_t_materias       int not null,
    id_t_usuarios       int not null,
    calificacion        decimal(10, 2),
    fecha_registro      date,
    primary key (id_t_calificaciones),
    foreign key (id_t_materias) references t_materias (id_t_materias),
    foreign key (id_t_usuarios) references t_alumnos (id_t_usuarios)
) ENGINE=INNODB;
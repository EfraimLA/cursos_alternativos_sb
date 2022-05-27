## Escuela de Cursos Alternativos

### REST EndPoint JSON

Obtener calificaciones usando el ID del alumno 

```
curl --location --request GET 'https://cursos-alternativos-sb.herokuapp.com/calificaciones/1'
```

Registrar calificación con el ID del alumno y de la materia

```
curl --location --request POST 'https://cursos-alternativos-sb.herokuapp.com/calificaciones' \
--header 'Content-Type: application/json' \
--data-raw '{
    "calificacion": 8,
    "alumno": {
        "id": 1
    },
    "materia": {
        "id": 2
    }
}'
```

Actualizar una calificación por su ID

```
curl --location --request PUT 'https://cursos-alternativos-sb.herokuapp.com/calificaciones/1' \
--header 'Content-Type: application/json' \
--data-raw '{
    "calificacion": 9
}'
```

Eliminar una calificacion por su ID

```
curl --location --request DELETE 'https://cursos-alternativos-sb.herokuapp.com/calificaciones/1'
```



### Vista ZKoss

La vista zkoss está disponible en la dirección `https://cursos-alternativos-sb.herokuapp.com/`

**Funciones disponibles**

- Listado de alumnos con nombre y apellidos
- Búsqueda de alumnos por nombre y apellido

**Funciones pendientes**

- Vista de detalles (calificaciones) de alumno
- Registro de nueva calificación

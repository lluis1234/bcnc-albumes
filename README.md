# API de Álbumes y Fotos

Esta API muestra:

- Un listado de todos los álbumes: `http://{server}:{port}/albums`
- Un listado de todas las fotos de un álbum: `http://{server}:{port}/photos?albumId={albumId}`
- La foto a partir de su id: `http://{server}:{port}/photos/{photoId}`

## Arquitectura y Tecnologías

Este proyecto sigue el patrón de arquitectura hexagonal.

Por el tamaño de este microservicio no es óptimo el uso de este patrón. Pero se ha decidido usarlo porque era uno de los requerimientos del puesto de trabajo.

Las tecnologías principales usadas en este proyecto son:

- Spring Boot
- Swagger
- Jacoco

## Puesta en marcha

- Para arrancar el proyecto:

```sh
mvn spring-boot:run
```

Si se quiere una interface gráfica se puede acceder a http://{server}:{port}/swagger-ui/index.html

- Para ejecutar los test:

```sh
mvn test
```

- Después de ejecutar los test, se puede generar un reporte de la cobertura de código:

```sh
mvn jacoco:report
```

El reporte se generará en `target/site/jacoco/index.html`.

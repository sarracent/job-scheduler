# JOB SCHEDULER DELETE TABLES 
El siguiente proyecto ejecuta tareas de depuración de tablas sobre una Base de datos MySQL. 
Las mismas estan croneadas para que se ejecuten diariamente a una determinada hora.
El Scheduling de las tareas se pasa por configuración en el archivo application.propperties, es completamente parametrizable.

## Dependencias y versión de JAVA
Tanto las dependencias como la versión de JAVA utilizadas en el proyecto se pueden encontrar en el archivo pom.xml.

## Configuración
Los parámetros para el Scheduling de las tareas se puede encontrar en el arcivo application.propperties.
```bash
cron.expression=0 0 4 * * *
```
En dicho archivo también se puede encontrar configuración de los Logs y conexión a Base de Datos.
Archivo logback.xml para el rolling de los logs.

## Build del JAR
Se usa Maven como herramienta para el build del proyecto:
```bash
./mvnw clean package
```

## Ejecutar el JAR
```bash
java -jar target/job-scheduler-delete-tables-0.0.1-SNAPSHOT.jar
```

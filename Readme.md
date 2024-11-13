# BANCO - PROYECTO BACKEND

### Requisitos

Plugins que deben estar instalados en su IDE :
* [Lombok](http://projectlombok.org/) - *Libreria de Bytecode que genera automaticamente los Getters y Setters*.
* Java 17
---
Ejecutar DockerFile - Ambiente Linux

Creación de imagen docker
* sudo docker build -t banco:1.0 .

Creación de contenedor con la imagen construida
* sudo docker run -d -p 9090:8080 --name bancocontainer banco:1.0


Ejecutar por maven

Ejecutar el primer comando
* mvn clean install

Ejecutar el segundo comando
* mvn spring-boot:run
---

### Pasos para ejecutar en el postman
Antes de ejecutar se tiene que crear la carpeta llama New Api en el disco C, y luego importar el json Proyecto Interbank.postman_collection.json en el postman.

1.- Ejecutar el controller de Roles y luego crear.


2.-Ejecutar el controller de Users y luego asociarlo con los roles creados.


3.-Ejecutar el controller de Login, para generar el token de acceso.


4.-Agregar el token de acceso, en las demas ejecuciones de los endpoints en el postman.



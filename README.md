# app manager-backend 
---------------------
Este repo contiene el backend que provee de servicios Rest al frontend.

### Stack de Tecnologías utilizadas
* Git
* jdk-8
* MySql
* Maven
* Spring
* Hibernate
* Tomcat embebido de maven

### Build + Deploy + Run application (sobre la raiz del proyecto)
* mvn clean install (genera artefacto: war)
* mvn tomcat7:run (corre el tomcat embebido)
* mvn -Dmaven.tomcat.port=8888 tomcat7:run (si se requiere cambiar el puerto por defecto)

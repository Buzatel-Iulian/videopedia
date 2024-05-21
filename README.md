


## Setup & Startup

Inside `src/main/resources/application.properties` add the path to you preferred video folder into the `spring.application.media.music` variable.

Start the server by running the `mvn spring-boot:run` in the project folder.

Build and start project in Docker 

- Powershell `docker run -it --rm --name my-maven-project -p 8080:8080 -v ${PWD}:/usr/src/mymaven -w /usr/src/mymaven maven:eclipse-temurin mvn spring-boot:run`

- Linux terminal `docker run -it --rm --name my-maven-project -p 8080:8080 -v $(pwd):/usr/src/mymaven -w /usr/src/mymaven maven:eclipse-temurin mvn spring-boot:run`





### Ref

- https://stackoverflow.com/a/41489151

# flight-ticket-api

Havayolları biletleme sistemi için restful api

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.finartz.flight.ticketapi.TicketApiApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

### Clone

--------

```sh
git clone https://github.com/keza/flight-ticket-api.git
```

### Run

--------

```sh
cd flight-ticket-api
```

```shell
mvn spring-boot:run
```

## Create Docker Image

```docker
docker build -t finartz.com/java/ticket-api:latest .

docker run --rm -p 8080:8080 finartz.com/java/ticket-api
```

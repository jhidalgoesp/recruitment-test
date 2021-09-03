# TrustHab Engineer Recruitment Test

This project deliver the information of devices from devices.json throug an API and Web interface.

## Getting Started

Please download a copy of this project

### Prerequisites

Java 8

Maven

### Installing

```
mvn clean install
```

### Testing

```
mvn test
```

### Deployment

Run the Spring boot project

```
mvn spring-boot:run
```

Or run the provided start.sh script

```
sh start.sh
```

If you prefer Docker you can also build the image and run a container using

```
docker build -t recruitment-test .
docker run -d -p 9000:9000 --name recruitment-test recruitment-test
```

## Built With

- [Spring-Boot](https://projects.spring.io/spring-boot/) - The web framework used
- [Maven](https://maven.apache.org/) - Dependency Management

#### If you have any question feel free to contact me!

- Jose Hidalgo(http://github.com/jhidalgoesp)

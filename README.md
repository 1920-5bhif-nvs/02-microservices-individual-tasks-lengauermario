# 02-microservices-individual-tasks-lengauermario

## Project RestService
```
mvn io.quarkus:quarkus-maven-plugin:0.23.2:create \
    -DprojectGroupId=at.htl \
    -DprojectArtifactId=cinema \
    -DclassName="at.htl.cinema.boundary.CinemaResource" \
    -Dpath="/cinema" \
    -Dextensions="kotlin,resteasy-jsonb"
```
## Project Microservice
```
mvn io.quarkus:quarkus-maven-plugin:0.23.2:create \
    -DprojectGroupId=at.htl \
    -DprojectArtifactId=microservice\
    -DclassName="at.htl.microservice.boundery.CinemaResource" \
    -Dpath="/cinema"
```
## Add Maven Depenencies
```
mvn quarkus:add-extension -Dextensions="health"
mvn quarkus:add-extension -Dextensions="metrics"
mvnw quarkus:add-extension -Dextensions="smallrye-fault-tolerance"
```

## Prometheus
Prometheus ist ein Open-Source-Toolkit zur Systemüberwachnung. 
Es hilft User generierte Daten zu visualisieren.

## Istio
Mit Istio können Benutzer den Datenverkehr verwalten, die Sicherheit für das Servicegitter einrichten und Methodenaufrufe nachverfolgen, die Netzwerknutzung überwachen und die dienstübergreifende Protokollierung nutzen.
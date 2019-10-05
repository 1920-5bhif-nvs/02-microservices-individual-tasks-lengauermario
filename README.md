# 02-microservices-individual-tasks-lengauermario

Quarkus, Kotlin, Postgres

## starter Project
mvn io.quarkus:quarkus-maven-plugin:0.23.2:create \
    -DprojectGroupId=at.htl \
    -DprojectArtifactId=cinema \
    -DclassName="at.htl.cinema.boundary.CinemaResource" \
    -Dpath="/cinema" \
    -Dextensions="kotlin,resteasy-jsonb"

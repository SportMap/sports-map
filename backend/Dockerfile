FROM eclipse-temurin:21.0.2_13-jdk-alpine as build

WORKDIR /app

COPY gradlew .
COPY .gradle .gradle
COPY gradle gradle
COPY build.gradle .
COPY src src

RUN ./gradlew build -x check

FROM eclipse-temurin:21.0.2_13-jre-alpine

RUN addgroup -S demo && adduser -S demo -G demo
USER demo

VOLUME /tmp
COPY --from=build /app/build/libs /app/build/libs

EXPOSE 8080

CMD ["java", "-jar", "/app/build/libs/app-0.0.1-SNAPSHOT.jar"]
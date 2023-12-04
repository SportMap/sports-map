FROM openjdk:21-bookworm
EXPOSE 8080 5005

WORKDIR /app
RUN apt update && apt install -y inotify-tools

COPY . /app
RUN chmod +x /app/gradlew /app/watch-and-restart.sh

ENTRYPOINT ["/app/watch-and-restart.sh"]
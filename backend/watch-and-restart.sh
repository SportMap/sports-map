#!/bin/bash

start_app() {
    java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005 -jar /app/build/libs/*.jar &
    APP_PID=$!
}

stop_app() {
    if [ ! -z "$APP_PID" ]; then
        kill $APP_PID
    fi
}

./gradlew build --no-daemon -x test
start_app

while true; do
    inotifywait -e modify -r /app/src
    echo "Source changed - rebuilding..."
    ./gradlew build --no-daemon -x test

    echo "Restarting the application..."
    stop_app
    start_app
done
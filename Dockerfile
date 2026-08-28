FROM gradle:9.5.1-jdk21-alpine
WORKDIR /app
#COPY gradlew gradlew.bat ./
#COPY gradle ./gradle
ENTRYPOINT ["./gradlew", "bootRun", "--no-daemon"]

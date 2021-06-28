FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=TheByteFoxBot
ENV BOT_TOKEN=1376500093:AAFNVrrpsqLXOb5zmhvSQGl33fGK_7COxZE_uso
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-jar", "/app.jar"]
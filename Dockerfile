FROM bellsoft/liberica-openjre-alpine:17.0.5
VOLUME /tmp
ADD target/*.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -jar /app.jar

#docker push snaiperlfc/docker-comp:0.0.1-SNAPSHOT

FROM openjdk:8u141-jre-slim
#WORKDIR /usr/local/java
SHELL ["bash", "-c"]
ADD authentication-service-ws/target/authentication-service-exec.jar app.jar
ADD entrypoint.sh entrypoint.sh
RUN chmod +x /entrypoint.sh
RUN touch /app.jar
# Install prerequisites
RUN apt-get update && apt-get install -y curl
EXPOSE 8080
ENTRYPOINT ["/entrypoint.sh"]

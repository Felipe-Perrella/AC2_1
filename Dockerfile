# Usar uma imagem leve do JDK 22
#FROM openjdk:22-jre-slim
FROM openjdk:jdk-22

# Definir o diretório de trabalho dentro do container
WORKDIR /ac2_1

# Copiar o arquivo .jar gerado para o diretório do container
COPY target/ac2_1-0.0.1-SNAPSHOT.jar /ac2_1/ac2_1-0.0.1-SNAPSHOT.jar
EXPOSE 8484

# Comando para executar a aplicação com Java 22
CMD ["java", "-XX:+UseContainerSupport", "-Xmx512m", "-Dserver.port=8585", "-jar", "ac2_1-0.0.1-SNAPSHOT.jar"]

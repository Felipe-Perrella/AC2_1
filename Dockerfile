# Usar uma imagem JDK 21 - por o 22 não estar funcionando
FROM openjdk:21

# Definir o diretório de trabalho dentro do container
WORKDIR /ac2_1

# Copiar o arquivo .jar gerado para o diretório do container
COPY target/*.jar /ac2_1/AC2_1-0.0.1-SNAPSHOT.jar
#EXPOSE 8484
EXPOSE 8585
#EXPOSE 8080

# Comando para executar a aplicação com Java 21
CMD ["java", "-XX:+UseContainerSupport", "-Xmx512m", "-Dserver.port=8585", "-jar", "AC2_1-0.0.1-SNAPSHOT.jar"]

# Usa una immagine con Java già installato
FROM eclipse-temurin:24-jre

# Crea una directory di lavoro
WORKDIR /app

# Copia il JAR nel container
COPY sommatore.jar sommatore.jar

# Comando di avvio dell'applicazione
CMD ["java", "-jar", "sommatore.jar"]
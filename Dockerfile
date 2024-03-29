FROM maven:3.8.2-jdk-11
WORKDIR /springWebApp
COPY . .
RUN ls -la
RUN mvn -e clean install
CMD mvn spring-boot:run
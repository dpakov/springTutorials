FROM maven:3.8.2-jdk-11
WORKDIR /springWebApp
COPY . .
RUN mvn -e clean install
CMD mvn spring-boot:run
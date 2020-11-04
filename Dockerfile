FROM maven:3.6.3-openjdk-11

RUN mkdir -p /usr/src/app

WORKDIR /usr/src/app

COPY . .

EXPOSE 8080

CMD ["mvn", "spring-boot:run"]
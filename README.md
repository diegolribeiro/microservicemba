# Trabalho de MicroServiço

## Backend

- Backend desenvolvido em java com spring
- Imagem openjdk:8-jdk-alpine
- Para gerar o container desta aplicação utilizamos o Dockerfile que se encontra no diretório \BackEnd\forum\target
- A imagem foi commitada no repositório dribeirodocker/firstspringapplication

## Frontend

- Frontend desenvolvido em angular
- Imagem node:10 e nginx:alpine
- Para gerar o container desta aplicação utilizamos o Dockerfile que se encontra no diretório FrontEnd\projeto_piloto\cmail
- A imagem foi commitada no repositório dribeirodocker/angapp

## Banco Mysql
- Utilizamos o banco de dados mysql 8, imagem oficial.

# Docker Compose
```
version: '3'
services:
    database:
        image: mysql
        container_name: database
        environment:
            MYSQL_ROOT_PASSWORD: root
            MYSQL_DATABASE: fj27_spring
            MYSQL_USER: caelum
            MYSQL_PASSWORD: caelum
        ports:
            - 3306:3306
        networks:
            - production-network

    angApp:
        image: dribeirodocker/angapp
        container_name: angularapp
        ports:
            - 80:80
        networks:
            - production-network
        depends_on:
            - database
    
    springApp:
        image: dribeirodocker/springapplicationv2
        container_name: springapp
        ports:
            - 8080:8080
        networks: 
            - production-network
        depends_on:
            - database

networks:
    production-network:
        driver: bridge
```

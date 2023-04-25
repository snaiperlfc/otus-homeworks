# Getting Started

## Homework - 1

````
Домашнее задание
Обернуть приложение в docker-образ и запушить его на Dockerhub

Описание/Пошаговая инструкция выполнения домашнего задания:

Шаг 1. Создать минимальный сервис, который
1. отвечает на порту 8000
2. имеет http-метод:
- GET /health/
- RESPONSE: {"status": "OK"}

Шаг 2. Cобрать локально образ приложения в докер.
Запушить образ в dockerhub
На выходе необходимо предоставить
1. имя репозитория и тэг на Dockerhub
2. ссылку на github c Dockerfile, либо приложить Dockerfile в ДЗ
````

### Docker Compose

The `docker-compose.yml` file that is in the root directory of this project will provide you with a `v3.7` Docker
Compose manifest that you can use to run this application locally. Just run the following commands.

```bash
docker-compose up -d
docker-compose logs -f
```

Get health, run the following commands:

````bash
curl -L 'localhost:8000/health'
````

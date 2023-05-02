# Getting Started

````
Домашнее задание
Основы работы с Kubernetes (Часть 2)

Цель:
В этом ДЗ вы научитесь создавать минимальный сервис.

Описание/Пошаговая инструкция выполнения домашнего задания:

Шаг 1. Создать минимальный сервис, который
1. отвечает на порту 8000
2. имеет http-метод
   GET /health/
   RESPONSE: {"status": "OK"}

Шаг 2. Cобрать локально образ приложения в докер.
Запушить образ в dockerhub

Шаг 3. Написать манифесты для деплоя в k8s для этого сервиса.
Манифесты должны описывать сущности: Deployment, Service, Ingress.
В Deployment могут быть указаны Liveness, Readiness пробы.
Количество реплик должно быть не меньше 2. Image контейнера должен быть указан с Dockerhub.
Хост в ингрессе должен быть arch.homework. В итоге после применения манифестов GET запрос на http://arch.homework/health должен отдавать {“status”: “OK”}.

Шаг 4. На выходе предоставить
0. ссылку на github c манифестами. Манифесты должны лежать в одной директории, так чтобы можно было их все применить одной командой kubectl apply -f .
1. url, по которому можно будет получить ответ от сервиса (либо тест в postmanе).

Задание со звездой (+5 баллов):*
В Ingress-е должно быть правило, которое форвардит все запросы с /otusapp/{student name}/* на сервис с rewrite-ом пути. Где {student name} - это имя студента.
````

## Homework - 2

### Minikube

Minikube quickly sets up a local Kubernetes cluster on macOS, Linux, and Windows.

Apply manifests, run the following commands:

````bash
kubectl apply -f ./deployment
````

Apply that helm if ingress-nginx is not exists in your minikube:

````bash
helm install nginx --create-namespace -n ingress-nginx ingress-nginx/ingress-nginx -f ./nginx-http-gateway.yaml
````

Get arch.homework health, run the following commands:

````bash
curl -L 'http://arch.homework/health'
curl -L 'http://arch.homework/otusapp/a.zimin/health'
````

Or you can use newman, run the following commands:

````bash
newman run ./otus.postman_collection.json
````

Delete manifests, run the following commands:

````bash
kubectl delete -f ./deployment
````

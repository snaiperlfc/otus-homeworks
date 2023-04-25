# Getting Started

````
Домашнее задание
Инфраструктурные паттерны

Цель:
В этом ДЗ вы создадите простейший RESTful CRUD.

Описание/Пошаговая инструкция выполнения домашнего задания:

Сделать простейший RESTful CRUD по созданию, удалению, просмотру и обновлению пользователей.
Пример API - https://app.swaggerhub.com/apis/otus55/users/1.0.0
Добавить базу данных для приложения.
Конфигурация приложения должна хранится в Configmaps.
Доступы к БД должны храниться в Secrets.
Первоначальные миграции должны быть оформлены в качестве Job-ы, если это требуется.
Ingress-ы должны также вести на url arch.homework/ (как и в прошлом задании)
На выходе должны быть предоставлена

1. ссылка на директорию в github, где находится директория с манифестами кубернетеса
2. инструкция по запуску приложения.
- команда установки БД из helm, вместе с файлом values.yaml.
- команда применения первоначальных миграций
- команда kubectl apply -f, которая запускает в правильном порядке манифесты кубернетеса
3. Postman коллекция, в которой будут представлены примеры запросов к сервису на создание, получение, изменение и удаление пользователя. Важно: в postman коллекции использовать базовый url - arch.homework.

Задание со звездочкой:
+5 балла за шаблонизацию приложения в helm чартах
````

## Homework - 3

### Minikube + Helm

Helm - package manager for Kubernetes

Add the cetic helm repository which contains the `postgresql` charts:

```bash
helm repo add cetic https://cetic.github.io/helm-charts
helm repo update
```

### Helm Deployment(Local)

Once Helm is set up, deploying the distributed system to any Kubernetes cluster is quite simple.

```bash
helm install otus ../otus-chart 
```

### Helm Deployment(Remote)

Helm install from GitHub repository. Before install add repository, use the following command.

````bash
helm repo add otus https://raw.githubusercontent.com/snaiperlfc/otus-homeworks/master
helm repo update
````

Install otus helm chart, use the following command.

````bash
helm install otus otus-chart
````

To check the status of the deployment, use the following command.

```bash
kubectl get pods
```

The following output will show you the full state of the cluster.

```text
NAME                                                   READY   STATUS    RESTARTS      AGE
my-release-nginx-ingress-controller-85bcd5d94c-2hw44   1/1     Running   0             17h
otus-otus-chart-7f68457b8c-kpx9r                       1/1     Running   1 (60s ago)   96s
otus-otus-chart-7f68457b8c-xhd8g                       1/1     Running   1 (61s ago)   96s
otus-postgresql-0                                      1/1     Running   0             96s
```

Create User, run the following commands:

````bash
curl -L 'http://arch.homework/users' -H 'Content-Type: application/json' --data-raw '{
    "username": "johndoe589",
    "firstName": "John",
    "lastName": "Doe",
    "email": "bestjohn@doe.com",
    "phone": "+71002003040"
}'
````

Get all Users, run the following commands:

````bash
curl -L 'http://arch.homework/users'
````

Update User, run the following commands:

````bash
curl -L -X PUT 'http://arch.homework/users/1' -H 'Content-Type: application/json' --data-raw '{
    "username": "johndoe589",
    "firstName": "John",
    "lastName": "Doe1",
    "email": "bestjohn@doe.com",
    "phone": "+71002003040"
}'
````

Delete User, run the following commands:

````bash
curl -L -X DELETE 'http://arch.homework/users/1'
````

Or you can use newman, run the following commands:

````bash
newman run ./otus.postman_collection.json
````

Uninstall helm, run the following commands:

````bash
helm uninstall otus
````

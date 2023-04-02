# Getting Started

## Homework - 1
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

## Homework - 2

### Minikube

Minikube quickly sets up a local Kubernetes cluster on macOS, Linux, and Windows.

Apply manifests, run the following commands:

````bash
kubectl apply -f ./deployment
````

Apply that helm if ingress-nginx is not exists in your minikube:

````bash
helm install nginx ingress-nginx/ingress-nginx -f nginx-ingress.yaml
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

## Homework - 3

### Minikube + Helm

Helm - package manager for Kubernetes

Add the cetic helm repository which contains the `postgresql` charts:

```bash
helm repo add cetic https://cetic.github.io/helm-charts
heln repo update
```

### Helm Deployment

Once Helm is set up, deploying the distributed system to any Kubernetes cluster is quite simple.

```bash
helm install otus ./otus-chart 
```

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

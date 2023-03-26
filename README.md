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

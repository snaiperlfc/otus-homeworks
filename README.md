# Getting Started

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

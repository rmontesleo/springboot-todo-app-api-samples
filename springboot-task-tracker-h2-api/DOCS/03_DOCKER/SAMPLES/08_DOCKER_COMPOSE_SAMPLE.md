

```yaml
version: '3.8'

services:
  api:
    build:
      context: .
      target: development
    container_name: task-tracker-h2-api-docker-container
    ports:
      - 8080:8080

networks:
  default:
    name: task-tracker-h2-api-docker-network
```
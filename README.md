# Woodie

A stupid app

## Run

Get a postgres server up and running at localhost:5432, then issue

```bash
psql
CREATE DATABASE "resident";
GRANT ALL PRIVILEGES ON DATABASE "resident" TO postgres;
```
Then you can run the Spring Boot run configuration
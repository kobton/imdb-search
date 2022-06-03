###Initialize DB with podman

Start podman
```podman machine start```

Pull and run PostgresDB
```podman run --name my-postgres -e POSTGRES_PASSWORD=mysecretpassword -d -p 5432:5432  docker.io/postgres:9.4```

Bash into container
```podman exec -it fa578c6b2eb1 bash```

Create default user and db
```psql -U postgres postgres```

List DB content
```\d movies```

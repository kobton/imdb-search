###Initialize DB with podman

Start podman
```podman machine start```

If issues
```Get-Service vmcompute | Restart-Service``` in Powershell

Pull and run PostgresDB
```podman run --name my-postgres -e POSTGRES_PASSWORD=mysecretpassword -d -p 5432:5432  docker.io/postgres:9.4```

List existing non-running
```podman ps -a```

Start container
```podman start my-postgres```

Bash into container
```podman exec -it d117521109ca bash```

Create default user and db
```psql -U postgres postgres```

List DB content

```\d movies```

```SELECT * FROM movies;```

Run maven project
```mvn spring-boot:run```
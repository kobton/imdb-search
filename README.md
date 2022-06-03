podman run --name my-postgres -e POSTGRES_PASSWORD=mysecretpassword -e POSTGRES_USER=postgres -e POSTGRES_DB=postgres -d -p 5432:5432  docker.io/postgres:9.4 

podman exec -it fa578c6b2eb1 bash

podman logs --follow=true fa578c6b2eb1

psql -U postgres postgres

\d movies

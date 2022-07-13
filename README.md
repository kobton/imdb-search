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

###Indexing

Query title before B-tree index

``` 
postgres=# EXPLAIN ANALYZE SELECT * FROM Imdb WHERE title = 'The Agent';
QUERY PLAN
------------------------------------------------------------------------------------------------
Seq Scan on imdb  (cost=0.00..42.06 rows=1 width=55) (actual time=0.221..0.252 rows=1 loops=1)
Filter: ((title)::text = 'The Agent'::text)
Rows Removed by Filter: 1524
Planning time: 0.151 ms
Execution time: 0.271 ms
```

After creating "imdb_title_desc" btree (title DESC) index

```
postgres=# EXPLAIN ANALYZE SELECT * FROM Imdb WHERE title = 'The Agent';
                                                      QUERY PLAN
-----------------------------------------------------------------------------------------------------------------------
 Index Scan using imdb_title_desc on imdb  (cost=0.28..8.29 rows=1 width=55) (actual time=0.020..0.021 rows=1 loops=1)
   Index Cond: ((title)::text = 'The Agent'::text)
 Planning time: 0.078 ms
 Execution time: 0.038 ms
```

Consistently reduced execution time.
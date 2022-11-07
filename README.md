# hash_offchain_storage #

# Offchain key-value storage

The key is the sha256 of the value stored

## Build & Run ##

```sh
$ cd hash_offchain_storage
$ sbt
> jetty:start
```
open [http://localhost:8080/](http://localhost:8080/) in your browser.

## Enpoints

+ get("/add/:value") 

+ get("/get/:hash")

+ get("/getAll")

# Snapshoting (TODO: make them only accessible via localhost calls)

get("/save")

get("/restore")
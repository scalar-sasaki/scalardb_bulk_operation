# 説明

```shell
touch scalardb-cluster.peroperties
```

```properties
scalar.db.storage=jdbc
scalar.db.contact_points=jdbc:postgresql://postgresql:5432/postgres
scalar.db.username=postgres
scalar.db.password=postgres
scalar.db.cluster.node.standalone_mode.enabled=true
scalar.db.cross_partition_scan.enabled=true
scalar.db.sql.enabled=true

# Disable authentication for local development
scalar.db.cluster.auth.enabled=false

# License key configurations
scalar.db.cluster.node.licensing.license_key=<lisenceKey>
calar.db.cluster.node.licensing.license_check_cert_pem=<pem>
```


```shell
curl -OL https://github.com/scalar-labs/scalardb/releases/download/v3.17.1/scalardb-schema-loader-3.17.1.jar
docker-compose up -d
java -jar scalardb-schema-loader-3.17.1.jar --config scalardb.properties --schema-file schema.json --coordinator
```

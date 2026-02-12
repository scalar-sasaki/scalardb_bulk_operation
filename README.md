# 説明

```shell
docker-compose up -d
curl -OL https://github.com/scalar-labs/scalardb/releases/download/v3.17.1/scalardb-schema-loader-3.17.1.jar
java -jar scalardb-schema-loader-3.17.1.jar --config scalardb.properties --schema-file schema.json --coordinator
```

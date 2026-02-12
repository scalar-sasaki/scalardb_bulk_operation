# 説明

Step1
```shell
touch scalardb-cluster.properties
```

Step2 scalardb-cluster.propertiesに下記を書き込み、ライセンスキーとPemを入れる

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

Step3 

```shell
curl -OL https://github.com/scalar-labs/scalardb/releases/download/v3.17.1/scalardb-schema-loader-3.17.1.jar
docker-compose up -d
```

Step4  これで動作確認

```shell
curl -X POST "http://localhost:8080/api/users/bulk?count=100"
curl -X GET "http://localhost:8080/api/users/bulk"
```

# それぞれの繊維先！
```puml
  ┌────────────┬───────────────────────┬──────────────────┐
  │  サービス  │          URL          │     認証情報     │
  ├────────────┼───────────────────────┼──────────────────┤
  │ Prometheus │ http://localhost:9090 │ なし             │
  ├────────────┼───────────────────────┼──────────────────┤
  │ Grafana    │ http://localhost:3001 │ admin / admin123 │
  └────────────┴───────────────────────┴──────────────────┘
```
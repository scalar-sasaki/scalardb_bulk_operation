FROM eclipse-temurin:21-jdk-alpine AS builder

WORKDIR /app

# Gradle Wrapper と設定ファイルをコピー
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

# ScalarDB関連のファイルもコピー
COPY scalardb.properties .
COPY scalardb-cluster.properties .
COPY schema.json .

# ソースコードをコピー
COPY src src

# 実行権限を付与してビルド
RUN chmod +x ./gradlew
RUN ./gradlew bootJar --no-daemon

# 実行ステージ
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# ビルドされたJARファイルをコピー
COPY --from=builder /app/build/libs/*.jar app.jar

# ScalarDB設定ファイルをコピー
COPY --from=builder /app/scalardb-cluster.properties .

EXPOSE 8080

# JVM メトリクス取得のためのオプション追加
ENTRYPOINT ["java", \
    "-XX:+UseContainerSupport", \
    "-XX:MaxRAMPercentage=75.0", \
    "-Djava.security.egd=file:/dev/./urandom", \
    "-jar", "app.jar"]
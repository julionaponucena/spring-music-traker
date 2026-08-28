# AGENTS.md

## Docker

### Build de produção (Dockerfile-prd)

```bash
docker build -f Dockerfile-prd -t spring-teste-prd:latest .
```

- O builder usa `gradle:9.5.1-jdk21-alpine` (mesma versão do wrapper, em `gradle/wrapper/gradle-wrapper.properties`). Não use imagens Gradle sem versão pinada (`gradle:jdk21-ubi10`) — o build fica não-reproduzível.
- Não rodar `gradle dependencies` como passo separado: o `bootJar` já resolve e baixa plugins/dependências.

### Rodar com banco (docker compose)

```bash
docker compose up -d --build
```

- O `app` usa `SPRING_DATASOURCE_URL` via env (definido no `docker-compose.yml`) para alcançar o Postgres do compose, então `application.yaml` usa `${SPRING_DATASOURCE_URL:...}`.
- Healthcheck depende de `spring-boot-starter-actuator` (adicionado em `build.gradle`).

### DNS e builds (importante nesta máquina)

O host só expõe nameservers IPv6 (2804:...) via systemd-resolved. O BuildKit copia esses upstreams para o container de build, e o bridge do Docker não tem rota IPv6, então **`docker build` falhava resolvendo qualquer host** (ex.: plugin do Spring Boot).

Correção aplicada em `/etc/docker/daemon.json`:

```json
{ "dns": ["8.8.8.8", "1.1.1.1"] }
```

Se um build voltar a falhar com `could not resolve`, verifique se o `daemon.json` continua com DNS IPv4 e que o daemon foi reiniciado (`sudo systemctl restart docker`).
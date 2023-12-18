FROM postgres:14

WORKDIR /docker-entrypoint-initdb.d/

COPY /initdb/01-schema.sql .

ENV POSTGRES_DB dbname
ENV POSTGRES_USER user
ENV POSTGRES_PASSWORD password

FROM postgres:11
LABEL maintainer="ovidio.zea@gmail.com"

ENV POSTGRES_PASSWORD=postgres123
ENV POSTGRES_USER=postgres

COPY ./scripts/ /docker-entrypoint-initdb.d/
RUN chmod 744 /docker-entrypoint-initdb.d/DDL1.sql
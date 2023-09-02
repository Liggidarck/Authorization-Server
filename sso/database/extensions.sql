--liquibase formatted sql

--changeset george:extensions-1
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
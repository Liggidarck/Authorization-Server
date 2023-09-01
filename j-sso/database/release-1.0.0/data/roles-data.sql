--liquibase formatted sql

--changeSet george:roles-data-01
INSERT INTO sso.roles(role_code, role_description)
VALUES ('USER_SSO', 'Роль обычного пользователя DL-SSO');
CREATE TABLE User (
    id BIGINT PRIMARY KEY,
    keycloakUUID VARCHAR(36) NOT NULL,
    username VARCHAR(255) NOT NULL UNIQUE,
    sex VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    avatar VARCHAR(255),
    description TEXT,
    city VARCHAR(255),
    CONSTRAINT uq_keycloak UNIQUE (keycloakUUID)
);

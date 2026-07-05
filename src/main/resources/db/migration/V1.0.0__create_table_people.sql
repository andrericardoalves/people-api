CREATE TABLE IF NOT EXISTS people (
    id BIGINT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    nickname VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    date_of_birth DATE,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE SEQUENCE IF NOT EXISTS people_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    CACHE 1
    OWNED BY people.id;
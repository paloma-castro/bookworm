CREATE TABLE book(
    id INT8 PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name TEXT NOT NULL,
    author TEXT NOT NULL,
    genre TEXT NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE
);
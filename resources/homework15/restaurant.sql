CREATE SCHEMA restaurant_schema;

SET SEARCH_PATH = restaurant_schema;

CREATE TABLE restaurant
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(32) UNIQUE NOT NULL
);

CREATE TABLE review
(
    id            SERIAL PRIMARY KEY,
    text          VARCHAR(256),
    restaurant_id INTEGER REFERENCES restaurant (id)
);

CREATE TABLE dish
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(32) UNIQUE NOT NULL
);

CREATE TABLE restaurant_dishes
(
    id            SERIAL PRIMARY KEY,
    restaurant_id INTEGER REFERENCES restaurant (id),
    dish_id       INTEGER REFERENCES dish (id)
);
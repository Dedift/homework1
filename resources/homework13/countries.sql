CREATE SCHEMA countries_schema;

CREATE TABLE countries_schema.countries
(
    name              CHARACTER VARYING(64),
    population        DECIMAL,
    area              DECIMAL,
    official_language CHARACTER VARYING(64)
);

INSERT INTO countries_schema.countries (name, population, area, official_language)
VALUES ('Great Britain', 66.273576, 243.809, 'English'),
       ('Poland', 38.244000, 312.679, 'Polish'),
       ('Belarus', 9.349645, 207.600, 'Belorussian'),
       ('Russia', 146.171015, 17125.191, 'Russian'),
       ('Lithuania', 2.795175, 65.301, 'Lithuanian'),
       ('Estonia', 1.330068, 45.227, 'Estonian'),
       ('Portugal', 10.347892, 92.225, 'Portuguese'),
       ('Japan', 125.552000, 377.944, 'Japanese'),
       ('China', 1411.778724, 9598.962, 'Chinese'),
       ('USA', 333.449281, 9519.431, 'English');

SELECT *
FROM countries_schema.countries
WHERE population > 50;

SELECT *
FROM countries_schema.countries
ORDER BY area;

UPDATE countries_schema.countries
SET official_language = 'Polish'
WHERE name = 'Russia';

DELETE
FROM countries_schema.countries
WHERE population IN (
    SELECT MAX(population)
    FROM countries_schema.countries
);

SELECT SUM(e.population) AS sum_population
FROM countries_schema.countries e
WHERE e.area IN (
    SELECT (p.area)
    FROM countries_schema.countries p
    ORDER BY p.area
    LIMIT 5
    );
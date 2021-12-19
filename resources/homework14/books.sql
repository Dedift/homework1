CREATE SCHEMA books_schema;

SET SEARCH_PATH = books_schema;

CREATE TABLE book
(
    id              SERIAL PRIMARY KEY,
    name            VARCHAR(32) NOT NULL,
    number_of_pages INTEGER     NOT NULL,
    genre           VARCHAR(32) NOT NULL
);

CREATE TABLE author
(
    id           SERIAL PRIMARY KEY,
    full_name    VARCHAR(64) NOT NULL,
    dat_of_birth DATE        NOT NULL,
    nationality  VARCHAR(32) NOT NULL
);

CREATE TABLE author_books
(
    id        SERIAL PRIMARY KEY,
    book_id   INTEGER REFERENCES book (id) ON DELETE CASCADE,
    author_id INTEGER REFERENCES author (id) ON DELETE CASCADE
);


INSERT INTO book (name, number_of_pages, genre)
VALUES ('Талисман', 800, 'Мистика'),
       ('Кладбище домашних животных', 379, 'Ужасы'),
       ('Дьюма-Ки', 672, 'Ужасы'),
       ('Обитель Теней', 608, 'Ужасы'),
       ('Война и мир', 1225, 'Роман'),
       ('Анна Каренина', 864, 'Роман'),
       ('Автостопом по галактике', 346, 'Научная фантастика'),
       ('Лосось сомнений', 320, 'Фантастика'),
       ('Частная жизнь Чингисхана', 453, 'Фантастика'),
       ('Удушье', 320, 'Сатира');

INSERT INTO author (full_name, dat_of_birth, nationality)
VALUES ('Стивен Кинг', '21-09-1947', 'Американец'),
       ('Питер Страуб', '02-03-1943', 'Американец'),
       ('Лев Толстой', '28-08-1828', 'Русский'),
       ('Дуглас Адамс', '12-10-1979', 'Англичанин'),
       ('Чак Паланик', '21-02-1962', 'Американец'),
       ('Грэм Чепмен', '08-01-1941', 'Американец');

INSERT INTO author_books(book_id, author_id)
VALUES ((SELECT id FROM book WHERE name = 'Талисман'), (SELECT id FROM author WHERE full_name = 'Стивен Кинг')),
       ((SELECT id FROM book WHERE name = 'Талисман'), (SELECT id FROM author WHERE full_name = 'Питер Страуб')),
       ((SELECT id FROM book WHERE name = 'Кладбище домашних животных'),  (SELECT id FROM author WHERE full_name = 'Стивен Кинг')),
       ((SELECT id FROM book WHERE name = 'Дьюма-Ки'), (SELECT id FROM author WHERE full_name = 'Стивен Кинг')),
       ((SELECT id FROM book WHERE name = 'Обитель Теней'), (SELECT id FROM author WHERE full_name = 'Питер Страуб')),
       ((SELECT id FROM book WHERE name = 'Война и мир'), (SELECT id FROM author WHERE full_name = 'Лев Толстой')),
       ((SELECT id FROM book WHERE name = 'Анна Каренина'), (SELECT id FROM author WHERE full_name = 'Лев Толстой')),
       ((SELECT id FROM book WHERE name = 'Автостопом по галактике'),  (SELECT id FROM author WHERE full_name = 'Дуглас Адамс')),
       ((SELECT id FROM book WHERE name = 'Лосось сомнений'), (SELECT id FROM author WHERE full_name = 'Дуглас Адамс')),
       ((SELECT id FROM book WHERE name = 'Частная жизнь Чингисхана'), (SELECT id FROM author WHERE full_name = 'Дуглас Адамс')),
       ((SELECT id FROM book WHERE name = 'Частная жизнь Чингисхана'),(SELECT id FROM author WHERE full_name = 'Грэм Чепмен')),
       ((SELECT id FROM book WHERE name = 'Удушье'), (SELECT id FROM author WHERE full_name = 'Чак Паланик'));

SELECT a.full_name AS book_author, b.name AS book_name
FROM author_books
         JOIN author a ON author_books.author_id = a.id
         JOIN book b ON author_books.book_id = b.id;

SELECT DISTINCT b.name AS book_name
FROM author_books
         JOIN author a ON author_books.author_id = a.id
         JOIN book b ON author_books.book_id = b.id
WHERE a.nationality = 'Американец';

SELECT DISTINCT b.name AS book_name
FROM author_books
         JOIN author a ON author_books.author_id = a.id
         JOIN book b ON author_books.book_id = b.id
WHERE (EXTRACT(YEAR FROM a.dat_of_birth)) > 1900;

DELETE
FROM book b
WHERE b.name = 'Талисман';

SELECT a.full_name AS book_author, a.nationality, AVG(b.number_of_pages)
FROM author_books
         JOIN author a ON author_books.author_id = a.id
         JOIN book b ON author_books.book_id = b.id
GROUP BY a.dat_of_birth, a.full_name, a.nationality
ORDER BY a.dat_of_birth;

SELECT a.full_name AS book_author, a.nationality, AVG(b.number_of_pages) AS average_number_of_written_pages
FROM author_books
         JOIN author a ON author_books.author_id = a.id
         JOIN book b ON author_books.book_id = b.id
GROUP BY a.full_name, a.nationality;

SELECT a.full_name AS book_author, AVG(b.number_of_pages) AS average_number_of_written_pages
FROM author_books
         JOIN author a ON author_books.author_id = a.id
         JOIN book b ON author_books.book_id = b.id
GROUP BY a.full_name
HAVING AVG(b.number_of_pages) > (SELECT AVG(b.number_of_pages)
                                 FROM author_books
                                          JOIN author a ON author_books.author_id = a.id
                                          JOIN book b ON author_books.book_id = b.id);
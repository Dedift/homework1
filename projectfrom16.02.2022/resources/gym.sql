CREATE SCHEMA gym_schema;

SET SEARCH_PATH = gym_schema;

CREATE TABLE Personal_trainer
(
    id            SERIAL PRIMARY KEY,
    firstName     VARCHAR(32),
    lastName      VARCHAR(32),
    gender        VARCHAR(32),
    date_of_birth DATE,
    experience    INTEGER
);

CREATE TABLE "User"
(
    id                  SERIAL PRIMARY KEY,
    email               VARCHAR(32),
    password            VARCHAR(32),
    gender              VARCHAR(32),
    role                VARCHAR(32),
    first_name          VARCHAR(32),
    last_name           VARCHAR(32),
    phone_number        VARCHAR(32),
    date_of_birth       DATE,
    bank_card           VARCHAR(32),
    personal_trainer_id INTEGER REFERENCES Personal_trainer (id) ON DELETE CASCADE
);

CREATE TABLE "Order"
(
    id          SERIAL PRIMARY KEY,
    purpose     VARCHAR(32),
    seasons      VARCHAR(32),
    count_train INTEGER,
    user_id     INTEGER REFERENCES "User" (id) ON DELETE CASCADE
);

CREATE TABLE Review
(
    id      SERIAL PRIMARY KEY,
    text    VARCHAR(512),
    user_id INTEGER REFERENCES "User" (id) ON DELETE CASCADE
);

CREATE TABLE Subscription
(
    id                    SERIAL PRIMARY KEY,
    count_remaining_Train INTEGER,
    time_of_action        DATE,
    price                 INTEGER,
    user_id               INTEGER REFERENCES "User" (id) ON DELETE CASCADE
);

CREATE TABLE Train_day
(
    id      SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES "User" (id) ON DELETE CASCADE
);

CREATE TABLE Exercise
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(32)
);

CREATE TABLE Train_day_exercises
(
    id           SERIAL PRIMARY KEY,
    exercise_id  INTEGER REFERENCES Exercise (id) ON DELETE CASCADE,
    train_day_id INTEGER REFERENCES Train_day (id) ON DELETE CASCADE
);

INSERT INTO Personal_trainer (firstName, lastName, gender, date_of_birth, experience)
VALUES ('Sveta', 'Popova', 'female', '2030-02-22', 3),
       ('POA', 'Polina', 'female', '2002-02-22', 1),
       ('Svesadgsta', 'Pdavopova', 'female', '2000-02-22', 3),
       ('Svaeeta', 'Poposdfva', 'female', '2030-02-22', 6),
       ('Sveasfcta', 'Popovasfea', 'female', '2070-02-22', 2),
       ('Svetasfea', 'Popasdfova', 'female', '2001-02-22', 8);

INSERT INTO "User" (email, password, gender, role, first_name, last_name, phone_number, date_of_birth, bank_card)
VALUES ('PODSA@gmail.com', 'fsafk', 'female', 'user', 'sveta', 'popova', '+375291234421', '2001-03-21', '23123122'),
       ('PODSA@gmail.com', 'fsafk', 'female', 'user', 'sveta', 'popova', '+375291234421', '2001-03-21', '23123122');


INSERT INTO Review (text)
VALUES ('afdsf'),
       ('sag');

INSERT INTO Subscription (count_remaining_Train, price)
VALUES (12, 23);

INSERT INTO Subscription (time_of_action, price)
VALUES ('2022-03-21', 23);

INSERT INTO "Order" (purpose, count_train)
VALUES ('muscle', 12);

INSERT INTO Exercise (name)
VALUES ('jim'),
       ('beg'),
       ('prised'),
       ('press');

INSERT INTO Train_day(user_id)
VALUES (1),
       (2);

INSERT INTO Train_day_exercises (exercise_id, train_day_id)
VALUES (1, 1),
       (2, 1),
       (3, 1),
       (4, 1),
       (4, 2),
       (3, 2);
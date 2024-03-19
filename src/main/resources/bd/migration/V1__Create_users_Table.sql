CREATE TABLE users (
                       id INT  PRIMARY KEY,
                       first_name VARCHAR(50) NOT NULL,
                       last_name VARCHAR(50) NOT NULL,
                       patronymic VARCHAR(50) NOT NULL,
                       email VARCHAR(100) UNIQUE,
                       age INT NOT NULL,
                       city VARCHAR(50) NOT NULL,
                       created_at DATE
);
INSERT INTO users (id, first_name, last_name, patronymic, email, age, city, created_at)
VALUES (1, 'Иван', 'Иванов', 'Иванович', 'ivanov@mail.com', 30, 'Москва', '2022-10-24');
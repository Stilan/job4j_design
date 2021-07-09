CREATE DATABASE init;
--1
Create table role(
   role_id serial Primary key,
   roleUser varchar(255)
);
--2
Create table users(
    users_id serial Primary key,
    name varchar(255),
	role_id int references role(role_id)
);
--2
Create table role_rules(
	role_rules_id serial Primary key,
	role_id int REFERENCES role(role_id),
    rule_id int REFERENCES rules(rule_id)
); 
--1
Create table rules (
	rule_id serial Primary key,
	rulesRole varchar(255)
);
--2
Create table item (
    item_id serial PRIMARY KEY,
    number int,
	users_id int REFERENCES users(users_id),
    categories_id int REFERENCES categories(categories_id),
    state_id int REFERENCES state(state_id)
);
--3
Create table comments (
   comments_id serial PRIMARY KEY,
   comment varchar(255),
   item_id int REFERENCES item(item_id)
);
--3
Create table attachs (
   attachs_id serial PRIMARY KEY,
   attachs varchar(500),
   item_id int REFERENCES item(item_id)
);
--1
Create table categories (
	categories_id serial PRIMARY KEY,
	categories varchar(255)
);
--1
Create table state (
	state_id serial PRIMARY KEY,
	state varchar(255)
);

INSERT INTO role VALUES (1,'пользователь');
INSERT INTO role VALUES (2,'администратор');

INSERT INTO rules VALUES (1,'Чтение, просмотор');
INSERT INTO rules VALUES (2, 'Удаление, добавление');

INSERT INTO categories VALUES (1,'активная');
INSERT INTO categories VALUES (2,'неактивна');

INSERT INTO state VALUES (1,'в обработке');
INSERT INTO state VALUES (2,'завершена');

INSERT INTO item (item_id, name, users_id, categories_id, state_id) VALUES (1, ' ', 1, 2, 1);
INSERT INTO item (item_id, name, users_id, categories_id, state_id) VALUES (2, ' ', 2, 1, 2);

INSERT INTO comments(comments_id, comment, item_id) VALUES (1, 'Спасибо', 1);
INSERT INTO comments(comments_id, comment, item_id) VALUES (2, 'Привет', 2);

INSERT INTO users (users_id, name, role_id) VALUES (1, 'Иванов', 1);
INSERT INTO users (users_id, name, role_id) VALUES (2, 'Сидоров', 2);

INSERT INTO attachs (attachs_id, attachs, item_id) VALUES (1,'/Users/aleksandrlitvinov/Documents',2);






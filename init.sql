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
--3
Create table item (
    item_id serial PRIMARY KEY,
    name varchar(255),
	users_id int REFERENCES users(users_id),
    categories_id varchar REFERENCES categories(categories_id),
    state_id varchar REFERENCES state(state_id)
);
--1
Create table comments (
   comments_id serial PRIMARY KEY,
   comment varchar(255),
   item_id int REFERENCES item(item_id)
);
--1
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




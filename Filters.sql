create table product(
    id serial Primary key,
	name varchar(255),
	type_id int REFERENCES type(id),
	expired_data date,
	price int
);

create table type(
     id serial Primary key,
	 name varchar(255)
);

INSERT INTO type(id,name) VALUES (1,'Сыр');
INSERT INTO type(id,name) VALUES (2,'Молоко');
INSERT INTO type(id,name) VALUES (3,'Хлеб');
INSERT INTO type(id,name) VALUES (4, 'Овощи и фрукты');
INSERT INTO type(id,name) VALUES (5,'Мясо');


INSERT INTO product(id,name,type_id,expired_data,price) VALUES (1,'Сыр маскарпоне',1,'2021-11-11',345);
INSERT INTO product(id,name,type_id,expired_data,price) VALUES (2,'Сыр моцарелла',1,'2021-06-21',543);
INSERT INTO product(id,name,type_id,expired_data,price) VALUES (3,'Сыр филадельфия',1,'2021-11-21',199);
INSERT INTO product(id,name,type_id,expired_data,price) VALUES (4,'Сыр чеддер',1,'2021-06-11',478);
INSERT INTO product(id,name,type_id,expired_data,price) VALUES (5,'Сыр гауда',1,'2021-03-23',254);


INSERT INTO product(id,name,type_id,expired_data,price) VALUES (6,'Кипячёное молоко',2,'2021-08-01',45);
INSERT INTO product(id,name,type_id,expired_data,price) VALUES (7,'Топлёное молоко',2,'2021-04-12',43);
INSERT INTO product(id,name,type_id,expired_data,price) VALUES (8,'Стерилизованное молоко',2,'2021-11-04',99);
INSERT INTO product(id,name,type_id,expired_data,price) VALUES (9,'Ультрапастеризованное молоко',2,'2021-10-10',78);


INSERT INTO product(id,name,type_id,expired_data,price) VALUES (10,'Соевое молоко',2,'2021-09-11',54);
INSERT INTO product(id,name,type_id,expired_data,price) VALUES (11,'Пшеничный хлеб',3,'2021-11-23',34);
INSERT INTO product(id,name,type_id,expired_data,price) VALUES (12,'Гречневый хлеб',3,'2021-10-05',54);
INSERT INTO product(id,name,type_id,expired_data,price) VALUES (13,'Зерновой хлеб',3,'2021-12-10',19);
INSERT INTO product(id,name,type_id,expired_data,price) VALUES (14,'Отрубной хлеб',3,'2021-12-01',47);
INSERT INTO product(id,name,type_id,expired_data,price) VALUES (15,'Лаваш',3,'2021-11-11',25);

INSERT INTO product(id,name,type_id,expired_data,price) VALUES (16,'свекла',4,'2021-11-29',35);
INSERT INTO product(id,name,type_id,expired_data,price) VALUES (17,'морковь',4,'2021-01-11',53);
INSERT INTO product(id,name,type_id,expired_data,price) VALUES (18,'сельдерей',4,'2021-11-10',19);
INSERT INTO product(id,name,type_id,expired_data,price) VALUES (19,'картофель',4,'2021-12-01',48);
INSERT INTO product(id,name,type_id,expired_data,price) VALUES (20,'редис',4,'2021-07-11',24);
INSERT INTO product(id,name,type_id,expired_data,price) VALUES (21,'персик',4,'2021-07-11',35);
INSERT INTO product(id,name,type_id,expired_data,price) VALUES (22,'слива',4,'2021-07-23',53);
INSERT INTO product(id,name,type_id,expired_data,price) VALUES (23,'абрикос',4,'2021-01-11',19);
INSERT INTO product(id,name,type_id,expired_data,price) VALUES (24,'вишня',4,'2021-01-10',48);
INSERT INTO product(id,name,type_id,expired_data,price) VALUES (25,'черешня',4,'2021-01-01',24);

INSERT INTO product(id,name,type_id,expired_data,price) VALUES (26,'Говядина',5,'2021-07-21',545);
INSERT INTO product(id,name,type_id,expired_data,price) VALUES (27,'Баранина',5,'2021-07-11',543);
INSERT INTO product(id,name,type_id,expired_data,price) VALUES (28,'Свинина',5,'2021-07-12',499);
INSERT INTO product(id,name,type_id,expired_data,price) VALUES (29,'Крольчатина',5,'2021-07-21',478);
INSERT INTO product(id,name,type_id,expired_data,price) VALUES (30,'Конина',5,'2021-07-11',454);

INSERT INTO product(id,name,type_id,expired_data,price) VALUES (31,'Молочное и сливочное мороженое',2,'2021-07-15',54);
INSERT INTO product(id,name,type_id,expired_data,price) VALUES (32,'Мороженое пломбир',2,'2021-07-18',54);

drop table product; 
--1. Написать запрос получение всех продуктов с типом "СЫР"
select t.name, p.name from type t JOIN product p on t.name='Сыр' and t.id = p.type_id group by p.name,t.name;
--2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженое"
select * from product where name like '%мороженое%';
--3. Написать запрос, который выводит все продукты, срок годности которых уже истек
select * from product where expired_data < current_date;
--4. Написать запрос, который выводит самый дорогой продукт.
select name from product where price = (select max(price) from product);
--5. Написать запрос, который выводит для каждого типа количество продуктов к нему принадлежащих. В виде имя_типа, количество
select t.name,count(p.type_id) from type t join product p on t.id = p.type_id group by t.name;
--6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select t.name, p.name from type t JOIN product p on (t.name='Сыр' or  t.name='Молоко') and t.id = p.type_id group by p.name,t.name;
--7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук. Под количеством подразумевается количество продуктов определенного типа. 
--Например, если есть тип "СЫР" и продукты "Сыр плавленный" и "Сыр моцарелла", которые ему принадлежат, то количество продуктов типа "СЫР" будет 2. 
select t.name,count(p.type_id) from type t join product p on t.id = p.type_id group by t.name having count(p.type_id)<10;
--8. Вывести все продукты и их тип.
select p.name,t.name from type t join product p on p.type_id = t.id;

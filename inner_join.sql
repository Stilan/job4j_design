Create table car(
      id_car serial primary key,
	  model varchar(255),
      number int
);

Create table driver(
   id_driver serial primary key,
	name varchar(255),
	id_car int references car(id_car)
);

insert into car(model, number) values ('Kia', 134);  
insert into car(model, number) values ('Hyundai',234 );
insert into car(model, number) values ('Hyundai', 457);
insert into car(model, number) values ('Lada', 453);
insert into car(model, number) values ('Kia', 890);
insert into car(model, number) values ('Lada', 138);
insert into car(model, number) values ('Mercedes', 998);

insert into driver(name, id_car) values ('Толя', 1);
insert into driver(name, id_car) values ('Коля', 2);
insert into driver(name, id_car) values ('Зоя', 3);
insert into driver(name, id_car) values ('Саша', 4);
insert into driver(name, id_car) values ('Вася', 5);
insert into driver(name, id_car) values ('Катя', 6);
insert into driver(name, id_car) values ('Дима', 7);

select c.model,d.name from driver  as d join car as c on d.id_car = c.id_car;  
select c.number,d.name from driver as d join car as c on d.id_car = c.id_car;  
select c.number,c.model,d.name from driver as d join car as c on d.id_car = c.id_car;  
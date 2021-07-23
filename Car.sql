create table Car_body(
   id serial primary key,
    name varchar(255)
);

create table Engine(
   id serial primary key,
    name varchar(255)
);

create table Transmission(
   id serial primary key,
    name varchar(255)
);

create table Car(
    id serial primary key,
    name varchar(255),
	car_body_id int references Car_body(id),
	engine_id int references Engine(id),
	transmission_id int references Transmission(id)
);

insert into Car_body(name) values('Универсал');
insert into Car_body(name) values('Хэтчбек');
insert into Car_body(name) values('Минивен');
insert into Car_body(name) values('Пикап');
insert into Car_body(name) values('Внедорожник');
insert into Car_body(name) values('Седан');
insert into Car_body(name) values('Купе');

insert into Engine(name) values('бензиновый');
insert into Engine(name) values('дизельный');
insert into Engine(name) values('гибридный');
insert into Engine(name) values('электродвигатель');

insert into Transmission(name) values('АКПП');
insert into Transmission(name) values('механическая');
insert into Transmission(name) values('Вариатор');
insert into Transmission(name) values('Робот');

insert into Car(name,car_body_id,engine_id,transmission_id) values('Kia Rio',6,1,1);
insert into Car(name,car_body_id,engine_id,transmission_id) values('Hyundai Creta',2,2,2);
insert into Car(name,car_body_id,engine_id,transmission_id) values('Subaru BRZ',7,1,1);
insert into Car(name,car_body_id,engine_id,transmission_id) values('Hyundai H-1 FL',3,2,2);
insert into Car(name,car_body_id,engine_id,transmission_id) values('CADILLAC ESCALADE',5,2,3);
insert into Car(name,car_body_id,engine_id,transmission_id) values('УАЗ Патриот',4,2,2);
insert into Car(name,car_body_id,engine_id,transmission_id) values('Toyota Aqua',2,3,1);

--1) Вывести список всех машин и все привязанные к ним детали.ПикапToyota Aqua
select c.name,cb.name,e.name,t.name from Car c left join Car_body cb on c.car_body_id = cb.id 
left join Engine e on c.engine_id = e.id 
left join Transmission t on c.transmission_id = t.id;
--2) Вывести отдельно детали (1 деталь - 1 запрос), которые не используются НИ в одной машине, кузова, двигатели, коробки передач.
select*from Car_body cb left join Car c on cb.id = c.car_body_id where c.car_body_id is null;

select*from Engine e left join Car c on e.id = c.engine_id where c.engine_id is null;

select*from Transmission t left join Car c on t.id = c.transmission_id where c.transmission_id is null;



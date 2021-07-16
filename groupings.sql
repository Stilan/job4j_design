create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name,price) values('Xiaomi Redmi 9A',7910);
insert into devices(name,price) values('Samsung Galaxy A12',10790 );
insert into devices(name,price) values('Vivo Y31',13550);
insert into devices(name,price) values('ZTE Blade L8',4560);
insert into devices(name,price) values('ZTE Blade L6',2260);
drop table devices_people;
drop table devices;
drop table people;

insert into people(name) values('Вася');
insert into people(name) values('Толя');
insert into people(name) values('Коля');
insert into people(name) values('Анна');

insert into devices_people(device_id,people_id) values(1,1),(2,1),(3,1);
insert into devices_people(device_id,people_id) values(1,2),(2,2),(3,2);
insert into devices_people(device_id,people_id) values(1,3),(2,3),(3,3);
insert into devices_people(device_id,people_id) values(1,4),(4,4),(5,4);

select*from devices;
select*from people;
select*from devices_people;
select avg(price) from devices;

select p.name, avg(d.price) from devices_people dp join people p on dp.people_id = p.id join devices
d on dp.device_id = d.id group by p.name having avg(d.price) > 5000;







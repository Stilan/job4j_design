create table departmenst(
    id serial primary key,
    name varchar(255)
); 

create table emploees(
    id serial primary key,
    name varchar(255),
	departmenst_id int references departmenst(id)
); 
drop table emploees;
select*from emploees;
select*from departmenst;
insert into departmenst(name) values('Отдел продаж ');
insert into departmenst(name) values('Бухгалтерия');
insert into departmenst(name) values('Юридический отдел');
insert into departmenst(name) values('IT отдел');

insert into emploees(name,departmenst_id) values('Смирнов',1);
insert into emploees(name,departmenst_id) values('Иванов',2);
insert into emploees(name,departmenst_id) values('Соколов',4);
insert into emploees(name,departmenst_id) values('Попов',1);
insert into emploees(name,departmenst_id) values('Лебедев',1);
insert into emploees(name,departmenst_id) values('Козлов',2);
insert into emploees(name,departmenst_id) values('Новиков',4);
insert into emploees(name,departmenst_id) values('Морозов',4);
insert into emploees(name,departmenst_id) values('Петров',1);
insert into emploees(name,departmenst_id) values('Волков',2);
insert into emploees(name,departmenst_id) values('Соловьёв',4);
insert into emploees(name,departmenst_id) values('Васильев',4);
insert into emploees(name,departmenst_id) values('Зайцев',2);
insert into emploees(name,departmenst_id) values('Семёнов',2);
insert into emploees(name,departmenst_id) values('Воробьёв',2);
insert into emploees(name,departmenst_id) values('Фёдоров',1);
--Выполнить запросы с left, rigth, full, cross соединениями
select*from emploees e left join departmenst d on e.departmenst_id = d.id;
select*from  departmenst d right join emploees e on e.departmenst_id = d.id;
select*from emploees e full join departmenst d on e.departmenst_id = d.id;
--Используя left join найти департаменты, у которых нет работников
select*from departmenst d left join emploees e on d.id = e.departmenst_id where e.departmenst_id is null;
--Используя left и right join написать запросы, которые давали бы одинаковый результат. 
select*from emploees e left join departmenst d on e.departmenst_id = d.id;
select*from  departmenst d right join emploees e on  d.id = e.departmenst_id;
-- Создать таблицу teens с атрибутами name, gender и заполнить ее. Используя cross join составить все возможные разнополые пары
create table teens(
     id serial primary key,
     name varchar(255),
	 gender varchar(255)
);

insert into teens(name,gender) values('Алёна','ж');
insert into teens(name,gender) values('Алексей','м');
insert into teens(name,gender) values('Алиса','ж');
insert into teens(name,gender) values('Вадим','м');
insert into teens(name,gender) values('Вероника','ж');
insert into teens(name,gender) values('Борис','м');
insert into teens(name,gender) values('Виталий','м');
insert into teens(name,gender) values('Кристина','ж');
insert into teens(name,gender) values('Мария','ж');
insert into teens(name,gender) values('Антон','м');
insert into teens(name,gender) values('София','ж');
insert into teens(name,gender) values('Полина','ж');
insert into teens(name,gender) values('Андрей','м');

drop table teens;
select m.name,m.gender,d.name,d.gender from teens m  cross join teens d where m.gender != d.gender;



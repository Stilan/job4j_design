create table if not exists Users (
    id serial primary key,
    nameUser varchar(20),
    email varchar(200)
);
select * from Users;
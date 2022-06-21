--table


drop table if exists users;

create table if not exists users(
id serial primary key,
username varchar(30) unique not null check(length(username) > 2),
password varchar(30) not null
);


create table if not  exists sales_staff (
	EmployeedId VARCHAR(50), SERIAL primary key,
	SalesOfficeCity varchar(30),
	Customers VARCHAR(50),
	Age int,
	OfficeAddress VARCHAR(50)
);
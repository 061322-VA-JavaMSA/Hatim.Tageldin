
--create database mydb;

create schema task_manager;
drop schema task_manager;

/*
Users
id			SERIAL
email		VARCHAR
password	VARCHAR
*/
drop table if exists users;
create table if not exists users(
id serial primary key,
username varchar(30) unique not null check(length(username) > 2),
password varchar(30) not null
--manager_id references users(id)
);

insert into users (username, password) values ('hcocking0', 'Gox1eyM1ph');
insert into users (username, password) values ('dvalenta1', 'GcYCYy4Q');
insert into users (username, password) values ('msargerson2', 'rN3ef1EzL');
insert into users (username, password) values ('jmoorey3', 'FZfFjGnS2L8N');
insert into users (username, password) values ('bfrancomb4', 'LpMu6k1');
insert into users (username, password) values ('jkahen5', 'GNgoHXs');
insert into users (username, password) values ('rblackster6', '4ZAhhFGDUQal');
insert into users (username, password) values ('ebyng7', 'Q2ujnRtXlAe7');
insert into users (username, password) values ('tbirkenshaw8', 'thIcitV');
insert into users (username, password) values ('jabele9', 'KcKuPU0lb');

/*
Tasks
id					SERIAL
description			TEXT
due_date			DATE
status				VARCHAR
user_assigned_id	INTEGER				 (FK)
*/
drop table if exists tasks;
create table tasks (
id serial primary key,
description text,
due_date date default current_date,
status varchar(15) default 'new', -- whenever a record is created, value should be "new"
user_assigned_id integer references users(id)
);

insert into tasks (description, user_assigned_id) values ('Networked encompassing complexity', 1);
insert into tasks (description, user_assigned_id) values ('Phased 4th generation internet solution', 2);
insert into tasks (description, user_assigned_id) values ('Down-sized zero administration standardization', 3);
insert into tasks (description, user_assigned_id) values ('Object-based multimedia core', 1);
insert into tasks (description, user_assigned_id) values ('Realigned didactic time-frame', 2);
insert into tasks (description, user_assigned_id) values ('Seamless fresh-thinking contingency', 3);
insert into tasks (description, user_assigned_id) values ('Front-line composite info-mediaries', 4);
insert into tasks (description, user_assigned_id) values ('Cross-group user-facing internet solution', 5);
insert into tasks (description, user_assigned_id) values ('Programmable intangible parallelism', 6);
insert into tasks (description, user_assigned_id) values ('Function-based even-keeled instruction set', 7);

-- many-to-one/one-to-many
drop table if exists teams;
create table teams(
id serial primary key,
name varchar(20)
);

drop table if exists players;
create table players(
id serial primary key,
name varchar(20),
team_id integer references teams(id)
);

-- many-to-many
drop table if exists people;
create table people(
id serial primary key,
name varchar(30)
);

drop table if exists friends;
create table friends(
	friend1_id integer references people(id),
	friend2_id integer references people(id),
	primary key (friend1_id, friend2_id)
);

-- insert 
insert into people (name) values ('Nikita');

insert into people (name) values ('Zaki'), ('Erik');

-- mockaroo data:
insert into people (name) values ('Blesbok');
insert into people (name) values ('Least chipmunk');
insert into people (name) values ('Lapwing, southern');
insert into people (name) values ('Pied cormorant');
insert into people (name) values ('Lizard, giant girdled');
insert into people (name) values ('Goose, andean');
insert into people (name) values ('Cockatoo, red-breasted');
insert into people (name) values ('Western patch-nosed snake');
insert into people (name) values ('Masked booby');
insert into people (name) values ('Jungle kangaroo');

-- friendships
insert into friends(friend1_id, friend2_id) values(1,3), (1,5);
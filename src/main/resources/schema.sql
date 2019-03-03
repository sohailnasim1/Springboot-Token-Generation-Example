create schema if not exists userdb;

create table if not exists users (
	username varchar(16) primary key,
	password varchar(16) not null,
	firstname varchar(24),
	lastname varchar(24) not null,
	emailaddress varchar(32) not null, 
	active char(1) default 'Y',
	check (active in ( 'Y', 'N' ))
);

create table if not exists roles (
	id int primary key,
	name varchar(16) not null
);

create table if not exists user_role(
	username varchar(16),
	role_id int,
	foreign key (username) references users(username),
	foreign key (role_id) references roles(id)
);
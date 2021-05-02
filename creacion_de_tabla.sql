create database mvcuniversity
go
use mvcuniversity
go
create table users(
	id int primary key identity(1,1),
	[name] varchar(30) not null,
	[file] varchar(30) not null,
	dni bigint not null,
	is_admin bit not null default 0
	)

	create table professors(
	id int primary key identity(1,1),
	[name] varchar(30) not null,
	[last_name] varchar(30) not null,
	dni bigint not null,
	is_active bit not null default 0
	)
	create table subjects(
	id int primary key identity(1,1),
	[name] varchar(100) not null,
	schedule time not null,
	[day] varchar(10) not null,
	duration int not null,
	professor_id int,
	max_students int not null,
	constraint FK_SUBJECTS_PROFESSOR foreign key (professor_id) references professors(id)
	)
	create table inscriptions(
		id int primary key identity(1,1),
		subject_id int not null,
		[user_id] int not null,
		constraint FK_INSCRIPTION_SUBJECT foreign key (subject_id) references subjects(id),
		constraint FK_INSCRIPTION_STUDENT foreign key ([user_id]) references users(id)
		)

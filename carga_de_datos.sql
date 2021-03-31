insert into subjects values
	('Matemática Discreta', convert(time, '13:30:00.0000000'),'Lunes', 120, null, 30),
	('Analisis Matemático', convert(time, '09:00:00.0000000'),'Martes', 120, null, 30)
insert into users values
	('Matias Giordano', '', '41537402', 1), 
	('Bruno Diaz', '123-123', '42537401', 0),
	('Bruno Diaz', '123-124', '42537405', 0)
insert into professors values
	('Jose','Perez', '40897452', 1),
	('María','Costa', '34897452', 1),
	('Alberto','Fernandez', '17897452', 0)
select * from subjects
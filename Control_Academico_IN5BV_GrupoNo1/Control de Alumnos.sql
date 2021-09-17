DROP DATABASE IF EXISTS Control_Academico;
CREATE DATABASE Control_Academico;
USE Control_Academico;
/*grupo no1*/

DROP TABLE IF EXISTS Alumno;
CREATE TABLE Alumno (
	carne VARCHAR(16) NOT NULL,
    apellidos VARCHAR (45) NOT NULL,
    nombres VARCHAR (45) NOT NULL,
    email VARCHAR(32) NOT NUll,
    PRIMARY KEY PK_Alummno (carne)
);
DROP TABLE IF EXISTS Horario;
CREATE TABLE Horario(
	horario_id INT NOT NULL AUTO_INCREMENT,
    horario_final TIME NOT NULL,
    horario_inicio TIME NOT NULL,
    PRIMARY KEY PK_Horario (horario_id)
);
DROP TABLE IF EXISTS Salon;
CREATE TABLE Salon(
	salon_id INT NOT NULL AUTO_INCREMENT,
    capacidad INT NOT NULL,
    descripcion VARCHAR(255),
    nombre_salon VARCHAR(255),
    PRIMARY KEY PK_Salon (salon_id)
);
DROP TABLE IF EXISTS Carrera_Tecnica;
CREATE TABLE Carrera_Tecnica(
	codigo_carrera VARCHAR(128) NOT NULL,
    nombre VARCHAR(45) NOT NULL,
    PRIMARY KEY PK_Carrera_Tecnica (codigo_carrera)
);
DROP TABLE IF EXISTS Instructor;
CREATE TABLE Instructor(
	instructor_id INT NOT NULL AUTO_INCREMENT,
    apellidos VARCHAR (45) NOT NULL,
    nombres VARCHAR (45) NOT NULL,
    direccion VARCHAR(100),
    telefono VARCHAR(8),
    PRIMARY KEY PK_Instructor(instructor_id)
);
DROP TABLE IF EXISTS Curso;
CREATE TABLE Curso(
	curso_id INT NOT NULL AUTO_INCREMENT,
    ciclo INT,
    cupo_maximo INT,
    cupo_minimo INT,
    descripcion VARCHAR(255),
	id_horario INT,
	id_salon INT,
    id_codigo_carrera VARCHAR(128),
    id_instructor INT,
    PRIMARY KEY PK_Curso(curso_id),
    CONSTRAINT FK_Curso_Horario 
		FOREIGN KEY (id_horario) REFERENCES Horario (horario_id),
	CONSTRAINT FK_Curso_Salon 
		FOREIGN KEY (id_salon) REFERENCES Salon (salon_id),
    CONSTRAINT FK_Curso_Carrera_Tecnica 
		FOREIGN KEY (id_codigo_carrera) REFERENCES Carrera_Tecnica(codigo_carrera),
    CONSTRAINT FK_Curso_Instructor 
		FOREIGN KEY (id_instructor) REFERENCES Instructor (instructor_id)
);
DROP TABLE IF EXISTS Asignacion_Alumno;
CREATE TABLE Asignacion_Alumno(
	asignacion_id VARCHAR(45) NOT NULL,
    carne_alumno VARCHAR(16) NOT NULL,
    id_curso INT NOT NULL,
    fecha_asignacion DATETIME NOT NULL,
    PRIMARY KEY PK_Asignacion_Alummno(asignacion_id),
    CONSTRAINT FK_Carrera_Tecnica_Alumno 
		FOREIGN KEY (carne_alumno) REFERENCES Alumno (carne),
	CONSTRAINT FK_carne_alummno_Curso
		FOREIGN KEY (id_curso) REFERENCES Curso (curso_id)
);


INSERT INTO Salon (capacidad, descripcion, nombre_salon) 
VALUES(45, "Salon de Matematicas", "C25");
INSERT INTO Salon (capacidad, descripcion, nombre_salon) 
VALUES ('250', 'Salon de operacion de computo', 'Salon de Computacion');
INSERT INTO Salon (capacidad, descripcion, nombre_salon) 
VALUES ('50', 'Salon de uso deportivo', 'Salon de Fisica');
INSERT INTO Salon (capacidad, descripcion, nombre_salon) 
VALUES ('180', 'Salon de instrumentos y sonido musical', 'Salon de Musica');
INSERT INTO Salon (capacidad, descripcion, nombre_salon) 
VALUES ('200', 'Salon de expresion artistica y creatividad', 'Salon de Artes');
INSERT INTO Salon (capacidad, descripcion, nombre_salon) 
VALUES ('100', 'Salon de proyectos especificos', 'Salon de Proyectos');
INSERT INTO Salon (capacidad, descripcion, nombre_salon) 
VALUES ('320', 'Almacenamiento de libros y espacio de estudio', 'Biblioteca');
INSERT INTO Salon (capacidad, descripcion, nombre_salon) 
VALUES ('350', 'Salon unicamente para matematicas', 'Salon de Matematicas');
INSERT INTO Salon (capacidad, descripcion, nombre_salon) 
VALUES ('2750', 'Salon donde estan todos los grupos de talleres', 'Salon para Talleres');
INSERT INTO Salon (capacidad, descripcion, nombre_salon) 
VALUES ('550', 'Salon de juegos y cosas recreativas', 'Salon Recreativo');
INSERT INTO Salon (capacidad, descripcion, nombre_salon) 
VALUES ('5050', 'Salon donde se juntan los alumnos para actos', 'Salon de Actos');



INSERT INTO Alumno (carne, apellidos, nombres, email) 
VALUE("2020-343", "Lancerio Ramirez", "Luis Miguel", "llancerio@gmail.com");
INSERT INTO Alumno (carne,apellidos, nombres, email)
VALUES ('2020-256','Pérez Canto', 'Jorge Luis', 'jorgeluisperez@kinal.edu.gt'),
('2020-257','Fernandez Rodriguez', 'Jose Luis', 'fernandezjo@kinal.edu.gt'),
('2020-366','Zamora Hernandez', 'Luis Fernando', 'zamoraher@kinal.edu.gt'),
('2019-666','Pascual Ramirez', 'Franshesco Emmanuel', 'pascualramirez@kinal.edu.gt'),
('2020-231','Mac Donald Manzano', 'Pablo Jose', 'macdonalmanzano@kinal.edu.gt'),
('2020-244','Lancerio Alvarado', 'Pedro Alexander', 'lancerioalvarado@kinal.edu.gt'),
('2020-211','Morales Franco', 'Denis Rene', 'moralesfranco@kinal.edu.gt'),
('2020-236','Herrera Soto', 'Marck Dylan', 'herrerasoto@kinal.edu.gt'),
('2020-003','Morataya Hernandez', 'Guideon Caleb', 'moratayahernandez@kinal.edu.gt'),
('2020-202','Lopez Pineda', 'Segio Javier', 'lopezpineda@kinal.edu.gt'),
('2020-298','Massella Elias', 'Miguel Antonio', 'massellaelias@kinal.edu.gt');

INSERT INTO Horario (horario_final, horario_inicio)VALUE("10:00:00","8:00:00");
INSERT INTO Horario (horario_final, horario_inicio)VALUE("12:00:00","10:00:00");
INSERT INTO Horario (horario_final, horario_inicio)VALUE("7:00:00","9:00:00");
INSERT INTO Horario (horario_final, horario_inicio)VALUE("15:00:00","7:00:00");

INSERT INTO Carrera_Tecnica(codigo_carrera, nombre)
VALUES("A1","Informática");
INSERT INTO Carrera_Tecnica(codigo_carrera, nombre)
VALUES("A2","Electrónica");
INSERT INTO Carrera_Tecnica(codigo_carrera, nombre)
VALUES("A3","Mecánica");
INSERT INTO Carrera_Tecnica(codigo_carrera, nombre)
VALUES("A4","Electronica Industrial");
INSERT INTO Carrera_Tecnica(codigo_carrera, nombre)
VALUES("A5","Dibujo tecnico");
INSERT INTO Carrera_Tecnica(codigo_carrera, nombre)
VALUES("A6","Electricidad");


INSERT INTO  Instructor(apellidos, nombres, direccion, telefono) 
VALUES ('perez ', 'luis', 'cuarta calle "a" ', '78945612');
INSERT INTO  Instructor(apellidos, nombres, direccion, telefono) 
VALUES ('barahona', 'pablo', 'segunda caller 7-41', '85296375');
INSERT INTO  Instructor(apellidos, nombres, direccion, telefono) 
VALUES ('lopez ', 'sergio', 'primera avenida  ', '89562374');
INSERT INTO Instructor (apellidos, nombres, direccion, telefono) 
VALUES("Pascual Ramirez", "Franshesco Pascual", "Diagonal 14, 15-04 JArdines de la asuncion zona 5", "30964851");

INSERT INTO Curso (ciclo, cupo_maximo, cupo_minimo, descripcion, id_horario, id_salon,id_codigo_carrera, id_instructor) 
VALUES(1, 35, 10, "Literatura y Filosofia",3,1,"A1",1);
INSERT INTO Curso (ciclo, cupo_maximo, cupo_minimo, descripcion, id_horario, id_salon,id_codigo_carrera, id_instructor) 
VALUES(1, 35, 10, "Productividad y Desarrollo",4,1,"A2",2);
INSERT INTO Curso (ciclo, cupo_maximo, cupo_minimo, descripcion, id_horario, id_salon,id_codigo_carrera, id_instructor) 
VALUES(1, 35, 10, "Etica Profesional",2,1,"A6",3);
INSERT INTO Curso (ciclo, cupo_maximo, cupo_minimo, descripcion, id_horario, id_salon,id_codigo_carrera, id_instructor) 
VALUES(1, 35, 10, "Idioma Ingles",4,1,"A4",2);
INSERT INTO Curso (ciclo, cupo_maximo, cupo_minimo, descripcion, id_horario, id_salon,id_codigo_carrera, id_instructor) 
VALUES(1, 35, 10, "Matematica Avanzada",1,1,"A3",1);


INSERT INTO Asignacion_Alumno(asignacion_id, carne_alumno, id_curso, fecha_asignacion) VALUE("B5C0E","2020-343", 1, "2021-03-03 15:20:15");

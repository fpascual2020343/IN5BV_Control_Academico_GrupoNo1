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

INSERT INTO  Instructor(apellidos, nombres, direccion, telefono) 
VALUES ('perez ', 'luis', 'cuarta calle "a" ', '78945612');

INSERT INTO  Instructor(apellidos, nombres, direccion, telefono) 
VALUES ('barahona', 'pablo', 'segunda caller 7-41', '85296375');
INSERT INTO  Instructor(apellidos, nombres, direccion, telefono) 
VALUES ('lopez ', 'sergio', 'primera avenida  ', '89562374');
INSERT INTO  Instructor(apellidos, nombres, direccion, telefono) 
VALUES ('perez ', 'luis', 'cuarta calle "a" ', '78945612');
INSERT INTO  Instructor(apellidos, nombres, direccion, telefono) 
VALUES ('perez ', 'luis', 'cuarta calle "a" ', '78945612');
INSERT INTO  Instructor(apellidos, nombres, direccion, telefono) 
VALUES ('perez ', 'luis', 'cuarta calle "a" ', '78945612');
INSERT INTO  Instructor(apellidos, nombres, direccion, telefono) 
VALUES ('perez ', 'luis', 'cuarta calle "a" ', '78945612');
INSERT INTO  Instructor(apellidos, nombres, direccion, telefono) 
VALUES ('perez ', 'luis', 'cuarta calle "a" ', '78945612');


INSERT INTO Horario (horario_final, horario_inicio)VALUE("15:00:00","7:00:00");
INSERT INTO Salon (capacidad, descripcion, nombre_salon) VALUES(45, "Salon de Matematicas", "C25");
INSERT INTO Carrera_Tecnica (codigo_carrera, nombre) VALUE("IN5BV","Informatica");
INSERT INTO Instructor (apellidos, nombres, direccion, telefono) VALUES("Pascual Ramirez", "Franshesco Pascual", "Diagonal 14, 15-04 JArdines de la asuncion zona 5", "30964851");
INSERT INTO  Instructor(apellidos, nombres, direccion, telefono) 
VALUES ('barahona', 'pablo', 'segunda caller 7-41', '85296375');
INSERT INTO  Instructor(apellidos, nombres, direccion, telefono) 
VALUES ('lopez ', 'sergio', 'primera avenida  ', '89562374');
INSERT INTO Curso (ciclo, cupo_maximo, cupo_minimo, descripcion, id_horario, id_salon,id_codigo_carrera, id_instructor) VALUES(1, 35, 10, "Matematica Avanzada",1,1,"IN5BV",1);

INSERT INTO Alumno (carne, apellidos, nombres, email) VALUE("2020343", "Lancerio Ramirez", "Luis Miguel", "llancerio@gmail.com");

SELECT instructor_id,apellidos,nombres,direccion,telefono FROM Instructor;
SELECT asignacion_id, carne_alumno, id_curso,fecha_asignacion FROM Asignacion_Alumno;

INSERT INTO Asignacion_Alumno(asignacion_id, carne_alumno, id_curso, fecha_asignacion) VALUE("B5C0E","2020343", 1, "2021-09-03 15:20:15");
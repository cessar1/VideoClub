
DROP TABLE IF EXISTS movie;
DROP TABLE IF EXISTS actor;

CREATE TABLE movie (
    id BIGINT IDENTITY PRIMARY KEY,
    name VARCHAR(50),
    country VARCHAR(50),
    release_date VARCHAR(50),
    director VARCHAR(50)
);
CREATE TABLE actor (
    id BIGINT IDENTITY PRIMARY KEY,
    id_movie BIGINT FOREIGN KEY REFERENCES movie,
    firstname VARCHAR(50),
    lastname VARCHAR(50)

);

INSERT INTO movie VALUES (1, 'Los Seguidores De Richard','Argentina','Fecha1','Richard Cuan');
INSERT INTO movie VALUES (2, 'Los Simuladores','Argentina','Fecha2','Richard Cuan');
INSERT INTO movie VALUES (3, 'Los Reyes del 11','Argentina','Fecha3','Richard Cuan');

INSERT INTO actor VALUES (1, 1, 'Juan', 'Cernadas');
INSERT INTO actor VALUES (2, 1, 'Cesare','Fernandez');
INSERT INTO actor VALUES (3, 1, 'Pol', 'Cuello');
INSERT INTO actor VALUES (4, 2, 'El Maestro','Adri');
INSERT INTO actor VALUES (5, 2, 'Lautaro','Urtolin');
INSERT INTO actor VALUES (6, 2, 'El Massi','So');
INSERT INTO actor VALUES (7, 3, 'Fran','Cisco');
INSERT INTO actor VALUES (8, 3, 'Jony','Se');
INSERT INTO actor VALUES (9, 3, 'Natu','Natalia');

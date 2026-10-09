INSERT INTO film (titre, realisateur, date_sortie, genre) 
VALUES ('Blade Runner', 'Ridley Scott', '1982-06-25', 'SCIENCE_FICTION'),
('Pulp Fiction','Quentin Tarantino','1994-10-14','ACTION');

INSERT INTO acteur (nom) VALUES 
('Harrison Ford'),
('Leonardo DiCaprio');

INSERT INTO film_acteur (id_film, id_acteur) VALUES 
(1, 1);
-- INSERER : Genres --
-- Reset auto increment
ALTER TABLE genre AUTO_INCREMENT = 1;
insert into genre (id, label) values (1, 'Horror');
insert into genre (id, label) values (2, 'Drama');
insert into genre (id, label) values (3, 'Comedy|Crime|Drama|Romance');
insert into genre (id, label) values (4, 'Comedy|Drama');
insert into genre (id, label) values (5, 'Western');
insert into genre (id, label) values (6, 'Adventure|Drama|War');
insert into genre (id, label) values (7, 'Comedy|Drama|Musical');
insert into genre (id, label) values (8, 'Horror');
insert into genre (id, label) values (9, 'Drama');
insert into genre (id, label) values (10, 'Comedy|Fantasy|Romance');

-- INSERER : Participants -- 
-- Reset auto increment --
ALTER TABLE participant AUTO_INCREMENT = 1;
insert into participant (id, lastname, firstname) values (1, 'Eseler', 'Mélys');
insert into participant (id, lastname, firstname) values (2, 'MacAllan', 'Miléna');
insert into participant (id, lastname, firstname) values (3, 'MacCarroll', 'Marie-josée');
insert into participant (id, lastname, firstname) values (4, 'Antoinet', 'Maëlys');
insert into participant (id, lastname, firstname) values (5, 'Wrightim', 'Marie-josée');
insert into participant (id, lastname, firstname) values (6, 'Lantuffe', 'Solène');
insert into participant (id, lastname, firstname) values (7, 'MacLaig', 'Léone');
insert into participant (id, lastname, firstname) values (8, 'Brockman', 'Lóng');
insert into participant (id, lastname, firstname) values (9, 'Olyunin', 'Marlène');
insert into participant (id, lastname, firstname) values (10, 'Bendell', 'Estève');

-- INSERER : Membres --
-- Reset auto increment --
ALTER TABLE member AUTO_INCREMENT = 1;
insert into member (id, lastname, firstname, login, password, is_admin) values (1, 'Proschke', 'Cinéma', 'Nélie', 'Nfc2QLkmn', 1);
insert into member (id, lastname, firstname, login, password, is_admin) values (2, 'Weightman', 'Solène', 'Josée', 'eKui60s', 0);
insert into member (id, lastname, firstname, login, password, is_admin) values (3, 'Fairn', 'Vérane', 'Sòng', 'llw4pMI5S', 1);
insert into member (id, lastname, firstname, login, password, is_admin) values (4, 'Woodall', 'Desirée', 'Régine', '3IZdOs0Zh6j', 0);
insert into member (id, lastname, firstname, login, password, is_admin) values (5, 'Edden', 'Lài', 'Åslög', 'ciCLWzkIr', 0);

-- INSERER : Movies --
-- Reset auto increment --
ALTER TABLE movie AUTO_INCREMENT = 1;
insert into movie (id, title, year, duration, synopsis, genre_id, director_id) values (1, 'Stand by Me Doraemon', 1850, 46, 'Extirpation of Matter from Left Finger Phalanx, Percutaneous Approach', 3, 4);
insert into movie (id, title, year, duration, synopsis, genre_id, director_id) values (2, 'Jackie Brown', 1855, 147, 'Insertion of Limb Lengthening External Fixation Device into Left Femoral Shaft, Percutaneous Endoscopic Approach', 8, 8);
insert into movie (id, title, year, duration, synopsis, genre_id, director_id) values (3, '8 1/2 (8½)', 1917, 90, 'Transfer Accessory Nerve to Accessory Nerve, Open Approach', 5, 10);
insert into movie (id, title, year, duration, synopsis, genre_id, director_id) values (4, 'Deepstar Six', 1937, 141, 'Bypass Right Axillary Artery to Lower Arm Vein with Synthetic Substitute, Open Approach', 4, 6);
insert into movie (id, title, year, duration, synopsis, genre_id, director_id) values (5, 'Hannibal Rising', 1896, 190, 'Drainage of Left Lesser Saphenous Vein with Drainage Device, Percutaneous Endoscopic Approach', 4, 5);
insert into movie (id, title, year, duration, synopsis, genre_id, director_id) values (6, 'RoboCop', 2022, 256, 'Fragmentation in Epidural Space, Percutaneous Endoscopic Approach', 9, 9);
insert into movie (id, title, year, duration, synopsis, genre_id, director_id) values (7, 'Frontière(s)', 1953, 221, 'Bypass Left Basilic Vein to Upper Vein with Synthetic Substitute, Percutaneous Endoscopic Approach', 8, 3);

-- INSERER : REVIEWS --
-- Reset auto increment --
ALTER TABLE review AUTO_INCREMENT = 1;
insert into review (id, rating, comment, membre_id, movie_id) values (1, 5, 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti. Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum.', 1, 1);
insert into review (id, rating, comment, membre_id, movie_id) values (2, 3, 'Vestibulum quam sapien, varius ut, blandit non, interdum in, ante.', 1, 1);
insert into review (id, rating, comment, membre_id, movie_id) values (3, 5, 'Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh. Quisque id justo sit amet sapien dignissim vestibulum.', 1, 1);
insert into review (id, rating, comment, membre_id, movie_id) values (4, 2, 'Phasellus sit amet erat. Nulla tempus. Vivamus in felis eu sapien cursus vestibulum. Proin eu mi.', 4, 1);
insert into review (id, rating, comment, membre_id, movie_id) values (5, 2, 'Vivamus vel nulla eget eros elementum pellentesque. Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla.', 2, 1);

-- INSERER : ACTEURS
insert into movie_actors (actors_id, actor_movies_id) values (4, 1);
insert into movie_actors (actors_id, actor_movies_id) values (10, 2);
insert into movie_actors (actors_id, actor_movies_id) values (5, 3);
insert into movie_actors (actors_id, actor_movies_id) values (4, 4);
insert into movie_actors (actors_id, actor_movies_id) values (10, 5);
insert into movie_actors (actors_id, actor_movies_id) values (4, 6);
insert into movie_actors (actors_id, actor_movies_id) values (9, 7);

insert into movie_actors (actors_id, actor_movies_id) values (5, 1);
insert into movie_actors (actors_id, actor_movies_id) values (7, 2);
insert into movie_actors (actors_id, actor_movies_id) values (6, 3);
insert into movie_actors (actors_id, actor_movies_id) values (7, 4);
insert into movie_actors (actors_id, actor_movies_id) values (8, 5);
insert into movie_actors (actors_id, actor_movies_id) values (9, 6);
insert into movie_actors (actors_id, actor_movies_id) values (5, 7);
INSERT INTO category (id, name, color) VALUES (0, 'None', 'A1B2C3');
INSERT INTO category (id, name, color) VALUES (1, 'Rock', 'F5E4D1');
INSERT INTO category (id, name, color) VALUES (2, 'Pop', 'D9C1F7');
INSERT INTO category (id, name, color) VALUES (3, 'Jazz', 'B8A9D4');
INSERT INTO category (id, name, color) VALUES (4, 'HipHop', '2E9B8F');
INSERT INTO category (id, name, color) VALUES (7, 'Reggaeton', 'C4A1F0');
INSERT INTO category (id, name, color) VALUES (8, 'Blues', '9C76D2');

INSERT INTO artist (id, name, color) VALUES (0, 'Michael Jackson', 'FFD700');
INSERT INTO artist (id, name, color) VALUES (1, 'Beyonce', '8A2BE2');
INSERT INTO artist (id, name, color) VALUES (2, 'The Beatles', '800000');
INSERT INTO artist (id, name, color) VALUES (3, 'Shakira', 'FF69B4');
INSERT INTO artist (id, name, color) VALUES (4, 'Eminem', '00CED1');
INSERT INTO artist (id, name, color) VALUES (5, 'Miles Davis', 'FF8C00');
INSERT INTO artist (id, name, color) VALUES (6, 'Luis Fonsi', '00BFFF');
INSERT INTO artist (id, name, color) VALUES (7, 'Marc Anthony', '8B008B');

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (8, '1971-11-08', 1, 6, 'Led Zeppelin IV', 'A3B6C9', 'Stairway to Hea');

INSERT INTO song_artists (artists_id, song_list_id) VALUES (2, 6);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (6, '1976-12-08', 1, 7, 'Hotel California', 'D7E2A5', 'Hotel Californi');

INSERT INTO song_artists (artists_id, song_list_id) VALUES (2, 7);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (6, '1987-07-21', 1, 8, 'Appetite for Destr', 'F4C1D2', 'Sweet Child O M');

INSERT INTO song_artists (artists_id, song_list_id) VALUES (2, 8);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (4, '1980-07-25', 1, 9, 'Back in Black', 'E5D4B1', 'Back in Black');

INSERT INTO song_artists (artists_id, song_list_id) VALUES (2, 9);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (5, '1991-07-29', 1, 10, 'Metallica', 'D2A3C4', 'Enter Sandman');

INSERT INTO song_artists (artists_id, song_list_id) VALUES (2, 10);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (4, '2014-11-10', 2, 11, 'Uptown Special', 'F1E3D4', 'Uptown Funk');

INSERT INTO song_artists (artists_id, song_list_id) VALUES (0, 11),
       (1, 11);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (4, '2014-08-18', 2, 12, '1989', 'A6F9C3', 'Shake It Off');

INSERT INTO song_artists (artists_id, song_list_id) VALUES (1, 12);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (4, '2010-11-29', 2, 13, '21', 'B2D5F1', 'Rolling in the D');

INSERT INTO song_artists (artists_id, song_list_id) VALUES (3, 13);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (3, '2019-11-29', 2, 14, 'After Hours', 'D1F8C7', 'Blinding Ligh');

INSERT INTO song_artists (artists_id, song_list_id) VALUES (4, 14);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (4, '2013-11-21', 2, 15, 'G I R L', 'A9C4F0', 'Happy');

INSERT INTO song_artists (artists_id, song_list_id) VALUES (0, 15);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (5, '1959-12-01', 3, 16, 'Time Out', 'C3D2A1', 'Take Five');

INSERT INTO song_artists (artists_id, song_list_id) VALUES (5, 16);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (9, '1959-08-17', 3, 17, 'Kind of Blue', 'F7A2C5', 'So What');

INSERT INTO song_artists (artists_id, song_list_id) VALUES (5, 17);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (3, '1967-10-01', 3, 18, 'What a Wonderful Wo', 'B5F8A2', 'What a Wond');

INSERT INTO song_artists (artists_id, song_list_id) VALUES (5, 18);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (3, '1965-10-01', 3, 19, 'I Put a Spell on Yo', 'E2C7F1', 'Feeling Good');

INSERT INTO song_artists (artists_id, song_list_id) VALUES (5, 19);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (6, '1959-06-01', 3, 20, 'Cannonball Adderley Q', 'D9B1F6', 'Autumn Leaves');

INSERT INTO song_artists (artists_id, song_list_id) VALUES (5, 20);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (5, '2002-10-28', 4, 21, '8 Mile Soundtrack', 'C3A4F8', 'Lose Yourself');

INSERT INTO song_artists (artists_id, song_list_id) VALUES (4, 21);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (5, '2018-08-03', 4, 22, 'Astroworld', 'F7A3C9', 'Sicko Mode');

INSERT INTO song_artists (artists_id, song_list_id) VALUES (4, 22);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (3, '2017-03-30', 4, 23, 'DAMN.', 'A4C1F5', 'HUMBLE.');

INSERT INTO song_artists (artists_id, song_list_id) VALUES (4, 23);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (4, '2018-02-16', 4, 24, 'Scary Hours', 'D6F1A2', 'Gods Plan');

INSERT INTO song_artists (artists_id, song_list_id) VALUES (4, 24);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (2, '2019-12-03', 4, 25, '7', 'C2B9F7', 'Old Town Roa');

INSERT INTO song_artists (artists_id, song_list_id) VALUES (4, 25);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (4, '2017-01-13', 7, 26, 'Vida', 'F5C2A9', 'Despacito');

INSERT INTO song_artists (artists_id, song_list_id) VALUES (6, 26);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (4, '2018-09-28', 7, 27, 'Carte Blanche', 'C8B1E2', 'Taki Taki');

INSERT INTO song_artists (artists_id, song_list_id) VALUES (3, 27);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (4, '2019-04-30', 7, 28, 'El Disco Duro', 'B1F2C5', 'Baila Baila B');

INSERT INTO song_artists (artists_id, song_list_id) VALUES (3, 28);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (4, '2013-07-23', 7, 29, '3.0', 'F1E4B2', 'Vivir Mi Vida');

INSERT INTO song_artists (artists_id, song_list_id) VALUES (7, 29);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (3, '2020-11-20', 7, 30, 'El ultimo Tour', 'A3D5F9', 'Dakiti');

INSERT INTO song_artists (artists_id, song_list_id) VALUES (4, 30);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (5, '1969-11-06', 8, 31, 'Completely Well', 'B2E4F1', 'Thrill is Gone');

INSERT INTO song_artists (artists_id, song_list_id) VALUES (5, 31);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (6, '1947-01-01', 8, 32, 'T-Bone Blues', 'D3A7F6', 'Stormy Monday');

INSERT INTO song_artists (artists_id, song_list_id) VALUES (5, 32);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (4, '1983-06-13', 8, 33, 'Texas Flood', 'A1F9C4', 'Pride and Joy');

INSERT INTO song_artists (artists_id, song_list_id) VALUES (5, 33);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (4, '1962-06-01', 8, 34, 'The Best of John Le', 'B6E3D9', 'Boom Boom');

INSERT INTO song_artists (artists_id, song_list_id) VALUES (5, 34);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (4, '1954-02-01', 8, 35, 'Muddy Waters: The A', 'F2B8D1', 'Hoochie Man');

INSERT INTO song_artists (artists_id, song_list_id) VALUES (5, 35);



INSERT INTO category (id, name, color) VALUES (0, 'None', 'A1B2C3');


INSERT INTO category (id, name, color) VALUES (1, 'Rock', 'FF6F61');
INSERT INTO category (id, name, color) VALUES (2, 'Pop', 'B56E69');
INSERT INTO category (id, name, color) VALUES (3, 'Jazz', '4E2A84');
INSERT INTO category (id, name, color) VALUES (4, 'Classical', '8A3A3A');
INSERT INTO category (id, name, color) VALUES (5, 'Hip-Hop', '333333');
INSERT INTO category (id, name, color) VALUES (6, 'Blues', '1E3A8A');
INSERT INTO category (id, name, color) VALUES (7, 'Reggae', '2C8D7D');
INSERT INTO category (id, name, color) VALUES (8, 'Country', 'D27900');
INSERT INTO category (id, name, color) VALUES (9, 'Metal', '5A1B1B');
INSERT INTO category (id, name, color) VALUES (10, 'Electronic', 'C0C0C0');
INSERT INTO category (id, name, color) VALUES (11, 'Hip-Hop Collab', 'D50032');

INSERT INTO artist (id, name, color) VALUES (1, 'Led Zeppeli', 'E67E22');
INSERT INTO artist (id, name, color) VALUES (2, 'MJ', 'F39C12');
INSERT INTO artist (id, name, color) VALUES (3, 'Armstrong', 'E74C3C');
INSERT INTO artist (id, name, color) VALUES (4, 'Beethoven', '8E44AD');
INSERT INTO artist (id, name, color) VALUES (5, 'Kendrick Lamar', '7F8C8D');
INSERT INTO artist (id, name, color) VALUES (6, 'Muddy W', 'D35400');
INSERT INTO artist (id, name, color) VALUES (7, 'Bob Marley', 'F1C40F');
INSERT INTO artist (id, name, color) VALUES (8, 'Johnny C', 'C0392B');
INSERT INTO artist (id, name, color) VALUES (9, 'Daft Punk', 'BDC3C7');
INSERT INTO artist (id, name, color) VALUES (10, 'Tupac', '9B59B6');
INSERT INTO artist (id, name, color) VALUES (11, 'Dr. Dre', '34495E');
INSERT INTO artist (id, name, color) VALUES (12, 'Snoop Dogg', '5DADE2');
INSERT INTO artist (id, name, color) VALUES (13, 'Eminem', '9B59B6');
INSERT INTO artist (id, name, color) VALUES (14, 'Jay-Z', 'C0392B');


INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (8, '1971-11-08', 1, 1, 'Led Zepp IV', 'A3B6C9', 'Stairway');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (1, 1);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (6, '1975-02-15', 1, 2, 'Phys Graff', 'C4C4C4', 'Kashmir');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (1, 2);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (7, '1970-03-21', 1, 3, 'Led Zepp II', 'D1E0E0', 'Whole Lotta');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (1, 3);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (5, '1969-08-30', 1, 4, 'Led Zepp I', 'F1E8D1', 'Good Times');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (1, 4);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (6, '1973-03-01', 1, 5, 'House Holy', 'E9D8A6', 'Song Same');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (1, 5);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (5, '1982-11-30', 2, 6, 'Thriller', 'FFD700', 'Billie J');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (2, 6);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (4, '1982-11-30', 2, 7, 'Thriller', 'FF5733', 'Beat It');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (2, 7);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (5, '1987-08-16', 2, 8, 'Bad', 'B9F2FF', 'Smooth C');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (2, 8);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (6, '1991-11-13', 2, 9, 'Dangerous', '6A5ACD', 'Black W');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (2, 9);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (6, '1988-05-16', 2, 10, 'Bad', '90EE90', 'Way Feel');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (2, 10);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (5, '1927-07-01', 3, 11, 'Louis W.C. Handy', '8B4513', 'St. Louis');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (3, 11);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (4, '1938-04-25', 3, 12, 'Best of Louis', 'A52A2A', 'What World');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (3, 12);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (5, '1929-01-01', 3, 13, 'Complete Hot Five', 'D2691E', 'West End');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (3, 13);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (6, '1930-05-25', 3, 14, 'Louis All-Stars', '8B4513', 'La Vie');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (3, 14);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (6, '1932-05-01', 3, 15, 'Best Louis', 'A52A2A', 'Saints March');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (3, 15);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (10, '1824-05-07', 4, 16, 'Symphony 9', '8A2BE2', 'Ode Joy');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (4, 16);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (9, '1808-12-22', 4, 17, 'Symphony 5', '7B68EE', 'Symphony');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (4, 17);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (8, '1799-01-01', 4, 18, 'Piano 14', 'F0E68C', 'Moonlight');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (4, 18);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (8, '1817-04-01', 4, 19, 'Piano 8', '8A2BE2', 'Pathétique');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (4, 19);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (7, '1801-12-01', 4, 20, 'Piano Concerto 5', 'DA70D6', 'Emperor');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (4, 20);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (4, '2012-10-22', 5, 21, 'good kid', '1C1C1C', 'Swimming');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (5, 21);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (5, '2015-03-23', 5, 22, 'To Pimp a', '4B0082', 'King Kunta');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (5, 22);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (6, '2012-10-22', 5, 23, 'good kid', '8B4513', 'Bitch Vibe');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (5, 23);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (5, '2017-04-14', 5, 24, 'DAMN.', '1C1C1C', 'HUMBLE.');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (5, 24);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (5, '2015-03-23', 5, 25, 'To Pimp a', 'D2691E', 'Alright');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (5, 25);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (5, '1950-09-15', 6, 26, 'Muddy Waters', '8B4513', 'Hoochie Coochie');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (6, 26);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (6, '1954-11-10', 6, 27, 'Muddy Waters', 'A52A2A', 'I Cant Be Satisfied');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (6, 27);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (7, '1941-01-01', 6, 28, 'Robert Johnson', 'F4A300', 'Cross Road Blues');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (6, 28);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (5, '1936-05-01', 6, 29, 'B.B. King', '8B4513', 'Three OClock Blues');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (6, 29);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (6, '1951-09-09', 6, 30, 'Howlin Wolf', 'D2691E', 'Smokestack Lightnin');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (6, 30);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (5, '1973-04-23', 7, 31, 'Bob Marley', 'FFD700', 'No Woman No Cry');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (7, 31);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (6, '1977-10-02', 7, 32, 'Bob Marley', 'DAA520', 'Buffalo Soldier');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (7, 32);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (4, '1973-04-23', 7, 33, 'Peter Tosh', 'F4A300', 'Legalize It');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (7, 33);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (5, '1977-09-11', 7, 34, 'Jimmy Cliff', 'FF6347', 'The Harder They');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (7, 34);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (5, '1977-10-02', 7, 35, 'The Wailers', '8A2BE2', 'Get Up Stand Up');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (7, 35);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (3, '1969-01-01', 8, 36, 'Johnny Cash', 'A52A2A', 'Ring of Fire');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (8, 36);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (4, '1964-05-01', 8, 37, 'Hank Williams', 'D2691E', 'Your Cheatin Heart');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (8, 37);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (5, '1970-06-15', 8, 38, 'Dolly Parton', 'A52A2A', 'Jolene');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (8, 38);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (4, '1975-03-03', 8, 39, 'Willie Nelson', '8B4513', 'Blue Eyes Crying');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (8, 39);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (5, '1990-11-10', 8, 40, 'Garth Brooks', 'D2691E', 'Friends in Low Places');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (8, 40);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (6, '1986-09-22', 9, 41, 'Metallica', '800000', 'Master of Puppets');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (9, 41);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (5, '1981-06-25', 9, 42, 'Black Sabbath', '8B0000', 'Paranoid');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (9, 42);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (7, '1992-08-02', 9, 43, 'Iron Maiden', 'B22222', 'Fear of the Dark');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (9, 43);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (5, '1991-09-24', 9, 44, 'Megadeth', 'DC143C', 'Symphony of Destruction');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (9, 44);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (6, '1988-09-29', 9, 45, 'Judas Priest', 'A52A2A', 'Hell Bent for Leather');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (9, 45);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (5, '1997-03-05', 10, 46, 'Daft Punk', '9B30FF', 'Around the World');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (9, 46);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (6, '2000-11-13', 10, 47, 'The Chemical', 'D2691E', 'Block Rockin Beats');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (9, 47);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (5, '2005-07-15', 10, 48, 'Justice', '8A2BE2', 'D.A.N.C.E.');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (9, 48);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (4, '2004-09-10', 10, 49, 'Moby', '20B2AA', 'Dance');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (9, 49);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (6, '2011-06-07', 10, 50, 'Deadmau5', 'FF6347', 'Ghosts N Stuff');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (9, 50);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (5, '1996-03-12', 11, 56, 'All Eyez On Me', 'FFD700', '2 of Amerikaz Most');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (10, 56), (11, 56);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (6, '1992-02-16', 11, 57, 'Doggystyle', '8B0000', 'Nuthin But A G Thang');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (12, 57), (11, 57), (10, 57);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (5, '2002-12-08', 11, 58, 'The Eminem Show', 'B22222', 'Forgot About Dre');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (13, 58), (11, 58);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (5, '2001-03-20', 11, 59, 'The Blueprint', 'ADFF2F', 'Renegade');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (14, 59), (13, 59);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (5, '2015-03-03', 11, 60, 'To Pimp A Butterfly', 'D2691E', 'Institutionalized');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (5, 60), (12, 60);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (6, '1996-06-04', 11, 61, 'All Eyez On Me', 'DC143C', 'California Love (Remix)');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (10, 61), (11, 61), (12, 61);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (5, '2011-11-21', 11, 62, 'Watch The Throne', '8A2BE2', 'Ni**as In Paris');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (14, 62), (13, 62);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (7, '2015-06-01', 11, 63, 'The Big Three', '4B0082', 'Worldwide Cypher');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (5, 63), (14, 63), (13, 63);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (6, '1999-11-12', 11, 64, 'The Marshall Mathers LP', '8B0000', 'Forgot About Dre (Remix)');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (12, 64), (11, 64), (13, 64);




INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (5, '1995-10-31', 11, 65, 'All Eyez On Me', 'FF6347', '2 of Amerikaz Most');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (12, 65), (10, 65);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (5, '2011-11-21', 11, 66, 'Watch The Throne', 'DC143C', 'Otis');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (14, 66), (13, 66), (12, 66);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (6, '2015-03-03', 11, 67, 'Compton', '8A2BE2', 'Deep Water');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (11, 67), (5, 67), (12, 67);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (7, '2015-06-01', 11, 68, 'The Cypher', '32CD32', 'Welcome To The Rap Game');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (13, 68), (11, 68), (12, 68), (5, 68);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (4, '2002-03-12', 11, 69, 'The Blueprint 2', 'FF4500', 'Blueprint (Remix)');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (12, 69), (14, 69);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (5, '2015-09-21', 11, 70, 'To Pimp A Blueprint', 'FF1493', 'Kings Story');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (5, 70), (11, 70), (14, 70);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (5, '1996-03-12', 11, 71, 'All Eyez On Me', 'FFD700', 'Thug Love');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (10, 71), (12, 71), (14, 71);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (5, '2015-07-05', 11, 72, 'Legacy', '00FFFF', 'Bad Influence');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (13, 72), (5, 72), (12, 72);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (6, '2001-10-16', 11, 73, '2001', '8B0000', 'Still D.R.E.');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (11, 73), (14, 73);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (6, '1997-02-13', 11, 74, 'The Final Round', '9400D3', 'Rap Revolution');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (10, 74), (11, 74), (12, 74), (14, 74);

INSERT INTO song (duration, release_date, category_id, id, album_name, color, name) VALUES (7, '2016-10-10', 11, 75, 'The Cypher II', '8A2BE2', 'Rap Battle Royal');
INSERT INTO song_artists (artists_id, song_list_id) VALUES (5, 75), (11, 75), (13, 75), (14, 75);



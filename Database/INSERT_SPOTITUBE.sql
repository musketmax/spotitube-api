# User
#
# The hashed password is "password" and uses the Java implementation of "PBKDF2" algorithm for hashing.
INSERT INTO users (username, password) VALUES 
('user', '1000:be8528029730569a3c0602cc6922bd7c:8953047bf438ad3840f4c6ce6de39fadaf0193245150b949a6f747da39cfed2396ecb4169088afd91ecf4c816f8657518eadde174de2b798f62fc887da7aadf8');
INSERT INTO users (username, password) VALUES 
('admin', '1000:be8528029730569a3c0602cc6922bd7c:8953047bf438ad3840f4c6ce6de39fadaf0193245150b949a6f747da39cfed2396ecb4169088afd91ecf4c816f8657518eadde174de2b798f62fc887da7aadf8');

# Playlists
INSERT INTO playlists (user_id, name) values ('2', 'Heavy Metal');
INSERT INTO playlists (user_id, name) values ('1', 'Rock \'n Roll');
INSERT INTO playlists (user_id, name) values ('2', 'Pop');
INSERT INTO playlists (user_id, name) values ('1', 'Progressive Rock');
INSERT INTO playlists (user_id, name) values ('1', 'Hip Hop');
INSERT INTO playlists (user_id, name) values ('2', 'R&B');
INSERT INTO playlists (user_id, name) values ('1', 'Classical');
INSERT INTO playlists (user_id, name) values ('2', '80\'s Classics');

# Tracks
INSERT INTO tracks (title, performer, duration, album, playcount, publicationDate, description)
VALUES ('Stairway To Heaven', 'Led Zeppelin', 778, 'Led Zeppelin IV', 4, CURRENT_DATE(), 'blabla');
INSERT INTO tracks (title, performer, duration, album, playcount, publicationDate, description)
VALUES ('Another Brick In The Wall', 'Pink Floyd', 443, 'Some Album', 23, CURRENT_DATE(), 'blabla');
INSERT INTO tracks (title, performer, duration, album, playcount, publicationDate, description)
VALUES ('Give A Little Bit', 'Supertramp', 290, 'Some Album', 1, CURRENT_DATE(), 'blabla');
INSERT INTO tracks (title, performer, duration, album, playcount, publicationDate, description)
VALUES ('Hotel California', 'The Eagles', 520, 'Some Album', 1, CURRENT_DATE(), 'blabla');
INSERT INTO tracks (title, performer, duration, album, playcount, publicationDate, description)
VALUES ('Rosanna', 'Africa', 330, 'Some Album', 1, CURRENT_DATE(), 'blabla');
INSERT INTO tracks (title, performer, duration, album, playcount, publicationDate, description)
VALUES ('A Horse With No Name', 'America', 800, 'Some Album', 1, CURRENT_DATE(), 'blabla');
INSERT INTO tracks (title, performer, duration, album, playcount, publicationDate, description)
VALUES ('Nothing Else Matters', 'Meticallica', 500, 'Some Album', 1, CURRENT_DATE(), 'blabla');
INSERT INTO tracks (title, performer, duration, album, playcount, publicationDate, description)
VALUES ('Sultans Of Swing', 'Dire Straits', 500, 'Some Album', 1, CURRENT_DATE(), 'blabla');
INSERT INTO tracks (title, performer, duration, album, playcount, publicationDate, description)
VALUES ('Brothers In Arms', 'Dire Straits', 445, 'Some Album', 1, CURRENT_DATE(), 'blabla');

# Pivot table
INSERT INTO playlist_tracks_pivot VALUES (1, 1, 0);
INSERT INTO playlist_tracks_pivot VALUES (1, 2, 1);
INSERT INTO playlist_tracks_pivot VALUES (1, 3, 1);
INSERT INTO playlist_tracks_pivot VALUES (3, 5, 1);
INSERT INTO playlist_tracks_pivot VALUES (3, 2, 1);
INSERT INTO playlist_tracks_pivot VALUES (4, 2, 0);
INSERT INTO playlist_tracks_pivot VALUES (8, 9, 0);
INSERT INTO playlist_tracks_pivot VALUES (8, 8, 0);
INSERT INTO playlist_tracks_pivot VALUES (8, 1, 1);
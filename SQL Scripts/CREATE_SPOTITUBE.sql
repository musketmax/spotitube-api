DROP DATABASE spotitube;
CREATE DATABASE spotitube;

USE spotitube;

CREATE TABLE `users` (
	`id` mediumint NOT NULL AUTO_INCREMENT,
	`username` VARCHAR(255) NOT NULL,
	`password` LONGTEXT NOT NULL,  
    PRIMARY KEY (`id`)
);

CREATE TABLE `tokens` (
	`id` mediumint NOT NULL AUTO_INCREMENT,
	`user_id` mediumint NOT NULL,
	`token` varchar(255) DEFAULT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT tokens_users_user_id_FK
	FOREIGN KEY (user_id) REFERENCES users (id)
		ON UPDATE CASCADE
		ON DELETE CASCADE
);

CREATE TABLE `playlists` (
	`id` mediumint NOT NULL AUTO_INCREMENT,
	`user_id` mediumint NOT NULL,
	`name` varchar(255) NOT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT playlists_users_user_id_FK
	FOREIGN KEY (user_id) REFERENCES users (id)
		ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE TABLE `tracks` (
	`id` mediumint NOT NULL AUTO_INCREMENT,
    `title` varchar(255) NOT NULL,
    `performer` varchar(255) NOT NULL,
    `duration` mediumint NOT NULL,
    `album` varchar(255) NOT NULL,
    `playcount` mediumint NULL,
    `publicationDate` Date NULL,
    `description` varchar(255) NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `playlist_tracks_pivot` (
	`playlist_id` mediumint NOT NULL,
    `track_id` mediumint NOT NULL,
    `offline_available` tinyint NOT NULL,
    PRIMARY KEY (`playlist_id`, `track_id`, `offline_available`),
    
    CONSTRAINT playlist_tracks_playlist_id_FK
    FOREIGN KEY (playlist_id) REFERENCES playlists (id)
		ON UPDATE CASCADE
        ON DELETE CASCADE,
	
    CONSTRAINT playlist_tracks_track_id_FK
    FOREIGN KEY (track_id) REFERENCES tracks (id)
		ON UPDATE CASCADE
        ON DELETE CASCADE
);
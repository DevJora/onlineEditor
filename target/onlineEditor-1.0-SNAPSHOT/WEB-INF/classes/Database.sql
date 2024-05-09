DROP DATABASE IF EXISTS `editor`;
CREATE DATABASE editor;

USE editor;

CREATE TABLE `user` (
                        `id` integer PRIMARY KEY AUTO_INCREMENT,
                        `pseudo` varchar(255) NOT NULL,
                        `mail` varchar(255) NOT NULL,
                        `mdp` varchar(255) NOT NULL
);

CREATE TABLE `document` (
                            `id` integer PRIMARY KEY AUTO_INCREMENT,
                            `title` varchar(100) NOT NULL,
                            `user_id` integer NOT NULL
);

CREATE TABLE `bloc` (
                        `id` integer PRIMARY KEY AUTO_INCREMENT,
                        `title` varchar(100),
                        `content` varchar(1000) NOT NULL,
                        `id_document` integer NOT NULL
);

CREATE TABLE `log` (
                       `id` integer PRIMARY KEY AUTO_INCREMENT,
                       `id_document` integer NOT NULL,
                       `id_bloc` integer NOT NULL,
                       `id_user` integer NOT NULL,
                       `date_modif` varchar(255) NOT NULL
);

CREATE TABLE `chat` (
                        `id_user` integer,
                        `id_document` integer,
                        `date_msg` varchar(255),
                        `message` varchar(200)
);

ALTER TABLE `document` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

ALTER TABLE `bloc` ADD FOREIGN KEY (`id_document`) REFERENCES `document` (`id`);

ALTER TABLE `log` ADD FOREIGN KEY (`id_bloc`) REFERENCES `bloc` (`id`);

ALTER TABLE `log` ADD FOREIGN KEY (`id_document`) REFERENCES `document` (`id`);

ALTER TABLE `log` ADD FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);

ALTER TABLE `chat` ADD FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);

ALTER TABLE `chat` ADD FOREIGN KEY (`id_document`) REFERENCES `document` (`id`);

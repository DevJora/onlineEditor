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
                            `user_id` integer NOT NULL,
                            `content` varchar(5000) NOT NULL,
                            `code_collab` varchar(10) NOT NULL
);

CREATE TABLE `historic`
(
    `id_doc`   integer NOT NULL,
    `id_user` integer       NOT NULL,
    `content_doc` varchar(5000) NOT NULL,
    `date` VARCHAR(30) NOT NULL
);

CREATE TABLE `collaboration`(
                                `id_user` integer NOT NULL,
                                `id_document` integer NOT NULL
);

ALTER TABLE `historic` ADD FOREIGN KEY (`id_doc`) REFERENCES `document` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `historic` ADD FOREIGN KEY (`id_user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;



ALTER TABLE `document` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
ALTER TABLE `collaboration` ADD FOREIGN KEY (`id_user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `collaboration` ADD FOREIGN KEY (`id_document`) REFERENCES `document` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;


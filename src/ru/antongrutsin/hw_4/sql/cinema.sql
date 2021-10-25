DROP TABLE IF EXISTS `ticket`;
DROP TABLE IF EXISTS `session`;
DROP TABLE IF EXISTS `movie`;
DROP TABLE IF EXISTS `schedule`;

CREATE TABLE `schedule` (
	`date` DATE NOT NULL,
    PRIMARY KEY (`date`)
)

CREATE TABLE `movie` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` CHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
)

CREATE TABLE `session` (
    `id` INT NOT NULL AUTO_INCREMENT,
	`date` DATE NOT NULL,
    `movie_id` INT NOT NULL,
	`start` TIME NOT NULL,
    `duration` TIME NOT NULL,
	`stop` TIME NOT NULL,
	`cost` DECIMAL(10) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `session_date` FOREIGN KEY (`date`) REFERENCES `schedule` (`date`),
    CONSTRAINT `session_movie_id` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`)
)

CREATE TABLE `ticket` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `quantity` INT NOT NULL,
    `session_id` INT NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `ticket_session_id` FOREIGN KEY (`session_id`) REFERENCES `session` (`id`)
)

INSERT INTO `schedule` VALUES ('2020-12-29'), ('2020-12-30'), ('2020-12-31');

INSERT INTO `movie` (`name`) VALUES ('Titanic'), ('Avengers'), ('Spider man');

INSERT INTO `session` (`date`, `movie_id`, `start`, `duration`, `stop`, `cost`) VALUES
('2020-12-30', 1, '09:00:00', '03:20:00', '12:20:00', 650),
('2020-12-30', 2, '10:00:00', '02:46:00', '12:46:00', 450),
('2020-12-30', 3, '12:00:00', '02:01:00', '14:01:00', 220),
('2020-12-30', 1, '15:30:00', '02:00:00', '17:30:00', 650),
('2020-12-30', 2, '18:00:00', '02:20:00', '20:20:00', 450);

INSERT INTO `ticket` (`session_id`, `quantity`) VALUES
(1, 3), (3, 2), (2, 5), (1, 7), (5, 4), (4, 2), (5, 4), (2, 2), (5, 6), (5, 7), (3, 5), (4, 4), (4, 2);
CREATE TABLE `vote` (
  `vote_id` int(11) NOT NULL AUTO_INCREMENT,
  `game_id` int(11) NOT NULL,
  `created` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`vote_id`),
  KEY `id_idx` (`game_id`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

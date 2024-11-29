USE `music`;
DROP function IF EXISTS `calcAlbumLength`;

USE `music`;
DROP function IF EXISTS `music`.`calcAlbumLength`;
;

DELIMITER $$
USE `music`$$
CREATE DEFINER=`devuser`@`localhost` FUNCTION `calcAlbumLength`(albumName TEXT) RETURNS DOUBLE
    READS SQL DATA
BEGIN
	DECLARE length DOUBLE DEFAULT 0.0;

	SELECT 
    COUNT(*) * 2.5
INTO length FROM
    music.albumview
WHERE
    album_name = albumName;
        
	RETURN length;
END$$

DELIMITER ;
;


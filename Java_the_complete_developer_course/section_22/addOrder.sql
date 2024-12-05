USE `storefront`;
DROP procedure IF EXISTS `storefront`.`addOrder`;

DELIMITER $$
USE `storefront`$$
CREATE DEFINER=`devuser`@`localhost` PROCEDURE `addOrder`(IN orderDate DATETIME, IN orderDetails JSON, OUT orderId INT, OUT insertedRecords INT)
BEGIN
	DECLARE i INT DEFAULT 0;
    DECLARE num_items INT;
    DECLARE item_description VARCHAR(255);
    DECLARE qty INT;
    SET num_items = JSON_LENGTH(orderDetails);
    
	SELECT order_id INTO orderId FROM storefront.order
		WHERE  order_date = orderDate;
	
	IF orderId IS NULL THEN
    
		START TRANSACTION;
        -- Insert a new order
        INSERT INTO storefront.order (order_date) VALUES (orderDate);
        
        -- Get order_id of last order inserted
		SELECT LAST_INSERT_ID() INTO orderId;
	
		-- Loop through the JSON order details Array
		WHILE i < num_items DO
			-- JSON functions extract the right element, and unquote it
			SET item_description = JSON_UNQUOTE(JSON_EXTRACT(orderDetails, CONCAT('$[', i, ']','.itemDescription')));	
			SET qty =  CAST(JSON_EXTRACT(orderDetails, CONCAT('$[', i, ']','.qty')) AS UNSIGNED);
			-- Insert a new song, track number is assigned here.
			INSERT INTO order_details (order_id, item_description, quantity)
				VALUES (orderId, item_description, qty); 
			SET i = i + 1;
			
		END WHILE;
    
		 COMMIT;
    END IF;
    
	SET insertedRecords = i;   
   
END$$

DELIMITER ;
DROP TABLE IF EXISTS price;

CREATE TABLE price (
  brand_id   INTEGER      NOT NULL,
  start_date TIMESTAMP NOT NULL,
  end_date TIMESTAMP NOT NULL,
  price_list   INTEGER      NOT NULL AUTO_INCREMENT,
  product_id   INTEGER      NOT NULL,
  priority  INTEGER      NOT NULL,
  price  DOUBLE      NOT NULL,
  curr VARCHAR(250),
  PRIMARY KEY (price_list)
);
DROP TABLE IF EXISTS price;
DROP INDEX IF EXISTS fk_price_service_provider_brand;
DROP TABLE IF EXISTS brand;

CREATE TABLE brand (
  brand_id   INTEGER      NOT NULL,
  name VARCHAR(50) NOT NULL,
  PRIMARY KEY (brand_id)
);

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

CREATE INDEX fk_price_service_provider_brand
    ON price(brand_id ASC);
ALTER TABLE price 
    ADD CONSTRAINT fk_price_service_provider_brand
    FOREIGN KEY (brand_id) 
    REFERENCES brand(brand_id)
    ON DELETE NO ACTION ON UPDATE NO ACTION;
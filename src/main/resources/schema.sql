CREATE TABLE operation_entity (
    id BIGINT PRIMARY KEY,
    operation_result NUMERIC,
    first_field NUMERIC,
    second_field NUMERIC,
    operation VARCHAR(25)
);
INSERT INTO operation_entity (id, operation_result, first_field, second_field, operation) VALUES (1, 2, 1, 1, 'SUMA');

CREATE TABLE exchange_rate (
    id BIGINT PRIMARY KEY auto_increment,
    origin_currency VARCHAR(255),
    finalCurrency VARCHAR(255),
    date VARCHAR(255),
    value VARCHAR(255)
);


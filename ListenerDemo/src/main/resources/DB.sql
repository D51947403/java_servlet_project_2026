
create schema if not exists servlet_crud;
use  servlet_crud;

CREATE TABLE if not exists counter (
        pageview INT,
        created_date DATE DEFAULT (CURRENT_DATE) -- Captures YYYY-MM-DD
);

INSERT INTO counter VALUES (0);
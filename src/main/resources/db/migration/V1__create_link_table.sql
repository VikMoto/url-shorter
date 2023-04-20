CREATE TABLE link (
    short_link VARCHAR(10) PRIMARY KEY ,
    link VARCHAR(2048) NOT NULL ,
    open_count INT DEFAULT 0
);
# create database suncode;
# create user 'test'@'%' identified by 'newpassword';
# grant all on suncode.* to 'test'@'%';

CREATE TABLE IF NOT EXISTS tabela_testowa (
    id bigint NOT NULL,
    kolumna1 VARCHAR(256),
    kolumna2 VARCHAR(256),
    kolumna3 VARCHAR(256),
    kolumna4 bigint
);

ALTER TABLE tabela_testowa ADD CONSTRAINT i1_constr PRIMARY KEY (id);
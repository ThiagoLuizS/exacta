create table if not exists tb_person (
   id_person int8 not null,
   name varchar(200)
);

alter table tb_person ADD CONSTRAINT tb_person_pkey PRIMARY KEY (id_person);

create table if not exists tb_user (
    id_user int8 not null,
    user_password text not null,
    user_email text not null,
    user_status varchar(50) not null
);

alter table tb_user ADD CONSTRAINT tb_user_pkey PRIMARY KEY (id_user);

create table if not exists tb_spending (
    id_spending int8 not null,
    id_person int8 not null,
    description varchar(200) not null,
    date_hour date not null,
    value decimal(10,2) not null default 0.0,
    tags text not null
);

alter table tb_spending ADD CONSTRAINT tb_spending_pkey PRIMARY KEY (id_spending);
alter table tb_spending ADD CONSTRAINT tb_spending_person_fkey FOREIGN KEY (id_person) REFERENCES tb_person (id_person);

CREATE SEQUENCE seq_id_person
    INCREMENT 1
    START 1;

CREATE SEQUENCE seq_id_spending
    INCREMENT 1
    START 1;

CREATE SEQUENCE seq_id_user
    INCREMENT 1
    START 1;

INSERT INTO tb_person
(id_person, name)
VALUES(1, 'Fulano de tal 1');
INSERT INTO tb_person
(id_person, name)
VALUES(2, 'Fulano de tal 2');
INSERT INTO tb_person
(id_person, name)
VALUES(3, 'Fulano de tal 3');
INSERT INTO tb_person
(id_person, name)
VALUES(4, 'Fulano de tal 4');


INSERT INTO tb_user
(id_user, user_password, user_email, user_status)
VALUES(1, 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 'exacta@gmail.com', 'ACTIVE');

INSERT INTO tb_spending
(id_spending, id_person, description, date_hour, value, tags)
VALUES(1, 1, 'Luz', '2022-10-31', 10.5, 'despesa fixa;conta atrasada;conta pra pagar');

INSERT INTO tb_spending
(id_spending, id_person, description, date_hour, value, tags)
VALUES(2, 1, 'Agua', '2022-10-31 20:50:31', 10.5, 'despesa fixa;conta atrasada;conta pra pagar');
create table doctors(
    id bigint not null auto_increment,
    name varchar(100) not null,
    email varchar(100) not null,
    crm varchar(6) not null unique,
    specialty varchar(100) not null,
    logradouro varchar(100) not null,
    bairro varchar(100) not null,
    cep varchar(9) not null,
    complemento varchar(100),
    numero varchar(20),
    uf varchar(2) not null,
    cidade varchar(100) not null,

    primary key(id)
);
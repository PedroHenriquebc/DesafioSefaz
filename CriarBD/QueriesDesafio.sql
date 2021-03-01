create database desafiosefazdb;
use desafiosefazdb;
create table usuarios(
	id int primary key auto_increment,
    nome varchar(50) not null,
    email varchar(50) not null,
    senha varchar(30) not null
);

create table telefones(
	id int primary key auto_increment,
    ddd int(2) not null,
    numero varchar(9) not null,
    tipo varchar(20) not null,
    idusuario int,
    foreign key (idusuario) references usuarios(id)
);
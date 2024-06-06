create database dbgestaofaz
CHARACTER SET utf8 COLLATE utf8_general_ci;

use dbgestaofaz;

create table raca(
id int auto_increment primary key,
nome varchar(50));

create table lote(
id int auto_increment primary key,
nome varchar(50),
area float);

create table animal(
id int auto_increment,
nome varchar(50),
peso float,
idraca int,
idlote int,
primary key (id),
foreign key (idraca) references raca(id), 
foreign key (idlote) references lote(id));

create table pecuarista(
id int auto_increment primary key,
nome varchar(100),
login varchar(100),
senha varchar(100));





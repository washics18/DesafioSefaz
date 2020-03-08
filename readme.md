# Desafio Sefaz

### Configuração

- SQL

```
create database userdb;

use userdb;

create table users(
userid int auto_increment primary key,
nome varchar(100) not null,
email varchar(30),
senha varchar(20) not null
);

create table phone(
id int auto_increment primary key,
ddd int not null,
numero varchar(20) not null,
tipo varchar(20),
Id_users int not null,
FOREIGN KEY (Id_users) REFERENCES users(userid)
);

insert into users(nome,email,senha) values ('admin','admin@admin.com','admin');
```
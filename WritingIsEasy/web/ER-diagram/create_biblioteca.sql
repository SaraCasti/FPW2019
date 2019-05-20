/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Sary
 * Created: 20-mag-2019
 */

create table libro(
    cod_libro serial primary key,
    titolo varchar(100) not null,
    autore varchar(100),
    editore varchar(100)
);

create table biblioteca(
	cod_biblioteca serial primary key,
    nome varchar(100),
    indirizzo varchar(200) not null
);

insert into libro values(default, 'Cages in Animation', 'Sara Casti', 'ilmiolibro.it');
insert into libro values(default, 'Polycubes and Fabrication', 'Anonimo', 'ilmiolibro.it');

select * from libro where autore = 'Sara Casti';


create table iscritto(
    cod_iscritto serial primary key,   
    nome varchar(100),
    cognome varchar(100),
    email varchar(200) not null,
    residenza varchar(200),
    n_ammonizioni integer
);

create table bibliotecario(
    cod_bibliotecario serial PRIMARY KEY,
    nome varchar(100),
    cognome varchar(100),
    email varchar(200),
    residenza varchar(100),
    cod_biblioteca bigint unsigned REFERENCES biblioteca(cod_biblioteca) 
    on update cascade on delete set null
    );


create table iscrizione(
    cod_biblioteca bigint unsigned REFERENCES biblioteca(cod_biblioteca) on DELETE cascade on update cascade,
    cod_iscritto bigint unsigned REFERENCES iscritto(cod_iscritto) on DELETE no action on update cascade,
    data_iscrizione date,
    PRIMARY KEY(cod_biblioteca,cod_iscritto)
);



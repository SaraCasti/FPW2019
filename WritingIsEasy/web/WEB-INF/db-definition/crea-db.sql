/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Sary
 * Created: 27-mag-2019
 */

create table utente(
    codU serial primary key,
    username varchar(200) not null,
    password varchar(300) not null,
    email varchar(200),
    eta smallint
);


create table libro(
    id serial primary key,
    isbn varchar(32),
    nome varchar(200),
    editore varchar(100),
    prezzo real(12,2),
    autore bigint unsigned references utente(codU) 
                           on delete cascade 
                           on update cascade
);

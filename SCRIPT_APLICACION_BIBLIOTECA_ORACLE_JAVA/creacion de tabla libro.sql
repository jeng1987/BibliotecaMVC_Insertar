create table libro(
    cod_libro number,
    tit_libro varchar(30),
    nom_libro varchar(30),
    edit_libro varchar(30)
);

alter table libro add constraint libro_pk PRIMARY key (cod_libro);
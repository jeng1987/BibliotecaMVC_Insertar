create tablespace poo2_tbs 
Datafile 'D:\TABLESPACES\POO2.DBF' 
SIZE 30M;

create user objetos2 identified by objetos2
default tablespace poo2_tbs
quota 10M
on poo2_tbs;

grant dba to objetos2





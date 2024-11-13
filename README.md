create table tbLibrería(
UUID_librería varchar2 (100),
nombre varchar2 (100) not null,
apellido varchar2 (100) not null, 
correo varchar2 (100) not null,
contrasena varchar2 (200) not null,
edad varchar2 (100) not null
);

create table tbLibros(
UUUID_libros varchar2 (100),
nombre_libro varchar2 (100) not null, 
autor varchar2 (100) not null,
ano_publicacion varchar2 (100) not null,
estado varchar2 (100) not null, 
ISBN varchar2 (200) not null, 
genero varchar2 (100) not null, 
paginas varchar2 (100) not null, 
editorial varchar2 (100) not null
);



select * from tbLibrería

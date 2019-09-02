drop database if exists tienda;

create database tienda;

\c tienda;

CREATE TABLE cliente (
	id numeric PRIMARY KEY,
	nombre varchar (100) NOT NULL,
	apellido varchar (100) NOT NULL,
	sexo varchar(10),
	tipo_documento varchar(10),
	numero_documento numeric
	);

CREATE TABLE producto (
	id numeric PRIMARY KEY,
	nombre varchar (100) NOT NULL,
	codigo_barras varchar (200) NOT NULL,
	valor numeric,
	cantidad int
	);

CREATE TABLE compras (
	id serial PRIMARY KEY,
	id_cliente numeric NOT NULL,
	id_producto numeric NOT NULL,
	numero_factura numeric
	);

ALTER TABLE compras ADD CONSTRAINT fk_constraint_compras_cliente FOREIGN KEY(id_cliente)
REFERENCES cliente (id)
on delete restrict on update restrict;

ALTER TABLE compras ADD CONSTRAINT fk_constraint_compras_producto FOREIGN KEY(id_producto)
REFERENCES producto (id)
on delete restrict on update restrict;

insert into cliente (id, nombre, apellido, sexo, tipo_documento, numero_documento) values (1, 'Ovidio', 'Zea', 'M', 'CC', 1024493);
insert into cliente (id, nombre, apellido, sexo, tipo_documento, numero_documento) values (2, 'Vanessa', 'Corredor', 'F', 'CC', 1012345);
insert into cliente (id, nombre, apellido, sexo, tipo_documento, numero_documento) values (3, 'Alberto', 'Zea', 'M', 'CC', 1024492);

insert into producto (id, nombre, codigo_barras, valor, cantidad) values (100, 'Pan', '123456789', 10, 1000);
insert into producto (id, nombre, codigo_barras, valor, cantidad) values (101, 'Leche', '8999888', 200, 100);
insert into producto (id, nombre, codigo_barras, valor, cantidad) values (102, 'Huevos', '87334849', 50, 67);

insert into compras (id, id_cliente, id_producto, numero_factura) values (1001, 1, 100, 99881);
insert into compras (id, id_cliente, id_producto, numero_factura) values (1002, 1, 101, 99881);
insert into compras (id, id_cliente, id_producto, numero_factura) values (1003, 1, 102, 99881);

insert into compras (id, id_cliente, id_producto, numero_factura) values (1004, 2, 102, 99882);

insert into compras (id, id_cliente, id_producto, numero_factura) values (1005, 3, 101, 99883);
insert into compras (id, id_cliente, id_producto, numero_factura) values (1006, 3, 100, 99883);

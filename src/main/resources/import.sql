INSERT INTO articulos (descripcion, imagen, nombre, precio, stock, stock_seguridad) VALUES ('Lavadora', 'Rojo', 'Lavadora', 200, 34, 10);
INSERT INTO articulos (descripcion, imagen, nombre, precio, stock, stock_seguridad) VALUES ('Movil', 'Verde', 'Movil', 300, 40, 20);
INSERT INTO articulos (descripcion, imagen, nombre, precio, stock, stock_seguridad) VALUES ('Televisor', 'Marron', 'Televisor', 250, 100, 15);
INSERT INTO articulos (descripcion, imagen, nombre, precio, stock, stock_seguridad) VALUES ('Licuadora', 'Azul', 'Licuadora', 150, 76, 7);



INSERT INTO clientes (apellido, codigo_postal, empresa, fecha_nacimiento, nombre, provincia, puesto, telefono) VALUES ('Gomez', '33210', 'Mercadona SL', '2022-03-04', 'Pedro', 'Asturias', 'Gerente', '987654234');
INSERT INTO clientes (apellido, codigo_postal, empresa, fecha_nacimiento, nombre, provincia, puesto, telefono) VALUES ('Sanchez', '33200', 'Carrefour SL', '2020-05-07', 'Marcos', 'Galicia', 'Jefe', '986567654');
INSERT INTO clientes (apellido, codigo_postal, empresa, fecha_nacimiento, nombre, provincia, puesto, telefono) VALUES ('Perez', '33400', 'Alimerka SL', '2019-03-09', 'Juan', 'Cantabria', 'Encargado', '986456432');
INSERT INTO clientes (apellido, codigo_postal, empresa, fecha_nacimiento, nombre, provincia, puesto, telefono) VALUES ('Fernandez', '33290', 'MasyMas SL', '2018-02-07', 'Ramon', 'Barcelona', 'Gerente', '987887667');


INSERT INTO compras (fecha, unidades, cod_articulo, cod_cliente) VALUES ('2022-03-09 13:44:10.000000', 7, 1, 1);
INSERT INTO compras (fecha, unidades, cod_articulo, cod_cliente) VALUES ('2020-02-07 13:44:10.000000', 8, 3, 4);
INSERT INTO compras (fecha, unidades, cod_articulo, cod_cliente) VALUES ('2019-01-05 13:44:10.000000', 9, 2, 3);
INSERT INTO compras (fecha, unidades, cod_articulo, cod_cliente) VALUES ('2017-03-01 13:44:10.000000', 10, 1, 3);
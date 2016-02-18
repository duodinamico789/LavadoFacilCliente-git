-- INSERTS  -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
USE `lavadero_01`;
INSERT INTO sucursales (NombreSuc,Telefono,Eliminado) VALUES ('Sucursal Aguada','20201234',0);
INSERT INTO sucursales (NombreSuc,Telefono,Eliminado) VALUES ('Sucursal Barrio Sur','20201235',0);
INSERT INTO sucursales (NombreSuc,Telefono,Eliminado) VALUES ('Sucursal Buceo','20201236',0);
INSERT INTO sucursales (NombreSuc,Telefono,Eliminado) VALUES ('Sucursal Carrasco','20201237',0);
INSERT INTO sucursales (NombreSuc,Telefono,Eliminado) VALUES ('Sucursal Centro','20201238',0);
INSERT INTO sucursales (NombreSuc,Telefono,Eliminado) VALUES ('Sucursal Cerro','20201239',0);
INSERT INTO sucursales (NombreSuc,Telefono,Eliminado) VALUES ('Sucursal Ciudad Vieja','20201240',0);
INSERT INTO sucursales (NombreSuc,Telefono,Eliminado) VALUES ('Sucursal Cordón','20201241',0);
INSERT INTO sucursales (NombreSuc,Telefono,Eliminado) VALUES ('Sucursal La Unión','20201242',0);
INSERT INTO sucursales (NombreSuc,Telefono,Eliminado) VALUES ('Sucursal Maroñas','20201243',0);
INSERT INTO sucursales (NombreSuc,Telefono,Eliminado) VALUES ('Sucursal Parque Rodó','20201244',0);
INSERT INTO sucursales (NombreSuc,Telefono,Eliminado) VALUES ('Sucursal Pocitos','20201245',0);
INSERT INTO sucursales (NombreSuc,Telefono,Eliminado) VALUES ('Sucursal Punta Gorda','20201246',0);
INSERT INTO prendas (Tipo,AplicaTint,Eliminado) VALUES ('Gorro',0,0);
INSERT INTO prendas (Tipo,AplicaTint,Eliminado) VALUES ('Guante',0,0);
INSERT INTO prendas (Tipo,AplicaTint,Eliminado) VALUES ('Pantalón',0,0);
INSERT INTO prendas (Tipo,AplicaTint,Eliminado) VALUES ('Sombrero',0,0);
INSERT INTO prendas (Tipo,AplicaTint,Eliminado) VALUES ('Sostén',0,0);
INSERT INTO prendas (Tipo,AplicaTint,Eliminado) VALUES ('Suéter',0,0);
INSERT INTO prendas (Tipo,AplicaTint,Eliminado) VALUES ('Vestido',0,0);
INSERT INTO prendas (Tipo,AplicaTint,Eliminado) VALUES ('Blusa',0,0);
INSERT INTO prendas (Tipo,AplicaTint,Eliminado) VALUES ('Boina',0,0);
INSERT INTO prendas (Tipo,AplicaTint,Eliminado) VALUES ('Camisa',0,0);
INSERT INTO prendas (Tipo,AplicaTint,Eliminado) VALUES ('Camiseta',0,0);
INSERT INTO prendas (Tipo,AplicaTint,Eliminado) VALUES ('Chaqueta',0,0);
INSERT INTO prendas (Tipo,AplicaTint,Eliminado) VALUES ('Corbata',0,0);
INSERT INTO prendas (Tipo,AplicaTint,Eliminado) VALUES ('Falda',0,0);
INSERT INTO prendas (Tipo,AplicaTint,Eliminado) VALUES ('Gorra',0,0);
INSERT INTO prendas (Tipo,AplicaTint,Eliminado) VALUES ('Pijama',0,0);
INSERT INTO prendas (Tipo,AplicaTint,Eliminado) VALUES ('Botas',0,0);
INSERT INTO prendas (Tipo,AplicaTint,Eliminado) VALUES ('Calcetines',0,0);
INSERT INTO prendas (Tipo,AplicaTint,Eliminado) VALUES ('Calzoncillos',0,0);
INSERT INTO prendas (Tipo,AplicaTint,Eliminado) VALUES ('Zapatos',0,0);
/*DELETE FROM opciones;
ALTER TABLE opciones AUTO_INCREMENT = 1;*/
INSERT INTO opciones (NombreOpc, Precio,Eliminado) VALUES ('Lavado completo', '160.00',0);
INSERT INTO opciones (NombreOpc, Precio,Eliminado) VALUES ('Lavado de blancos', '170.00',0);
INSERT INTO opciones (NombreOpc, Precio,Eliminado) VALUES ('Lavado delicado', '190.00',0);
INSERT INTO opciones (NombreOpc, Precio,Eliminado) VALUES ('Lavado a mano', '200.00',0);
INSERT INTO opciones (NombreOpc, Precio,Eliminado) VALUES ('Secado', '100.00',0);
INSERT INTO opciones (NombreOpc, Precio,Eliminado) VALUES ('Planchado', '80.00',0);
INSERT INTO opciones (NombreOpc, Precio,Eliminado) VALUES ('Utilizar agua caliente', '0.00',0);
/*Solo perfumado no. No vas a llevar la ropa al lavadero solo para q la perfumen*/
/*INSERT INTO opciones (NombreOpc, Precio) VALUES ('Perfumado', '80.00');*/
/*DELETE FROM excepciones;
ALTER TABLE excepciones AUTO_INCREMENT = 1;*/
INSERT INTO excepciones (Nombre,Eliminado) VALUES ('Omitir perfumado',0);
/*Solo secado no. No vas a dejar la ropa mojada*/
INSERT INTO excepciones (Nombre,Eliminado) VALUES ('Omitir planchado',0);
INSERT INTO excepciones (Nombre,Eliminado) VALUES ('Lavar a menos de 30 grados',0);
INSERT INTO excepciones (Nombre,Eliminado) VALUES ('Lavar con ropa clara',0);
INSERT INTO excepciones (Nombre,Eliminado) VALUES ('Lavar con ropa oscura',0);
insert into personas (Cedula, Passw, Nombre, Telefono, Celular, FechaOlvidoPass,Eliminado) 
	values ('1111111', 'nancy', 'Nancy Rosa', '48-(609)830-9913', '256-(776)883-1158', null,0);
insert into personas (Cedula, Passw, Nombre, Telefono, Celular, FechaOlvidoPass,Eliminado) 
	values ('37185257', 'vitae', 'Gary Medina', '48-(609)860-9913', '256-(776)883-1154', null,0);
insert into personas (Cedula, Passw, Nombre, Telefono, Celular, FechaOlvidoPass,Eliminado) 
	values ('20732224', 'volutpat', 'Jean Warren', '86-(877)575-9413', '30-(713)123-5995', null,0);
insert into personas (Cedula, Passw, Nombre, Telefono, Celular, FechaOlvidoPass,Eliminado) 
	values ('78810941', 'id', 'Peter Baker', '84-(674)214-0807', '86-(739)532-4091', null,0);
insert into personas (Cedula, Passw, Nombre, Telefono, Celular, FechaOlvidoPass,Eliminado) 
	values ('27314113', 'venenatis', 'Aaron Peterson', '7-(438)880-7149', '385-(238)626-6948', null,0);
insert into personas (Cedula, Passw, Nombre, Telefono, Celular, FechaOlvidoPass,Eliminado) 
	values ('91150042', 'mattis', 'Patricia Wright', '48-(790)363-2250', '351-(763)186-8138', null,0);
insert into personas (Cedula, Passw, Nombre, Telefono, Celular, FechaOlvidoPass,Eliminado) 
	values ('15965519', 'lectus', 'Douglas Arnold', '55-(128)992-6875', '86-(839)451-6600', null,0);
insert into clientes (Cedula, FechaReg, FechaUltimaEntrada) values ('1111111', '2015-01-11 11:55:00', null);
insert into clientes (Cedula, FechaReg, FechaUltimaEntrada) values ('37185257', '2015-01-11 11:55:00', null);
insert into clientes (Cedula, FechaReg, FechaUltimaEntrada) values ('20732224', '2015-01-11 11:55:00', null);
insert into empleados (Cedula, Sueldo, FechaIngreso, TipoEmpleado, IdSuc) values ('78810941', '13398.68', '2015-01-11 11:55:00', 3, 12);
insert into empleados (Cedula, Sueldo, FechaIngreso, TipoEmpleado, IdSuc) values ('27314113', '22466.63', '2015-01-11 11:55:00', 2, 4);
insert into empleados (Cedula, Sueldo, FechaIngreso, TipoEmpleado, IdSuc) values ('91150042', '23196.94', '2015-01-11 11:55:00', 5, 5);
insert into empleados (Cedula, Sueldo, FechaIngreso, TipoEmpleado, IdSuc) values ('15965519', '23525.79', '2015-01-11 11:55:00', 1, 4);
insert into Ubicaciones (Direccion, Barrio, Ciudad,Eliminado) values ('5293 Monterey Point', 'Alaska', 'Anchorage',0);
insert into Ubicaciones (Direccion, Barrio, Ciudad,Eliminado) values ('6 Russell Alley', 'Florida', 'Miami',0);
insert into Ubicaciones (Direccion, Barrio, Ciudad,Eliminado) values ('93470 Golf Course Street', 'Alaska', 'Anchorage',0);
insert into Ubicaciones (Direccion, Barrio, Ciudad,Eliminado) values ('914 Grasskamp Street', 'South Carolina', 'Greenville',0);
insert into Ubicaciones (Direccion, Barrio, Ciudad,Eliminado) values ('253 Roxbury Place', 'Georgia', 'Cumming',0);
insert into Ubicaciones (Direccion, Barrio, Ciudad,Eliminado) values ('22 Lakewood Park', 'California', 'Los Angeles',0);
insert into Ubicaciones (Direccion, Barrio, Ciudad,Eliminado) values ('fgfgfg', 'Georgia', 'Albany',0);
insert into Ubicaciones (Direccion, Barrio, Ciudad,Eliminado) values ('bnbn', 'Georgia', 'Albany',0);
insert into Ubicaciones (Direccion, Barrio, Ciudad,Eliminado) values ('fgfdgfg', 'Georgia', 'Albany',0);
insert into Ubicaciones (Direccion, Barrio, Ciudad,Eliminado) values ('dfgfdg', 'Georgia', 'Albany',0);
insert into Ubicaciones (Direccion, Barrio, Ciudad,Eliminado) values ('bbnbn', 'Georgia', 'Albany',0);
insert into Ubicaciones (Direccion, Barrio, Ciudad,Eliminado) values ('xxxx', 'Georgia', 'Albany',0);
insert into relacion_ubicpersona(IdUbic, CedPersona) Values(1, 1111111);
insert into relacion_ubicpersona(IdUbic, CedPersona) Values(2, 37185257);
insert into relacion_ubicpersona(IdUbic, CedPersona) Values(3, 20732224);
insert into relacion_ubicpersona(IdUbic, CedPersona) Values(4, 78810941);
insert into relacion_ubicpersona(IdUbic, CedPersona) Values(5, 27314113);
insert into relacion_ubicpersona(IdUbic, CedPersona) Values(6, 91150042);
insert into relacion_ubicpersona(IdUbic, CedPersona) Values(7, 15965519);
insert into relacion_ubicsucursales(IdUbic, idSuc) Values(8, 2);
insert into relacion_ubicsucursales(IdUbic, idSuc) Values(9, 3);
insert into relacion_ubicsucursales(IdUbic, idSuc) Values(10, 4);
insert into relacion_ubicsucursales(IdUbic, idSuc) Values(11, 5);
insert into relacion_ubicsucursales(IdUbic, idSuc) Values(12, 6);



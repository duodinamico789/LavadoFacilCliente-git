-- INSERTS  -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
INSERT INTO sucursales (NombreSuc,Telefono) VALUES ('Sucursal Aguada','20201234');
INSERT INTO sucursales (NombreSuc,Telefono) VALUES ('Sucursal Barrio Sur','20201235');
INSERT INTO sucursales (NombreSuc,Telefono) VALUES ('Sucursal Buceo','20201236');
INSERT INTO sucursales (NombreSuc,Telefono) VALUES ('Sucursal Carrasco','20201237');
INSERT INTO sucursales (NombreSuc,Telefono) VALUES ('Sucursal Centro','20201238');
INSERT INTO sucursales (NombreSuc,Telefono) VALUES ('Sucursal Cerro','20201239');
INSERT INTO sucursales (NombreSuc,Telefono) VALUES ('Sucursal Ciudad Vieja','20201240');
INSERT INTO sucursales (NombreSuc,Telefono) VALUES ('Sucursal Cordón','20201241');
INSERT INTO sucursales (NombreSuc,Telefono) VALUES ('Sucursal La Unión','20201242');
INSERT INTO sucursales (NombreSuc,Telefono) VALUES ('Sucursal Maroñas','20201243');
INSERT INTO sucursales (NombreSuc,Telefono) VALUES ('Sucursal Parque Rodó','20201244');
INSERT INTO sucursales (NombreSuc,Telefono) VALUES ('Sucursal Pocitos','20201245');
INSERT INTO sucursales (NombreSuc,Telefono) VALUES ('Sucursal Punta Gorda','20201246');
INSERT INTO prendas (Tipo,AplicaTint) VALUES ('Gorro','0');
INSERT INTO prendas (Tipo,AplicaTint) VALUES ('Guante','0');
INSERT INTO prendas (Tipo,AplicaTint) VALUES ('Pantalón','0');
INSERT INTO prendas (Tipo,AplicaTint) VALUES ('Sombrero','0');
INSERT INTO prendas (Tipo,AplicaTint) VALUES ('Sostén','0');
INSERT INTO prendas (Tipo,AplicaTint) VALUES ('Suéter','0');
INSERT INTO prendas (Tipo,AplicaTint) VALUES ('Vestido','0');
INSERT INTO prendas (Tipo,AplicaTint) VALUES ('Blusa','0');
INSERT INTO prendas (Tipo,AplicaTint) VALUES ('Boina','0');
INSERT INTO prendas (Tipo,AplicaTint) VALUES ('Camisa','0');
INSERT INTO prendas (Tipo,AplicaTint) VALUES ('Camiseta','0');
INSERT INTO prendas (Tipo,AplicaTint) VALUES ('Chaqueta','0');
INSERT INTO prendas (Tipo,AplicaTint) VALUES ('Corbata','0');
INSERT INTO prendas (Tipo,AplicaTint) VALUES ('Falda','0');
INSERT INTO prendas (Tipo,AplicaTint) VALUES ('Gorra','0');
INSERT INTO prendas (Tipo,AplicaTint) VALUES ('Pijama','0');
INSERT INTO prendas (Tipo,AplicaTint) VALUES ('Botas','0');
INSERT INTO prendas (Tipo,AplicaTint) VALUES ('Calcetines','0');
INSERT INTO prendas (Tipo,AplicaTint) VALUES ('Calzoncillos','0');
INSERT INTO prendas (Tipo,AplicaTint) VALUES ('Zapatos','0');
DELETE FROM opciones;
ALTER TABLE opciones AUTO_INCREMENT = 1;
INSERT INTO opciones (NombreOpc, Precio) VALUES ('Lavado completo', '160.00');
INSERT INTO opciones (NombreOpc, Precio) VALUES ('Lavado de blancos', '170.00');
INSERT INTO opciones (NombreOpc, Precio) VALUES ('Lavado delicado', '190.00');
INSERT INTO opciones (NombreOpc, Precio) VALUES ('Lavado a mano', '200.00');
INSERT INTO opciones (NombreOpc, Precio) VALUES ('Secado', '100.00');
INSERT INTO opciones (NombreOpc, Precio) VALUES ('Planchado', '80.00');
INSERT INTO opciones (NombreOpc, Precio) VALUES ('Utilizar agua caliente', '0.00');
/*Solo perfumado no. No vas a llevar la ropa al lavadero solo para q la perfumen*/
/*INSERT INTO opciones (NombreOpc, Precio) VALUES ('Perfumado', '80.00');*/
DELETE FROM excepciones;
ALTER TABLE excepciones AUTO_INCREMENT = 1;
INSERT INTO excepciones (Nombre) VALUES ('Omitir perfumado');
/*Solo secado no. No vas a dejar la ropa mojada*/
/*INSERT INTO excepciones (Nombre) VALUES ('Omitir secado');*/
INSERT INTO excepciones (Nombre) VALUES ('Omitir planchado');
INSERT INTO excepciones (Nombre) VALUES ('Lavar a menos de 30 grados');
INSERT INTO excepciones (Nombre) VALUES ('Lavar con ropa clara');
INSERT INTO excepciones (Nombre) VALUES ('Lavar con ropa oscura');
insert into personas (Cedula, Passw, Nombre, Telefono, Celular, FechaOlvidoPass) values ('1111111', 'nancy', 'Nancy Rosa', '48-(609)830-9913', '256-(776)883-1158', null);
insert into personas (Cedula, Passw, Nombre, Telefono, Celular, FechaOlvidoPass) values ('37185257', 'vitae', 'Gary Medina', '48-(609)860-9913', '256-(776)883-1154', null);
insert into personas (Cedula, Passw, Nombre, Telefono, Celular, FechaOlvidoPass) values ('20732224', 'volutpat', 'Jean Warren', '86-(877)575-9413', '30-(713)123-5995', null);
insert into personas (Cedula, Passw, Nombre, Telefono, Celular, FechaOlvidoPass) values ('78810941', 'id', 'Peter Baker', '84-(674)214-0807', '86-(739)532-4091', null);
insert into personas (Cedula, Passw, Nombre, Telefono, Celular, FechaOlvidoPass) values ('27314113', 'venenatis', 'Aaron Peterson', '7-(438)880-7149', '385-(238)626-6948', null);
insert into personas (Cedula, Passw, Nombre, Telefono, Celular, FechaOlvidoPass) values ('91150042', 'mattis', 'Patricia Wright', '48-(790)363-2250', '351-(763)186-8138', null);
insert into personas (Cedula, Passw, Nombre, Telefono, Celular, FechaOlvidoPass) values ('15965519', 'lectus', 'Douglas Arnold', '55-(128)992-6875', '86-(839)451-6600', null);
insert into clientes (Cedula, FechaReg, FechaUltimaEntrada) values ('1111111', '2015-01-11 11:55:00', null);
insert into clientes (Cedula, FechaReg, FechaUltimaEntrada) values ('37185257', '2015-01-11 11:55:00', null);
insert into clientes (Cedula, FechaReg, FechaUltimaEntrada) values ('20732224', '2015-01-11 11:55:00', null);
insert into empleados (Cedula, Sueldo, FechaIngreso, TipoEmpleado, IdSuc) values ('78810941', '13398.68', '2015-01-11 11:55:00', 3, 12);
insert into empleados (Cedula, Sueldo, FechaIngreso, TipoEmpleado, IdSuc) values ('27314113', '22466.63', '2015-01-11 11:55:00', 2, 4);
insert into empleados (Cedula, Sueldo, FechaIngreso, TipoEmpleado, IdSuc) values ('91150042', '23196.94', '2015-01-11 11:55:00', 5, 5);
insert into empleados (Cedula, Sueldo, FechaIngreso, TipoEmpleado, IdSuc) values ('15965519', '23525.79', '2015-01-11 11:55:00', 1, 4);
insert into Ubicaciones (Direccion, Barrio, Ciudad) values ('5293 Monterey Point', 'Alaska', 'Anchorage');
insert into Ubicaciones (Direccion, Barrio, Ciudad) values ('6 Russell Alley', 'Florida', 'Miami');
insert into Ubicaciones (Direccion, Barrio, Ciudad) values ('93470 Golf Course Street', 'Alaska', 'Anchorage');
insert into Ubicaciones (Direccion, Barrio, Ciudad) values ('914 Grasskamp Street', 'South Carolina', 'Greenville');
insert into Ubicaciones (Direccion, Barrio, Ciudad) values ('253 Roxbury Place', 'Georgia', 'Cumming');
insert into Ubicaciones (Direccion, Barrio, Ciudad) values ('22 Lakewood Park', 'California', 'Los Angeles');
insert into Ubicaciones (Direccion, Barrio, Ciudad) values ('6266 Basil Alley', 'Georgia', 'Albany');
insert into relacion_ubicpersona(IdUbic, CedPersona) Values(1, 1111111);
insert into relacion_ubicpersona(IdUbic, CedPersona) Values(2, 37185257);
insert into relacion_ubicpersona(IdUbic, CedPersona) Values(3, 20732224);
insert into relacion_ubicpersona(IdUbic, CedPersona) Values(4, 78810941);
insert into relacion_ubicpersona(IdUbic, CedPersona) Values(5, 27314113);
insert into relacion_ubicpersona(IdUbic, CedPersona) Values(6, 91150042);
insert into relacion_ubicpersona(IdUbic, CedPersona) Values(7, 15965519);
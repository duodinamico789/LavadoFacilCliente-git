DROP DATABASE IF EXISTS `lavadero_01`;
CREATE DATABASE `lavadero_01`; USE `lavadero_01`;
CREATE TABLE `brechasHorarias` (
 `HoraInicio` TIME NOT NULL,
 `HoraFin` TIME NOT NULL,
 `DiasVigencia` VARCHAR(55) NOT NULL,
 `LimiteSol` INT(11) NOT NULL,
 `NoDisponible` BIT(1) NOT NULL, PRIMARY KEY (`HoraInicio`,`HoraFin`)
);
CREATE TABLE `personas` (
 `Cedula` VARCHAR(30) NOT NULL,
 `Passw` VARCHAR(40) NOT NULL,
 `Nombre` VARCHAR(100) NOT NULL,
 `Telefono` VARCHAR(40) NOT NULL,
 `Celular` VARCHAR(30) NOT NULL,
 `FechaOlvidoPass` DATETIME DEFAULT NULL, PRIMARY KEY (`Cedula`)
);
CREATE TABLE `clientes` (
 `Cedula` VARCHAR(30) NOT NULL,
 `FechaReg` DATETIME NOT NULL,
 `FechaUltimaEntrada` DATETIME, CONSTRAINT `FK_personas_clientes` FOREIGN KEY (`Cedula`) REFERENCES `personas` (`Cedula`), PRIMARY KEY (`Cedula`)
);
CREATE TABLE `sucursales` (
 `IdSuc` INT(11) NOT NULL AUTO_INCREMENT,
 `NombreSuc` VARCHAR(30) NOT NULL UNIQUE,
 `Telefono` VARCHAR(30) NOT NULL, PRIMARY KEY (`IdSuc`)
);
CREATE TABLE `empleados` (
 `Cedula` VARCHAR(30) NOT NULL,
 `Sueldo` DECIMAL(10,2) NOT NULL,
 `FechaIngreso` DATE NOT NULL,
 `tipoempleado` varchar(30) NOT NULL,
 `IdSuc` INT(11) NOT NULL, CONSTRAINT `FK__sucursalesemp2` FOREIGN KEY (`IdSuc`) REFERENCES `sucursales` (`IdSuc`), CONSTRAINT `FK_personas_empleados` FOREIGN KEY (`Cedula`) REFERENCES `personas` (`Cedula`), PRIMARY KEY (`Cedula`)
);
CREATE TABLE `excepciones` (
 `IdExc` INT(11) NOT NULL AUTO_INCREMENT,
 `Nombre` VARCHAR(50) NOT NULL, PRIMARY KEY (`IdExc`)
);
CREATE TABLE `movimientos` (
 `IdMov` INT(11) NOT NULL AUTO_INCREMENT,
 `FechaMov` DATETIME NOT NULL,
 `NombreMov` VARCHAR(30) NOT NULL,
 `TipoMov` INT NOT NULL,
 `Monto` DECIMAL(10,2) NOT NULL,
 `Descripcion` VARCHAR(30) NOT NULL,
 `IdSuc` INT(11) NOT NULL, PRIMARY KEY (`IdMov`), CONSTRAINT `FK___sucursalesnew2` FOREIGN KEY (`IdSuc`) REFERENCES `sucursales` (`IdSuc`)
);
CREATE TABLE `opciones` (
 `IdOpc` INT(11) NOT NULL AUTO_INCREMENT,
 `NombreOpc` VARCHAR(50) NOT NULL,
 `Precio` DECIMAL(10,2) NOT NULL,
 PRIMARY KEY (`IdOpc`)
);
CREATE TABLE `prendas` (
 `IdPda` INT(11) NOT NULL AUTO_INCREMENT,
 `Tipo` VARCHAR(30) NOT NULL UNIQUE,
 `AplicaTint` BIT(1) NOT NULL, PRIMARY KEY (`IdPda`)
);
CREATE TABLE `solicitudes` (
 `Id` INT(11) NOT NULL AUTO_INCREMENT,
 `FechaIngreso` DATETIME NOT NULL,
 `Observaciones` VARCHAR(180),
 `FechaEntrega` DATETIME,
 `Estado` VARCHAR(50) NOT NULL,
 `CedulaCli` VARCHAR(30) NOT NULL,
 `CedulaEmp` VARCHAR(30) NOT NULL,
 `ConDelivery` bool NOT NULL,
 `IdSuc` INT(11) NOT NULL, PRIMARY KEY (`Id`), CONSTRAINT `FK_clientes_solicitudes` FOREIGN KEY (`CedulaCli`) REFERENCES `clientes` (`Cedula`), CONSTRAINT `FK_empleados_solicitudes` FOREIGN KEY (`CedulaEmp`) REFERENCES `empleados` (`Cedula`), CONSTRAINT `FK_suc_solicitudes` FOREIGN KEY (`IdSuc`) REFERENCES `sucursales` (`IdSuc`)
);
CREATE TABLE `solicitudDetalles` (
 `Id` int (11) NOT NULL AUTO_INCREMENT,
 `IdSol` int NOT NULL,
 `Linea` INT(4) NOT NULL,
 `IdPda` INT(4),
 `Precio` DECIMAL(10,2) ,
 `Cantidad` INT,
 `Descripcion` VARCHAR(100) NOT NULL, PRIMARY KEY (`Id`), CONSTRAINT `FK_solicitudDetalles_pda` FOREIGN KEY (`IdPda`) REFERENCES `prendas` (`IdPda`), CONSTRAINT `FK_solicitudDetalles_sol` FOREIGN KEY (`IdSol`) REFERENCES `solicitudes` (`Id`)
);
CREATE TABLE `tintorerias` (
 `IdTint` INT(11) NOT NULL AUTO_INCREMENT,
 `Nombre` VARCHAR(30) NOT NULL UNIQUE,
 `Telefono` VARCHAR(30) NOT NULL, PRIMARY KEY (`IdTint`)
);
CREATE TABLE `ubicaciones` (
 `Id` INT NOT NULL AUTO_INCREMENT,
 `Direccion` VARCHAR(100) NOT NULL,
 `Barrio` VARCHAR(30) DEFAULT NULL,
 `Ciudad` VARCHAR(30) DEFAULT NULL, PRIMARY KEY (`Id`)
);
CREATE TABLE `relacion_prendaenvio`(
 `Id` INT NOT NULL AUTO_INCREMENT,
 `IdPda` INT(4)NOT NULL,
 `IdTint`INT (11)NOT NULL,
 `Precio` DECIMAL(10,2)NOT NULL, PRIMARY KEY (`Id`)
);
CREATE TABLE `relacion_solicitudesopciones` (
 `IdSol` INT(11) NOT NULL,
 `IdOpcion` INT(11) NOT NULL, KEY `FK__solicitudes` (`IdSol`), KEY `FK__opciones` (`IdOpcion`), CONSTRAINT `FK__solicitudes` FOREIGN KEY (`IdSol`) REFERENCES `solicitudes` (`Id`), CONSTRAINT `FK__opciones` FOREIGN KEY (`IdOpcion`) REFERENCES `opciones` (`IdOpc`)
);
CREATE TABLE `relacion_ubicsucursales` (
 `IdUbic` INT(11) NOT NULL,
 `IdSuc` INT(11) NOT NULL, PRIMARY KEY (`IdUbic`, `IdSuc`), CONSTRAINT `FK__ubicacionesnew` FOREIGN KEY (`IdUbic`) REFERENCES `ubicaciones` (`Id`), CONSTRAINT `FK___sucursalesnew` FOREIGN KEY (`IdSuc`) REFERENCES `sucursales` (`IdSuc`)
);
CREATE TABLE `relacion_ubictintorerias` (
 `IdUbic` INT(11) NOT NULL,
 `IdTint` INT(11) NOT NULL, PRIMARY KEY (`IdUbic`, `IdTint`), CONSTRAINT `FK__ubicaciones` FOREIGN KEY (`IdUbic`) REFERENCES `ubicaciones` (`Id`), CONSTRAINT `FK__tintorerias` FOREIGN KEY (`IdTint`) REFERENCES `tintorerias` (`IdTint`)
);
CREATE TABLE `relacion_solicitudesbrechas` (
 `IdSol` INT(11) NOT NULL,
 `HoraInicio` TIME NOT NULL,
 `HoraFin` TIME NOT NULL, CONSTRAINT `FK__brechasHorarias` FOREIGN KEY (`HoraInicio`, `HoraFin`) REFERENCES `brechasHorarias` (`HoraInicio`, `HoraFin`)
);
CREATE TABLE `relacion_tintoreriassucursales` (
	`IdTint` INT(11) NOT NULL,
	`IdSuc` INT(11) NOT NULL, CONSTRAINT `FK___tintorerias` FOREIGN KEY (`IdTint`) REFERENCES `tintorerias` (`IdTint`), CONSTRAINT `FK___nnnsucursales` FOREIGN KEY (`IdSuc`) REFERENCES `sucursales` (`IdSuc`)
);
CREATE TABLE `relacion_ubicpersona` (
	`IdUbic` INT(11) NOT NULL,
	`CedPersona` VARCHAR(30) NOT NULL, CONSTRAINT `FK___ubicaciones` FOREIGN KEY (`idubic`) REFERENCES `ubicaciones` (`id`), CONSTRAINT `FK___personas` FOREIGN KEY (`CedPersona`) REFERENCES `personas` (`Cedula`)
);
CREATE TABLE `relacion_excepcionesPrendas` (
	`IdPda` INT(11) NOT NULL,
	`IdExc` INT(11) NOT NULL, CONSTRAINT `FK___prendas` FOREIGN KEY (`IdPda`) REFERENCES `prendas` (`IdPda`), CONSTRAINT `FK___excepciones` FOREIGN KEY (`IdExc`) REFERENCES `excepciones` (`IdExc`)
);

DELIMITER //


/*-- -- -- -- -- -- -- -- -- -- SOLICITUDES -- -- -- -- -- -- -- -- -- -- */
/*-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- */
create procedure AltaSolicitudDetalle(idSol2 int, linea2 int, precio2 DECIMAL(10,2), cantidad2 int, descripcion2 varchar(100), idPda2 int, OUT result int)begin
declare exit handler for SqlException
	begin
		SET result = -1;
		rollback;
	end;
	
	INSERT INTO SolicitudDetalleS (`IdSol`, `Linea`,`IdPda`, `Precio`, `Cantidad`, `Descripcion`) VALUES (idSol2,linea2, idPda2, precio2, cantidad2, descripcion2);
	SET result = 1;
	commit;
end//	

create procedure BajaSolicitudDetalle(idSol2 int, OUT result int) begin
	declare exit handler for SqlException
	begin
		SET result = -1;
		rollback;
	end;
	
	DELETE FROM SolicitudDetalleS WHERE `IdSol` = idSol2;
	commit;
	SET result = 1;
end//

create procedure ListarOpcionesXSol(idSol int)
begin
  select opciones.* 
  from opciones
  inner join relacion_solicitudesopciones on relacion_solicitudesopciones.IdOpcion = opciones.IdOpc
  where relacion_solicitudesopciones.IdSol = idSol;
end//

create procedure ListarPrendasXSol(idSol int)
begin
  select solicituddetalles.*, prendas.*
  from solicituddetalles 
  inner join prendas on prendas.IdPda = solicituddetalles.IdPda
  where solicituddetalles.IdSol = idSol and prendas.IdPda not in(1);
end//
	
Create Procedure BuscarSolicitudXId(idSol int)
begin
 select solicitudes.*, opciones.*, solicituddetalles.*
 from solicitudes 
 inner join relacion_solicitudesopciones on relacion_solicitudesopciones.IdSol = solicitudes.Id
 inner join opciones on relacion_solicitudesopciones.IdOpcion = opciones.IdOpc
 inner join solicituddetalles on solicituddetalles.IdSol = solicitudes.Id
 where solicitudes.Id =  idSol
 GROUP by solicitudes.Id;   
end//

Create Procedure BuscarSolicitudXCli(CiCli varchar(30))
begin
 select solicitudes.*, opciones.*, solicituddetalles.*
 from solicitudes 
 inner join relacion_solicitudesopciones on relacion_solicitudesopciones.IdSol = solicitudes.Id
 inner join opciones on relacion_solicitudesopciones.IdOpcion = opciones.IdOpc
 inner join solicituddetalles on solicituddetalles.IdSol = solicitudes.Id
 where solicitudes.CedulaCli =  CiCli
 GROUP by solicitudes.Id;  
end//

create procedure listarBrechasXSol(idSol int)
begin
   select brechashorarias.*
	from brechashorarias 
	inner join relacion_solicitudesbrechas on relacion_solicitudesbrechas.HoraInicio = brechashorarias.HoraInicio and relacion_solicitudesbrechas.HoraFin = brechashorarias.HoraFin
	where relacion_solicitudesbrechas.IdSol = idSol; 
end//

create procedure ListarSolicitudes()
begin
  select*
  from solicitudes;
end//	

create procedure AltaSolicitud(fechaIngreso2 datetime, Observaciones2 varchar(180), 
										 fechaEntrega2 datetime, estado2 varchar(50),
                               cedulaCli2 varchar(30), cedulaEmp2 varchar(30), 
										 ConDelivery2 bool, idSuc2 varchar(30), 
										 OUT result int,  OUT increment int)
begin
	declare exit handler for SqlException
    begin
		SET result = -1;
		rollback;
    end;
   
   start transaction;
	   INSERT INTO `lavadero_01`.`Solicitudes` (`fechaIngreso`, `Observaciones`, fechaEntrega, estado, cedulaCli, CedulaEmp, ConDelivery, idSuc) 
			VALUES (fechaIngreso2, Observaciones2, fechaEntrega2, estado2,cedulaCli2, cedulaEmp2, ConDelivery2, idSuc2);
   	SET result = 1;
   	set increment = @@IDENTITY;
   commit;
end//	


create procedure AltaRelacion_solicitudesopciones(IdSol2 int, IdOpcion2 int, OUT result int)
begin
   declare exit handler for sqlexception
   begin 
      set result = -1;
      rollback;
   end;
	set result=0;
   
   if(exists(
		select IdSol, IdOpcion  
		from Relacion_solicitudesopciones 
		where IdSol = IdSol2
			and IdOpcion = IdOpcion2)) then set result=-2;
   end if;
   
   if(result = 0) then
      insert into Relacion_solicitudesopciones(IdSol,IdOpcion)
			values(IdSol2,IdOpcion2);
		set result=1;
	end if;
end//	


create procedure BajaRelacion_solicitudesopciones(IdSol2 int, IdOpcion2 int,OUT result int)
begin
   declare exit handler for SqlException
   begin
      set result = -1;
      rollback;
   end;
   
   delete from Relacion_solicitudesopciones where IdSol = IdSol2 and IdOpcion = IdOpcion2;
   set result = 1;
end//	

create procedure AltaRelacion_solicitudesbrechas(IdSol2 int, HoraInicio2 time, HoraFin2 time,OUT result int)
begin
   declare exit handler for sqlexception
   begin 
      set result = -1;
      rollback;
   end;
	set result=0;
   
   if(exists(
		select IdSol, HoraInicio,HoraFin 
		from  Relacion_solicitudesbrechas 
		where IdSol = IdSol2
			and HoraInicio = HoraInicio2
			and HoraFin = HoraFin2)) then set result=-2;
   end if;
   
   if(result = 0) then
      insert into Relacion_solicitudesbrechas(IdSol,HoraInicio,HoraFin)
			values(IdSol2,HoraInicio2,HoraFin2);
		set result=1;
	end if;
end//	

create procedure BajaRelacion_solicitudbrechas(IdSol2 int, HoraInicio2 time, HoraFin2 time, OUT result int)
begin
   declare exit handler for SqlException
   begin
      set result = -1;
      rollback;
   end;
   
   delete from Relacion_solicitudbrechas where IdSol = IdSol2 and HoraInicio = HoraInicio2 and HoraFin = HoraFin2;
   set result = 1;
end//	


create procedure ModificarSolicitud(id2 int, fechaIngreso2 datetime, 
												Observaciones2 varchar(180), fechaEntrega2 datetime, 
												estado2 varchar(50), cedulaCli2 varchar(30), 
												CedulaEmp2 varchar(30), ConDelivery2 bit, 
												NomSucursal2 varchar(30), OUT result int)
begin
   declare exit handler for sqlexception
   begin
     set result=-1;
	  rollback;
	end;
	set result=0;
	
	if not(exists(select id from solicitudes where id = id2))then set result=-2;
	end if;
	
	if(result=0) then
	   start transaction;
		   update solicitudes set fechaIngreso = fechaIngreso2, 
			                       Observaciones = Observaciones2, 
										  fechaEntrega = fechaEntrega2,
										  estado = estado2,
										  cedulaCli = cedulaCli2,
										  cedulaEmp = CedulaEmp2,
										  ConDelivery = ConDelivery2,
										  NomSucursal = NomSucursal2
										  where id=id2;
		set result=1;	
		commit;
	end if;
end// 

CREATE PROCEDURE BajaSolicitud(id2 int, OUT result int)
begin
   declare exit handler for SqlException
   begin
      set result = -1;
      rollback;
   end;
   
   start transaction;
   delete from solicitudes where id = id2;
   set result = 1;
	commit;   
end//	

/*-- -- -- -- -- -- -- -- -- -- CambioPassPedido  -- -- -- -- -- -- -- -- -- -- */
/*-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- */
	
create procedure ActualizarCambioPassPedido(cedula2 varchar(30), fecha2 datetime, OUT result int)
begin
   declare exit handler for sqlexception
   begin
     set result=-1;
	  rollback;
	end;
	set result=0;
	
	if not(exists(select cedula from personas where cedula = cedula2))then set result=-2;
	end if;
	
	if(result=0)then
	   start transaction;
      update personas set FechaOlvidoPass = fecha2 where cedula=cedula2;
		set result=1;	
		commit;
	end if;
end//	

create procedure ListarCambioPassPedido()
begin
  select * from personas where FechaOlvidoPass IS NOT NULL
  order by personas.FechaOlvidoPass desc;
end//

create procedure RestablecerPass(cedula2 varchar(30), OUT result int)
begin
   declare exit handler for sqlexception
   begin
     set result=-1;
	  rollback;
	end;
	set result=0;
	
	if not(exists(select cedula from personas where cedula = cedula2))then set result=-2;
	end if;
	
	if(result=0)then
	   start transaction;
	   update personas set 
			Passw = "usuario1",
			FechaOlvidoPass = NULL
		where cedula=cedula2;
		set result=1;	
		commit;
	end if;
end//	
      
create procedure CambioPass(cedula2 varchar(30), passw2 varchar(30), OUT result int)
begin
   declare exit handler for sqlexception
   begin
     set result=-1;
	  rollback;
	end;
	set result=0;
	
	if not(exists(select cedula from personas where cedula = cedula2))then set result=-2;
	end if;
	
	if(result=0)then
	   start transaction;
		update personas set Passw = md5(Passw2) where cedula = cedula2;
		set result=1;
		commit;
	end if;
end//	
  
create procedure LogueoUsuario (cedula2 varchar(30), passw2 varchar(30))
begin
	select * 
	from personas
   where Cedula = cedula2 and Passw = md5(passw2);
end//

/*-- -- -- -- -- -- -- -- -- -- MOVIMIENTOS -- -- -- -- -- -- -- -- -- -- */
/*-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- */

create procedure AltaMovimiento (fechaMov2 datetime, nombreMov2 varchar(30), 
											tipoMov2 int, descripcion2 varchar(30), 
											monto2 decimal(10,2), idSuc2 int, OUT result int) begin
	declare exit handler for SqlException
	begin
		SET result = -1;
		rollback;
	end;
	   
	start transaction;
	INSERT INTO movimientos (`FechaMov`, `NombreMov`, `TipoMov`, `Monto`, `Descripcion`, `IdSuc`) 
		VALUES (fechaMov2, nombreMov2, tipoMov2, monto2, descripcion2, idSuc2);
	SET result = 1;
	commit;
end//

create procedure BajaMovimiento (idMov2 int, OUT result int) begin
	declare exit handler for SqlException
	begin
		SET result = -1;
		rollback;
	end;
	
	start transaction;
	DELETE FROM movimientos WHERE `IdMov` = idMov2;
	SET result = 1;
	commit;
end//

create procedure ModificarMovimiento(idMov2 int, fechaMov2 datetime, 
											nombreMov2 varchar(30), tipoMov2 int, 
											descripcion2 varchar(30), monto2 decimal(10,2), 
											OUT result int) begin
	declare exit handler for SqlException
	begin
		SET result = -1;
		rollback;
	end;

	SET result = 0;
	
	if not(exists(select `IdMov` from movimientos where `IdMov` = idMov2)) then SET result = -2;
	end if;

	if(result = 0) then
		start transaction;
     	update movimientos 
		set FechaMov 	= fechaMov2,
			NombreMov 	= nombreMov2,
			TipoMov 		= tipoMov2, 
			Descripcion = descripcion2, 
			Monto 		= monto2
		where IdMov = idMov2;
		commit;
		SET result = 1;
	end if;
end//

Create Procedure BuscarMovimiento(idMov2 int)
begin
	SELECT m.*, s.NombreSuc, s.Telefono as 'SucTelefono'
	FROM movimientos m
	INNER JOIN sucursales s ON s.IdSuc = m.IdSuc
	where `IdMov` = idMov2;
end//

create procedure ListarMovimientosPorSucursal(tipoMov2 int, idSuc2 int) begin
	SELECT m.*
	FROM movimientos m
	where m.TipoMov = tipoMov2 AND (idSuc2 IS NOT NULL AND m.IdSuc = idSuc2);
end//

create procedure ListarMovimientosPorSucYFecha(tipoMov2 int, idSuc2 int, desde date, hasta date) begin
	SELECT m.*
	FROM movimientos m
	where m.TipoMov = tipoMov2 
		AND (idSuc2 IS NOT NULL AND m.IdSuc = idSuc2)
		AND (m.FechaMov >= desde AND m.FechaMov <= hasta);
end//

/*-- -- -- -- -- -- -- -- -- -- TINTORERIAS -- -- -- -- -- -- -- -- -- -- */
/*-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- */

create procedure AltaTintoreria(Nombre2 varchar(30), Telefono2 varchar(30), OUT result int, OUT increment int) begin
	declare exit handler for SqlException
	begin
		SET result = -1;
		rollback;
	end;
	
	INSERT INTO tintorerias (`Nombre`, `Telefono`) VALUES (Nombre2, Telefono2);
	SET result = 1;
	set increment = @@IDENTITY;
	commit;
end// 

create procedure BajaTintoreria(idTint2 int, OUT result int) begin
	declare exit handler for SqlException
	begin
		SET result = -1;
		rollback;
	end;
	
	DELETE FROM tintorerias WHERE `IdTint` = idTint2;
	commit;
	SET result = 1;
end//

create procedure ModificarTintoreria(idTint2 int, Nombre2 varchar(30), 
												 Telefono2 varchar(30), OUT result int) begin
	declare exit handler for SqlException
	begin
		SET result = -1;
		rollback;
	end;
	
	update tintorerias
	set 
		`Nombre` = Nombre2,
   	`Telefono` = Telefono2
	where `IdTint` = idTint2;
	SET result = 1;
end//

/*Create Procedure BuscarTintoreria(Nombre2 varchar(30), OUT result int)
begin
   declare exit handler for SqlException
   begin
     set result = -1;
     rollback;
   end;
      set @var := 0;
      set @var:= (select IdTint from tintorerias where tintorerias.Nombre = Nombre2);
	   if(exists(select IdTint from relacion_tintoreriassucursales where IdTint = @var))then
			SELECT tintorerias.*, Ubicaciones.*, sucursales.IdSuc, sucursales.NombreSuc
			from tintorerias
			inner join relacion_ubictintorerias on relacion_ubictintorerias.IdTint = tintorerias.IdTint
			inner join ubicaciones on relacion_ubictintorerias.idubic = ubicaciones.Id
			inner join relacion_tintoreriassucursales on relacion_tintoreriassucursales.IdTint = tintorerias.IdTint	
			inner join sucursales on relacion_tintoreriassucursales.IdSuc = sucursales.IdSuc
			where tintorerias.Nombre = Nombre2;
			commit;
			set result = 1;
		end if;
		if not(exists(select IdTint from relacion_tintoreriassucursales where IdTint = @var))then
		   SELECT tintorerias.*, Ubicaciones.*
			from tintorerias
			inner join relacion_ubictintorerias on relacion_ubictintorerias.IdTint = tintorerias.IdTint
			inner join ubicaciones on relacion_ubictintorerias.idubic = ubicaciones.id
			where tintorerias.Nombre = Nombre2;
			commit;
		set result = 2;
		end if;
end//*/

/*--PRUEBA: ----------------------------------------------------------------------------------------------------------------*/
Create Procedure BuscarTintoreria2(Nombre2 varchar(30), OUT result int)
begin
   declare exit handler for SqlException
   begin
     set result = -1;
     rollback;
   end;
	   SELECT tintorerias.*, Ubicaciones.*
		from tintorerias
		inner join relacion_ubictintorerias on relacion_ubictintorerias.IdTint = tintorerias.IdTint
		inner join ubicaciones on relacion_ubictintorerias.idubic = ubicaciones.id
		where tintorerias.Nombre = Nombre2;
		commit;
		set result = 1;
end//

create procedure ListarTintorerias() 
begin
   SELECT tintorerias.*, sucursales.IdSuc, sucursales.NombreSuc, Ubicaciones.*
	from tintorerias
	inner join relacion_ubictintorerias on relacion_ubictintorerias.IdTint = tintorerias.IdTint
	inner join ubicaciones on relacion_ubictintorerias.idubic = ubicaciones.id
	inner join relacion_tintoreriassucursales on relacion_tintoreriassucursales.IdTint = tintorerias.IdTint	
	inner join sucursales on relacion_tintoreriassucursales.IdSuc = sucursales.IdSuc;
end//
   
CREATE PROCEDURE Altarelacion_tintoreriassucursales (idTint2 int, idSuc2 int, out result int)
begin
   declare exit handler for sqlexception
   begin 
      set result = -1;
      rollback;
   end;
	set result=0;
   
   if(exists(
		select IdTint, IdSuc  
		from relacion_tintoreriassucursales 
		where IdTint = idTint2
			and IdSuc = idSuc2)) then set result=-2;
   end if;
   
   if(result = 0) then
      insert into relacion_tintoreriassucursales(IdTint,IdSuc)
			values(idTint2,idSuc2);
		set result=1;
	end if;
end//	

CREATE PROCEDURE Bajarelacion_tintoreriassucursales(idTint2 int, idSuc2 int, OUT result int)
begin
   declare exit handler for SqlException
   begin
      set result = -1;
      rollback;
   end;
   
   delete from relacion_tintoreriassucursales where IdTint = idTint2 and IdSuc = idSuc2;
   set result = 1;
end//	

CREATE PROCEDURE Altarelacion_ubictintorerias (idubic2 int, idTint2 int, out result int)
begin
   declare exit handler for sqlexception
   begin 
      set result = -1;
      rollback;
   end;
	set result=0;
   
   if(exists(select idubic, IdTint from relacion_ubictintorerias where IdUbic = idubic2 and IdTint = idTint2))then set result = -2;
   end if;
   
   if(result = 0) then
		insert into relacion_ubictintorerias(idubic, IdTint) values (idubic2, idTint2);
		set result=1;
	end if;
end//	

CREATE PROCEDURE Bajarelacion_ubictintorerias(idubic2 int, idTint2 int, OUT result int)
begin
   declare exit handler for SqlException
   begin
      set result = -1;
      rollback;
   end;
   
   delete from relacion_ubictintorerias where IdUbic = idubic2 and IdTint = idTint2;
   set result = 1;
end//	

CREATE PROCEDURE AltaRelacion_ubicsucursales (idubic2 int, idSuc2 int, out result int)
begin
   declare exit handler for sqlexception
   begin 
      set result = -1;
      rollback;
   end;
	set result=0;
   
   if(exists(select idubic, idSuc from relacion_ubicsucursales where idubic=idubic2 and IdSuc = idSuc2))then set result=-2;
   end if;
   
   if(result = 0) then
		insert into relacion_ubicsucursales(idubic,IdSuc) values (idubic2,idSuc2);
		set result=1;
	end if;
end//	

CREATE PROCEDURE BajaRelacion_ubicsucursales(idubic2 int, idSuc2 int, OUT result int)
begin
   declare exit handler for SqlException
   begin
      set result = -1;
      rollback;
   end;
   
   delete from Relacion_ubicsucursales where idubic = idubic2 and IdSuc = idSuc2;
   set result = 1;
end//	
    
CREATE PROCEDURE ListarRelacion_ubicsucursales()
begin
   select * from Relacion_ubicsucursales;
end//


CREATE PROCEDURE Altarelacion_ubicpersona (CedPersona2 varchar(30), idubic2 int, out result int)
begin
   declare exit handler for sqlexception
   begin 
      set result = -1;
      rollback;
   end;
	set result=0;
   
   if(exists(select CedPersona, idubic from relacion_ubicpersona where CedPersona = CedPersona2 and idubic = idubic2))then set result=-2;
   end if;
   
   if(result = 0) then
		insert into relacion_ubicpersona(CedPersona,idubic)values(CedPersona2,idubic2);
		set result=1;
	end if;
end//	


CREATE PROCEDURE Bajarelacion_ubicpersona(CedPersona2 varchar(30), idubic2 int, OUT result int)
begin
   declare exit handler for SqlException
   begin
      set result = -1;
      rollback;
   end;
   
   delete from relacion_ubicpersona where CedPersona = CedPersona2 and idubic = idubic2;
   set result = 1;
end//	
    
CREATE PROCEDURE Listarrelacion_ubicpersona()
begin
   select relacion_ubicpersona.*
   from relacion_ubicpersona;
end//

/*-- -- -- -- -- -- -- -- -- --  PRENDAS ENVIO -- -- -- -- -- -- -- -- -- */
/*-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- */
CREATE PROCEDURE AltaPrendaEnvio(IdPda2 int, IdTint2 int, Precio2 decimal(10,2), OUT result int)
begin
   declare exit handler for sqlexception
   begin 
      set result = -1;
      rollback;
   end;
	set result=0;
   
   if(exists(select id from relacion_prendaenvio where IdPda=IdPda2 and IdTint=IdTint2 ))then set result=-2;
   end if;
   
   if(result = 0) then
	start transaction;
	insert into relacion_prendaenvio(IdPda,IdTint,Precio)values(IdPda2,IdTint2,Precio2);
	set result=1;	
	commit;
	end if; 
end// 

CREATE PROCEDURE ModificarPrendaEnvio(Id2 int, IdPda2 int, IdTint2 int, Precio2 decimal(10,2), OUT result int)
begin
   declare exit handler for sqlexception
   begin
     set result=-1;
	  rollback;
	end;
	set result = 0;
	
	if not(exists(select Id from relacion_prendaenvio where Id = Id2))then set result=-2;
	end if;
	
	if(result=0)then
	   start transaction;
		   update relacion_prendaenvio set IdPda = IdPda2, IdTint = IdTint, Precio = Precio2 where Id = Id2;

	set result=1;	
	commit;
	end if;
end// 

CREATE PROCEDURE BajaPrendaEnvio(Id2 int, OUT result int)
begin
   declare exit handler for SqlException
   begin
      set result = -1;
      rollback;
   end;
	set result = 0;
	
	if(result = 0)then
	   delete from relacion_prendaenvio where Id = Id2;
	   set result = 1;
	   commit;
	end if;  
end//	

CREATE PROCEDURE ListarPrendaEnvio()
begin
   select relacion_prendaenvio.*, prendas.Tipo
   from relacion_prendaenvio inner join prendas
   on relacion_prendaenvio.IdPda = prendas.IdPda
	where relacion_prendaenvio.IdPda = prendas.IdPda;
end//

CREATE PROCEDURE ListarPrendasEnvioXIdPren(idpren int)
begin
   select relacion_prendaenvio.*, prendas.Tipo, tintorerias.Nombre
   from relacion_prendaenvio 
	inner join prendas on prendas.IdPda = relacion_prendaenvio.IdPda
   inner join tintorerias on tintorerias.IdTint = relacion_prendaenvio.IdTint
	where relacion_prendaenvio.IdPda = idpren;
end//

/*-- -- -- -- -- -- -- -- -- --  PRENDAS -- -- -- -- -- -- -- -- -- -- -- */
/*-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- */

CREATE PROCEDURE BuscarPrenda(tipo2 varchar(30))
begin
   select Prendas.*
   from Prendas
   where prendas.Tipo = tipo2;
end//

CREATE PROCEDURE AltaPrenda(tipo2 varchar(30), aplicaTint2 bit(1), out result int)
begin
   declare exit handler for sqlexception
   begin 
      set result = -1;
      rollback;
   end;
	set result=0;
   
   if(exists(select tipo from prendas where tipo=tipo2))then set result=-2;
   end if;
   
   if(result = 0) then
	start transaction;
	insert into prendas(tipo,AplicaTint)values(tipo2,aplicaTint2);
	set result=1;	
	commit;
	end if;					           
end// 

CREATE PROCEDURE ModificarPrenda(IdPda2 int, tipo2 varchar(30), aplicaTint2 bit(1), OUT result int)
begin
   declare exit handler for sqlexception
   begin
     set result=-1;
	  rollback;
	end;
	set result = 0;
	
	if not(exists(select IdPda from prendas where IdPda = IdPda2))then set result=-2;
	end if;
	
	if(result=0)then
	   start transaction;
		   update prendas set Tipo = tipo2, AplicaTint = aplicaTint2 where IdPda = IdPda2;

	set result=1;	
	commit;
	end if;
end// 

CREATE PROCEDURE BajaPrenda(IdPda2 int, OUT result int)
begin
   declare exit handler for SqlException
   begin
      set result = -1;
      rollback;
   end;
	set result = 0;
	
	if(result = 0)then
	   delete from prendas where IdPda = IdPda2;
	   set result = 1;
	   commit;
	end if;  
end//	

CREATE PROCEDURE ListarPrendas(aplicaTint bool)
begin
   select prendas.*
   from prendas
   where prendas.AplicaTint = aplicaTint;
end//

/*-- -- -- -- -- -- -- -- -- --  UBICACION  -- -- -- -- -- -- -- -- -- -- */
/*-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- */


CREATE PROCEDURE BuscarUbicacion(Direccion2 varchar(30))
begin
   select ubicaciones.*
   from ubicaciones
   where ubicaciones.Direccion = Direccion2;
end//


CREATE PROCEDURE AltaUbicacion(Direccion2 varchar(100), barrio2 varchar(30), ciudad2 varchar(30), out result int, out increment int)
begin
   declare exit handler for sqlexception
   begin 
      set result = -1;
      rollback;
   end;
	set result=0;
   
   if(exists(select Id from ubicaciones where (Direccion = Direccion2 and Barrio = barrio2 and Ciudad = ciudad2) ))then set result=-2;
   end if;
   
   if(result = 0) then
	insert into ubicaciones(direccion,barrio, ciudad) values (direccion2,barrio2,ciudad2);
	set result=1;
	set increment = @@IDENTITY;	
   end if;
end// 

CREATE PROCEDURE ModificarUbicacion(id2 int, Direccion2 varchar(100), barrio2 varchar(30), ciudad2 varchar(30), OUT result int)
begin
   declare exit handler for sqlexception
   begin
     set result=-1;
	  rollback;
	end;
	set result=0;
	
	if not(exists(select id from ubicaciones where id = id2))then set result=-2;
	end if;
	
	if(result=0)then
	   start transaction;
		   update ubicaciones set direccion = Direccion2, barrio = barrio2, ciudad = ciudad2 where id=id2;
	set result=1;	
	commit;
	end if;
end// 

CREATE PROCEDURE BajaUbicacion(id2 int, OUT result int)
begin
   declare exit handler for SqlException
   begin
      set result = -1;
      rollback;
   end;
	   delete from ubicaciones where id = id2;
	   commit;
	   set result = 1;
end//	
  
CREATE PROCEDURE ListarUbicaciones()
begin
   select ubicaciones.*
   from ubicaciones;
end//

/*-- -- -- -- -- -- -- -- -- --   SUCURSAL  -- -- -- -- -- -- -- -- -- -- */
/*-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- */

Create PROCEDURE BuscarSucursal(nombresuc2 varchar(30))
begin
select sucursales.*, ubicaciones.Id as 'IdUbic', ubicaciones.Direccion, ubicaciones.Ciudad, ubicaciones.Barrio
   from sucursales
	inner join relacion_ubicsucursales on relacion_ubicsucursales.IdSuc = sucursales.IdSuc
	inner join ubicaciones on relacion_ubicsucursales.idubic = ubicaciones.id
	/*left outer join empleados on sucursales.CedEmpleado = empleados.Cedula
	left outer join personas on empleados.Cedula = personas.Cedula*/
   where sucursales.NombreSuc = nombresuc2;
end//

CREATE PROCEDURE AltaSucursal(nombresuc2 varchar(30), telefono2 varchar(30), out result int, out increment int)
begin
   declare exit handler for sqlexception
   begin 
      set result = -1;
      rollback;
   end;
	set result=0;
   
   if(exists(select nombresuc from sucursales where nombresuc=nombresuc2))then set result=-2;
   end if;
   
   if(result = 0) then
	   start transaction; 
		insert into Sucursales(NombreSuc,telefono) values (nombresuc2,telefono2);
		set result=1;
	   set increment = @@IDENTITY;
		commit;
	end if;						           
end// 


CREATE PROCEDURE ModificarSucursal(IdSuc2 int, nombresuc2 varchar(30), telefono2 varchar(30), OUT result int)
begin
   declare exit handler for sqlexception
   begin
     set result=-1;
	  rollback;
	end;
	set result=0;
	
	if not(exists(select IdSuc from sucursales where IdSuc = IdSuc2))then set result=-2;
	end if;
	
	if(result=0)then
	   start transaction;
		   update sucursales set NombreSuc = nombresuc2, telefono = telefono2 where IdSuc=IdSuc2;

	set result=1;	
	commit;
	end if;
end// 

CREATE PROCEDURE BajaSucursal(IdSuc2 int, OUT result int)
begin
   declare exit handler for SqlException
   begin
      set result = -1;
      rollback;
   end;
      if (EXISTS(
			select relacion_tintoreriassucursales.IdSuc 
			from relacion_tintoreriassucursales 
			WHERE relacion_tintoreriassucursales.IdSuc = IdSuc2)) then 
				DELETE from relacion_tintoreriassucursales 
	     		where relacion_tintoreriassucursales.IdSuc = IdSuc2;
	   end if;
	   DELETE from sucursales where IdSuc = IdSuc2;
	   set result = 1;
	   commit;	     
end//	
  
CREATE PROCEDURE ListarSucursales()
begin
   select sucursales.*, ubicaciones.Id as 'IdUbic', ubicaciones.Direccion, ubicaciones.Ciudad, ubicaciones.Barrio
   from sucursales
   inner join relacion_ubicsucursales on relacion_ubicsucursales.IdSuc = sucursales.IdSuc
	inner join ubicaciones on relacion_ubicsucursales.idubic = ubicaciones.id;
end//

CREATE PROCEDURE ListarSucursalesPorTint(IdTint2 int)
begin
   select a.*, c.Id as 'IdUbic', c.Direccion, c.Ciudad, c.Barrio
   from sucursales a
   inner join relacion_ubicsucursales b on b.IdSuc = a.IdSuc
	inner join ubicaciones c on b.idubic = c.id
	inner join relacion_tintoreriassucursales d on d.IdSuc = a.IdSuc
	where d.IdTint = IdTint2;
end//

/*-- -- -- -- -- -- -- -- EMPLEADOS Y CLIENTES -- -- -- -- -- -- -- -- -- */
/*-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- */

CREATE PROCEDURE BuscarEmpleado(cedula2 varchar(30))
begin
   select personas.*, empleados.Sueldo, empleados.FechaIngreso, empleados.tipoempleado, ubicaciones.Id as 'IdUbic', 
			 ubicaciones.Direccion, ubicaciones.Ciudad, ubicaciones.Barrio, empleados.IdSuc, sucursales.NombreSuc
	from empleados
   inner join personas on empleados.Cedula = personas.Cedula
	inner join sucursales on empleados.IdSuc = sucursales.IdSuc  
	inner join relacion_ubicpersona on relacion_ubicpersona.CedPersona = personas.Cedula
	inner join Ubicaciones on relacion_ubicpersona.idubic = ubicaciones.id
	where empleados.Cedula=cedula2;
end//

CREATE PROCEDURE Buscarcliente(cedula2 varchar(30))
begin
   select personas.*, clientes.FechaReg, ubicaciones.Id as 'IdUbic', 
			 ubicaciones.Direccion, ubicaciones.Ciudad, ubicaciones.Barrio
   from clientes 
	inner join personas on clientes.Cedula = personas.Cedula  
	inner join relacion_ubicpersona on relacion_ubicpersona.CedPersona = personas.Cedula
	inner join Ubicaciones on relacion_ubicpersona.idubic = ubicaciones.id
   where clientes.Cedula=cedula2;
end//

CREATE PROCEDURE AltaEmpleado(cedula2 varchar(30), passw2 varchar(40), 
                               nombre2 varchar(100), telefono2 varchar(40), celular2 varchar(30),
										 sueldo2 decimal(10,2), fechaingreso2 date, tipoempleado2 varchar(30),IdSuc2 int(11),
										 
										 OUT result int)   
begin
   declare exit handler for sqlexception    
   begin
      set result = -1;
      rollback;
   end;
   set result=0;
   
   if(exists(select personas.Cedula from personas where cedula=cedula2))then set result=-2;
   end if;
   
   if(result = 0) then
      start transaction;
        if(passw2 = 'usuario1')then        
          insert into personas(Cedula,passw,nombre,telefono,celular)values(cedula2,passw2,nombre2,telefono2,celular2);
        end if;
        if(passw2 != 'usuario1')then        
          insert into personas(Cedula,passw,nombre,telefono,celular)values(cedula2,md5(passw2),nombre2,telefono2,celular2);
        end if;
          
        insert into empleados(cedula,sueldo,fechaingreso,tipoempleado,IdSuc) 
		               values(cedula2,sueldo2,fechaingreso2,tipoempleado2,IdSuc2);
			set result=1;
		commit;
	end if;						           
end//

CREATE PROCEDURE AltaCliente(cedula2 varchar(30), passw2 varchar(40), 
                             nombre2 varchar(100), telefono2 varchar(40), celular2 varchar(30), 
									  fechaReg2 datetime, OUT result int)   
begin
   declare exit handler for sqlexception    
   begin
      set result = -1;
      rollback;
   end;
   set result=0;
   
   if(exists(select personas.Cedula from personas where cedula=cedula2))then set result=-2;
   end if;
    
   if(result=0)then
      start transaction;

        if(passw2 = 'usuario1')then        
          insert into personas(Cedula,passw,nombre,telefono,celular)values(cedula2,passw2,nombre2,telefono2,celular2);
        end if;
        if(passw2 != 'usuario1')then        
          insert into personas(Cedula,passw,nombre,telefono,celular)values(cedula2,md5(passw2),nombre2,telefono2,celular2);
        end if;
        insert into clientes(cedula, FechaReg) 
		               values(cedula2, fechaReg2); 
			set result=1;
		commit;
	end if;						           
end//


CREATE PROCEDURE ModificarEmpleado(cedula2 varchar(30), passw2 varchar(40), 
                                   nombre2 varchar(100), telefono2 varchar(40), celular2 varchar(30),
										     sueldo2 decimal(10,2), fechaingreso2 date, tipoempleado2 varchar(30),IdSuc2 int(11),
										     OUT result int)
begin
   declare exit handler for sqlexception
   begin
     set result=-1;
	  rollback;
	end;
	set result=0;
	
   if not(exists(select personas.Cedula from personas where cedula=cedula2))then set result=-2;
   end if;
	
	if(result=0)then
	   start transaction;
		   update personas set passw=passw2,
		                       nombre=nombre2,
		                       telefono=telefono2,
		                       celular=celular2 where cedula=cedula2;
		    update empleados set sueldo=sueldo2,
			                      fechaingreso=fechaingreso2,
										 tipoempleado=tipoempleado2, 
										 IdSuc=IdSuc2 where cedula=cedula2;
	set result=1;	
	commit;
	end if;
end//	

CREATE PROCEDURE ModificarCliente (cedula2 varchar(30), passw2 varchar(40), 
                                   nombre2 varchar(100), telefono2 varchar(40), celular2 varchar(30),OUT result int)
begin
   declare exit handler for sqlexception
   begin
     set result=-1;
	  rollback;
	end;
	set result=0;
	
   if not(exists(select personas.Cedula from personas where cedula=cedula2))then set result=-2;
   end if;
	
	if(result=0)then
	   start transaction;
		   update personas set passw=passw2,
		                       nombre=nombre2,
		                       telefono=telefono2,
		                       celular=celular2 where cedula=cedula2;
	set result=1;	
	commit;
	end if;
end//

CREATE PROCEDURE BajaPersona(cedula2 varchar(30), tipo varchar(1), OUT result int)
begin
   declare exit handler for SqlException
   begin
      set result = -1;
      rollback;
   end;
	set result = 0;
	start transaction;
	if(tipo = 'c') then
	   delete from clientes where cedula = cedula2;
   end if;
	if(tipo = 'e')then
     if (EXISTS(select relacion_empleadosucursales.CedEmpleado from relacion_empleadosucursales WHERE 
	    relacion_empleadosucursales.CedEmpleado = cedula2)) then DELETE from relacion_empleadosucursales 
	    where relacion_empleadosucursales.CedEmpleado = cedula2;
	  end if;
	delete from empleados where cedula = cedula2;	   
	end if;
	delete from personas where cedula = cedula2;
	
	set result = 1;
	commit;
end//

CREATE PROCEDURE ListarclientesXFechaReg()
begin
   select personas.*,clientes.*, ubicaciones.Direccion
	from clientes
   inner join personas on clientes.Cedula = personas.Cedula  
	inner join relacion_ubicpersona on relacion_ubicpersona.CedPersona = personas.Cedula
	inner join Ubicaciones on relacion_ubicpersona.idubic = ubicaciones.id
	order by clientes.FechaReg desc;
end//

CREATE PROCEDURE ListarclientesXFechaUltimaEntrada()
begin
   select personas.*,clientes.*, ubicaciones.Direccion
	from clientes
   inner join personas on clientes.Cedula = personas.Cedula  
	inner join relacion_ubicpersona on relacion_ubicpersona.CedPersona = personas.Cedula
	inner join Ubicaciones on relacion_ubicpersona.idubic = ubicaciones.id
	order by clientes.FechaUltimaEntrada desc;
end//

CREATE PROCEDURE IngresoSistemaCli(cedula2 varchar(30), FechaUltimaEntrada2 date, OUT result int)
begin
   declare exit handler for sqlexception
   begin
     set result=-1;
	  rollback;
	end;
	set result=0;
	
   if not(exists(select personas.Cedula from personas where cedula=cedula2))then set result=-2;
   end if;
	
	if(result=0)then
	   start transaction;
		   update clientes set FechaUltimaEntrada=FechaUltimaEntrada2
			                    where cedula=cedula2;
	set result=1;	
	commit;
	end if;
end//

CREATE PROCEDURE Listarempleados()
begin
   select personas.*, empleados.Sueldo, empleados.FechaIngreso, empleados.TipoEmpleado, ubicaciones.Direccion, sucursales.NombreSuc
	from empleados
   inner join personas on empleados.Cedula = personas.Cedula  
	inner join relacion_ubicpersona on relacion_ubicpersona.CedPersona = personas.Cedula
	inner join Ubicaciones on relacion_ubicpersona.idubic = ubicaciones.id
	inner join sucursales on empleados.IdSuc = sucursales.IdSuc;
end//

CREATE PROCEDURE ListarTipoempleados(tipoempleado2 varchar(30))
begin 
   select personas.*, empleados.sueldo, empleados.FechaIngreso, empleados.TipoEmpleado
	from empleados inner join personas
	on empleados.Cedula = personas.Cedula
	where empleados.TipoEmpleado = tipoempleado2;
end//

CREATE PROCEDURE ListarempleadosConSucursal()
begin
   select personas.*, empleados.Sueldo, empleados.FechaIngreso, empleados.TipoEmpleado
	from empleados
   inner join personas on empleados.Cedula = personas.Cedula
	inner join relacion_empleadosucursales on relacion_empleadosucursales.CedEmpleado = personas.Cedula
	inner join sucursales on relacion_empleadosucursales.NomSucursal = sucursales.NombreSuc
	where personas.Cedula = relacion_empleadosucursales.CedEmpleado;
end//

/*-- -- -- -- -- -- -- --  BRECHAS HORARIAS -- -- -- -- -- -- -- -- -- -- */
/*-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- */

CREATE PROCEDURE AltaBrechaHoraria(HoraInicio2 time, HoraFin2 time, DiasVigencia2 varchar(55), LimiteSol2 int(11), NoDisponible2 bit , out result int)
begin
   declare exit handler for sqlexception
   begin 
      set result = -1;
      rollback;
   end;
	set result=0;
      
   if exists(select * from brechasHorarias where HoraInicio = HoraInicio2 and HoraFin = HoraFin2) then set result=-2;
	end if;
      
   if(result = 0) then
      start transaction;
        insert into brechasHorarias(HoraInicio, HoraFin, DiasVigencia, LimiteSol, NoDisponible)
		  		values(HoraInicio2,HoraFin2, DiasVigencia2, LimiteSol2, NoDisponible2);
			set result=1;
		commit;
	end if;
end// 

CREATE PROCEDURE ModificarBrechaHoraria(HoraInicio2 time, HoraFin2 time, DiasVigencia2 varchar(55), NewHoraInicio2 time, NewHoraFin2 time, 
LimiteSol2 int(11), NoDisponible2 bit, out result int)
begin
   declare exit handler for sqlexception
   begin
     set result=-1;
	  rollback;
	end;
	set result=0;
	
   if exists(select * from brechasHorarias where HoraInicio = NewHoraInicio2 and HoraFin = NewHoraFin2) then set result=-2;
	end if;
	
	if(result=0)then
	   start transaction;
		   update brechasHorarias set 
										HoraInicio 		= NewHoraInicio2,
										HoraFin 			= NewHoraFin2,
										DiasVigencia   = DiasVigencia2,
										LimiteSol 		= LimiteSol2,
										NoDisponible 	= NoDisponible2
			 where HoraInicio = HoraInicio2 
			 and HoraFin = HoraFin2;
		set result=1;	
	commit;
	end if;
end// 

CREATE PROCEDURE BajaBrechaHoraria(HoraInicio2 time, HoraFin2 time, OUT result int)
begin
   declare exit handler for SqlException
   begin
      set result = -1;
      rollback;
   end;
	set result = 0;
	
	if(result = 0)then
	   delete from brechasHorarias where HoraInicio = HoraInicio2 
			 and HoraFin = HoraFin2;
	   set result = 1;
	   commit;
	end if;  
end//	


CREATE PROCEDURE BuscarBrechaHoraria(HoraInicio2 time, HoraFin2 time)
begin
   select * from brechasHorarias where HoraInicio = HoraInicio2 
			 and HoraFin = HoraFin2;
end//

CREATE PROCEDURE ListarbrechasHorarias()
begin
   select * from brechasHorarias;
end//



/*-- -- -- -- -- -- -- -- -- -- OPCIONES -- -- -- -- -- -- -- -- -- -- -- */
/*-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- */
CREATE PROCEDURE AltaOpcion(Nombre2 varchar(50), Precio2 decimal(10,2), out result int)
begin
   declare exit handler for sqlexception
   begin 
      set result = -1;
      rollback;
   end;
	set result = 0;
      
   if exists(select * from opciones where NombreOpc = Nombre2) then set result=-2;
	end if;
      
   if(result = 0) then
		INSERT INTO opciones(NombreOpc, Precio) VALUES (Nombre2, Precio2); 
		SET result=1;
	END IF; END// 

CREATE PROCEDURE ModificarOpcion(IdOpc2 int, Nombre2 varchar(50), NewNombre2 varchar(50), Precio2 decimal(10,2), out result int)
begin
   declare exit handler for sqlexception
   begin
     set result=-1;
	  rollback;
	end;
	set result=0;
	
	/*Ya existe ese nombre de opcion. Si dejo esto nunca podre modificar el dato*/
   /*if exists(select * from opciones where NombreOpc = Nombre2) then set result=-2;
	end if;*/
	
	if(result=0)then
	   /*start transaction;*/
UPDATE opciones SET NombreOpc = NewNombre2, Precio = Precio2
WHERE IdOpc = IdOpc2 ; SET result=1;
		/*commit;*/ END IF; END//
		
CREATE PROCEDURE BajaOpcion(IdOpc2 INT, OUT result INT) BEGIN DECLARE EXIT HANDLER FOR SQLEXCEPTION BEGIN SET result = -1; ROLLBACK; END;
DELETE
FROM opciones
WHERE IdOpc = IdOpc2; SET result = 1; END//

CREATE PROCEDURE BuscarOpcion(IdOpc2 int) BEGIN
SELECT *
FROM opciones
WHERE IdOpc = IdOpc2; END//

CREATE PROCEDURE ListarOpciones() BEGIN
SELECT *
FROM opciones; END//


/*-- -- -- -- -- -- -- -- -- -- EXCEPCIONES -- -- -- -- -- -- -- -- -- -- */
/*-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- */

CREATE PROCEDURE AltaExcepcion(Nombre2 varchar(50), out result int)
begin
   declare exit handler for sqlexception
   begin 
      set result = -1;
      rollback;
   end;
	set result=0;
      
   if exists(select * from excepciones where Nombre = Nombre2) then set result=-2;
	end if;
      
   if(result = 0) then
      start transaction;
		insert into excepciones(Nombre) values(Nombre2);
		set result=1;
		commit;
	end if;		           
end// 

CREATE PROCEDURE ModificarExcepcion(Nombre2 varchar(50), NewNombre2 varchar(50), out result int)
begin
   declare exit handler for sqlexception
   begin
     set result=-1;
	  rollback;
	end;
	set result=0;
	
	/*Ya existe ese nombre de opcion. Si dejo esto nunca podre modificar el dato*/
   /*if exists(select * from excepciones where Nombre = NewNombre2) then set result=-2;
	end if;*/
	
	if(result=0)then
	   start transaction;
		   update excepciones set Nombre = NewNombre2 where Nombre = Nombre2;
		set result=1;	

	end if;
	
	commit;
end// 

CREATE PROCEDURE BajaExcepcion(Nombre2 varchar(50), out result int)
begin
   declare exit handler for SqlException
   begin
      set result = -1;
      rollback;
   end;
	set result = 0;
	
	if(result = 0)then
	   delete from excepciones where Nombre = Nombre2;
	   set result = 1;
	   commit;
	end if;  
end//	


CREATE PROCEDURE Buscarexcepciones(Nombre2 varchar(50))
begin
   select * from excepciones where Nombre = Nombre2;
end//

CREATE PROCEDURE Listarexcepciones()
begin
   select * from excepciones;
end//

/*-- -- -- -- -- -- -- -- -- -- INSERTS -- -- -- -- -- -- -- -- -- -- */
/*-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- */
/*PRENDA VACIA, DEJARLA ASI COMO ESTA*/
INSERT INTO prendas(Tipo,AplicaTint) VALUES ('',0); 
INSERT INTO prendas(Tipo, AplicaTint) values ('AcolchadoPlumas', 1);
INSERT INTO prendas(Tipo, AplicaTint) values ('AcolchadoWata', 1);
INSERT INTO prendas(Tipo, AplicaTint) values ('Frazada', 1);
INSERT INTO prendas(Tipo, AplicaTint) values ('Gabanes', 1);
INSERT INTO prendas(Tipo, AplicaTint) values ('Gabardinas', 1);
INSERT INTO prendas(Tipo, AplicaTint) values ('PantalonVestir', 1);
INSERT INTO prendas(Tipo, AplicaTint) values ('PantalonPana', 1);
INSERT INTO prendas(Tipo, AplicaTint) values ('Saco', 1);
INSERT INTO prendas(Tipo, AplicaTint) values ('Traje', 1);
INSERT INTO prendas(Tipo, AplicaTint) values ('Tapado', 1);


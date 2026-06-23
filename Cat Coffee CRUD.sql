CREATE DATABASE IF NOT EXISTS `gestion_de_campanas_mercadeo` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `gestion_de_campanas_mercadeo`;

DROP TABLE IF EXISTS `activos`;
CREATE TABLE `activos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `marca` varchar(45) DEFAULT NULL,
  `modelo` varchar(45) DEFAULT NULL,
  `ano_adquisicion` date NOT NULL,
  `valor_comercial` decimal(20,2) NOT NULL,
  `estado` enum('DISPONIBLE','RESERVADO','PRESTADO') NOT NULL DEFAULT 'DISPONIBLE',
  `CATEGORIAS_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ACTIVOS_CATEGORIAS_idx` (`CATEGORIAS_id`),
  CONSTRAINT `fk_ACTIVOS_CATEGORIAS` FOREIGN KEY (`CATEGORIAS_id`) REFERENCES `categorias` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

INSERT INTO `activos` VALUES (1,'Stand Expo 3000','Stand','ProStand','S-3000','2021-06-01',5000000.00,'DISPONIBLE',1),(2,'Display LED 55','Display','LedCorp','L55','2022-01-15',1200000.00,'DISPONIBLE',1),(3,'Banner Grande XL','Banner','PrintCo','B-XL','2020-03-20',200000.00,'DISPONIBLE',2),(4,'Pop-up Vertical','Pop-up','PrintCo','PU-1','2019-08-10',150000.00,'DISPONIBLE',2),(5,'Mesa Promocional M20','Mobiliario','Furno','M-20','2023-02-05',800000.00,'DISPONIBLE',2);

DROP TABLE IF EXISTS `campanas`;
CREATE TABLE `campanas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `descripcion` text,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `estado` enum('PLANIFICADA','EN_EJECUCION','FINALIZADA') NOT NULL DEFAULT 'PLANIFICADA',
  `PERSONAS_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_CAMPANAS_PERSONAS1_idx` (`PERSONAS_id`),
  CONSTRAINT `fk_CAMPANAS_PERSONAS1` FOREIGN KEY (`PERSONAS_id`) REFERENCES `personas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

INSERT INTO `campanas` VALUES (1,'Lanzamiento del Año','Lanzamiento de los productos del año 2025','2026-02-01','2026-02-28','FINALIZADA',1),(2,'Promoción de Investigación','Promoción de Productos Investigativos UIS','2026-03-01','2026-03-31','PLANIFICADA',2),(3,'Comida Deliciosa Calle Master','Promoción de la Mejor Hamburguesa Calle Master','2026-04-10','2026-04-20','PLANIFICADA',6),(4,'Tecnologia UTS','Venta de productos investigativos SEIIS','2025-12-01','2025-12-31','FINALIZADA',1),(5,'ExpoLibros UIS','Venta de Libros de la Facultad de Humanas UIS','2026-06-01','2026-06-30','PLANIFICADA',2),(6,'Semillero SEIIS','Semillero de investigación de SISTEMAS UTS','2026-04-28','2026-05-16','PLANIFICADA',9);

DROP TABLE IF EXISTS `categorias`;
CREATE TABLE `categorias` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` enum('PREMIUM','STANDARD') NOT NULL,
  `dias_prestamo` int(11) NOT NULL,
  `porcentaje_penalizacion` decimal(3,2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT INTO `categorias` VALUES (1,'PREMIUM',3,1.00),(2,'STANDARD',10,0.50);

DROP TABLE IF EXISTS `penalizacion_prestamos`;
CREATE TABLE `penalizacion_prestamos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dias_retraso` int(11) NOT NULL,
  `valor_penali` decimal(10,2) NOT NULL,
  `fecha_generacion` date NOT NULL,
  `pagada` tinyint(4) NOT NULL DEFAULT '0',
  `PRESTAMOS_ACTIVO_PERSONA_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_PENALIZACION_PRESTAMOS_PRESTAMOS_ACTIVO_PERSONA1_idx` (`PRESTAMOS_ACTIVO_PERSONA_id`),
  CONSTRAINT `fk_PENALIZACION_PRESTAMOS_PRESTAMOS_ACTIVO_PERSONA1` FOREIGN KEY (`PRESTAMOS_ACTIVO_PERSONA_id`) REFERENCES `prestamos_activo_persona` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO `penalizacion_prestamos` VALUES (1,1,50000.00,'2026-02-14',0,1),(2,5,3750.00,'2026-01-25',1,4),(3,1,4000.00,'2026-02-26',0,5);

DROP TABLE IF EXISTS `personas`;
CREATE TABLE `personas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_documento` varchar(45) NOT NULL,
  `numero_documento` varchar(45) NOT NULL,
  `razon_social` varchar(45) NOT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `ROL_id` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `usuario` varchar(45) NOT NULL DEFAULT '',
  `contrasena` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `numero_documento_UNIQUE` (`numero_documento`),
  KEY `fk_PERSONAS_ROL1_idx` (`ROL_id`),
  CONSTRAINT `fk_PERSONAS_ROL1` FOREIGN KEY (`ROL_id`) REFERENCES `rol` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

INSERT INTO `personas` VALUES
(1,'NIT','900100200-1','Unidades Tecnologicas de Santander','3101000100','contacto@correo.uts.edu.co','Calle 1 #10-20',1,'UTS','',''),
(2,'NIT','900200300-1','Universidad Industrial de Santander','3102000200','info@correo.uis.edu.co','Calle 2 #20-30',1,'UIS','',''),
(3,'CC','12345678','Empleado','3203000300','solangelyepesnunez@gmail.com','Cra 3 #30-40',2,'Sol Angel Yepes','',''),
(4,'CC','87654321','Empleado','3204000400','angeloso74@hotmail.com','Av 4 #40-50',2,'Miguel Angel Osorio Orduz','',''),
(5,'CC','00000001','ADMIN','3000000001','admin@agencia.com','Oficina Central',3,'Admin','Admin',MD5('1234')),
(6,'NIT','900300400-1','Pachorizo Food','3103000300','contacto@pachorizo.com','Calle 5 #50-60',1,'Pachorizo','',''),
(7,'CC','5555555','SOPORTE','3107000700','soporte@apachorizo.com','Soporte Piso 1',5,'Soporte Técnico','',''),
(8,'CC','4444444','SUPERVISOR','3108000800','supervisor@pachorizo.com','Gerencia Piso 2',4,'Supervisor','',''),
(9,'TI','1234567890','DUEÑA DE PACHORIZO','3053034242','mariana@mariana.com','calle 62 1w26',7,'Mariana Ravelo Osorio','','');

DROP TABLE IF EXISTS `prestamos_activo_persona`;
CREATE TABLE `prestamos_activo_persona` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_inicio` date NOT NULL,
  `fecha_fin_programa` date NOT NULL,
  `fecha_entrega_real` date DEFAULT NULL,
  `estado` enum('ACTIVO','ATRASADO','FINALIZADO') NOT NULL DEFAULT 'ACTIVO',
  `PERSONAS_id` int(11) NOT NULL,
  `ACTIVOS_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_PRESTAMOS_ACTIVO_PERSONA_PERSONAS1_idx` (`PERSONAS_id`),
  KEY `fk_PRESTAMOS_ACTIVO_PERSONA_ACTIVOS1_idx` (`ACTIVOS_id`),
  CONSTRAINT `fk_PRESTAMOS_ACTIVO_PERSONA_ACTIVOS1` FOREIGN KEY (`ACTIVOS_id`) REFERENCES `activos` (`id`),
  CONSTRAINT `fk_PRESTAMOS_ACTIVO_PERSONA_PERSONAS1` FOREIGN KEY (`PERSONAS_id`) REFERENCES `personas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

INSERT INTO `prestamos_activo_persona` VALUES (1,'2026-02-10','2026-02-13','2026-02-14','FINALIZADO',1,1),(2,'2026-02-01','2026-02-11','2026-02-11','FINALIZADO',2,3),(3,'2026-02-20','2026-02-23',NULL,'ACTIVO',6,2),(4,'2026-01-10','2026-01-20','2026-01-25','FINALIZADO',1,4),(5,'2026-02-15','2026-02-25','2026-02-26','FINALIZADO',2,5);

DROP TABLE IF EXISTS `reservas_activos_clientes`;
CREATE TABLE `reservas_activos_clientes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_reserva` date NOT NULL,
  `estado` enum('ACTIVA','CANCELADA','ATENDIDA') DEFAULT 'ACTIVA',
  `ACTIVOS_id` int(11) NOT NULL,
  `PERSONAS_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_RESERVAS_ACTIVOS_CLIENTES_ACTIVOS1_idx` (`ACTIVOS_id`),
  KEY `fk_RESERVAS_ACTIVOS_CLIENTES_PERSONAS1_idx` (`PERSONAS_id`),
  CONSTRAINT `fk_RESERVAS_ACTIVOS_CLIENTES_ACTIVOS1` FOREIGN KEY (`ACTIVOS_id`) REFERENCES `activos` (`id`),
  CONSTRAINT `fk_RESERVAS_ACTIVOS_CLIENTES_PERSONAS1` FOREIGN KEY (`PERSONAS_id`) REFERENCES `personas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

INSERT INTO `reservas_activos_clientes` VALUES (1,'2026-02-20','ATENDIDA',3,1),(2,'2026-02-25','ACTIVA',1,2),(3,'2026-02-27','CANCELADA',2,6),(4,'2026-02-28','ACTIVA',4,1),(5,'2026-03-01','ACTIVA',5,2);

DROP TABLE IF EXISTS `rol`;
CREATE TABLE `rol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_rol` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

INSERT INTO `rol` VALUES (1,'CLIENTE'),(2,'EMPLEADO'),(3,'ADMIN'),(4,'HIPERVISOR'),(5,'SOPORTE'),(7,'CONTADOR');
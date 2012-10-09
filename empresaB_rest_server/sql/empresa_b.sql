CREATE DATABASE  IF NOT EXISTS `empresa_b` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `empresa_b`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: empresa_b
-- ------------------------------------------------------
-- Server version	5.5.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `producto_b`
--

DROP TABLE IF EXISTS `producto_b`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto_b` (
  `idproductoB` int(15) NOT NULL AUTO_INCREMENT,
  `nombre_productoB` varchar(45) NOT NULL,
  `cantidad_existencias_b` int(15) DEFAULT NULL,
  `longitud_b` decimal(10,2) DEFAULT NULL,
  `diametro_b` decimal(10,2) DEFAULT NULL,
  `precio_b` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`idproductoB`)
) ENGINE=InnoDB AUTO_INCREMENT=907 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto_b`
--

LOCK TABLES `producto_b` WRITE;
/*!40000 ALTER TABLE `producto_b` DISABLE KEYS */;
INSERT INTO `producto_b` VALUES (903,'sifuncionara34',7900,33.00,333.00,33.00),(904,'otro nuevo',9970,33.00,33.00,33.00),(905,'otro mas',50000,33.00,44.00,44.00),(906,'ultimo1',9900,11.00,11.00,11.00);
/*!40000 ALTER TABLE `producto_b` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_b`
--

DROP TABLE IF EXISTS `usuario_b`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario_b` (
  `idusuarios_b` int(15) NOT NULL AUTO_INCREMENT,
  `dni_nif_b` varchar(10) NOT NULL,
  `login_usuario_b` varchar(15) NOT NULL,
  `password_b` varchar(10) NOT NULL,
  `nombre_b` varchar(256) NOT NULL,
  `apellidos_b` varchar(256) DEFAULT NULL,
  `email_b` varchar(256) NOT NULL,
  `AUTHORITY` enum('UNKNOWN','ROLE_CLIENTE','ROLE_ADMIN') DEFAULT 'ROLE_CLIENTE',
  `ENABLED` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idusuarios_b`),
  UNIQUE KEY `login_usuario_b_UNIQUE` (`login_usuario_b`)
) ENGINE=InnoDB AUTO_INCREMENT=162 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_b`
--

LOCK TABLES `usuario_b` WRITE;
/*!40000 ALTER TABLE `usuario_b` DISABLE KEYS */;
INSERT INTO `usuario_b` VALUES (143,'23456789','jefe','jefe','jefon','nofej','jefe@llls.com','ROLE_ADMIN',1),(156,'34234321','otro','otro','otromas','otro','lsl@gl.com','ROLE_CLIENTE',1),(158,'12345678','jefe2','JEFE2','otro jefote','lsls','lsl@glsl.es','ROLE_ADMIN',1),(159,'23455422','muyjefe','muyjefe','JEFE34','LSLS','lslkdj@llss.es','ROLE_ADMIN',1),(160,'12345678','aaaa','aaaa','aaaa','aaaa','aaa@aa.aa','ROLE_CLIENTE',1),(161,'12345654G','bbbb','bbbb','bbbb','bbbb','rory@gmail.com','ROLE_CLIENTE',1);
/*!40000 ALTER TABLE `usuario_b` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente_b`
--

DROP TABLE IF EXISTS `cliente_b`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente_b` (
  `idusuarios_b` int(15) NOT NULL,
  `fecha_alta_b` date DEFAULT NULL,
  `direccion_b` varchar(75) DEFAULT NULL,
  `provincia_b` varchar(45) DEFAULT NULL,
  `codigopostal_b` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idusuarios_b`),
  KEY `cliente_ibfk_1` (`idusuarios_b`),
  CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`idusuarios_b`) REFERENCES `usuario_b` (`idusuarios_b`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente_b`
--

LOCK TABLES `cliente_b` WRITE;
/*!40000 ALTER TABLE `cliente_b` DISABLE KEYS */;
INSERT INTO `cliente_b` VALUES (156,'2012-10-07','direccion','Barcelona','12345'),(160,'2012-10-04','aaaa','Alava','12345'),(161,'2012-10-07','ssss','Barcelona','08016');
/*!40000 ALTER TABLE `cliente_b` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto_bseleccionado`
--

DROP TABLE IF EXISTS `producto_bseleccionado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto_bseleccionado` (
  `idproductoB` int(15) NOT NULL,
  `idcarro_b` int(15) NOT NULL,
  `cantidad` varchar(45) DEFAULT NULL,
  `idproductoSeleccionado` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idproductoSeleccionado`,`idcarro_b`,`idproductoB`),
  KEY `fk_idproductoB` (`idproductoB`),
  KEY `fk_idcarro_b` (`idcarro_b`),
  CONSTRAINT `fk_idproductoB` FOREIGN KEY (`idproductoB`) REFERENCES `producto_b` (`idproductoB`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_idcarro_b` FOREIGN KEY (`idcarro_b`) REFERENCES `carro_b` (`idcarro_b`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto_bseleccionado`
--

LOCK TABLES `producto_bseleccionado` WRITE;
/*!40000 ALTER TABLE `producto_bseleccionado` DISABLE KEYS */;
INSERT INTO `producto_bseleccionado` VALUES (903,122,'900',54),(903,127,'1000',56),(903,128,'100',57),(906,129,'100',59);
/*!40000 ALTER TABLE `producto_bseleccionado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `administrador_b`
--

DROP TABLE IF EXISTS `administrador_b`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administrador_b` (
  `idusuarios_b` int(15) NOT NULL,
  `cargo_b` varchar(150) DEFAULT NULL,
  `matricula_b` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idusuarios_b`),
  KEY `administrador_ibfk_1` (`idusuarios_b`),
  CONSTRAINT `administrador_b_ibfk_1` FOREIGN KEY (`idusuarios_b`) REFERENCES `usuario_b` (`idusuarios_b`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrador_b`
--

LOCK TABLES `administrador_b` WRITE;
/*!40000 ALTER TABLE `administrador_b` DISABLE KEYS */;
INSERT INTO `administrador_b` VALUES (143,'jefe','12334'),(158,'muyjefe','2123ELL'),(159,'muyjefe','muyjefe');
/*!40000 ALTER TABLE `administrador_b` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carro_b`
--

DROP TABLE IF EXISTS `carro_b`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carro_b` (
  `idcarro_b` int(15) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `pagado` tinyint(1) DEFAULT '0',
  `idcliente` int(15) DEFAULT NULL,
  `enviado` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`idcarro_b`),
  KEY `id_cliente_FK` (`idcliente`),
  CONSTRAINT `id_cliente_FK` FOREIGN KEY (`idcliente`) REFERENCES `cliente_b` (`idusuarios_b`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=130 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carro_b`
--

LOCK TABLES `carro_b` WRITE;
/*!40000 ALTER TABLE `carro_b` DISABLE KEYS */;
INSERT INTO `carro_b` VALUES (122,'2012-10-05',0,160,0),(123,'2012-10-05',1,160,0),(125,'2012-10-05',0,160,0),(126,'2012-10-05',1,160,1),(127,'2012-10-07',1,160,1),(128,'2012-10-07',0,156,0),(129,'2012-10-07',0,161,0);
/*!40000 ALTER TABLE `carro_b` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-10-07 18:45:39

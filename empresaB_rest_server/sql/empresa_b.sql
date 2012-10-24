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
) ENGINE=InnoDB AUTO_INCREMENT=926 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto_b`
--

LOCK TABLES `producto_b` WRITE;
/*!40000 ALTER TABLE `producto_b` DISABLE KEYS */;
INSERT INTO `producto_b` VALUES (906,'ultimo1',10700,11.00,11.00,11.00),(907,'calentito',12,22.00,22.00,22.00),(908,'desde cliente',33,33.00,33.00,33.00),(909,'22ññww',2221,22.00,22.00,22.00),(911,'eeeeeuuuu',33,33.00,33.00,33.00);
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
) ENGINE=InnoDB AUTO_INCREMENT=180 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_b`
--

LOCK TABLES `usuario_b` WRITE;
/*!40000 ALTER TABLE `usuario_b` DISABLE KEYS */;
INSERT INTO `usuario_b` VALUES (143,'23456789','jefe','jefe','jefon','nofej','jefe@llls.com','ROLE_ADMIN',1),(172,'12121212','vvvv','vvvv','creoUnoVario2','petito','rory133@gmail.com','ROLE_CLIENTE',1),(173,'12345678','eeee','eeee','assdghh','asds','rory133@gmail.com','ROLE_CLIENTE',1),(174,'21234567','jjjj','jjjj','jjjjj','jjjjj','jdjdj@glgl.com','ROLE_ADMIN',1),(175,'12345678','paco','paco','paco','mer','rory133@gmail.com','ROLE_ADMIN',1),(176,'55544433G','maki','maki','maki','navaja','rory133@gmail.com','ROLE_CLIENTE',1),(178,'12345678','ffff','ffff','jjjj','jjj','rory133@gmail.com','ROLE_CLIENTE',1),(179,'12345678','oooo','oooo','desdeOtro','Otro','juan-ma@telefonica.net','ROLE_CLIENTE',1);
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
INSERT INTO `cliente_b` VALUES (172,'2012-10-24','eww','Alava','12345'),(173,'2012-10-24','ssss','Alava','12345'),(176,'2012-10-24','33l2l2ll','Cordoba','12345'),(178,'2012-10-24','sdfsf','Alava','12345'),(179,'2012-10-24','2233','Barcelona','12345');
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
  `subTotal` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`idproductoSeleccionado`,`idcarro_b`,`idproductoB`),
  KEY `fk_idproductoB` (`idproductoB`),
  KEY `fk_idcarro_b` (`idcarro_b`),
  CONSTRAINT `fk_idproductoB` FOREIGN KEY (`idproductoB`) REFERENCES `producto_b` (`idproductoB`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_idcarro_b` FOREIGN KEY (`idcarro_b`) REFERENCES `carro_b` (`idcarro_b`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto_bseleccionado`
--

LOCK TABLES `producto_bseleccionado` WRITE;
/*!40000 ALTER TABLE `producto_bseleccionado` DISABLE KEYS */;
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
INSERT INTO `administrador_b` VALUES (143,'jefe','12334'),(174,'jjjj','jjjjj'),(175,'do','12345');
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
  `total` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`idcarro_b`),
  KEY `id_cliente_FK` (`idcliente`),
  CONSTRAINT `id_cliente_FK` FOREIGN KEY (`idcliente`) REFERENCES `cliente_b` (`idusuarios_b`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carro_b`
--

LOCK TABLES `carro_b` WRITE;
/*!40000 ALTER TABLE `carro_b` DISABLE KEYS */;
INSERT INTO `carro_b` VALUES (50,'2012-10-23',0,173,0,-660.00),(51,'2012-10-23',0,173,0,0.00),(53,'2012-10-23',0,173,0,0.00),(54,'2012-10-23',0,173,0,0.00),(55,'2012-10-23',0,173,0,0.00),(56,'2012-10-23',0,173,0,0.00),(57,'2012-10-23',0,173,0,0.00),(58,'2012-10-23',0,173,0,0.00),(59,'2012-10-23',0,173,0,33.00),(60,'2012-10-23',0,173,0,0.00),(61,'2012-10-23',0,173,0,0.00),(62,'2012-10-23',0,173,0,33.00),(63,'2012-10-23',0,173,0,495.00);
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

-- Dump completed on 2012-10-24 12:42:57

-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: 11-Nov-2018 às 02:52
-- Versão do servidor: 5.7.23
-- versão do PHP: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fazenda`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionarios`
--

DROP TABLE IF EXISTS `funcionarios`;
CREATE TABLE IF NOT EXISTS `funcionarios` (
  `ID_FUNC` int(6) NOT NULL AUTO_INCREMENT,
  `NOME_FUNC` varchar(60) NOT NULL,
  `DTADMI_FUNC` date NOT NULL,
  `DTDEMIS_FUNC` date NOT NULL,
  `USUARIO_FUNC` varchar(10) NOT NULL,
  `SENHA_FUNC` varchar(10) NOT NULL,
  `PERMISSOES_FUNC` int(4) NOT NULL,
  `ID_SETOR` int(5) NOT NULL,
  PRIMARY KEY (`ID_FUNC`),
  KEY `ID_SETOR` (`ID_SETOR`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `ocorrencias`
--

DROP TABLE IF EXISTS `ocorrencias`;
CREATE TABLE IF NOT EXISTS `ocorrencias` (
  `ID_OCOR` int(4) NOT NULL AUTO_INCREMENT,
  `ID_FUNC` int(4) NOT NULL,
  `DESC_OCOR` varchar(200) NOT NULL,
  `DATA_OCOR` date NOT NULL,
  `RESOL_OCOR` varchar(200) NOT NULL,
  `ID_SETOR` int(5) NOT NULL,
  PRIMARY KEY (`ID_OCOR`),
  KEY `ID_FUNC` (`ID_FUNC`),
  KEY `ID_SETOR` (`ID_SETOR`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `setores`
--

DROP TABLE IF EXISTS `setores`;
CREATE TABLE IF NOT EXISTS `setores` (
  `ID_SETOR` int(5) NOT NULL AUTO_INCREMENT,
  `NOME_SETOR` varchar(60) NOT NULL,
  PRIMARY KEY (`ID_SETOR`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tarefas`
--

DROP TABLE IF EXISTS `tarefas`;
CREATE TABLE IF NOT EXISTS `tarefas` (
  `ID_TAREFA` int(4) NOT NULL AUTO_INCREMENT,
  `DESC_TAREFA` varchar(200) NOT NULL,
  `DATA_TAREFA` date NOT NULL,
  `SETOR_TAREFA` int(5) NOT NULL,
  `OBS_TAREFA` varchar(200) NOT NULL,
  `STATUS_TAREFA` int(5) NOT NULL,
  `DTCONCLUSAO_TAREFA` date NOT NULL,
  PRIMARY KEY (`ID_TAREFA`),
  KEY `SETOR_TAREFA` (`SETOR_TAREFA`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `teste`
--

DROP TABLE IF EXISTS `teste`;
CREATE TABLE IF NOT EXISTS `teste` (
  `ID_TESTE` int(3) NOT NULL,
  `NOME_TESTE` varchar(60) NOT NULL,
  PRIMARY KEY (`ID_TESTE`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           5.6.34-log - MySQL Community Server (GPL)
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Copiando estrutura do banco de dados para banco_de_questoes
CREATE DATABASE IF NOT EXISTS `banco_de_questoes` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `banco_de_questoes`;


-- Copiando estrutura para tabela banco_de_questoes.aluno
CREATE TABLE IF NOT EXISTS `aluno` (
  `id_alun` int(11) NOT NULL AUTO_INCREMENT,
  `matricula` bigint(20) NOT NULL DEFAULT '0',
  `senha` varchar(50) NOT NULL DEFAULT '0',
  `nivel` int(11) NOT NULL DEFAULT '0',
  `data` date NOT NULL,
  `nome` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_alun`,`matricula`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela banco_de_questoes.aluno: ~10 rows (aproximadamente)
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` (`id_alun`, `matricula`, `senha`, `nivel`, `data`, `nome`) VALUES
	(1, 20141064010220, '123', 1, '2017-02-08', NULL),
	(2, 20131064010282, '123', 0, '2017-02-03', NULL),
	(3, 123, 'admin', 0, '2017-02-08', 'zé'),
	(4, 125, 'admin', 1, '2017-02-05', 'luan'),
	(5, 122, 'admin', 1, '2017-02-05', 'newton'),
	(6, 456, 'admin', 1, '2017-02-08', 'teste2'),
	(7, 9876, 'admin', 1, '2017-02-08', 'luan'),
	(8, 157, 'admin', 0, '2017-02-09', 'teste4'),
	(9, 123456, '123', 1, '2017-02-09', 'newton'),
	(10, 66613, 'admin', 1, '2017-02-09', 'vinicius');
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;


-- Copiando estrutura para tabela banco_de_questoes.questao
CREATE TABLE IF NOT EXISTS `questao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pergunta` varchar(1024) DEFAULT NULL,
  `resposta` varchar(1024) DEFAULT NULL,
  `materia` varchar(144) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela banco_de_questoes.questao: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `questao` DISABLE KEYS */;
INSERT INTO `questao` (`id`, `pergunta`, `resposta`, `materia`) VALUES
	(1, 'teste?', 'oi', 'Manutenção'),
	(2, 'newton é alemão??//', 'não seu gld', 'Manutenção'),
	(3, 'luan é indiano?', 'claro q sim', 'Manutenção'),
	(4, 'pablo é do arocha?', 'wcbnwq~cl', 'Banco de Dados');
/*!40000 ALTER TABLE `questao` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

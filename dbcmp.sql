-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 25, 2017 at 12:58 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbcmp`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `delacc` (IN `acno` INT)  NO SQL
delete from tbacc where accno=acno$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `delcmp` (IN `cpcod` INT)  NO SQL
DELETE from tbcmp where cmpcod=cpcod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `delemps` (IN `epcod` INT)  NO SQL
DELETE from tbemps WHERE empcod=epcod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `delvst` (IN `cod` INT)  NO SQL
delete from tbvst where vstcod=cod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `disacc` ()  NO SQL
select * from tbacc order by accno$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `discmp` ()  NO SQL
SELECT * from tbcmp ORDER BY cmpcod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `disemps` ()  NO SQL
SELECT * from tbemps ORDER BY empcod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `disvst` ()  NO SQL
select * from tbvst order by vstcod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `dsempbyloc` (IN `loc` VARCHAR(100))  NO SQL
SELECT * from tbemps where emploc=loc$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `findacc` (IN `acno` INT)  NO SQL
SELECT * from tbacc where accno=acno$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `findcmp` (IN `cmcod` INT)  NO SQL
SELECT * from tbcmp where cmpcod=cmcod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `findemps` (IN `ecod` INT)  NO SQL
SELECT * FROM tbemps WHERE empcod=ecod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `findvst` (IN `cod` INT)  NO SQL
select * from tbvst WHERE vstcod=cod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insacc` (IN `acnam` VARCHAR(100), IN `acdat` DATE, IN `acad` VARCHAR(100), IN `acloc` VARCHAR(100), IN `acphn` VARCHAR(100), IN `actyp` VARCHAR(100))  NO SQL
insert into tbacc VALUES(null,acnam,NOW(),acad,acloc,acphn,actyp)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `inscmp` (IN `cmpac` INT, IN `cmdat` DATE, IN `cmdsc` VARCHAR(100), IN `cmascod` INT, IN `cmsts` VARCHAR(10))  NO SQL
INSERT into tbcmp VALUES(null,cmpac,NOW(),cmdsc,cmascod,cmsts)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insemps` (IN `emnam` VARCHAR(100), IN `empic` VARCHAR(50), IN `emloc` VARCHAR(100), IN `emphn` VARCHAR(100))  NO SQL
insert into tbemps VALUES(null,emnam,empic,emloc,emphn)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insvst` (IN `vsdat` DATE, IN `cod` INT, IN `vsdsc` VARCHAR(1000), IN `vsfed` INT)  NO SQL
insert into tbvst VALUES(null,NOW(),cod,vsdsc,vsfed)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updacc` (IN `acno` INT, IN `acnam` VARCHAR(100), IN `acdat` DATE, IN `acad` VARCHAR(100), IN `acloc` VARCHAR(100), IN `acphn` VARCHAR(100), IN `actyp` VARCHAR(100))  NO SQL
UPDATE tbacc set accnam=acnam,accrtdat=NOW(),accadd=acad,accloc=acloc,accphnno=acphn,acctyp=actyp where accno=acno$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updcmp` (IN `cpcod` INT, IN `cpsts` VARCHAR(10))  NO SQL
UPDATE tbcmp set cmpcod=cpcod,cmpsts=cpsts$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updemps` (IN `epcod` INT, IN `emnam` VARCHAR(100), IN `empic` VARCHAR(50), IN `emloc` VARCHAR(100), IN `emphn` VARCHAR(100))  NO SQL
UPDATE tbemps SET empname=emnam,emppic=empic,emploc=emloc,empphnno=emphn where empcod=epcod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updvst` (IN `vscod` INT, IN `vsdat` DATE, IN `cod` INT, IN `vsdsc` VARCHAR(1000), IN `vsfed` INT)  NO SQL
UPDATE tbvst set vstdat=NOW(),vstcmpcod=cod,vstdsc=vsdsc,vstfed=vsfed where vstcod=vscod$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tbacc`
--

CREATE TABLE `tbacc` (
  `accno` int(11) NOT NULL,
  `accnam` varchar(100) NOT NULL,
  `accrtdat` date NOT NULL,
  `accadd` varchar(100) NOT NULL,
  `accloc` varchar(100) NOT NULL,
  `accphnno` varchar(100) NOT NULL,
  `acctyp` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbacc`
--

INSERT INTO `tbacc` (`accno`, `accnam`, `accrtdat`, `accadd`, `accloc`, `accphnno`, `acctyp`) VALUES
(1, ' Vivek Mishra', '2017-10-10', 'Hno.82 street no.2 shankar colony bhamian khurd ludhiana ', 'Patiala', ' 9872435977', 'Phone'),
(3, ' Ajay Khanna', '1970-01-01', 'hno 90 jalalabad ', 'Chandigarh', ' 9876545291', 'Broadband'),
(4, ' Yogesh Bansal', '1970-01-01', 'hno 98 bathinda ', 'Bathinda', '700987416 ', 'Airtel Money'),
(5, ' Puneet Kumar', '2017-10-19', 'hn0. 93A upkar nagar factory area patiala ', 'Ludhiana', ' 9780440718', 'Phone');

-- --------------------------------------------------------

--
-- Table structure for table `tbcmp`
--

CREATE TABLE `tbcmp` (
  `cmpcod` int(11) NOT NULL,
  `cmpaccno` int(11) NOT NULL,
  `cmpdat` date NOT NULL,
  `cmpdsc` varchar(100) NOT NULL,
  `cmpasgempcod` int(11) NOT NULL,
  `cmpsts` varchar(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbcmp`
--

INSERT INTO `tbcmp` (`cmpcod`, `cmpaccno`, `cmpdat`, `cmpdsc`, `cmpasgempcod`, `cmpsts`) VALUES
(9, 3, '2017-10-11', 'no network', 4, 'A'),
(8, 3, '2017-10-10', 'slow net speed', 4, 'A'),
(7, 3, '2017-10-10', 'wifi network not available', 4, 'A'),
(6, 1, '2017-10-10', 'sim slot not working', 5, 'C');

-- --------------------------------------------------------

--
-- Table structure for table `tbemps`
--

CREATE TABLE `tbemps` (
  `empcod` int(11) NOT NULL,
  `empname` varchar(100) NOT NULL,
  `emppic` varchar(50) NOT NULL,
  `emploc` varchar(100) NOT NULL,
  `empphnno` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbemps`
--

INSERT INTO `tbemps` (`empcod`, `empname`, `emppic`, `emploc`, `empphnno`) VALUES
(4, 'Deepansh Bhargavya', 'Deepansh.jpg', 'Chandigarh', '9109508408'),
(5, ' Kunal Chalia', 'Kunal.jpg', 'Patiala', ' 9646587073'),
(12, 'Vikas Pandey ', 'Vikas.jpg', 'Delhi', ' 9988227834');

-- --------------------------------------------------------

--
-- Table structure for table `tbvst`
--

CREATE TABLE `tbvst` (
  `vstcod` int(11) NOT NULL,
  `vstdat` date NOT NULL,
  `vstcmpcod` int(11) NOT NULL,
  `vstdsc` varchar(1000) NOT NULL,
  `vstfed` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbvst`
--

INSERT INTO `tbvst` (`vstcod`, `vstdat`, `vstcmpcod`, `vstdsc`, `vstfed`) VALUES
(4, '2017-10-10', 7, 'suceesfully treated', 0),
(3, '2017-10-10', 6, 'done', 4),
(5, '2017-10-10', 8, 'not resolved', 1),
(6, '2017-10-11', 8, 'succeded', 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbacc`
--
ALTER TABLE `tbacc`
  ADD PRIMARY KEY (`accno`);

--
-- Indexes for table `tbcmp`
--
ALTER TABLE `tbcmp`
  ADD PRIMARY KEY (`cmpcod`);

--
-- Indexes for table `tbemps`
--
ALTER TABLE `tbemps`
  ADD PRIMARY KEY (`empcod`);

--
-- Indexes for table `tbvst`
--
ALTER TABLE `tbvst`
  ADD PRIMARY KEY (`vstcod`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbacc`
--
ALTER TABLE `tbacc`
  MODIFY `accno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `tbcmp`
--
ALTER TABLE `tbcmp`
  MODIFY `cmpcod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `tbemps`
--
ALTER TABLE `tbemps`
  MODIFY `empcod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `tbvst`
--
ALTER TABLE `tbvst`
  MODIFY `vstcod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

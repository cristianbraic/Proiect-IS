-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 11, 2015 at 09:13 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `onlinebanking`
--

-- --------------------------------------------------------

--
-- Table structure for table `accountdetail`
--

CREATE TABLE IF NOT EXISTS `accountdetail` (
  `username` varchar(100) NOT NULL,
  `accno` int(11) NOT NULL,
  `amount` double NOT NULL,
  `gender` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  `emailid` varchar(100) NOT NULL,
  `phoneno` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accountdetail`
--

INSERT INTO `accountdetail` (`username`, `accno`, `amount`, `gender`, `address`, `status`, `emailid`, `phoneno`) VALUES
('cristi', 100, 999999999500, 'M', 'asdfasd', 'Inactive', 'vcasdvas@gmail.com', '0455888965'),
('simina', 0, 500, 'L', 'asdasd', 'unfucked', 'dobor_bote@gmail.com', '123456789');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `role` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`, `role`) VALUES
('cristi', 'laba', 'CUSTOMER'),
('simina', 'dorin', 'CUSTOMER');

-- --------------------------------------------------------

--
-- Table structure for table `transactiondetail`
--

CREATE TABLE IF NOT EXISTS `transactiondetail` (
  `username` varchar(100) NOT NULL,
  `fromacct` int(11) NOT NULL,
  `toacct` int(11) NOT NULL,
  `transamount` double NOT NULL,
  `shwdate` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transactiondetail`
--

INSERT INTO `transactiondetail` (`username`, `fromacct`, `toacct`, `transamount`, `shwdate`) VALUES
('cristi', 100, 0, 500, '11/1/15');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

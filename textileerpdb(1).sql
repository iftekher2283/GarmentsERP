-- phpMyAdmin SQL Dump
-- version 4.2.12deb2+deb8u1build0.15.04.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Aug 11, 2016 at 07:27 AM
-- Server version: 5.6.28-0ubuntu0.15.04.1
-- PHP Version: 5.6.4-4ubuntu6.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `textileerpdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `Buyer`
--

CREATE TABLE IF NOT EXISTS `Buyer` (
  `buyerName` varchar(255) NOT NULL,
  `addedBy` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `areaCode` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `companyBrandName` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `officeSiteName` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `updatedBy` varchar(255) DEFAULT NULL,
  `zipCode` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Buyer`
--

INSERT INTO `Buyer` (`buyerName`, `addedBy`, `address`, `areaCode`, `city`, `companyBrandName`, `email`, `officeSiteName`, `phone`, `state`, `updatedBy`, `zipCode`) VALUES
('Russel', 'merchandizer', '123/abc, Park Street', '1234', 'London', 'BCDEA', 'abc@xyz.com', 'ABCDE', '+4779903209', 'London', 'merchandizer', '1098');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_employee`
--

CREATE TABLE IF NOT EXISTS `tbl_employee` (
  `id` varchar(11) NOT NULL,
  `permDist` varchar(255) DEFAULT NULL,
  `permHouseNo` varchar(255) DEFAULT NULL,
  `permPO` varchar(255) DEFAULT NULL,
  `permPS` varchar(255) DEFAULT NULL,
  `permPhn` varchar(255) DEFAULT NULL,
  `permRoadNo` varchar(255) DEFAULT NULL,
  `permVillage` varchar(255) DEFAULT NULL,
  `presDist` varchar(255) DEFAULT NULL,
  `presHouseNo` varchar(255) DEFAULT NULL,
  `presPO` varchar(255) DEFAULT NULL,
  `presPS` varchar(255) DEFAULT NULL,
  `presPhn` varchar(255) DEFAULT NULL,
  `presRoadNo` varchar(255) DEFAULT NULL,
  `presVillage` varchar(255) DEFAULT NULL,
  `branchId` varchar(255) DEFAULT NULL,
  `companyNo` int(11) NOT NULL,
  `confirmationDate` varchar(255) DEFAULT NULL,
  `departmentCode` varchar(255) DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `joiningDate` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `birthPlace` varchar(255) DEFAULT NULL,
  `bloodGroup` varchar(255) DEFAULT NULL,
  `children` int(11) NOT NULL,
  `dateOfBirth` varchar(255) DEFAULT NULL,
  `eduQuali` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `emerContNo` varchar(255) DEFAULT NULL,
  `fathersName` varchar(255) DEFAULT NULL,
  `height` double NOT NULL,
  `maritalStatus` varchar(255) DEFAULT NULL,
  `mobileNo` varchar(255) DEFAULT NULL,
  `mothersName` varchar(255) DEFAULT NULL,
  `nationality` varchar(255) DEFAULT NULL,
  `nidNo` varchar(255) DEFAULT NULL,
  `passportNo` varchar(255) DEFAULT NULL,
  `religion` varchar(255) DEFAULT NULL,
  `spouse` varchar(255) DEFAULT NULL,
  `techQuali` varchar(255) DEFAULT NULL,
  `tinNo` varchar(255) DEFAULT NULL,
  `weight` double NOT NULL,
  `ac_no` varchar(255) DEFAULT NULL,
  `bank_code` varchar(255) DEFAULT NULL,
  `basic_salary` double NOT NULL,
  `sex` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_employee`
--

INSERT INTO `tbl_employee` (`id`, `permDist`, `permHouseNo`, `permPO`, `permPS`, `permPhn`, `permRoadNo`, `permVillage`, `presDist`, `presHouseNo`, `presPO`, `presPS`, `presPhn`, `presRoadNo`, `presVillage`, `branchId`, `companyNo`, `confirmationDate`, `departmentCode`, `designation`, `joiningDate`, `name`, `birthPlace`, `bloodGroup`, `children`, `dateOfBirth`, `eduQuali`, `email`, `emerContNo`, `fathersName`, `height`, `maritalStatus`, `mobileNo`, `mothersName`, `nationality`, `nidNo`, `passportNo`, `religion`, `spouse`, `techQuali`, `tinNo`, `weight`, `ac_no`, `bank_code`, `basic_salary`, `sex`) VALUES
('123', 'Mymensngh', '78', 'Muktagacha', 'Muktagacha', '0156728798', '130', 'Muktagacha', 'Dhaka', '19', 'Khilkhet', 'Khilkhet', '0177209832', '20', 'Khilkhet', 'RD2', 3, '6/1/2016', 'RSnDEV', 'Director', '6/4/2016', 'Md. Giasuddin', 'Mysmensingh', 'A_POSITIVE', 2, '23-04-1990', 'MSc', 'abc@zxy.com', '01783984678', 'Md. Nizamuddin', 5.8, 'Married', '01774399021', 'Fatema Khanam', 'Bangladesh', '19909027376000028', 'PP-239867', 'Islam', 'Amena Begum', 'Nil', '98734582', 67, 'DHK2172', 'AAIBL', 30000, 'Male'),
('3213', 'Dhaka', '41', 'Khilkhet', 'Khilkhet', '0177825676', '19', 'Nikunja-2', 'tr', 'trh', 'fd', 'hgf', 'hgdff', 'dfasd', 'fds', 'GBF', 5, '6/1/2016', 'MRK', 'Managing_Director', '6/3/2016', 'Md. Nabil Mahmud', 'hrt', 'A_POSITIVE', 1, '23-3-1990', 'gfds', 'hgfh', 'dsafr', 'Md. Hamid Mahmud', 5.7, 'Unmarried', 're', 'Mrs. Hamida Mahmud', 'Bangladeshi', 'g', 'hgf', 'Islam', 'NA', 'gsdf', 'fdsg', 66, 'JBLDHK12.576', 'JBL', 40000, 'Male');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_users`
--

CREATE TABLE IF NOT EXISTS `tbl_users` (
`sl` int(4) NOT NULL,
  `user_id` varchar(20) NOT NULL,
  `password` varchar(40) NOT NULL,
  `user_type` int(2) NOT NULL,
  `isBlocked` int(2) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_users`
--

INSERT INTO `tbl_users` (`sl`, `user_id`, `password`, `user_type`, `isBlocked`) VALUES
(1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 8, 0),
(2, 'hrmanager', 'cc501ce6cd4e21d3fa81134e6e2eed81', 7, 0),
(3, 'merchandizer', '65d55c1eec5c4240e8521694ed8ba111', 1, 0),
(4, 'indeng', 'c24d508b02a9a0e2444174d758a37d35', 3, 0),
(5, 'quality', 'd66636b253cb346dbb6240e30def3618', 5, 0),
(6, 'production', 'fd89784e59c72499525556f80289b2c7', 4, 0),
(7, 'planner', '0273b494d66af726729c3817b9e194e3', 2, 0),
(8, 'store', '8cd892b7b97ef9489ae4479d3f4ef0fc', 6, 0),
(9, '3213', '60474c9c10d7142b7508ce7a50acf414', 1, 0),
(10, '123', '4d42bf9c18cb04139f918ff0ae68f8a0', 2, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Buyer`
--
ALTER TABLE `Buyer`
 ADD PRIMARY KEY (`buyerName`);

--
-- Indexes for table `tbl_employee`
--
ALTER TABLE `tbl_employee`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_users`
--
ALTER TABLE `tbl_users`
 ADD PRIMARY KEY (`sl`), ADD UNIQUE KEY `user_id` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_users`
--
ALTER TABLE `tbl_users`
MODIFY `sl` int(4) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.2.12deb2+deb8u1build0.15.04.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Aug 26, 2016 at 11:54 PM
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
  `zipCode` varchar(255) DEFAULT NULL,
  `isDeleted` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Buyer`
--

INSERT INTO `Buyer` (`buyerName`, `addedBy`, `address`, `areaCode`, `city`, `companyBrandName`, `email`, `officeSiteName`, `phone`, `state`, `updatedBy`, `zipCode`, `isDeleted`) VALUES
('John', 'merchandiser', '', '4000', 'Sydney', 'ZYXBA', 'john@123.com', 'XYZAB', '+47738192028', 'Sydney', 'merchandiser', '1035', 0),
('Russel', 'merchandizer', '123/abc, Park Street', '1234', 'London', 'BCDEA', 'abc@xyz.com', 'ABCDE', '+4779903209', 'London', 'merchandiser', '1089', 0);

-- --------------------------------------------------------

--
-- Table structure for table `Consumption`
--

CREATE TABLE IF NOT EXISTS `Consumption` (
`sl` int(11) NOT NULL,
  `calculatedBy` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `lastUpdatedBy` varchar(255) DEFAULT NULL,
  `orderId` int(11) NOT NULL,
  `size` varchar(255) DEFAULT NULL,
  `sizeQuantity` int(11) NOT NULL,
  `fabricConsumption_sl` int(11) DEFAULT NULL,
  `threadConsumption_sl` int(11) DEFAULT NULL,
  `isDeleted` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Consumption`
--

INSERT INTO `Consumption` (`sl`, `calculatedBy`, `date`, `lastUpdatedBy`, `orderId`, `size`, `sizeQuantity`, `fabricConsumption_sl`, `threadConsumption_sl`, `isDeleted`) VALUES
(7, 'merchandiser', '8/26/2016', 'merchandiser', 1, 'XL', 123637, 1, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `FabricConsumption`
--

CREATE TABLE IF NOT EXISTS `FabricConsumption` (
`sl` int(11) NOT NULL,
  `fabricGsm` double NOT NULL,
  `wastage` double NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `FabricConsumption`
--

INSERT INTO `FabricConsumption` (`sl`, `fabricGsm`, `wastage`) VALUES
(1, 160, 10);

-- --------------------------------------------------------

--
-- Table structure for table `FabricConsumptionComponents`
--

CREATE TABLE IF NOT EXISTS `FabricConsumptionComponents` (
`sl` int(11) NOT NULL,
  `allowance` double NOT NULL,
  `component` varchar(255) DEFAULT NULL,
  `value` double NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `FabricConsumptionComponents`
--

INSERT INTO `FabricConsumptionComponents` (`sl`, `allowance`, `component`, `value`) VALUES
(3, 5, 'Body_Length', 72);

-- --------------------------------------------------------

--
-- Table structure for table `FabricConsumption_FabricConsumptionComponents`
--

CREATE TABLE IF NOT EXISTS `FabricConsumption_FabricConsumptionComponents` (
  `FabricConsumption_sl` int(11) NOT NULL,
  `components_sl` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `FabricConsumption_FabricConsumptionComponents`
--

INSERT INTO `FabricConsumption_FabricConsumptionComponents` (`FabricConsumption_sl`, `components_sl`) VALUES
(1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_employee`
--

CREATE TABLE IF NOT EXISTS `tbl_employee` (
  `id` varchar(20) NOT NULL,
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
  `sex` varchar(255) DEFAULT NULL,
  `addedBy` varchar(255) DEFAULT NULL,
  `lastUpdatedBy` varchar(255) DEFAULT NULL,
  `isDeleted` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_employee`
--

INSERT INTO `tbl_employee` (`id`, `permDist`, `permHouseNo`, `permPO`, `permPS`, `permPhn`, `permRoadNo`, `permVillage`, `presDist`, `presHouseNo`, `presPO`, `presPS`, `presPhn`, `presRoadNo`, `presVillage`, `branchId`, `companyNo`, `confirmationDate`, `departmentCode`, `designation`, `joiningDate`, `name`, `birthPlace`, `bloodGroup`, `children`, `dateOfBirth`, `eduQuali`, `email`, `emerContNo`, `fathersName`, `height`, `maritalStatus`, `mobileNo`, `mothersName`, `nationality`, `nidNo`, `passportNo`, `religion`, `spouse`, `techQuali`, `tinNo`, `weight`, `ac_no`, `bank_code`, `basic_salary`, `sex`, `addedBy`, `lastUpdatedBy`, `isDeleted`) VALUES
('123', 'Mymensngh', '78', 'Muktagacha', 'Muktagacha', '0156728798', '130', 'Muktagacha', 'Dhaka', '19', 'Khilkhet', 'Khilkhet', '0177209832', '20', 'Khilkhet', 'RD2', 3, '6/1/2016', 'RSnDEV', 'Director', '6/4/2016', 'Md. Giasuddin', 'Mysmensingh', 'A_POSITIVE', 2, '23-04-1990', 'MSc', 'abc@zxy.com', '01783984678', 'Md. Nizamuddin', 5.8, 'Married', '01774399021', 'Fatema Khanam', 'Bangladesh', '19909027376000028', 'PP-239867', 'Islam', 'Amena Begum', 'Nil', '98734582', 67, 'DHK2172', 'AAIBL', 30000, 'Male', NULL, NULL, 0),
('3213', 'Dhaka', '41', 'Khilkhet', 'Khilkhet', '0177825676', '19', 'Nikunja-2', 'tr', 'trh', 'fd', 'hgf', 'hgdff', 'dfasd', 'fds', 'GBF', 5, '6/1/2016', 'MRK', 'Managing_Director', '6/3/2016', 'Md. Nabil Mahmud', 'hrt', 'A_POSITIVE', 1, '23-3-1990', 'gfds', 'hgfh', '01457643', 'Md. Hamid Mahmud', 5.7, 'Unmarried', 're', 'Mrs. Hamida Mahmud', 'Bangladeshi', 'g', 'hgf', 'Islam', 'NA', 'gsdf', '76GH371BV318', 66, 'JBLDHK12.576', 'JBL', 40000, 'Male', NULL, 'hrmanager', 0),
('32472', 'Tangail', '213', 'Dariapur', 'Sokhipur', '6172638', '21', 'Faila Pagla', 'Dhaka', '43', 'Mirpur', 'MIrpur', '016738347836', '12', 'Mirpur', 'GBF', 3, '8/1/2016', 'FnAC', 'Manager', '8/4/2016', 'Md. Mehedi Hasan', 'Tangail', 'AB_POSITIVE', 0, '12-03-1965', 'BSc', 'jhgfdj@gckj', '73467218321', 'Abu Bakar Siddique', 5.9, 'Unmarried', '0832178413', 'Sufia Begum', 'Bangladeshi', '199393912729732198', 'PP-Scotch', 'Islam', '', 'dfsdf', '2327233872313', 62, 'JJ124378', 'JBL', 70000, 'Male', NULL, NULL, 0),
('4231', 'dfsgf', '21', 'gfsg', 'fsdg', '12312', '321', 'fdsgsgf', 'fds', '23', 'fsg', 'gsd', '341124', '43', 'dgf', 'RAPP', 2, '8/16/2016', 'FnAC', 'Additional_Director', '8/11/2016', 'eefdf', 'dadfa', 'A_NEGATIVE', 0, '13-11-1991', 'gfgs', 'fdaa@dfa', '018273182', 'dfaf', 5.3, 'Unmarried', '3213123', 'daf', 'Bangladeshi', '1991123342133123321', 'PP-674823', 'Others', '', 'fdsg', '123WD321HJ123', 49, '192.168.56.2', 'AAIBL', 120000, 'Female', 'hrmanager', 'hrmanager', 0),
('admin', 'Sirajganj', '218', 'Shuvgacha', 'Kazipur', '01733441777', '34', 'Beer Shuvgacha', 'Tangail', '829/2', 'Tangail', 'Tangail', '01881443508', '18', 'Sabalia', 'RD2', 1, '12/03/2016', 'FnAC', 'Manager', '01/04/2016', 'Mahmudur Rahman', 'Sirajganj', 'A_POSITIVE', 2, '01/05/1991', 'BSc in CSE', 'volume420@gmail.com', '01732529091', 'Md Abdul Latif', 5.8, 'Married', '01680161684', 'Amena Begum', 'Bangladeshi', '19919329518000032', 'AA-328975', 'Islam', 'Sabira Rahman', 'etc etc', '2012000000010', 66, '192.168.56.2', 'JBL', 40000, 'Male', NULL, NULL, 0),
('hrmanager', 'Vola', '23', 'Vola', 'Vola', '0163892789', '12', 'Vola', 'Dhaka', '67', 'Khilkhet', 'Khilkhet', '0183927398', '43', 'Nikunja-2', 'RD2', 2, '12/3/2015', 'HRM', 'Manager', '15/3/2015', 'Nazmul Huda', 'Vola', 'B_NEGATIVE', 2, '12-11-1987', 'MBA', 'nazmul@abc.com', '0173846253', 'Kamrul Huda', 5.7, 'Married', '01637458', 'Rabeya Huda', 'Bangladeshi', '1937382637383', 'PP-117782', 'Islam', 'Rokeya Huda', 'Ace kicu ekta', 'AB21321DC21', 68, '192.17.4.254', 'AAIBL', 60000, 'Male', NULL, NULL, 0),
('indeng', 'Mymensingh', '132', 'Muktagacha', 'Muktagacha', '017327328', '12', 'Muktagacha', 'Dhaka', '41', 'Khilkhet', 'Khilkhet', '0137383278', '19', 'Nikunja', 'RSCT', 3, '26/12/2015', 'COM', 'Manager', '01/01/2016', 'Anondo Mohon', 'Mymensingh', 'AB_POSITIVE', 0, '03/06/1987', 'MSc', 'anondo@jdf.com', '0183837', 'Babu Mohon', 5.6, 'Unmarried', '01837', 'Mina Rani', 'Bangladeshi', '19383377836', 'PP-627364', 'Sanatan', NULL, 'jhgddj', '6387372182', 65, 'jhdjhdsj', 'JBL', 65000, 'Male', NULL, NULL, 0),
('merchandiser', 'Rangpur', '32', 'Rangpur', 'Rangpur', '9843284328', '76', 'Rangpur', 'Dhaka', '32', 'Kochukhet', 'Cantonment', '01273', '12', 'Kochukhet', 'GBF', 5, '23/11/2015', 'RSnDEV', 'Manager', '27/11/2015', 'Suvash D Costa', 'Rangpur', 'O_POSITIVE', 2, '13/02/1978', 'MSc', 'suvash21@jd.com', '874761', 'Andrew D Costa', 5.6, 'Married', '7372318', 'Marry D Costa', 'Bangladeshi', '6378321892819', 'PP-373821', 'Christian', 'Mariyam D Costa', 'jdjdsakj', '6713283218', 72, '182.164.12.243', 'AAIBL', 60000, 'Male', NULL, NULL, 0),
('planner', 'Tangail', '32', 'Vukta', 'Kalihati', '01715867770', '221', 'Vukta', 'Dhaka', '12', 'Khilkhet', 'Khilkhet', '01833040866', '19', 'Nikunja', 'RD2', 1, '12/07/2016', 'FnAC', 'Manager', '01/08/2016', 'Mahmuda Tabassum', 'Tangail', 'AB_POSITIVE', 0, '20/12/1993', 'BSc', 'mahmuda@abc.com', '312781372', 'Shamsu Bhuiyan', 5.6, 'Unmarried', '7122873', 'Shahana Bhuiyan', 'Bangladeshi', '61287327', 'PP-317887', 'Islam', NULL, 'jdada', '6127823', 48, '192.172.56.2', 'JBL', 70000, 'Female', NULL, NULL, 0),
('production', 'Dhaka', '45', 'Ganderia', 'Jatrabari', '721872', '14', 'Ganderia', 'Dhaka', '45', 'Ganderia', 'Jatrabari', '721872', '14', 'Ganderia', 'RAPP', 4, '19/07/2015', 'RSnDEV', 'Manager', '23/07/2015', 'Tamim Hasan', 'Dhaka', 'AB_NEGATIVE', 0, '27/11/1988', 'MSc', 'tamim@mnl.com', '6182389', 'Maksud Hasan', 5.7, 'Married', '23176', 'Rokeya Hasan', 'Bangladeshi', '13456758', 'PP-546734', 'Islam', 'Rabeya Hasan', 'fgf', '6768790877855', 68, '172.17.4.254', 'AAIBL', 70000, 'Male', NULL, NULL, 0),
('quality', 'Manikganj', '21', 'Manikganj', 'Manikganj', '73737', '23', 'Manikganj', 'Manikganj', '23', 'Dhaka', 'Dhaka', '7318912', '17', 'Manikganj', 'RD1', 1, '12/11/2015', 'MRK', 'Manager', '23/11/2015', 'Sumaia Rahman', 'Manikganj', 'O_POSITIVE', 0, '12/04/1993', 'BSc', 'sumaia@123.com', '831287', 'Maksud Rahman', 5.4, 'Unmarried', '171378', 'Tahmina Rahman', 'Bangladeshi', '7813278312', 'PP-238890', 'Islam', NULL, 'kjasdkjl', '8913278', 53, 'jkldwdj', 'AAIBL', 50000, 'Female', NULL, NULL, 0),
('store', 'Kushtia', '78', 'Cheuria', 'Kushtia', '2338712', '34', 'Cheuria', 'Dhaka', '56', 'Mirpur', 'Mirpur', '3729', '11', 'Mirpur', 'GBF', 2, '21/05/2016', 'MRK', 'Manager', '23/05/2016', 'Badhan Bhoumik', 'Kushtia', 'O_NEGATIVE', 3, '28/03/1976', 'MSc', 'badhan@xyz.com', '73278', 'Mihir Bhoumik', 5.8, 'Married', '62173', 'Mukti Rani', 'Bangladeshi', '61289379', 'PP-234578', 'Buddhism', 'Shilpa Rani', 'kskaldj', '7897970', 73, '167.673.928.178', 'JBL', 90000, 'Male', NULL, NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_order`
--

CREATE TABLE IF NOT EXISTS `tbl_order` (
`orderId` int(11) NOT NULL,
  `buyerName` varchar(255) DEFAULT NULL,
  `buyerRequirements` varchar(255) DEFAULT NULL,
  `orderAddedBy` varchar(255) DEFAULT NULL,
  `orderCategory` varchar(255) DEFAULT NULL,
  `orderCost` double DEFAULT NULL,
  `orderCurrency` varchar(255) DEFAULT NULL,
  `orderDate` varchar(255) DEFAULT NULL,
  `orderDeliveryDate` varchar(255) DEFAULT NULL,
  `orderDescription` varchar(255) DEFAULT NULL,
  `orderFloorNo` varchar(255) DEFAULT NULL,
  `orderInternalComments` varchar(255) DEFAULT NULL,
  `orderIsDeleted` int(11) DEFAULT NULL,
  `orderLastUpdatedBy` varchar(255) DEFAULT NULL,
  `orderLineNo` varchar(255) DEFAULT NULL,
  `orderName` varchar(255) DEFAULT NULL,
  `orderPriority` varchar(255) DEFAULT NULL,
  `orderQuantity` int(11) DEFAULT NULL,
  `orderSmv` double DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_order`
--

INSERT INTO `tbl_order` (`orderId`, `buyerName`, `buyerRequirements`, `orderAddedBy`, `orderCategory`, `orderCost`, `orderCurrency`, `orderDate`, `orderDeliveryDate`, `orderDescription`, `orderFloorNo`, `orderInternalComments`, `orderIsDeleted`, `orderLastUpdatedBy`, `orderLineNo`, `orderName`, `orderPriority`, `orderQuantity`, `orderSmv`) VALUES
(1, 'Russel', 'ffjhf', 'merchandiser', 'Shirt', 343547645453, 'USD', '20/08/2016', '8/25/2016', 'cghjjkgfhgfhjgkgdgghhjfy', 'BGL2', 'bla bla bla', 0, 'merchandiser', 'A3', 'bvfhjf', 'DFDGHDGH', 3245356, 34),
(2, 'Russel', 'fhjhjf', 'merchandiser', 'Shirt', 5435356, 'USD', '20/08/2016', '9/2/2016', 'gkjkmlkjfgh', 'BGL2', 'mfghfhj', 1, 'merchandiser', 'A3', 'hfhjgh', 'dgfhjfg', 43234, 23);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_users`
--

CREATE TABLE IF NOT EXISTS `tbl_users` (
`sl` int(4) NOT NULL,
  `user_id` varchar(20) NOT NULL,
  `password` varchar(40) NOT NULL,
  `user_type` int(2) NOT NULL,
  `isBlocked` int(2) NOT NULL,
  `addedBy` varchar(20) NOT NULL,
  `lastUpdatedBy` varchar(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_users`
--

INSERT INTO `tbl_users` (`sl`, `user_id`, `password`, `user_type`, `isBlocked`, `addedBy`, `lastUpdatedBy`) VALUES
(1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 8, 0, '', ''),
(2, 'hrmanager', 'cc501ce6cd4e21d3fa81134e6e2eed81', 7, 0, '', ''),
(3, 'merchandiser', 'a7dc4930adb43d6a892d95add61b8f1e', 1, 0, '', ''),
(4, 'indeng', 'c24d508b02a9a0e2444174d758a37d35', 3, 0, '', ''),
(5, 'quality', 'd66636b253cb346dbb6240e30def3618', 5, 0, '', ''),
(6, 'production', 'fd89784e59c72499525556f80289b2c7', 4, 0, '', ''),
(7, 'planner', '0273b494d66af726729c3817b9e194e3', 2, 0, '', ''),
(8, 'store', '8cd892b7b97ef9489ae4479d3f4ef0fc', 6, 0, '', ''),
(9, '3213', '60474c9c10d7142b7508ce7a50acf414', 1, 0, '', ''),
(10, '123', '4d42bf9c18cb04139f918ff0ae68f8a0', 2, 0, '', ''),
(11, '32472', 'e99a18c428cb38d5f260853678922e03', 3, 0, '', '');

-- --------------------------------------------------------

--
-- Table structure for table `ThreadConsumption`
--

CREATE TABLE IF NOT EXISTS `ThreadConsumption` (
`sl` int(11) NOT NULL,
  `wastage` double NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ThreadConsumption`
--

INSERT INTO `ThreadConsumption` (`sl`, `wastage`) VALUES
(1, 5);

-- --------------------------------------------------------

--
-- Table structure for table `ThreadConsumptionOperation`
--

CREATE TABLE IF NOT EXISTS `ThreadConsumptionOperation` (
`sl` int(11) NOT NULL,
  `operationName` varchar(255) DEFAULT NULL,
  `ratio` double NOT NULL,
  `seamLength` double NOT NULL,
  `stitchType` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ThreadConsumptionOperation`
--

INSERT INTO `ThreadConsumptionOperation` (`sl`, `operationName`, `ratio`, `seamLength`, `stitchType`) VALUES
(1, 'Operation1', 10, 28, 'CoverStitch_5thread_605');

-- --------------------------------------------------------

--
-- Table structure for table `ThreadConsumption_ThreadConsumptionOperation`
--

CREATE TABLE IF NOT EXISTS `ThreadConsumption_ThreadConsumptionOperation` (
  `ThreadConsumption_sl` int(11) NOT NULL,
  `operations_sl` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ThreadConsumption_ThreadConsumptionOperation`
--

INSERT INTO `ThreadConsumption_ThreadConsumptionOperation` (`ThreadConsumption_sl`, `operations_sl`) VALUES
(1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Buyer`
--
ALTER TABLE `Buyer`
 ADD PRIMARY KEY (`buyerName`);

--
-- Indexes for table `Consumption`
--
ALTER TABLE `Consumption`
 ADD PRIMARY KEY (`sl`), ADD KEY `FK_5dmejhoq53aimo6567ls82ri2` (`fabricConsumption_sl`), ADD KEY `FK_75g3w885d3u1xskqblj9u42a9` (`threadConsumption_sl`);

--
-- Indexes for table `FabricConsumption`
--
ALTER TABLE `FabricConsumption`
 ADD PRIMARY KEY (`sl`);

--
-- Indexes for table `FabricConsumptionComponents`
--
ALTER TABLE `FabricConsumptionComponents`
 ADD PRIMARY KEY (`sl`);

--
-- Indexes for table `FabricConsumption_FabricConsumptionComponents`
--
ALTER TABLE `FabricConsumption_FabricConsumptionComponents`
 ADD UNIQUE KEY `UK_h7s1740bh8wqgnhm5nedg6nce` (`components_sl`), ADD KEY `FK_xr26sw6e5ep6pxrgd8cs9ajf` (`FabricConsumption_sl`);

--
-- Indexes for table `tbl_employee`
--
ALTER TABLE `tbl_employee`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_order`
--
ALTER TABLE `tbl_order`
 ADD PRIMARY KEY (`orderId`);

--
-- Indexes for table `tbl_users`
--
ALTER TABLE `tbl_users`
 ADD PRIMARY KEY (`sl`), ADD UNIQUE KEY `user_id` (`user_id`);

--
-- Indexes for table `ThreadConsumption`
--
ALTER TABLE `ThreadConsumption`
 ADD PRIMARY KEY (`sl`);

--
-- Indexes for table `ThreadConsumptionOperation`
--
ALTER TABLE `ThreadConsumptionOperation`
 ADD PRIMARY KEY (`sl`);

--
-- Indexes for table `ThreadConsumption_ThreadConsumptionOperation`
--
ALTER TABLE `ThreadConsumption_ThreadConsumptionOperation`
 ADD UNIQUE KEY `UK_tmy6pkuq9jwwk5t4w7mmhtv47` (`operations_sl`), ADD KEY `FK_av79utqxdghiwsn6jhyt6q0e7` (`ThreadConsumption_sl`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Consumption`
--
ALTER TABLE `Consumption`
MODIFY `sl` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `FabricConsumption`
--
ALTER TABLE `FabricConsumption`
MODIFY `sl` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `FabricConsumptionComponents`
--
ALTER TABLE `FabricConsumptionComponents`
MODIFY `sl` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tbl_order`
--
ALTER TABLE `tbl_order`
MODIFY `orderId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tbl_users`
--
ALTER TABLE `tbl_users`
MODIFY `sl` int(4) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `ThreadConsumption`
--
ALTER TABLE `ThreadConsumption`
MODIFY `sl` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `ThreadConsumptionOperation`
--
ALTER TABLE `ThreadConsumptionOperation`
MODIFY `sl` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `Consumption`
--
ALTER TABLE `Consumption`
ADD CONSTRAINT `FK_5dmejhoq53aimo6567ls82ri2` FOREIGN KEY (`fabricConsumption_sl`) REFERENCES `FabricConsumption` (`sl`),
ADD CONSTRAINT `FK_75g3w885d3u1xskqblj9u42a9` FOREIGN KEY (`threadConsumption_sl`) REFERENCES `ThreadConsumption` (`sl`);

--
-- Constraints for table `FabricConsumption_FabricConsumptionComponents`
--
ALTER TABLE `FabricConsumption_FabricConsumptionComponents`
ADD CONSTRAINT `FK_h7s1740bh8wqgnhm5nedg6nce` FOREIGN KEY (`components_sl`) REFERENCES `FabricConsumptionComponents` (`sl`),
ADD CONSTRAINT `FK_xr26sw6e5ep6pxrgd8cs9ajf` FOREIGN KEY (`FabricConsumption_sl`) REFERENCES `FabricConsumption` (`sl`);

--
-- Constraints for table `ThreadConsumption_ThreadConsumptionOperation`
--
ALTER TABLE `ThreadConsumption_ThreadConsumptionOperation`
ADD CONSTRAINT `FK_av79utqxdghiwsn6jhyt6q0e7` FOREIGN KEY (`ThreadConsumption_sl`) REFERENCES `ThreadConsumption` (`sl`),
ADD CONSTRAINT `FK_tmy6pkuq9jwwk5t4w7mmhtv47` FOREIGN KEY (`operations_sl`) REFERENCES `ThreadConsumptionOperation` (`sl`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

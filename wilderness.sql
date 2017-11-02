-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 02, 2017 at 07:50 PM
-- Server version: 5.6.26
-- PHP Version: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `wilderness`
--

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `employee_id` int(11) NOT NULL,
  `employee_num` int(11) NOT NULL,
  `first_name` varchar(15) NOT NULL,
  `last_name` varchar(15) NOT NULL,
  `date_started` date NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`employee_id`, `employee_num`, `first_name`, `last_name`, `date_started`) VALUES
(1, 10000, 'Mark', 'Hamill', '1977-05-25'),
(2, 11223, 'Dakota', 'Nation', '2017-11-01'),
(3, 19932, 'Brad', 'Majors', '1975-09-25');

-- --------------------------------------------------------

--
-- Table structure for table `station`
--

CREATE TABLE IF NOT EXISTS `station` (
  `station_id` int(11) NOT NULL,
  `location` varchar(45) DEFAULT NULL,
  `date_added` date DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `station`
--

INSERT INTO `station` (`station_id`, `location`, `date_added`) VALUES
(1, 'New York', '2011-04-30'),
(2, 'Idaho', '2009-10-31'),
(3, 'Mississippi', '2007-10-01'),
(4, 'Tennessee', '2014-06-02'),
(5, 'Washington', '2014-06-02'),
(6, 'California', '2006-03-13'),
(7, 'California', '2013-07-02'),
(8, 'Texas', '2013-12-04'),
(9, 'Alabama', '2009-02-13'),
(10, 'Georgia', '2016-05-21');

-- --------------------------------------------------------

--
-- Table structure for table `station_detail`
--

CREATE TABLE IF NOT EXISTS `station_detail` (
  `stationID` int(11) NOT NULL,
  `wind_speed` varchar(45) DEFAULT NULL,
  `wind_direction` varchar(45) DEFAULT NULL,
  `ground_temp` varchar(45) DEFAULT NULL,
  `air_temp` varchar(45) DEFAULT NULL,
  `barometric_pressure` varchar(45) DEFAULT NULL,
  `rainfall` varchar(45) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `station_detail`
--

INSERT INTO `station_detail` (`stationID`, `wind_speed`, `wind_direction`, `ground_temp`, `air_temp`, `barometric_pressure`, `rainfall`) VALUES
(10, '3.4', '90.4', '10', '19', '769.3', '0');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL,
  `emp_num` int(11) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(12) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `emp_num`, `email`, `password`) VALUES
(1, 10000, 'mark.hamill@starwars.com', 'daddyissues6'),
(2, 11223, 'djnati6387@ung.edu', 'password1'),
(3, 19932, 'brad.majors@rockypictures.com', 'shocktreatme');

-- --------------------------------------------------------

--
-- Table structure for table `user_station`
--

CREATE TABLE IF NOT EXISTS `user_station` (
  `station_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_station`
--

INSERT INTO `user_station` (`station_id`, `user_id`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1),
(7, 1),
(8, 1),
(9, 1),
(10, 1),
(1, 2),
(2, 2),
(3, 2),
(4, 2),
(5, 2),
(6, 2),
(7, 2),
(8, 2),
(9, 2),
(10, 2),
(1, 3),
(2, 3),
(3, 3),
(4, 3),
(5, 3),
(6, 3),
(7, 3),
(8, 3),
(9, 3),
(10, 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`employee_id`,`employee_num`),
  ADD UNIQUE KEY `employee_id_UNIQUE` (`employee_id`),
  ADD UNIQUE KEY `employee_num_UNIQUE` (`employee_num`);

--
-- Indexes for table `station`
--
ALTER TABLE `station`
  ADD PRIMARY KEY (`station_id`);

--
-- Indexes for table `station_detail`
--
ALTER TABLE `station_detail`
  ADD PRIMARY KEY (`stationID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`,`emp_num`),
  ADD UNIQUE KEY `email_UNIQUE` (`email`),
  ADD UNIQUE KEY `emp_num_UNIQUE` (`emp_num`),
  ADD KEY `emp_num_idx` (`emp_num`);

--
-- Indexes for table `user_station`
--
ALTER TABLE `user_station`
  ADD PRIMARY KEY (`station_id`,`user_id`),
  ADD KEY `user_id_idx` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `employee_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `station`
--
ALTER TABLE `station`
  MODIFY `station_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `station_detail`
--
ALTER TABLE `station_detail`
  MODIFY `stationID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `station_detail`
--
ALTER TABLE `station_detail`
  ADD CONSTRAINT `stationid` FOREIGN KEY (`stationID`) REFERENCES `station` (`station_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `employee_number` FOREIGN KEY (`emp_num`) REFERENCES `employee` (`employee_num`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `user_station`
--
ALTER TABLE `user_station`
  ADD CONSTRAINT `station_id` FOREIGN KEY (`station_id`) REFERENCES `station` (`station_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

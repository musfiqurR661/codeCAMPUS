-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 04, 2023 at 04:44 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `musfiq`
--

-- --------------------------------------------------------

--
-- Table structure for table `allpost`
--

CREATE TABLE `allpost` (
  `id` int(11) NOT NULL,
  `post` varchar(3000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `allpost`
--

INSERT INTO `allpost` (`id`, `post`) VALUES
(1, 'md noman<separatorForUsername,Post,Link&PostType>dfgjdhgjdh<separatorForUsername,Post,Link&PostType>null<separatorForUsername,Post,Link&PostType>Query'),
(2, 'md noman<separatorForUsername,Post,Link&PostType>hghhjfhh\n\nkhljhk\nhgjhkjjhngh<separatorForUsername,Post,Link&PostType>null<separatorForUsername,Post,Link&PostType>Query'),
(3, 'md noman<separatorForUsername,Post,Link&PostType>fdggffg<separatorForUsername,Post,Link&PostType>null<separatorForUsername,Post,Link&PostType>Query'),
(4, 'md noman<separatorForUsername,Post,Link&PostType>hoy na re<separatorForUsername,Post,Link&PostType>null<separatorForUsername,Post,Link&PostType>Query'),
(5, 'Ajwad Akil<separatorForUsername,Post,Link&PostType>gdfhdgfhsdgv<separatorForUsername,Post,Link&PostType>link<separatorForUsername,Post,Link&PostType>ContestAnnouncement'),
(6, 'Ajwad Akil<separatorForUsername,Post,Link&PostType>kjhgfjhg\ngvshdvdsgf\ndfgdgfhsfvs\ngfjsdhgfjhgdsf\ndhhjfhsdgfjhsdgf\nhfjsdgfshjgf\nfjbjbjhb<separatorForUsername,Post,Link&PostType>fgjdsgfjgfjhsgfjdshfkdfjwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<separatorForUsername,Post,Link&PostType>Announcement'),
(7, 'md noman<separatorForUsername,Post,Link&PostType>fjhgfjh\nfdhgfshdgf\ndhufdsfg\nfdfhgdvf\nbfdsjhgfhf\nfjgjhfg\nffgdg<separatorForUsername,Post,Link&PostType>null<separatorForUsername,Post,Link&PostType>Query'),
(8, 'md noman<separatorForUsername,Post,Link&PostType>fdfvj vjvcvvdjvf\n<separatorForUsername,Post,Link&PostType>null<separatorForUsername,Post,Link&PostType>Query'),
(9, 'md noman<separatorForUsername,Post,Link&PostType>fjgvfhsgvgyfv\njhgg<separatorForUsername,Post,Link&PostType>null<separatorForUsername,Post,Link&PostType>Query'),
(10, 'Ajwad Akil<separatorForUsername,Post,Link&PostType>usdyfsdysvhvc<separatorForUsername,Post,Link&PostType>dssdbdsbvdd<separatorForUsername,Post,Link&PostType>ContestAnnouncement'),
(11, 'Ajwad Akil<separatorForUsername,Post,Link&PostType>fggsdgsdv<separatorForUsername,Post,Link&PostType>check<separatorForUsername,Post,Link&PostType>null'),
(12, 'md noman<separatorForUsername,Post,Link&PostType><separatorForUsername,Post,Link&PostType>null<separatorForUsername,Post,Link&PostType>Query'),
(13, 'md noman<separatorForUsername,Post,Link&PostType>hiii<separatorForUsername,Post,Link&PostType>null<separatorForUsername,Post,Link&PostType>Query'),
(14, 'Ajwad Akil<separatorForUsername,Post,Link&PostType>hiii<separatorForUsername,Post,Link&PostType><separatorForUsername,Post,Link&PostType>null');

-- --------------------------------------------------------

--
-- Table structure for table `messages`
--

CREATE TABLE `messages` (
  `Id` int(11) NOT NULL,
  `Message` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `messages`
--

INSERT INTO `messages` (`Id`, `Message`) VALUES
(1, 'md noman<separate>hi'),
(2, 'md noman<separate>hello'),
(3, 'md noman<separate>ki koro'),
(4, 'Musfq<separate>toh ajke dekhano jabe ui complete kore?'),
(5, 'Sharmin Sultana Liza<separate>kire tora ghumash nai ekhono..?...!!!!'),
(6, 'md noman<separate>ooohhhhh..'),
(7, 'Musfq<separate>seuii'),
(8, 'md noman<separate>hi'),
(9, 'Ajwad Akil<separate>hello'),
(10, 'Ajwad Akil<separate>hjlkhli'),
(11, 'md noman<separate>nggffgdjd'),
(12, 'md noman<separate>hi'),
(13, 'md noman<separate>hello'),
(14, 'Sharmin Sultana Liza<separate>fvdhfgshgsfd'),
(16, 'md noman<separate>uyiuyery'),
(17, 'Sharmin Sultana Liza<separate>fdhfg'),
(19, 'md noman<separate>hi'),
(20, 'md noman<separate>hello'),
(22, 'md noman<separate>dadfhfd'),
(23, 'md noman<separate>hfhjj'),
(24, 'md noman<separate>hfhf'),
(27, 'md noman<separate>hgfh'),
(29, 'md noman<separate>gfhgh'),
(31, 'md noman<separate>gfdg'),
(32, 'md noman<separate><null>'),
(33, 'md noman<separate>fsdfsd'),
(34, 'md noman<separate>fsdfsgfgsdf'),
(36, 'md noman<separate>gdfg'),
(37, 'md noman<separate>lllll'),
(38, 'Tarek Hasan<separate>hi'),
(39, 'Musfq<separate>hello'),
(40, 'md noman<separate>helllo'),
(41, 'Tarek Hasan<separate>hi'),
(42, 'Musfq<separate>hi'),
(43, 'md noman<separate>hi'),
(44, 'md noman<separate>Done'),
(45, 'md noman<separate>h');

-- --------------------------------------------------------

--
-- Table structure for table `useraccounts`
--

CREATE TABLE `useraccounts` (
  `id` int(11) NOT NULL,
  `fullName` text NOT NULL,
  `email` text NOT NULL,
  `username` text NOT NULL,
  `password` text NOT NULL,
  `userType` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `useraccounts`
--

INSERT INTO `useraccounts` (`id`, `fullName`, `email`, `username`, `password`, `userType`) VALUES
(7, 'bb', 'edr', 'reg', 'ss', 'Teacher'),
(8, 'Ajwad Akil', 'akil@gmail.com', 'azakil', '1122w', 'Teacher'),
(9, 'Musfq', 'aa', 'aa', '11', 'Student'),
(10, 'md noman', 'nm@gmail.com', 'nm', 'nm', 'Student'),
(11, 'Sharmin Sultana Liza', 'sharli@gmail.com', 'sharli', '123', 'Student'),
(12, 'Ajwad Akil', 'akil@gmail.com', 'akil', 'akil', 'Teacher'),
(13, 'Tarek Hasan', 'tarek@gmail.com', 'tarek', 'tarek', 'Teacher'),
(14, 'Rafsan Ahmed Tarek', 'tarekrahman01@gmail.com', 'rafsan', 'rafsan', 'Student'),
(15, 'rakib', 'rakib@gmail.com', 'rakib', 'rakib', 'Student'),
(16, 'Tashin Parvez', 'tashin@gmail.com', 'tashin', 'tashin', 'Student');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `allpost`
--
ALTER TABLE `allpost`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `messages`
--
ALTER TABLE `messages`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `useraccounts`
--
ALTER TABLE `useraccounts`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `allpost`
--
ALTER TABLE `allpost`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `messages`
--
ALTER TABLE `messages`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- AUTO_INCREMENT for table `useraccounts`
--
ALTER TABLE `useraccounts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

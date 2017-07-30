-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 30, 2017 at 06:48 AM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `makeawish`
--

-- --------------------------------------------------------

--
-- Table structure for table `children`
--

CREATE TABLE `children` (
  `id` int(10) UNSIGNED NOT NULL,
  `aadhar_id` int(11) NOT NULL,
  `hospital_name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `case_no` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `illness` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `children`
--

INSERT INTO `children` (`id`, `aadhar_id`, `hospital_name`, `case_no`, `illness`, `status`, `created_at`, `updated_at`) VALUES
(3, 2354443, 'Lilavati', '1a', 'Leukemia', 'Referred', '2017-07-29 17:44:04', '2017-07-29 17:44:04'),
(4, 2354445, 'Tata', '1b', 'Cancer', 'Referred', '2017-07-29 17:44:33', '2017-07-29 17:44:33');

-- --------------------------------------------------------

--
-- Table structure for table `childs`
--

CREATE TABLE `childs` (
  `id` int(10) UNSIGNED NOT NULL,
  `aadhar_id` int(11) NOT NULL,
  `hospital_name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `case_no` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `illness` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `coments`
--

CREATE TABLE `coments` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `donations`
--

CREATE TABLE `donations` (
  `id` int(10) UNSIGNED NOT NULL,
  `user_id` int(11) NOT NULL,
  `amount` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `donations`
--

INSERT INTO `donations` (`id`, `user_id`, `amount`, `created_at`, `updated_at`) VALUES
(2, 1, '1000', '2017-07-29 14:48:57', '2017-07-29 14:48:57'),
(3, 3, '100', '2017-07-29 14:52:38', '2017-07-29 14:52:38'),
(4, 1, '100', '2017-07-29 15:06:55', '2017-07-29 15:06:55'),
(5, 3, '200', '2017-07-29 15:14:20', '2017-07-29 15:14:20'),
(6, 1, '5000000', '2017-07-29 17:01:04', '2017-07-29 17:01:04'),
(7, 3, '20', '2017-07-29 17:01:35', '2017-07-29 17:01:35');

-- --------------------------------------------------------

--
-- Table structure for table `migrations`
--

CREATE TABLE `migrations` (
  `id` int(10) UNSIGNED NOT NULL,
  `migration` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `migrations`
--

INSERT INTO `migrations` (`id`, `migration`, `batch`) VALUES
(1, '2014_10_12_000000_create_users_table', 1),
(2, '2014_10_12_100000_create_password_resets_table', 1),
(3, '2016_01_01_193651_create_roles_permissions_tables', 2),
(4, '2017_07_29_195908_create_donations_table', 3),
(5, '2017_07_29_212121_create_coments_table', 4),
(6, '2017_07_29_214251_create_children_table', 5),
(7, '2017_07_29_214324_create_childs_table', 5),
(8, '2017_07_29_215725_create_wishs_table', 6);

-- --------------------------------------------------------

--
-- Table structure for table `password_resets`
--

CREATE TABLE `password_resets` (
  `email` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `token` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `permissions`
--

CREATE TABLE `permissions` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `label` varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `permissions`
--

INSERT INTO `permissions` (`id`, `name`, `label`, `created_at`, `updated_at`) VALUES
(1, 'refer_child', 'refer_child', '2017-07-29 14:20:24', '2017-07-29 14:20:24');

-- --------------------------------------------------------

--
-- Table structure for table `permission_role`
--

CREATE TABLE `permission_role` (
  `permission_id` int(10) UNSIGNED NOT NULL,
  `role_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `label` varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`id`, `name`, `label`, `created_at`, `updated_at`) VALUES
(1, 'doctor', 'doctor', '2017-07-29 14:19:44', '2017-07-29 14:19:44'),
(2, 'volunteer', 'volunteer', '2017-07-29 14:19:58', '2017-07-29 14:19:58'),
(3, 'donor', 'donor', '2017-07-29 14:20:06', '2017-07-29 14:20:06'),
(4, 'admin', 'admin', '2017-07-29 14:21:23', '2017-07-29 14:21:23');

-- --------------------------------------------------------

--
-- Table structure for table `role_user`
--

CREATE TABLE `role_user` (
  `role_id` int(10) UNSIGNED NOT NULL,
  `user_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `role_user`
--

INSERT INTO `role_user` (`role_id`, `user_id`) VALUES
(1, 2),
(2, 3),
(3, 4),
(3, 5),
(3, 6),
(4, 1);

-- --------------------------------------------------------

--
-- Table structure for table `smss`
--

CREATE TABLE `smss` (
  `name` varchar(10) NOT NULL,
  `mobile` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `smss`
--

INSERT INTO `smss` (`name`, `mobile`) VALUES
('vol1', '8108894824'),
('vol1', '8898342418');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `remember_token` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`, `remember_token`, `created_at`, `updated_at`) VALUES
(1, 'admin', 'admin@gmail.com', '$2y$10$pdFDbbUZkQorFclVwIFpUeIPNN7uhFnJP23LwPl72xMU18i68zpYu', 'D2SVjTZLlM0E1yWAiMw9FMU0QJcW3ZscCxCtAVJqbOcakvwpixhqurIP0meu', '2017-07-29 14:17:22', '2017-07-29 14:21:30'),
(2, 'doctor', 'doctor@gmail.com', '$2y$10$ee.CGlqEt9lidCK3LREzwOkOdRh.1uXGFHbjgk6VBI4hvi/YnHAHi', '1zZM1EukOdLfzfFZBmDE6THYvwoHwveQtGzNFAGIZeUF3oKuww7kugGtzbEa', '2017-07-29 14:18:14', '2017-07-29 14:21:36'),
(3, 'volunteer', 'volunteer@gmail.com', '$2y$10$Me1DTOEP2dW8mxYAS2ZUA.8gvXyZ1lRUPAdM9ebEfJUIZD4yFy/si', 'xPzFK2FKreET0y4jy38qcJ7TU9PWhvQsA7P8iE0OvUHHROHfHj3u8VsSUDOO', '2017-07-29 14:21:02', '2017-07-29 16:22:33'),
(4, 'donor1', 'user1@gmail.com', '$2y$10$V.eBgkSRaIuaTztiIvQLmOLC.SGCbwcUHvd8nEygDL5zaxjHopOcC', NULL, '2017-07-29 14:25:53', '2017-07-29 14:25:53'),
(5, 'donor2', 'donor2@gmail.com', '$2y$10$XkUxAqXIg3VImNXFEO3ShOsOtaOo7/.oPVpZGvjhyRtF1KIibum32', NULL, '2017-07-29 14:26:11', '2017-07-29 17:12:34'),
(6, 'donor3', 'donor3@gmail.com', '$2y$10$Gcrf5hfEdZjDNbrzFz8sI.Dt/EzQx8owl//5WdYjupHjQOyxcKgL6', NULL, '2017-07-29 14:26:29', '2017-07-29 14:26:29');

-- --------------------------------------------------------

--
-- Table structure for table `wishs`
--

CREATE TABLE `wishs` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `details` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `wish1` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `wish2` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `wish3` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `wish1_type` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `wish2_type` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `wish3_type` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `wishs`
--

INSERT INTO `wishs` (`id`, `name`, `details`, `wish1`, `wish2`, `wish3`, `wish1_type`, `wish2_type`, `wish3_type`, `created_at`, `updated_at`) VALUES
(2, '342543251', 'Child is excited, and want to go to Goa', 'Get a Doll', 'Go to Goa', 'Meet Sachin', '', '', '', '2017-07-29 18:20:15', '2017-07-29 18:20:15'),
(3, '5312867', 'Want to see a movie', 'to meet XYZ', 'to see Aish', 'to go to US', 'to meet', 'to see', 'to go', '2017-07-29 19:31:49', '2017-07-29 19:31:49');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `children`
--
ALTER TABLE `children`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `childs`
--
ALTER TABLE `childs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `coments`
--
ALTER TABLE `coments`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `donations`
--
ALTER TABLE `donations`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `migrations`
--
ALTER TABLE `migrations`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `password_resets`
--
ALTER TABLE `password_resets`
  ADD KEY `password_resets_email_index` (`email`);

--
-- Indexes for table `permissions`
--
ALTER TABLE `permissions`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `permission_role`
--
ALTER TABLE `permission_role`
  ADD PRIMARY KEY (`permission_id`,`role_id`),
  ADD KEY `permission_role_role_id_foreign` (`role_id`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `role_user`
--
ALTER TABLE `role_user`
  ADD PRIMARY KEY (`role_id`,`user_id`),
  ADD KEY `role_user_user_id_foreign` (`user_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `users_email_unique` (`email`);

--
-- Indexes for table `wishs`
--
ALTER TABLE `wishs`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `children`
--
ALTER TABLE `children`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `childs`
--
ALTER TABLE `childs`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `coments`
--
ALTER TABLE `coments`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `donations`
--
ALTER TABLE `donations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `migrations`
--
ALTER TABLE `migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `permissions`
--
ALTER TABLE `permissions`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `wishs`
--
ALTER TABLE `wishs`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `permission_role`
--
ALTER TABLE `permission_role`
  ADD CONSTRAINT `permission_role_permission_id_foreign` FOREIGN KEY (`permission_id`) REFERENCES `permissions` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `permission_role_role_id_foreign` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `role_user`
--
ALTER TABLE `role_user`
  ADD CONSTRAINT `role_user_role_id_foreign` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `role_user_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
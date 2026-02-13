/*
 Navicat Premium Dump SQL

 Source Server         : DB Lokal
 Source Server Type    : MySQL
 Source Server Version : 100131 (10.1.31-MariaDB)
 Source Host           : localhost:3306
 Source Schema         : sik_nirwana

 Target Server Type    : MySQL
 Target Server Version : 100131 (10.1.31-MariaDB)
 File Encoding         : 65001

 Date: 13/02/2026 22:38:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for antrian_informasi
-- ----------------------------
DROP TABLE IF EXISTS `antrian_informasi`;
CREATE TABLE `antrian_informasi`  (
  `kode` int NOT NULL AUTO_INCREMENT,
  `url_video_player` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `kalimat` longtext CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `url_playlist` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `shutdown_tv_antrian` time NULL DEFAULT NULL,
  `lokasi_file_video` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`kode`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of antrian_informasi
-- ----------------------------
INSERT INTO `antrian_informasi` VALUES (1, 'https://www.youtube.com/watch?v=SsfMCN4uOoA&list=PLawLjelFQXJG97TGXnOoL57lXnPOpzHeL', ' Selamat datang di RSU Nirwana Banjarbaru. Silakan menunggu nomor antrian Anda dipanggil sesuai poliklinik tujuan. Mohon menjaga ketertiban dan kebersihan. Semoga Bapak/Ibu yang sedang menjalani pemeriksaan maupun pengobatan senantiasa diberikan kesehatan, kesembuhan, dan kemudahan dalam setiap proses pelayanan. Terima kasih atas kesabaran dan kepercayaan Anda kepada layanan kami.', 'https://www.youtube.com/watch?v=SsfMCN4uOoA&list=PLawLjelFQXJG97TGXnOoL57lXnPOpzHeL', '00:00:00', '/home/bibing/Videos/Vidio Edukasi Kesehatan.mp4');

SET FOREIGN_KEY_CHECKS = 1;

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for rc_admin
-- ----------------------------
DROP TABLE IF EXISTS `rc_admin`;
CREATE TABLE `rc_admin`  (
  `admin_id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `admin_username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `admin_password` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `admin_privilege` int(0) NOT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE,
  UNIQUE INDEX `idx_admin_username`(`admin_username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rc_admin
-- ----------------------------
INSERT INTO `rc_admin` VALUES (1, 'admin', '123456', 255);

-- ----------------------------
-- Table structure for rc_class
-- ----------------------------
DROP TABLE IF EXISTS `rc_class`;
CREATE TABLE `rc_class`  (
  `class_id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `class_major_id` int(0) UNSIGNED NOT NULL,
  `class_grade` int(0) UNSIGNED NOT NULL,
  `class_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`class_id`) USING BTREE,
  INDEX `fk_major_id`(`class_major_id`) USING BTREE,
  INDEX `idx_class_name`(`class_name`) USING BTREE,
  CONSTRAINT `rc_class_ibfk_1` FOREIGN KEY (`class_major_id`) REFERENCES `rc_major` (`major_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rc_class
-- ----------------------------
INSERT INTO `rc_class` VALUES (1, 1, 2023, '计科2301班');

-- ----------------------------
-- Table structure for rc_course
-- ----------------------------
DROP TABLE IF EXISTS `rc_course`;
CREATE TABLE `rc_course`  (
  `course_id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `course_teacher_id` int(0) UNSIGNED NOT NULL,
  `course_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course_grade` int(0) UNSIGNED NOT NULL,
  `course_time` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course_location` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course_credit` int(0) UNSIGNED NOT NULL,
  `course_selected_count` int(0) UNSIGNED NOT NULL DEFAULT 0,
  `course_max_size` int(0) UNSIGNED NOT NULL,
  `course_exam_date` datetime NULL DEFAULT NULL,
  `course_exam_location` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`course_id`) USING BTREE,
  INDEX `fk_course_teacher_id`(`course_teacher_id`) USING BTREE,
  INDEX `idx_course_name`(`course_name`) USING BTREE,
  CONSTRAINT `rc_course_ibfk_1` FOREIGN KEY (`course_teacher_id`) REFERENCES `rc_teacher` (`teacher_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rc_course
-- ----------------------------
INSERT INTO `rc_course` VALUES (9, 1, 'Java程序设计', 2023, '2-2-2', '第一教学楼201', 2, 1, 50, NULL, '第一教学楼201');
INSERT INTO `rc_course` VALUES (10, 1, '计算机组成原理', 2023, '3-5-2', '第二教学楼502', 2, 0, 50, NULL, '第二教学楼502');
INSERT INTO `rc_course` VALUES (11, 1, '计算机网络', 2023, '5-3-2', '第一教学楼202', 2, 1, 50, NULL, '第一教学楼202');

-- ----------------------------
-- Table structure for rc_department
-- ----------------------------
DROP TABLE IF EXISTS `rc_department`;
CREATE TABLE `rc_department`  (
  `department_id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `department_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`department_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rc_department
-- ----------------------------
INSERT INTO `rc_department` VALUES (1, '计算机系');
INSERT INTO `rc_department` VALUES (2, '数学系');
INSERT INTO `rc_department` VALUES (3, '物理系');
INSERT INTO `rc_department` VALUES (4, '化学系');

-- ----------------------------
-- Table structure for rc_major
-- ----------------------------
DROP TABLE IF EXISTS `rc_major`;
CREATE TABLE `rc_major`  (
  `major_id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `major_department_id` int(0) UNSIGNED NOT NULL,
  `major_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`major_id`) USING BTREE,
  INDEX `fk_major_department_id`(`major_department_id`) USING BTREE,
  INDEX `idx_major_name`(`major_name`) USING BTREE,
  CONSTRAINT `rc_major_ibfk_1` FOREIGN KEY (`major_department_id`) REFERENCES `rc_department` (`department_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rc_major
-- ----------------------------
INSERT INTO `rc_major` VALUES (1, 1, '计算机科学与技术');
INSERT INTO `rc_major` VALUES (2, 1, '软件工程');
INSERT INTO `rc_major` VALUES (3, 1, '信息工程');
INSERT INTO `rc_major` VALUES (4, 2, '应用数学');
INSERT INTO `rc_major` VALUES (5, 2, '数学师范');

-- ----------------------------
-- Table structure for rc_option
-- ----------------------------
DROP TABLE IF EXISTS `rc_option`;
CREATE TABLE `rc_option`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `option_key` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '枚举键',
  `option_value` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '枚举值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rc_option
-- ----------------------------
INSERT INTO `rc_option` VALUES (1, 'ALLOW_STUDENT_SELECT', 'true');
INSERT INTO `rc_option` VALUES (2, 'ALLOW_TEACHER_GRADE', 'true');

-- ----------------------------
-- Table structure for rc_student
-- ----------------------------
DROP TABLE IF EXISTS `rc_student`;
CREATE TABLE `rc_student`  (
  `student_id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `student_class_id` int(0) UNSIGNED NOT NULL,
  `student_number` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `student_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `student_password` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `student_email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `student_birthday` datetime NULL DEFAULT NULL,
  `student_sex` tinyint(0) UNSIGNED NOT NULL,
  `student_last_login_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`student_id`) USING BTREE,
  UNIQUE INDEX `idx_student_number`(`student_number`) USING BTREE,
  INDEX `fk_student_class_id`(`student_class_id`) USING BTREE,
  INDEX `idx_student_name`(`student_name`) USING BTREE,
  CONSTRAINT `rc_student_ibfk_1` FOREIGN KEY (`student_class_id`) REFERENCES `rc_class` (`class_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rc_student
-- ----------------------------
INSERT INTO `rc_student` VALUES (1, 1, '202307300101', '李四', '123456', '123@qq.com', '1998-08-19 00:00:00', 0, '2023-10-18 18:31:33');

-- ----------------------------
-- Table structure for rc_student_course
-- ----------------------------
DROP TABLE IF EXISTS `rc_student_course`;
CREATE TABLE `rc_student_course`  (
  `sc_id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `sc_student_id` int(0) UNSIGNED NOT NULL,
  `sc_course_id` int(0) UNSIGNED NOT NULL,
  `sc_daily_score` int(0) UNSIGNED NULL DEFAULT NULL,
  `sc_exam_score` int(0) UNSIGNED NULL DEFAULT NULL,
  `sc_score` int(0) UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`sc_id`) USING BTREE,
  INDEX `fk_sc_course_id`(`sc_course_id`) USING BTREE,
  INDEX `fk_sc_student_id`(`sc_student_id`) USING BTREE,
  CONSTRAINT `rc_student_course_ibfk_1` FOREIGN KEY (`sc_course_id`) REFERENCES `rc_course` (`course_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `rc_student_course_ibfk_2` FOREIGN KEY (`sc_student_id`) REFERENCES `rc_student` (`student_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rc_student_course
-- ----------------------------
INSERT INTO `rc_student_course` VALUES (23, 1, 9, 40, 55, 95);
INSERT INTO `rc_student_course` VALUES (28, 1, 11, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for rc_teacher
-- ----------------------------
DROP TABLE IF EXISTS `rc_teacher`;
CREATE TABLE `rc_teacher`  (
  `teacher_id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `teacher_department_id` int(0) UNSIGNED NOT NULL,
  `teacher_number` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `teacher_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `teacher_password` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`teacher_id`) USING BTREE,
  UNIQUE INDEX `idx_teacher_number`(`teacher_number`) USING BTREE,
  INDEX `fk_teacher_department_id`(`teacher_department_id`) USING BTREE,
  CONSTRAINT `rc_teacher_ibfk_1` FOREIGN KEY (`teacher_department_id`) REFERENCES `rc_department` (`department_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rc_teacher
-- ----------------------------
INSERT INTO `rc_teacher` VALUES (1, 1, '202307300201', '张三', '123456');

SET FOREIGN_KEY_CHECKS = 1;

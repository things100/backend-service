CREATE TABLE `fustack_user`
(
    `id`        int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `nick_name` VARCHAR(255)  DEFAULT NULL COMMENT '昵称',
    `real_name` VARCHAR(255)  DEFAULT NULL COMMENT '真实姓名',
    `mobile`    VARCHAR(11)   DEFAULT NULL COMMENT '手机号',
    `password`  VARCHAR(255)  DEFAULT NULL COMMENT '密码',
    `email`     VARCHAR(255)  DEFAULT NULL COMMENT '邮箱',
    `avatar`    VARCHAR(1000) DEFAULT NULL COMMENT '头像',
    `birthday`  date          DEFAULT NULL COMMENT '生日',
    `gender`    tinyint       DEFAULT 0 COMMENT '性别;0=未知,1=男,2=女',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户表';

ALTER TABLE `fustack_user`
    ADD COLUMN `create_by`        int(11)  NOT NULL COMMENT '创建者',
    ADD COLUMN `create_date_time` DATETIME NOT NULL COMMENT '创建时间',
    ADD COLUMN `updated_by`       int(11)  DEFAULT NULL COMMENT '修改人',
    ADD COLUMN `update_date_time` DATETIME DEFAULT NULL COMMENT '最后修改时间';
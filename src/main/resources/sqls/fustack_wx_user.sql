CREATE TABLE `fustack_wx_user`
(
    `id`               int(11)      NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_id`          int(11)      NOT NULL COMMENT '用户主键',
    `mini_open_id`     varchar(255) NOT NULL COMMENT '微信小程序openId',
    `create_by`        int(11)      NOT NULL COMMENT '创建者',
    `create_date_time` DATETIME     NOT NULL COMMENT '创建时间',
    `updated_by`       int(11)  DEFAULT NULL COMMENT '修改人',
    `update_date_time` DATETIME DEFAULT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='微信用户关联表';
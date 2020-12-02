CREATE TABLE `fustack_thing_group_user`
(
    `id`               INT(11)  NOT NULL AUTO_INCREMENT COMMENT '主键',

    `user_id`          INT(11)  NOT NULL COMMENT '用户ID',
    `group_id`         INT(11)  NOT NULL COMMENT '分组ID',

    `delete_status`    tinyint  NOT NULL DEFAULT 1 COMMENT '删除状态，1=未删除，0=已删除',
    `create_by`        int(11)  NOT NULL COMMENT '创建者',
    `create_date_time` DATETIME NOT NULL COMMENT '创建时间',
    `updated_by`       int(11)           DEFAULT NULL COMMENT '修改人',
    `update_date_time` DATETIME          DEFAULT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='事情分组与用户关联表';
CREATE TABLE `fustack_thing`
(
    `id`               INT(11)     NOT NULL AUTO_INCREMENT COMMENT '主键',

    `thing_group_id`   INT(11)     NOT NULL COMMENT '所属分组ID',
    `title`            VARCHAR(52) NOT NULL COMMENT '标题',
    `sort_num`         tinyint     NOT NULL COMMENT '顺序',
    `user_id`          INT(11)     NOT NULL COMMENT '用户ID',
    `complete_date`    DATETIME             DEFAULT NULL COMMENT '完成时间',
    `complete`         BIT                  DEFAULT 0 COMMENT '是否完成',

    `delete_status`    tinyint     NOT NULL DEFAULT 1 COMMENT '删除状态，1=未删除，0=已删除',
    `create_by`        int(11)     NOT NULL COMMENT '创建者',
    `create_date_time` DATETIME    NOT NULL COMMENT '创建时间',
    `updated_by`       int(11)              DEFAULT NULL COMMENT '修改人',
    `update_date_time` DATETIME             DEFAULT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='事情项';
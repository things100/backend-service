CREATE TABLE `fustack_test`
(
    `id`               int(11)  NOT NULL AUTO_INCREMENT COMMENT '主键',
    `col1`             varchar(255),
    `col2`             varchar(255),
    `col3`             varchar(255),
    `col4`             varchar(255),
    `col5`             varchar(255),
    `gender`           tinyint  DEFAULT 0 COMMENT '性别;0=未知,1=男,2=女',
    `create_by`        int(11)  NOT NULL COMMENT '创建者',
    `create_date_time` DATETIME NOT NULL COMMENT '创建时间',
    `updated_by`       int(11)  DEFAULT NULL COMMENT '修改人',
    `update_date_time` DATETIME DEFAULT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='测试表';

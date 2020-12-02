package com.futao.springbootservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.futao.springbootservice.entity.ThingGroupUser;
import com.futao.springbootservice.model.result.GroupUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author futao
 * @date 2020/12/2
 */
public interface ThingGroupUserMapper extends BaseMapper<ThingGroupUser> {

    List<GroupUser> selectUserByGroupId(@Param("groupId") Long groupId);
}

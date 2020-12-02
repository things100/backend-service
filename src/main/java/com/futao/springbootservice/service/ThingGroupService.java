package com.futao.springbootservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.futao.springbootservice.controller.things100.ThingGroupController;
import com.futao.springbootservice.entity.ThingGroup;
import com.futao.springbootservice.model.result.GroupUser;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author futao
 * @date 2020/12/2
 */
public interface ThingGroupService {
    @Transactional(rollbackFor = Exception.class)
    void add(ThingGroupController.AddBody addBody);

    Page<ThingGroup> page(long page, long perPage);

    void delete(Long id);

    List<GroupUser> groupMembers(Long groupId);

    void invite(ThingGroupController.JoinBody body);
}

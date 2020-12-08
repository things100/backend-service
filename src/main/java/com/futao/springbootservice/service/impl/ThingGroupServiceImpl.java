package com.futao.springbootservice.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.futao.springbootservice.controller.things100.ThingGroupController;
import com.futao.springbootservice.entity.ThingGroup;
import com.futao.springbootservice.entity.ThingGroupUser;
import com.futao.springbootservice.entity.enums.DeleteStatusEnum;
import com.futao.springbootservice.mapper.ThingGroupMapper;
import com.futao.springbootservice.mapper.ThingGroupUserMapper;
import com.futao.springbootservice.model.result.GroupUser;
import com.futao.springbootservice.service.ThingGroupService;
import com.futao.springbootservice.utils.TimeUtil;
import com.futao.starter.fustack.auth.threadlocals.CurrentUserId;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author futao
 * @date 2020/12/2
 */
@Service
public class ThingGroupServiceImpl implements ThingGroupService {

    @Resource
    private ThingGroupMapper groupMapper;

    @Resource
    private ThingGroupUserMapper groupUserMapper;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(ThingGroupController.AddBody addBody) {
        ThingGroup thingGroupEntity = ThingGroup.builder()
                .deleteStatus(DeleteStatusEnum.NORMAL.getValue())
                .title(addBody.getTitle())
                .description(addBody.getDescription())
                .cover(addBody.getCover())
                .coverType(addBody.getCoverType())
                .open(addBody.isOpen())
                .build();
        groupMapper.insert(thingGroupEntity);
        groupUserMapper.insert(ThingGroupUser.builder()
                .userId(CurrentUserId.get())
                .groupId(thingGroupEntity.getId())
                .deleteStatus(DeleteStatusEnum.NORMAL.getValue())
                .build());
    }

    @Override
    public Page<ThingGroup> page(long page, long perPage) {

        Set<Long> groupIdSet = groupUserMapper.selectList(Wrappers.<ThingGroupUser>lambdaQuery()
                .select(ThingGroupUser::getGroupId)
                .eq(ThingGroupUser::getUserId, CurrentUserId.get())
                .eq(ThingGroupUser::getDeleteStatus, DeleteStatusEnum.NORMAL.getValue())
        ).stream()
                .map(ThingGroupUser::getGroupId)
                .collect(Collectors.toSet());

        if (CollectionUtils.isNotEmpty(groupIdSet)) {
            return groupMapper.selectPage(new Page<>(page, perPage)
                    , Wrappers.<ThingGroup>lambdaQuery()
                            .in(ThingGroup::getId, groupIdSet)
                            .eq(ThingGroup::getDeleteStatus, DeleteStatusEnum.NORMAL.getValue())
                            .orderByDesc(ThingGroup::getCreateDateTime)
            );
        }
        return new Page<>(page, perPage);
    }

    @Override
    public void delete(Long id) {
        groupMapper.update(null, Wrappers.<ThingGroup>lambdaUpdate()
                .set(ThingGroup::getDeleteStatus, DeleteStatusEnum.DELETED.getValue())
                .set(ThingGroup::getUpdateDateTime, TimeUtil.currentDateTime())
                .set(ThingGroup::getUpdatedBy, CurrentUserId.get())
                .eq(ThingGroup::getId, id)
                .eq(ThingGroup::getCreateBy, CurrentUserId.get())
        );
    }

    @Override
    public List<GroupUser> groupMembers(Long groupId) {
        return groupUserMapper.selectUserByGroupId(groupId);
    }

    @Override
    public void invite(ThingGroupController.JoinBody body) {
        ThingGroupUser thingGroupUser = groupUserMapper.selectOne(Wrappers.<ThingGroupUser>lambdaQuery()
                .eq(ThingGroupUser::getUserId, CurrentUserId.get())
                .eq(ThingGroupUser::getGroupId, body.getGroupId())
        );
        if (thingGroupUser == null) {
            ThingGroupUser thingGroupUserEntity = ThingGroupUser.builder()
                    .userId(CurrentUserId.get())
                    .groupId(body.getGroupId())
                    .inviteByUserId(body.getInviteUserId())
                    .deleteStatus(DeleteStatusEnum.NORMAL.getValue())
                    .build();
            groupUserMapper.insert(thingGroupUserEntity);
        } else {
            thingGroupUser.setInviteByUserId(body.getInviteUserId());
            thingGroupUser.setDeleteStatus(DeleteStatusEnum.NORMAL.getValue());
            groupUserMapper.update(thingGroupUser, null);
        }
    }
}

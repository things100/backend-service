package com.futao.springbootservice.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.futao.springbootservice.controller.things100.ThingController;
import com.futao.springbootservice.entity.Thing;
import com.futao.springbootservice.entity.ThingGroup;
import com.futao.springbootservice.entity.enums.DeleteStatusEnum;
import com.futao.springbootservice.mapper.ThingGroupMapper;
import com.futao.springbootservice.mapper.ThingMapper;
import com.futao.springbootservice.service.ThingService;
import com.futao.springbootservice.utils.TimeUtil;
import com.futao.starter.fustack.auth.threadlocals.CurrentUserId;
import com.futao.starter.fustack.db.IdTimeEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author futao
 * @date 2020/12/8
 */
@Service
public class ThingServiceImpl implements ThingService {

    @Resource
    private ThingMapper thingMapper;

    @Resource
    private ThingGroupMapper groupMapper;

    @Override
    public Page<Thing> list(int page, int perPage, long thingGroupId) {
        // TODO: 2020/12/8 权限控制
        return thingMapper.selectPage(new Page<>(page, perPage), Wrappers.<Thing>lambdaQuery()
                .eq(Thing::getThingGroupId, thingGroupId)
                .eq(Thing::getDeleteStatus, DeleteStatusEnum.NORMAL.getValue())
                .orderByAsc(Thing::getSortNum)
        );
    }

    @Override
    public ThingController.GroupWithThings pageWithGroup(int page, int perPage, long thingGroupId) {
        return new ThingController.GroupWithThings(groupMapper.selectById(thingGroupId),
                thingMapper.selectPage(new Page<>(page, perPage), Wrappers.<Thing>lambdaQuery()
                        .eq(Thing::getThingGroupId, thingGroupId)
                        .eq(Thing::getDeleteStatus, DeleteStatusEnum.NORMAL.getValue())
                        .orderByAsc(Thing::getSortNum)
                ));
    }

    @Override
    public void add(ThingController.AddBody addBody) {
        thingMapper.insert(Thing.builder()
                .title(addBody.getTitle())
                .complete(false)
                .deleteStatus(DeleteStatusEnum.NORMAL.getValue())
                .sortNum(addBody.getSortNum())
                .userId(CurrentUserId.get())
                .thingGroupId(addBody.getThingGroupId())
                .build());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean complete(ThingController.UpdateCompleteBody body) {
        // TODO: 2020/12/8 权限控制
        thingMapper.update(null, Wrappers.<Thing>lambdaUpdate()
                .eq(Thing::getId, body.getId())
                .set(Thing::isComplete, body.isComplete())
                .set(body.isComplete(), Thing::getCompleteDate, TimeUtil.currentDateTime())
                .set(IdTimeEntity::getUpdatedBy, CurrentUserId.get())
                .set(IdTimeEntity::getUpdateDateTime, TimeUtil.currentDateTime())
        );
        Thing thing = thingMapper.selectById(body.getId());
        boolean isThingGroupComplete = !thingMapper.selectList(Wrappers.<Thing>lambdaQuery()
                .select(Thing::isComplete)
                .eq(Thing::getDeleteStatus, DeleteStatusEnum.NORMAL.getValue())
                .eq(Thing::getThingGroupId, thing.getThingGroupId())
        ).stream()
                .map(Thing::isComplete)
                .collect(Collectors.toSet())
                .contains(Boolean.FALSE);
        if (isThingGroupComplete) {
            // 都完成了
            groupMapper.update(null, Wrappers.<ThingGroup>lambdaUpdate()
                    .eq(ThingGroup::getId, thing.getThingGroupId())
                    .set(ThingGroup::isComplete, true)
                    .set(ThingGroup::getCompleteDate, TimeUtil.currentDateTime())
            );
        }
        return isThingGroupComplete;
    }

    @Override
    public double completePercent(Long groupId) {
        List<Thing> things = thingMapper.selectList(Wrappers.<Thing>lambdaQuery()
                .select(Thing::isComplete)
                .eq(Thing::getThingGroupId, groupId)
                .eq(Thing::getDeleteStatus, DeleteStatusEnum.NORMAL.getValue())
        );
        return (int) things.stream().filter(Thing::isComplete).count() / ((double) things.size());
    }
}

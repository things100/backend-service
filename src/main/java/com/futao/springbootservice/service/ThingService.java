package com.futao.springbootservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.futao.springbootservice.controller.things100.ThingController;
import com.futao.springbootservice.entity.Thing;

/**
 * @author futao
 * @date 2020/12/8
 */
public interface ThingService {
    Page<Thing> list(int page, int perPage, long thingGroupId);

    ThingController.GroupWithThings pageWithGroup(int page, int perPage, long thingGroupId);

    void add(ThingController.AddBody addBody);

    boolean complete(ThingController.UpdateCompleteBody body);

    double completePercent(Long groupId);
}

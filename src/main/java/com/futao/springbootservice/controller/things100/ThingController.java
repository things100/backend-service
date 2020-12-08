package com.futao.springbootservice.controller.things100;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.futao.springbootservice.entity.Thing;
import com.futao.springbootservice.entity.ThingGroup;
import com.futao.springbootservice.service.ThingService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author futao
 * @date 2020/12/8
 */
@RestController
@RequestMapping("/thing")
public class ThingController {

    @Autowired
    private ThingService thingService;


    @PostMapping
    public void add(
            @RequestBody ThingController.AddBody addBody
    ) {
        thingService.add(addBody);
    }

    @Getter
    @Setter
    public static class AddBody {
        private long thingGroupId;
        private String title;
        private int sortNum;
    }

    @GetMapping("/page")
    public Page<Thing> page(
            @RequestParam("page") int page,
            @RequestParam("perPage") int perPage,
            @RequestParam("thingGroupId") long thingGroupId
    ) {
        return thingService.list(page, perPage, thingGroupId);
    }

    @GetMapping("/page/group")
    public GroupWithThings pageWithGroup(
            @RequestParam("page") int page,
            @RequestParam("perPage") int perPage,
            @RequestParam("thingGroupId") long thingGroupId
    ) {
        return thingService.pageWithGroup(page, perPage, thingGroupId);
    }

    @GetMapping("/completePercent/{groupId}")
    public double completePercent(@PathVariable("groupId") Long groupId) {
        return thingService.completePercent(groupId);
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GroupWithThings {
        private ThingGroup thingGroup;
        private Page<Thing> thingPage;
    }


    @PutMapping("/complete")
    public boolean complete(@RequestBody ThingController.UpdateCompleteBody body) {
        return thingService.complete(body);
    }

    @Getter
    @Setter
    public static class UpdateCompleteBody {
        private long id;
        private boolean complete;
    }


}

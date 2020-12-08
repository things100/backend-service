package com.futao.springbootservice.controller.things100;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.futao.springbootservice.entity.ThingGroup;
import com.futao.springbootservice.model.result.GroupUser;
import com.futao.springbootservice.service.ThingGroupService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author futao
 * @date 2020/12/2
 */
@RequestMapping("/thingGroup")
@RestController
public class ThingGroupController {

    @Autowired
    private ThingGroupService thingGroupService;

    /**
     * 分页查询我的事情组
     *
     * @param page
     * @param perPage
     * @return
     */
    @GetMapping("/page")
    public Page<ThingGroup> page(
            @RequestParam int page,
            @RequestParam int perPage
    ) {
        return thingGroupService.page(page, perPage);
    }

    @PostMapping
    public void add(
            @RequestBody ThingGroupController.AddBody body
    ) {
        thingGroupService.add(body);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        thingGroupService.delete(id);
    }

    @Getter
    @Setter
    public static class AddBody {
        private String title;
        private String description;
        private String cover;
        private int coverType;
        private boolean open;
    }

    @GetMapping("/members/{groupId}")
    public List<GroupUser> groupMembers(@PathVariable("groupId") Long groupId) {
        return thingGroupService.groupMembers(groupId);
    }

    @PostMapping("/join")
    public void join(@RequestBody JoinBody body) {
        thingGroupService.invite(body);
    }

    @Getter
    @Setter
    public static class JoinBody {
        private Long groupId;
        private Long inviteUserId;
    }
}

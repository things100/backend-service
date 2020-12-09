package com.futao.springbootservice.service.impl;

import com.futao.springbootservice.entity.ThingRecord;
import com.futao.springbootservice.mapper.ThingRecordMapper;
import com.futao.springbootservice.service.ThingRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author futao
 * @date 2020/12/9
 */
@Service
public class ThingRecordServiceImpl implements ThingRecordService {
    @Resource
    private ThingRecordMapper recordMapper;




    public void get(Long id){
        ThingRecord thingRecord = recordMapper.selectById(id);
    }
}

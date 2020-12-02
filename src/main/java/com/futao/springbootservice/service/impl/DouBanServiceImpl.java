package com.futao.springbootservice.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.futao.springbootservice.service.DouBanService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author futao
 * @date 2020/11/26
 */
@Slf4j
@Service
public class DouBanServiceImpl implements DouBanService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public JSONObject movieList() {
        String s = redisTemplate.opsForValue().get("springboot:service:douban:movies");
        if (StringUtils.isBlank(s)) {
            String url = UriComponentsBuilder
                    .fromHttpUrl("https://movie.douban.com/j/search_subjects")
                    .queryParam("type", "movie")
                    .queryParam("tag", "热门")
                    .queryParam("page_start", 0)
                    .queryParam("limit", 50)
                    .build()
                    .toString();
            JSONObject body = restTemplate.getForEntity(url, JSONObject.class).getBody();
            log.debug("{}", body);
            redisTemplate.opsForValue().set("springboot:service:douban:movies", JSON.toJSONString(body));
            return body;
        } else {
            return JSONObject.parseObject(s);
        }
    }
}

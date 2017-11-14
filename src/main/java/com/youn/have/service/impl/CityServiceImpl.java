package com.youn.have.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.youn.have.entity.City;
import com.youn.have.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@Slf4j
public class CityServiceImpl implements CityService {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Override
    public City getCityById(String id) {
        try {
            if(redisTemplate.hasKey(id)){  //如果缓存中存在就从缓存中取，解析为对象
                String jsonCity = redisTemplate.opsForValue().get(id);
                return objectMapper.readValue(jsonCity, City.class);
            } else {  //如果缓存中不存在，先从Database中取，然后放到缓存中，并解析返回
                City city = getCityFromDatabase(id);
                redisTemplate.opsForValue().set(id, objectMapper.writeValueAsString(city), TimeUnit.DAYS.toMillis(123L));
                return city;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return getCityFromDatabase(id);  //如果连接redis、或者出现其他错误，就直接从数据库读取
    }

    public City getCityFromDatabase(String id) {
        return new City();
    }
}

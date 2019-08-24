package com.cx.SecondhandMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class RedisController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @PostMapping("/redis")
    public void addUser(@RequestParam("userId") String userId,
                        @RequestParam("url") String url) {
//        redisTemplate.opsForList().leftPush(userId, url);
        redisTemplate.opsForValue().set(userId, url);
    }

    @GetMapping("/redis/{userId}")
    public String getUserSession(@PathVariable("userId") String userId) {
        return redisTemplate.opsForValue().get(userId);
    }

}

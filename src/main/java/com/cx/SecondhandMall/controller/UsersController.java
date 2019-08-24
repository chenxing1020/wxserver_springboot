package com.cx.SecondhandMall.controller;

import com.cx.SecondhandMall.model.Users;
import com.cx.SecondhandMall.model.Users.*;
import com.cx.SecondhandMall.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @PostMapping("/register")
    public Users registerUser(@RequestParam(name = "openId") String openId,
                              @RequestParam(name = "stuId") String stuId,
                              @RequestParam(name = "name") String name,
                              @RequestParam(name = "avatar") String avatar,
                              @RequestParam(name = "campus") String campus,
                              @RequestParam(name = "college") String college) {
        Users user = new Users();
        user.setOpenId(openId).setStuId(stuId).setAvatar(avatar).setName(name)
                .setCampus(Campus.valueOf(campus)).setCollege(College.valueOf(college));
        return usersRepository.save(user);
    }
}

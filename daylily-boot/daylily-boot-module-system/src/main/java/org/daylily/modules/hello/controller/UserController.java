package org.daylily.modules.hello.controller;

import org.daylily.modules.hello.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @RequestMapping("/getUserMap")
    public Map<String, User> getUserMap() {
        Map<String, User> userMap = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId(i);
            user.setUsername("hello spring boot" + i);
            user.setPassword("123456");
            userMap.put(i + "", user);
        }
        return userMap;
    }
}

package com.wsc.controller;

import com.wsc.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;


@Controller
public class HelloController {

        /*
            这里是测试自定义的错误页面和错误json
            页面返回错误页面
            json请求返回错误json
            */

    @ResponseBody
    @RequestMapping("/hello")

    public String hello(@RequestParam("user") String user) {
        if (user.equals("aaa")) {
            throw new UserNotExistException();
        }
        return "Hello World";
    }

    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("hello", "<h1>你好</h1>");
        map.put("users", Arrays.asList("紫金山", "头驼铃", "山顶公园"));
        return "success";
    }
}

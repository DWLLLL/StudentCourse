package com.rabbiter.cm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController extends BaseController {
    @RequestMapping("/")
    public String hello() {
        return "Hello Course Management System";
    }

    @RequestMapping("/test")
    public Object test() {
        return "Hello";
    }
}

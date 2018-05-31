package com.zktd.bigdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: komi
 * @Date: 2018/5/25 15:22
 */
@Controller
public class SysController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest req, HttpServletResponse rep) {
        return "/login";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpServletRequest req, HttpServletResponse rep) {
        return "/index";
    }
}

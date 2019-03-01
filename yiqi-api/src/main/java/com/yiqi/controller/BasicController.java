package com.yiqi.controller;

import com.yiqi.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author chan
 * @Description: 公共controller类
 * @email chan150@163.com
 * @date 2019/1/30 17:41
 */
public class BasicController {

    /** 日志 **/
    public final static Logger LOGGER = LoggerFactory.getLogger(BasicController.class);

    @Autowired
    public UserService userService;
}

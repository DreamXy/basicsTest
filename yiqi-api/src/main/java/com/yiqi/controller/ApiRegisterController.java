package com.yiqi.controller;


import com.yiqi.common.utils.R;
import com.yiqi.common.validator.ValidatorUtils;
import com.yiqi.entity.*;
import com.yiqi.form.RegisterForm;
import com.yiqi.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 注册接口
 * @author chenshun
 *
 * @date 2017-03-26 17:27
 */
@RestController
@RequestMapping("/api")
@Api(tags="注册接口")
public class ApiRegisterController {
    @Autowired
    private UserService userService;

    @GetMapping("register")
    @ApiOperation("注册")
    public R register(){
//        //表单校验 @RequestBody RegisterForm form
//        ValidatorUtils.validateEntity(form);

        YlbAccountEntity user = new YlbAccountEntity();
        user.setAccountphone("18138756086");
        String bbq = DigestUtils.sha256Hex("123456");
        user.setAccountpwd(bbq);
        user.setRegistertime(new Date());
        user.setRegistertype(1);
        user.setAccouttype(1);
        user.setAccountsate(0);
        user.setAccoutnname("测试1号");
        userService.insert(user);

        return R.ok();
    }
}

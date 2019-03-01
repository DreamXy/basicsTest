package com.yiqi.controller;


import com.yiqi.annotation.Login;
import com.yiqi.common.utils.R;
import com.yiqi.common.validator.ValidatorUtils;
import com.yiqi.entity.*;
import com.yiqi.form.LoginForm;
import com.yiqi.service.TokenService;
import com.yiqi.service.UserService;
import com.yiqi.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 登录接口
 *
 * @author chenshun
 *
 * @date 2017-03-23 15:31
 */
@RestController
@RequestMapping("/api")
@Api(tags="登录接口")
public class ApiLoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;


    @PostMapping("login")
    @ApiOperation("登录")
    public Result<YlbAccountEntity> login(LoginForm form){
        //表单校验
        ValidatorUtils.validateEntity(form);

        //用户登录
        YlbAccountEntity userEntity = userService.login(form);

        return Result.success(userEntity);
    }

    @PostMapping("wechalogin")
    @ApiOperation("微信登陆")
    public Result<YlbAccountEntity> wechalogin(@RequestBody LoginForm form){
        //表单校验
        ValidatorUtils.validateEntity(form);

        //用户登录
        YlbAccountEntity userEntity = userService.login(form);

        return Result.success(userEntity);
    }

    @Login
    @PostMapping("logout")
    @ApiOperation("退出")
    public R logout(@ApiIgnore @RequestAttribute("userId") long userId){
        tokenService.expireToken(userId);
        return R.ok();
    }

}

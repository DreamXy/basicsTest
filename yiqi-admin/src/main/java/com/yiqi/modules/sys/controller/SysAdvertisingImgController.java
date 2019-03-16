package com.yiqi.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yiqi.modules.sys.entity.SysAdvertisingImgEntity;
import com.yiqi.modules.sys.service.SysAdvertisingImgService;
import com.yiqi.common.utils.PageUtils;
import com.yiqi.common.utils.R;
import com.yiqi.common.validator.ValidatorUtils;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-03-13 17:06:06
 */
@RestController
@RequestMapping("sys/sysadvertisingimg")
public class SysAdvertisingImgController {
    @Autowired
    private SysAdvertisingImgService sysAdvertisingImgService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:sysadvertisingimg:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysAdvertisingImgService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:sysadvertisingimg:info")
    public R info(@PathVariable("id") Integer id){
        SysAdvertisingImgEntity sysAdvertisingImg = sysAdvertisingImgService.selectById(id);

        return R.ok().put("sysAdvertisingImg", sysAdvertisingImg);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:sysadvertisingimg:save")
    public R save(@RequestBody SysAdvertisingImgEntity sysAdvertisingImg){
        sysAdvertisingImgService.insert(sysAdvertisingImg);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:sysadvertisingimg:update")
    public R update(@RequestBody SysAdvertisingImgEntity sysAdvertisingImg){
        ValidatorUtils.validateEntity(sysAdvertisingImg);
        sysAdvertisingImgService.updateAllColumnById(sysAdvertisingImg);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:sysadvertisingimg:delete")
    public R delete(@RequestBody Integer[] ids){
        sysAdvertisingImgService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}

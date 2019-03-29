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

import com.yiqi.modules.sys.entity.YlbAdvertisingEntity;
import com.yiqi.modules.sys.service.YlbAdvertisingService;
import com.yiqi.common.utils.PageUtils;
import com.yiqi.common.utils.R;
import com.yiqi.common.validator.ValidatorUtils;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-03-29 00:07:00
 */
@RestController
@RequestMapping("sys/ylbadvertising")
public class YlbAdvertisingController {
    @Autowired
    private YlbAdvertisingService ylbAdvertisingService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:ylbadvertising:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = ylbAdvertisingService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:ylbadvertising:info")
    public R info(@PathVariable("id") Integer id){
        YlbAdvertisingEntity ylbAdvertising = ylbAdvertisingService.selectById(id);

        return R.ok().put("ylbAdvertising", ylbAdvertising);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:ylbadvertising:save")
    public R save(@RequestBody YlbAdvertisingEntity ylbAdvertising){
        ylbAdvertisingService.insert(ylbAdvertising);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:ylbadvertising:update")
    public R update(@RequestBody YlbAdvertisingEntity ylbAdvertising){
        ValidatorUtils.validateEntity(ylbAdvertising);
        ylbAdvertisingService.updateAllColumnById(ylbAdvertising);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:ylbadvertising:delete")
    public R delete(@RequestBody Integer[] ids){
        ylbAdvertisingService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}

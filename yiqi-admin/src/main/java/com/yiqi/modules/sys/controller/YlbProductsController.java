package com.yiqi.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import com.yiqi.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yiqi.modules.sys.entity.YlbProductsEntity;
import com.yiqi.modules.sys.service.YlbProductsService;
import com.yiqi.common.utils.PageUtils;
import com.yiqi.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-03-26 00:29:42
 */
@RestController
@RequestMapping("sys/ylbproducts")
public class YlbProductsController {
    @Autowired
    private YlbProductsService ylbProductsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:ylbproducts:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = ylbProductsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{pid}")
    @RequiresPermissions("sys:ylbproducts:info")
    public R info(@PathVariable("pid") Integer pid){
        YlbProductsEntity ylbProducts = ylbProductsService.selectById(pid);

        return R.ok().put("ylbProducts", ylbProducts);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:ylbproducts:save")
    public R save(@RequestBody YlbProductsEntity ylbProducts){
        ylbProductsService.insert(ylbProducts);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:ylbproducts:update")
    public R update(@RequestBody YlbProductsEntity ylbProducts){
        ValidatorUtils.validateEntity(ylbProducts);
        ylbProductsService.updateAllColumnById(ylbProducts);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:ylbproducts:delete")
    public R delete(@RequestBody Integer[] pids){
        ylbProductsService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

}

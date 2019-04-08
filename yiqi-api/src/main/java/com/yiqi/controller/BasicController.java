package com.yiqi.controller;

import com.yiqi.service.*;
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
    
/**
 * 護工
 */
    @Autowired
    public YlbHugongService ylbHugongService;
    

    @Autowired
    public YlbByabecareService ylbByabecareService;
    

    @Autowired
    public YlbFamilycareService ylbfamilycareService;
    

    @Autowired
    public YlbHospitalcareService ylbhospitalcareService;
    

    /**
     * 圖片
     */
    @Autowired
    public SysAdvertisingImgService sysAdvertisingImgService;
    /**
     * 廣告咨詢
     */
    @Autowired
    public YlbAdvertisingService ylbAdvertisingService;
    
    @Autowired
    public YlbProductsService ylbProductsService;
}

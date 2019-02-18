package com.yiqi.service;

import com.yiqi.datasources.DataSourceNames;
import com.yiqi.datasources.annotation.DataSource;
import com.yiqi.modules.sys.entity.SysUserEntity;
import com.yiqi.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 测试多数据源
 *
 *
 * @since 3.1.0 2018-01-28
 */
@Service
public class DataSourceTestService {
    @Autowired
    private SysUserService sysUserService;

    public SysUserEntity queryUser(Long userId){
        return sysUserService.selectById(userId);
    }

    @DataSource(name = DataSourceNames.SECOND)
    public SysUserEntity queryUser2(Long userId){
        return sysUserService.selectById(userId);
    }
}

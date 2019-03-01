package com.yiqi.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yiqi.entity.*;

import java.util.List;

/**
 * 用户
 * 
 * @author chenshun
 *
 * @date 2017-03-23 15:22:06
 */
public interface UserDao extends BaseMapper<YlbAccountEntity> {

    /**
     * 批量新增
     * @param list
     * @return
     */
    int insertDataByBatch(List<YlbAccountEntity> list);

    /**
     * 分页查询，倒序
     * page是分页插件，必须有此参数
     * @param page
     * @return
     */
    List<YlbAccountEntity> selectUserInfoPage(Pagination page, String password);
}

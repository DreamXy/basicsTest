/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.yiqi.utils;

import com.baomidou.mybatisplus.plugins.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 分页工具类
 * 
 * @author chan
 * @email chan150@163.com
 * @date 2016年11月4日 下午12:59:00
 */
@ApiModel("自定义分页类")
public class CustomerPage<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    // 总记录数
    @ApiModelProperty("总记录数")
    private long totalCount;
    // 每页记录数
    @ApiModelProperty("每页记录数")
    private int pageSize;
    // 总页数
    @ApiModelProperty("总页数")
    private int totalPage;
    // 当前页数
    @ApiModelProperty("当前页数")
    private int currPage;
    // 列表数据
    @ApiModelProperty("分页列表数据")
    private List<T> list;
    /**
     * 分页
     *
     * @param list
     *            列表数据
     * @param totalCount
     *            总记录数
     * @param pageSize
     *            每页记录数
     * @param currPage
     *            当前页数
     */
    public CustomerPage(List<T> list, int totalCount, int pageSize, int currPage) {
        this.list = list;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.currPage = currPage;
        this.totalPage = (int)Math.ceil((double)totalCount / pageSize);
    }

    /**
     * 自定义复杂类型分页
     *
     * @param list
     *            列表数据
     * @param page
     *            总记录数
     */
    public CustomerPage(List<T> list, Page<T> page) {
        this.list = list;
        this.totalCount = (int)page.getTotal();
        this.pageSize = page.getSize();
        this.currPage = page.getCurrent();
        this.totalPage = (int)page.getPages();
    }

    /**
     * 分页
     */
    public CustomerPage(Page<T> page) {
        this.list = page.getRecords();
        this.totalCount = page.getTotal();
        this.pageSize = page.getSize();
        this.currPage = page.getCurrent();
        this.totalPage = (int)page.getPages();
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

}

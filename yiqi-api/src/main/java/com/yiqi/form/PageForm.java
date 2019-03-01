package com.yiqi.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 分页
 *
 * @since 3.1.0 2018-01-25
 */
@Data
@ApiModel(value = "接收分页参数")
public class PageForm {

    @ApiModelProperty(value = "当前页码,默认为1", required = true)
    private int page = 1;

    @ApiModelProperty(value = "每页条数，默认为10", required = true)
    private int limit = 10;

    public Map<String, Object> getPage(PageForm form) {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("currPage", form.getPage());
        params.put("limit", form.getLimit());

        return params;
    }

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
    
    

}

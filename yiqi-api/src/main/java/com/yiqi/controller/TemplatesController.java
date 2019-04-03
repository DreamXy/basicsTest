package com.yiqi.controller;

import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import com.yiqi.entity.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TemplatesController  extends BasicController {
	
	@GetMapping("/templates")
	String test(HttpServletRequest request) {
		String value=request.getParameter("key");
		YlbAdvertisingEntity ye = ylbAdvertisingService.selectById(value);
		request.setAttribute("ti", ye.getTitle());
		request.setAttribute("cn", decode(ye.getTcontent()));
		request.setAttribute("da", ye.getReleasetime());
		return "/index";
	}  
	

    /**
     * 将 BASE64 编码的字符串 s 进行解码
     *
     * @return String
     * @author lifq
     * @date 2015-3-4 上午09:24:26
     */
    public String decode(String s) {
        if (s == null)
            return null;
        
        try {
            byte[] b = Base64.getDecoder().decode(s.getBytes());
            return new String(b,"utf-8");
        } catch (Exception e) {
            return null;
        }
    }

}

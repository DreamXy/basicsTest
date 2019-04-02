package com.yiqi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TemplatesController {
	
	@GetMapping("/templates")
	String test(HttpServletRequest request) {
		String value=request.getParameter("key");
		//逻辑处理
		request.setAttribute("key", "hello world"+value);
		return "/index";
	}  

}

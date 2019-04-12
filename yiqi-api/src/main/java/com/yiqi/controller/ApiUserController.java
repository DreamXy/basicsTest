package com.yiqi.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.yiqi.common.utils.CodeMsg;
import com.yiqi.common.utils.R;
import com.yiqi.common.utils.ResponseResult;
import com.yiqi.common.validator.ValidatorUtils;
import com.yiqi.entity.TokenEntity;
import com.yiqi.entity.YlbAccountEntity;
import com.yiqi.entity.YlbAdvertisingEntity;
import com.yiqi.entity.YlbByabecareEntity;
import com.yiqi.entity.YlbFamilycareEntity;
import com.yiqi.entity.YlbHospitalcareEntity;
import com.yiqi.entity.YlbHugongEntity;
import com.yiqi.form.HuGongForm;
import com.yiqi.form.PageForm;
import com.yiqi.form.RegisterForm;
import com.yiqi.form.UserForm;
import com.yiqi.interceptor.AuthorizationInterceptor;
import com.yiqi.service.TokenService;
import com.yiqi.service.YlbAccountService;
import com.yiqi.service.YlbByabecareService;
import com.yiqi.service.YlbFamilycareService;
import com.yiqi.service.YlbHospitalcareService;
import com.yiqi.service.YlbHugongService;
import com.yiqi.utils.CustomerPage;
import com.yiqi.utils.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author chan
 * @Description: demo 接口
 * @email chan150@163.com
 * @date 2019-01-23 10:47
 */
@RestController
@RequestMapping("/api/User")
@Api(tags = "demo接口")
public class ApiUserController extends BasicController {
	@Autowired
	private YlbAccountService userService;

	@Autowired
	private YlbHugongService ylbHugongService;

	@Autowired
	private YlbByabecareService ylbByabecareService;

	@Autowired
	private YlbFamilycareService ylbfamilycareService;

	@Autowired
	private YlbHospitalcareService ylbhospitalcareService;

	@Autowired
	private TokenService tokenService;

	private String filePath = "C:/image/";

	@RequestMapping(path = "/register", method = RequestMethod.POST)
	@ApiOperation(value = "账号注册")
	public R register(@RequestBody RegisterForm form) {
		ValidatorUtils.validateEntity(form);
		YlbAccountEntity yace = new YlbAccountEntity();
		yace.setAccountphone(form.getMobile());
		yace.setImagsrc(form.getImagsrc());
		yace.setAccoutnname(form.getUsername());
		yace.setAccouttype(
				form.getRegtype() == "" || form.getRegtype() == null ? 0 : Integer.parseInt(form.getRegtype()));
		switch (form.getRegtype()) {
		case "2":
			yace.setWxopenid(form.getOpenid());
			break;
		case "3":
			yace.setQqopenid(form.getOpenid());
			break;
		case "4":
			yace.setXcopenid(form.getOpenid());
			break;
		}
		yace.setRegistertime(new Date());
		yace.setAccountsate(0);
		int flag = userService.add(yace);
		System.out.println("新增返回参数" + flag + "xin" + yace.getAccountid());
		if (flag > 0) {
			// 获取登录token
			TokenEntity tokenEntity = tokenService.createToken(yace.getAccountid());

			Map<String, Object> map = new HashMap<>(2);
			map.put("token", tokenEntity.getToken());
			map.put("expire", tokenEntity.getExpireTime().getTime() - System.currentTimeMillis());
			return R.ok(map);
		}
		return R.error();
	}

	@RequestMapping(path = "/GetUserId", method = RequestMethod.POST)
	public Result GetUserId(@RequestBody TokenEntity tokenEntity) {
		System.out.println("啥参数" + tokenEntity.getToken());
		TokenEntity te = tokenService.queryByToken(tokenEntity.getToken());
		return Result.success("用户ID" + tokenEntity + " 堕落的原因：" + te.getToken() + " 夜晚：" + te.getUserId() + " 过期："
				+ te.getExpireTime() + " 修改" + te.getUpdateTime());
	}
	
	@RequestMapping(path = "/ApplyHgTest", method = RequestMethod.POST)
	@ApiOperation(value = "护工申请")
	public Result ApplyHgTest(@RequestParam MultipartFile photo,@RequestParam MultipartFile file36,@RequestParam String name) {

        System.out.println(photo);
        System.out.println(file36);
        return Result.success();
	}

	@RequestMapping(path = "/ApplyHg", method = RequestMethod.POST)
	@ApiOperation(value = "护工申请")
	public Result applyHg(@RequestBody HuGongForm form) {

        System.out.println(form.getPhoto());
        System.out.println(form.file36);
		ValidatorUtils.validateEntity(form);
		YlbHugongEntity ylbhge = new YlbHugongEntity();
		YlbFamilycareEntity ylbfam = new YlbFamilycareEntity();
		YlbByabecareEntity ylbbb = new YlbByabecareEntity();
		YlbHospitalcareEntity ylbhc = new YlbHospitalcareEntity();
		ylbhge.setAge(Integer.parseInt(form.getAge()));
		ylbhge.setIdcard(form.getIdcard());
		ylbhge.setIsmanageteacher(form.getIsmanageteacher());
		ylbhge.setName(form.getName());
		//ylbhge.setPhoto(form.getPhoto());
		ylbhge.setSex(Integer.parseInt(form.getSex()));
		int reult = ylbHugongService.add(ylbhge);
		if (reult > 0) {

//			ylbfam.setOldageimage(form.get);
			switch (ylbhge.getServetyle()) {
			case "1": // 护工服务类型 1为 医院陪护 2为家庭陪护 3为母婴 4为管理员
				ylbhc.setHugongid(ylbhge.getId());
				ylbhc.setLeve(form.getLeve());
				ylbhc.setWorkage(form.getWorkage());
				ylbhc.setHospital(Integer.parseInt(form.getHospitalid()));
				ylbhc.setIsoldage(Integer.parseInt(form.getIsoldage()));
				ylbhc.setCompany(form.getCompanyid());
				ylbhc.setIntroductions(form.getIntroductions());
				ylbhc.setIshealth(Integer.parseInt(form.getIsHealth()));
				ylbhospitalcareService.insert(ylbhc);
				break;
			case "2":
				ylbfam.setHugongid(ylbhge.getId());
				ylbfam.setLeve(form.getLeve());
				ylbfam.setWorkage(form.getWorkage());
				ylbfam.setHospitalid(Integer.parseInt(form.getHospitalid()));
				ylbfam.setIsoldage(Integer.parseInt(form.getIsoldage()));
				ylbfam.setCompany(form.getCompanyid());
				ylbfam.setIntroductions(form.getIntroductions());
				ylbfam.setIshealth(Integer.parseInt(form.getIsHealth()));
				ylbfamilycareService.insert(ylbfam);
				break;
			case "3":
				ylbbb.setHugongid(ylbhge.getId());
				ylbbb.setLeve(form.getLeve());
				ylbbb.setWorkage(form.getWorkage());
				ylbbb.setCompany(form.getCompanyid());
				ylbbb.setIntroductions(form.getIntroductions());
				ylbbb.setIshealth(Integer.parseInt(form.getIsHealth()));
				ylbByabecareService.insert(ylbbb);
				break;
			case "4":
				break;
			default:
				break;
			}
		}
		return Result.error(CodeMsg.ERROR);
	}
	
	
	public void uploadPicture(@RequestParam(value="file",required=false)MultipartFile file,HttpServletRequest request,HttpServletResponse response){
		 ResponseResult result = new ResponseResult();
		Map<String, Object> map = new HashMap<String, Object>();
       File targetFile=null;
       String url="";//返回存储路径
       int code=1;
       System.out.println(file);
       String fileName=file.getOriginalFilename();//获取文件名加后缀
       if(fileName!=null&&fileName!=""){   
           String path = filePath; //文件存储位置
           String fileF = fileName.substring(fileName.lastIndexOf("."), fileName.length());//文件后缀
           fileName=new Date().getTime()+"_"+new Random().nextInt(1000)+fileF;//新的文件名

           //先判断文件是否存在
           SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
           String fileAdd = sdf.format(new Date());
           //获取文件夹路径
           File file1 =new File(path); 
           //如果文件夹不存在则创建    
           if(!file1 .exists()  && !file1 .isDirectory()){       
               file1 .mkdir();  
           }
           //将图片存入文件夹
           targetFile = new File(file1, fileName);
           try {
           	//将上传的文件写到服务器上指定的文件。
               file.transferTo(targetFile);
               url="http://www.jiuzhenjk.xyz/image/"+fileName; 
               code=0;
               result.setCode(code);
               result.setMessage("图片上传成功");
               map.put("url", url);
               result.setResult(map);
           } catch (Exception e) {
               e.printStackTrace();
               result.setMessage("系统异常，图片上传失败");
           }
       }
   }

}

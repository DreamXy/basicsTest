package com.yiqi.modules.sys.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yiqi.modules.sys.entity.SysAdvertisingImgEntity;
import com.yiqi.modules.sys.service.SysAdvertisingImgService;
import com.google.gson.Gson;
import com.yiqi.common.utils.PageUtils;
import com.yiqi.common.utils.R;
import com.yiqi.common.utils.ResponseResult;
import com.yiqi.common.validator.ValidatorUtils;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-03-13 17:06:06
 */
@RestController
@RequestMapping("sys/sysadvertisingimg")
public class SysAdvertisingImgController extends AbstractController {
	@Autowired
	private SysAdvertisingImgService sysAdvertisingImgService;
	private String filePath = "C:/image/";

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:sysadvertisingimg:list")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = sysAdvertisingImgService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sys:sysadvertisingimg:info")
	public R info(@PathVariable("id") Integer id) {
		SysAdvertisingImgEntity sysAdvertisingImg = sysAdvertisingImgService.selectById(id);

		return R.ok().put("sysAdvertisingImg", sysAdvertisingImg);
	}

	/**
	 * 保存 @RequestParam("file") MultipartFile file
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys:sysadvertisingimg:save")
	public R save(@RequestBody SysAdvertisingImgEntity sysAdvertisingImg) {
		sysAdvertisingImgService.insert(sysAdvertisingImg);

		return R.ok();
	}
	
	@RequestMapping("/uploadImg.xhtml")
	@RequiresPermissions("sys:sysadvertisingimg:save")
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
       writeJson(response, result);
    }
	 public void writeJson(HttpServletResponse response, Object obj) {
	        response.setContentType("text/json;charset=utf-8");
	        response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
	        PrintWriter pw = null;
	        Gson gson = new Gson();
	        try {
	            pw = response.getWriter();
	            pw.write(gson.toJson(obj));
	            
	            pw.flush();
	        } catch (Exception e) {
	            logger.info("输出JSON数据异常", e);
	        }finally{
	        	if(pw!=null){
	        		pw.close();
	        	}
	        }
	    }


	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys:sysadvertisingimg:update")
	public R update(@RequestBody SysAdvertisingImgEntity sysAdvertisingImg) {
		ValidatorUtils.validateEntity(sysAdvertisingImg);
		sysAdvertisingImgService.updateAllColumnById(sysAdvertisingImg);// 全部更新

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:sysadvertisingimg:delete")
	public R delete(@RequestBody Integer[] ids) {
		sysAdvertisingImgService.deleteBatchIds(Arrays.asList(ids));

		return R.ok();
	}

}

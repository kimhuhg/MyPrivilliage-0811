package com.kimhuhg.control;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kimhuhg.pojo.Role;
import com.kimhuhg.pojo.Users;
import com.kimhuhg.service.IRoleService;
import com.kimhuhg.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
/**
* Create by kimhuhg@163.com on 2017/8/12.
* 使用shiro框架来做权限控制
*/

@Controller
@RequestMapping("uc")
public class UserController {
	
	@RequestMapping(value="checklogin")
	public String login(Users users, HttpServletRequest request) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(users.getLoginname(), users.getLoginpwd());
		try{
			subject.login(token);//跳到自定义的realm中
			request.getSession().setAttribute("users", users);
			return "home";
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("error", "用户名或密码错误！");
			return "index";
		}
	}
}

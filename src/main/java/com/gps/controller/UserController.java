package com.gps.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gps.common.utils.MD5;
import com.gps.entity.User;
import com.gps.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * <p>HSBC</p>
 * <p>作者：毛兆伟</p>
 * <p>邮箱：itzwmao@163.com</p>
 * <p>创建时间： 2018年11月16日 下午2:01:28 </p>
 * <p>类说明：用户管理模块控制器</p>
 * <p>修改记录： </p> 
 */
@Controller
@Api(value="用户接口",tags={"UserAPI"})
public class UserController {

	@Autowired
	private UserService userService;
	
	@ApiOperation(value="用户注册", notes="根据User对象创建用户")
	@ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	public String register(@Valid User user, BindingResult result, HttpServletRequest request) throws Exception {
		boolean hasError = result.hasErrors();
		//校验不通过
		if(hasError) {
			Map<String, Object> errorMap = new HashMap<String, Object>();
			List<FieldError> fieldErrors=result.getFieldErrors();
			for (FieldError fieldError : fieldErrors) {
				errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			request.setAttribute("errorMap", errorMap);
			request.setAttribute("user", user);
			return "pages/front/register.jsp";
		}else {//校验通过
			user.setPwd(MD5.finalMd5(user.getPwd()));
			int flag = userService.insert(user);
			if(flag==1) {
				request.setAttribute("message", "注册成功！");
				return "pages/front/success.jsp";
			}else {
				request.setAttribute("message", "注册失败！");
				return "pages/front/failure.jsp";
			}
		}
	}
	
	@ApiOperation(value="删除用户", notes="根据ID删除用户")
	@RequestMapping(value="/deleteByPrimaryKey.do", method=RequestMethod.POST)
	public String deleteByPrimaryKey(Long id, HttpServletRequest request) {
		int login = userService.deleteByPrimaryKey(id);
		if(login >= 1) {
			request.setAttribute("message", "删除成功！");
			return "pages/front/success.jsp";
		}else {
			request.setAttribute("message", "删除失败！");
			return "pages/front/failure.jsp";
		}
	}
	
	@ApiOperation(value="查找用户", notes="根据ID查找用户")
	@RequestMapping(value = "/selectByPrimaryKey.do", method = RequestMethod.GET)
    public String selectByPrimaryKey(Long id, HttpServletRequest request) {
    	User user = userService.selectByPrimaryKey(id);
		request.setAttribute("user", user);
		return "pages/front/register.jsp";
    }
	
	@RequestMapping(value = "/selectUsers.do", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="获取用户列表", notes="获取用户列表")
    public List<User> selectUsers(HttpServletRequest request) {
		PageHelper.startPage(2, 2);
		Page<User> list = (Page<User>) userService.selectUsers();
		List<User> result = list.getResult();
		return result;
    }
	
	@ApiOperation(value="更新用户", notes="根据ID更新用户")
	@RequestMapping(value = "/updateByPrimaryKey.do", method = RequestMethod.POST)
    public String updateByPrimaryKey(User record, HttpServletRequest request) {
    	int user = userService.updateByPrimaryKey(record);
    	if(user >= 1) {
			request.setAttribute("message", "更新成功！");
			return "pages/front/success.jsp";
		}else {
			request.setAttribute("message", "更新失败！");
			return "pages/front/failure.jsp";
		}
    }
	
	@ApiOperation(value="登录", notes="用户登录")
	@RequestMapping(value = "/login.do", method =RequestMethod.POST)
	public void login(User user, HttpServletRequest request, HttpSession session, HttpServletResponse response) throws Exception {
		int login = userService.login(user.getName(), MD5.finalMd5(user.getPwd()));
		if(login >= 1) {
			request.setAttribute("message", "登陆成功！");
			session.setAttribute("user", user.getName());
			response.sendRedirect("swagger-ui.html");
		}else {
			request.setAttribute("message", "登陆失败！");
		}
	}
}

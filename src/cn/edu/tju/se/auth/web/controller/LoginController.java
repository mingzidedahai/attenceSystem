package cn.edu.tju.se.auth.web.controller;

import java.io.IOException;
import java.net.HttpCookie;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.tju.se.attence.domain.UserFile;
import cn.edu.tju.se.auth.dao.UserDao;
import cn.edu.tju.se.auth.domain.User;
import cn.edu.tju.se.auth.service.UserService;
import cn.edu.tju.se.base.cons.CommonConstant;
import cn.edu.tju.se.base.cons.CommonConstant.Auth;
import cn.edu.tju.se.base.web.controller.BaseController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * <br>
 * <b>类描述:</b>
 * 
 * <pre>
 *   景区登录控制器，处理登录验证、注销等操作
 * </pre>
 * 
 * @see
 * @since
 */
@Controller
@RequestMapping("/auth")
public class LoginController extends BaseController {
	/**
	 * 自动注入
	 */
	@Autowired
	private UserService userService;

	/**
	 * 用户登录
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(method=RequestMethod.POST, value="/login")
	public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		User user = userService.findUserByUserName(userName);
		
		if (user == null) {
			request.setAttribute("errorMsg", "用户名不存在");
			return "forward:/login.html";
		} else if (!userService.checkPassword(password, user)) {
			request.setAttribute("errorMsg", "用户密码不正确");
			return "forward:/login.html";
		} else {
			setSessionUser(request,user);
			
			Cookie cookie[]=new Cookie[CommonConstant.AUTH_NUMBER+1];
			cookie[0]=new Cookie(CommonConstant.USER_CONTEXT,user.getUserfileid()+"");
			cookie[1]=new Cookie(CommonConstant.AUTH_LEAVINGAPPROVAL,""+(user.getLeavingapprovalauth()==Auth.yes));
			cookie[2]=new Cookie(CommonConstant.AUTH_EVECTIONAPPROVAL,""+(user.getEvectionapprovalauth()==Auth.yes));
			cookie[3]=new Cookie(CommonConstant.AUTH_LEAVINGTABLE,""+(user.getLeavingtableauth()==Auth.yes));
			cookie[4]=new Cookie(CommonConstant.AUTH_IMPORTPUNCHDATA,""+(user.getImportpunchdataauth()==Auth.yes));
			cookie[5]=new Cookie(CommonConstant.AUTH_SETVOCATION,""+(user.getSetvocationauth()==Auth.yes));
			cookie[6]=new Cookie(CommonConstant.AUTH_ALLPUNCH,""+(user.getAllpunchauth()==Auth.yes));
			
			
			

			
			
			for(int i=0;i<cookie.length;i++){
//				System.out.println(cookie[i].getValue());
//				System.out.println(cookie[i].getName());
				cookie[i].setPath("/");  
				response.addCookie(cookie[i]);
                }
	
			
            response.sendRedirect(request.getContextPath()+"/welcome.html");
			return "";
			//return "forward:/welcome.html?userfileid="+user.getUserfileid();
		}
	}

	/**
	 * 登录注销
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute(CommonConstant.USER_CONTEXT);
		return "forward:/login.html";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/register")
	public String register(HttpServletRequest request,
			HttpServletResponse response) {
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		userService.save(user);
		return "forward:/login.html";
	}

}

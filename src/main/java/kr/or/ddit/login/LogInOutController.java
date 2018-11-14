package kr.or.ddit.login;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserServiceInf;

//@RequestMapping("/login")
@Controller
public class LogInOutController {

	@Resource(name="userService")
	private UserServiceInf userService;
	
	//1. 일단 페이지 로드 
	@RequestMapping("/login")
	public String loginView() {		
		return "/login/login";
	}
	
	//2. 페이지에서 입력된 값 받아오기
	@RequestMapping("/loginCheck")
	public String loginCheck(UserVo userVo, HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		String userId = userVo.getUserid();
		String userPass = userVo.getUserpass();

		String rememberMe = req.getParameter("remember-me");
		
		if(rememberMe==null){
			Cookie[] cookies = req.getCookies();
			for(Cookie cookie :cookies ){
				if(cookie.getName().equals("rememberMe") ||  cookie.getName().equals("userId")){
					cookie.setMaxAge(0);
					resp.addCookie(cookie);
				}
			}
		}else{
			Cookie cookie = new Cookie("rememberMe", "Y");
			Cookie userIdCookie = new Cookie("userId",userId);
			resp.addCookie(cookie);
			resp.addCookie(userIdCookie);
		}
		
		UserVo uservo = userService.selectUser(userId);
		
		if(userVo.getUserid().equals(userId)&&userVo.getUserpass().equals(userPass)) {
			session.setAttribute("uservo", uservo);
			return "main";
		}else{
			return "/login/login";
		}
	}
	
	//3. 로그아웃 
	@RequestMapping("/logout")
	public String loginView(HttpServletRequest req) {	//세션획득
		HttpSession session = req.getSession();
		//무효화
		session.invalidate();
		//이동
		return "/login/login";
	}
}

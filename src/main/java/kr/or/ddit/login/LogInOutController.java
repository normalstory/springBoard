package kr.or.ddit.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/login")
@Controller
public class LogInOutController {

	@RequestMapping("/login")
	public String login() {
		
		
		// 일단 선언하고 서비스갔다가 다오로 갔다가 xml까지 
		
		//return "/login/login";
		return "main";
	}
}

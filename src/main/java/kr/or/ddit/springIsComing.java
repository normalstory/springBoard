package kr.or.ddit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class springIsComing {

	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
}

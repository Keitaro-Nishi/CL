package jp.co.gyosei.botlog.app;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PageController {
	
	@RequestMapping("/")
	public String Home() {
		return "signup";
	}
}
package jp.co.gyosei.botlog.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//import jp.co.gyosei.botlog.domain.form.LoginForm;

@Controller
public class LoginController {
/*
	@RequestMapping(value = "/")
	public String login(Model model) {
		model.addAttribute(new LoginForm());
		return "login";
	}

    // SpringConfig�Őݒ肵�����O�C���ł��Ȃ������ꍇ�̏������`����
    @RequestMapping(value = "/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "/login";
    }
	 */

	@RequestMapping(value = "/login")
	public String Login() {
		return "login";
	}
	
	@RequestMapping(value = "/menu")
	public String Menu() {
		return "menu";
	}
}
package jp.co.gyosei.botlog.app;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//import jp.co.gyosei.botlog.LoginCust;
import jp.co.gyosei.botlog.LoginUserDetails;
import jp.co.gyosei.botlog.domain.form.LoginForm;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/")
	public String Login(Model model) {
		model.addAttribute(new LoginForm());
		return "Login";
	}

    // SpringConfig
    @RequestMapping(value = "/Login-error")
    public String LoginError(Model model) {
        model.addAttribute("LoginError", true);
        return "Login";
    }

    @Controller
    public class MenuController {

        @RequestMapping(value = "/menu")
        public String memu(@AuthenticationPrincipal LoginUserDetails cust, Model model) {
            // @AuthenticationPrincipal���g���ƔF�؃I�u�W�F�N�g���Q�Ƃł���B

            return "menu";
        }
    }
}
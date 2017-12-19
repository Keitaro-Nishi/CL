package jp.co.gyosei.botlog.app;

//import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;

//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;

import jp.co.gyosei.botlog.domain.service.CustinfoService;
import jp.co.gyosei.botlog.domain.repository.CustinfoRepository;
import jp.co.gyosei.botlog.domain.form.CustomerForm;


//import java.util.List;

@Controller
public class CustomerController {
	

	@Autowired
    CustinfoService custinfoService;
	
	@Autowired
	CustinfoRepository custinforepository;
	
	@RequestMapping("/")
	public String Home() {
		return "signup";
	}
	
	@GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("customerForm", new CustomerForm());
        return "signup";
    }
	
	@PostMapping("/signup")
    public String signupPost(Model model, @Valid CustomerForm customerForm, BindingResult bindingResult, HttpServletRequest request) {
		custinfoService.registerUser(customerForm.getNo(),customerForm.getCustid(),customerForm.getCustname(),customerForm.getOrgname(),customerForm.getPassword(),"1","USER");
		return "signup";
	}
	
	
}


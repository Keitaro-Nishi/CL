package jp.co.gyosei.botlog.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import jp.co.gyosei.botlog.domain.entity.CustinfoEntity;
import jp.co.gyosei.botlog.domain.form.CustomerListForm;
import jp.co.gyosei.botlog.domain.service.CustinfoService;
import jp.co.gyosei.botlog.domain.repository.CustinfoRepository;

import java.util.List;
import java.util.Arrays;

@Controller
@RequestMapping("CustomerList")
public class CustomerListController {

	@Autowired
	CustinfoService custinfoService;

	@Autowired
	CustinfoRepository custinfoRepository;

	@GetMapping
	public String list(Model model) {
		List<CustinfoEntity> custinfoEntity = custinfoRepository.findAll();
		model.addAttribute("custinfoEntity",custinfoEntity);
		//model.addAttribute("customerListForm", new CustomerListForm());
		return "CustomerList";
	}

	@PostMapping
	public String customerPost(Model model, CustomerListForm customerListForm, BindingResult bindingResult, HttpServletRequest request) {

		Integer [] rowIdsdata = customerListForm.getRowIds();
		System.out.println(rowIdsdata);
		System.out.println(Arrays.toString(rowIdsdata));

		for(int i = 0; i < rowIdsdata.length; i++) {
			Integer no = rowIdsdata[i];
			custinfoRepository.delete(no);
		}
		return "Customer";
	}
}

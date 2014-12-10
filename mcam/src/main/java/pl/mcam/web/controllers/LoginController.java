package pl.mcam.web.controllers;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.mcam.web.utils.Login;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	@ModelAttribute("login")
	public Login getLogin() {
		return new Login();
	}
	
	@RequestMapping(value="/index.html", method=RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("login");
	}
}

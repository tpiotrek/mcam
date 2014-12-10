package pl.mcam.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.mcam.web.dao.services.UserService;
import pl.mcam.web.domain.RoleName;
import pl.mcam.web.domain.User;
import pl.mcam.web.utils.Registration;
import pl.mcam.web.utils.validators.PasswordValidator;

@Controller
@RequestMapping(value="/registration")
public class RegistrationController {
	
	@ModelAttribute("registration")
	public Registration getRegistration() {
		return new Registration();
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new PasswordValidator());
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	@RequestMapping(value="/success.html", method=RequestMethod.GET)
	public ModelAndView success() {
		final ModelAndView mav = new ModelAndView("success");
		return mav;
	}
	
	@RequestMapping(value="/form.html", method=RequestMethod.GET)
	public ModelAndView index() {
		final ModelAndView mav = new ModelAndView("registration");
		return mav;
	}
	
	@RequestMapping(value="/process", method=RequestMethod.POST)
	public ModelAndView process(@ModelAttribute("registration") 
								@Valid 
								Registration registration, BindingResult result) {
		final ModelAndView mav = new ModelAndView();
		mav.setViewName("registration");
		if (!result.hasErrors()) {
			try {
				final User user = registration.populate();
				switch (userService.create(user, RoleName.ROLE_USER)) {
					case OK: {
						mav.setViewName("redirect:success.html");
					} break;
					case EXISTS: {
						result.rejectValue("email", "error.email.exists");
					} break;
				}
			} catch (Exception e) {
				result.rejectValue("email", "registration.email", "Wystapi� jaki� b��d !!! ["+e+"]");
			}
		}
		return mav;
	}
	
	@Autowired(required=true)
	private UserService userService;
}

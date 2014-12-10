package pl.mcam.web.controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.mcam.web.dao.services.UserService;
import pl.mcam.web.domain.User;
import pl.mcam.web.utils.Registration;

@Controller
@RequestMapping(value="/users")
public class UsersController {
	
	@ModelAttribute("form")
	Form getAction() {
		return new Form();
	}
	
	@RequestMapping(value="/index.html", method=RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("users/index");
		mav.addObject("users", userService.getAll());
		return mav;
	}
	
	@RequestMapping(value="/process", method=RequestMethod.POST, params="remove")
	public ModelAndView remove(@ModelAttribute("form") 
							   Form form, 
							   BindingResult result) {
		ModelAndView mav = new ModelAndView("redirect:/users/index.html");
		for (Integer uId : form.getUsersId()) {
			User user = userService.findById(new Long(uId));
			if (user != null) {
				userService.delete(user);
			}
		}
		return mav;
	}
	
	@RequestMapping(value="/process", method=RequestMethod.POST, params="edit")
	public ModelAndView edit(@ModelAttribute("registration") 
							 Registration registration, 
							 BindingResult result) {
		ModelAndView mav = new ModelAndView("users/edit");
		return mav;
	}
	
	static class Form {
		
		public List<Integer> getUsersId() {
			return usersId;
		}
		
		public void setUsersId(List<Integer> usersId) {
			if (usersId == null) {
				usersId = new LinkedList<Integer>();
			}
			this.usersId = usersId;
		}
		
		private List<Integer> usersId;
	}
	
	@Autowired(required=true)
	private UserService userService;
}
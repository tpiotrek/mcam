package pl.mcam.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author Tokarz Piotr
 * 
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("admin/index");
		return mav;
	}
}

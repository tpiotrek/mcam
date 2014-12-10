package pl.mcam.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexController {
	
	Logger logger = Logger.getLogger(IndexController.class);
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView view = new ModelAndView("index");
		return view;
	}
}

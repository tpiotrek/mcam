package pl.mcam.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.mcam.web.dao.services.UserService;

/**
 * 
 * @author Tokarz Piotr
 *
 */
@Controller
@RequestMapping(value="/account")
public class AccountController {
	
	@Autowired(required=true)
	private UserService userService;
}

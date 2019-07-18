package com.fdmgroup.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.fdmgroup.dao.UsersDAO;
import com.fdmgroup.model.E_Users;

@Controller
@SessionAttributes(value= {"User"}, types = {E_Users.class})
public class LoginController {
	
	@Autowired
	private UsersDAO usersdao;
	
	//display login page
		@RequestMapping(value="/login")
		public String showLogin(Model model){
			
			model.addAttribute("user", new E_Users());
			return "login";
		}
		
		//process the login
		@RequestMapping(value="/processLogin", method = RequestMethod.POST)
		public String processLogin(Model model, @Validated E_Users user, BindingResult br){
			
			if(br.hasErrors()){
				return "login";
			}
			
			List<E_Users> sList = new ArrayList<>();
			sList = usersdao.findAllUsers();
			
			boolean isFound = false;
			int foundID = 0;
			E_Users foundUser = null;
			
			for(int i=0; i< sList.size(); i++){
				
				if(sList.get(i).getUsername().equals(user.getUsername())){
					isFound = true;
					foundID = sList.get(i).getUserId();
				}
				
			}
			
			if(isFound){
				foundUser = usersdao.findByUserid(foundID);
				model.addAttribute("user", foundUser);
				return "splash";
			}
			
			model.addAttribute("errorInfo", "SILLY AGENT, CREDENTIALS ARE KIND OF IMPORTANT >>>>");
			return "login";
		}
		
		
		//logout
		@RequestMapping(value = "/logout")
		public String logout(SessionStatus sessionStatus, Model model){
			
			sessionStatus.setComplete();
			model.addAttribute("logoutInfo", "GOODNIGHT NEVERLAND!");
			
			return "forward:/login";
		}
		

}

package com.icegate.IceGate.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.icegate.IceGate.response.GenericResponse;
import com.icegate.IceGate.service.UserService;
import com.icegate.IceGate.utility.CaptchUtility;
import com.icegate.IceGate.vo.UserVO;

@RestController
@RequestMapping("/user")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String firstPage(Model model) {
		model.addAttribute("user", new UserVO());
		return "upload";
	}

	@PostMapping("/registerUser")
//	@RequiresCaptcha
	public GenericResponse registerUserAccount(@RequestBody UserVO user) throws Exception {
		if (user != null && (!StringUtils.isEmpty(user.getPassword()) && !StringUtils.isEmpty(user.getLoginId()))) {
			return userService.registerNewUserAccount(user);
		} else {
			return new GenericResponse(false, "Login Id & password fields are required", 400, null);
		}

	}

	@GetMapping("/getUserDetails/{userId}")
	public GenericResponse getUserDetails(@PathVariable("userId") Long userId) {
		return userService.getUserDetails(userId);
	}


	@GetMapping("/getUserList")
	public GenericResponse getUserList() {
		return userService.getUserList();
	}
	
	@PostMapping(value = "/registerCustomCapt")
	public GenericResponse registerNewUserAccount(@RequestBody UserVO user,
			Model model, HttpServletRequest request) throws Exception {
		if (user.getCaptchaResponse() != null ) {
			if (user.getCaptchaResponse().equals(request.getAttribute("captcha"))) {
				if (user != null && (!StringUtils.isEmpty(user.getPassword()) && !StringUtils.isEmpty(user.getLoginId()))) {
					return userService.registerNewUserAccount(user);
				} else {
					return new GenericResponse(false, "Login Id & password fields are required", 400, null);
				}
			} else {
				return new GenericResponse(false, "captcha does not match", 400, null);
			}
		}
		else {
			return new GenericResponse(false, "captcha is required", 400, null);
		}
	}
	
	@PostMapping(value = "/register", produces = "application/json; charset=utf-8")
//	@RequiresCaptcha
	public GenericResponse registerNewUserAccountViaBotDetect(@RequestBody UserVO user,
			 HttpServletRequest request) throws Exception {
		
	    request.setAttribute("captchaId", user.getCaptchaId());
	    request.setAttribute("userEnteredCaptchaCode",user.getUserEnteredCaptchaCode());
	    boolean captchaVerification = CaptchUtility.verifyCaptcha(request, user);
	    if (captchaVerification == false) {
	    	return new GenericResponse(false, "captcha does not match", 400, null);
	    } else {
	    	if (user != null && (!StringUtils.isEmpty(user.getPassword()) && !StringUtils.isEmpty(user.getLoginId())))
	    	return new GenericResponse(false, "Login Id & password fields are required", 400, null);
	    	else
	    		return userService.registerNewUserAccountViaBotDetect(user);
	    }
	}
	

}

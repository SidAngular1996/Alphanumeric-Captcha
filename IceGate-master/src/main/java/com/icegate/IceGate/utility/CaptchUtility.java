package com.icegate.IceGate.utility;

import javax.servlet.http.HttpServletRequest;

import com.captcha.botdetect.web.servlet.SimpleCaptcha;
import com.icegate.IceGate.vo.UserVO;

public class CaptchUtility {

	public static String generateCaptchaTextMethod2(int captchaLength) {
	     String saltChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	     StringBuffer captchaStrBuffer = new StringBuffer();
	            java.util.Random rnd = new java.util.Random();
	            // build a random captchaLength chars salt
	            while (captchaStrBuffer.length() < captchaLength)
	            {
	                int index = (int) (rnd.nextFloat() * saltChars.length());
	                captchaStrBuffer.append(saltChars.substring(index, index+1));
	            }
	        return captchaStrBuffer.toString();
	}

	public static boolean verifyCaptcha(HttpServletRequest request, UserVO user) {
		SimpleCaptcha captcha = SimpleCaptcha.load(request);
		boolean isHuman = captcha.validate(user.getUserEnteredCaptchaCode(), user.getCaptchaId());
		return isHuman;
	}

}

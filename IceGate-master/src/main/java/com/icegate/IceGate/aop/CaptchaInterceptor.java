//package com.icegate.IceGate.aop;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.reflect.CodeSignature;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import com.icegate.IceGate.serviceIMPL.CaptchaValidator;
//import com.icegate.IceGate.vo.UserVO;
//
//@Aspect
//@Component
//public class CaptchaInterceptor {
//
//	@Autowired
//	private CaptchaValidator captchaValidator;
//
//	private static final String CAPTCHA_HEADER_NAME = "captcha-response";
//
//	@Around("@annotation(com.icegate.IceGate.customAnnotation.RequiresCaptcha)")
//	public Object validateCaptcha(ProceedingJoinPoint joinPoint) throws Throwable {
//		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
//				.getRequest();
//		CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();
//		String[] arr = codeSignature.getParameterNames();
//		Object[] arr1 = joinPoint.getArgs();
//        System.out.println("First argument's value: " + joinPoint.getArgs()[0]);
//
//		String captchaResponse = request.getHeader(CAPTCHA_HEADER_NAME);
//		boolean isValidCaptcha = captchaValidator.validateCaptcha(captchaResponse);
//		if (!isValidCaptcha) {
//			throw new Exception("Invalid captcha");
//		}
//		return joinPoint.proceed();
//	}
//
//}

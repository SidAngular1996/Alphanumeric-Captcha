package com.icegate.IceGate;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import com.captcha.botdetect.web.servlet.SimpleCaptchaServlet;

@SpringBootApplication
//@ServletComponentScan
public class IceGateApplication {

	public static void main(String[] args) {
		SpringApplication.run(IceGateApplication.class, args);
	}
	  @Bean
	  ServletRegistrationBean captchaServletRegistration () {
	    ServletRegistrationBean srb = new ServletRegistrationBean();
	    srb.setServlet(new SimpleCaptchaServlet());
	    srb.addUrlMappings("/simple-captcha-endpoint");
	    return srb;
	  }
	  
	  @Bean
	  public ServletContextInitializer initializer() {
	    return new ServletContextInitializer() {

			@Override
			public void onStartup(ServletContext servletContext) throws ServletException {
				servletContext.setInitParameter(
					    "BDC_configFileLocation", "/WEB-INF/botdetect.xml");				
			}

	  };
	}
}

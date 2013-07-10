/* http://portalhub.wordpress.com/2012/05/12/spring-mvc-portlet-hello-world-based-on-annotations/*/
package com.liferay.sample.hello;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

@RequestMapping("VIEW")
@Controller("sampleHelloController")
public class SampleHelloController {
	@ExceptionHandler({ Exception.class })
	public String handleException() {
		return "errorPage";
	}

	@RenderMapping
	public String showHomePage(RenderRequest request, RenderResponse response) {
		System.out.println("Inside HelloWorldController -> ShowHomePage");
		return "hello/show";

	}
}

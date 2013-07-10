/* Jul.09/2013
 * If you want to use Spring Web MVC Porlet then follow the instructions
 * contained in this article  http://portalhub.wordpress.com/2012/05/12/spring-mvc-portlet-hello-world-based-on-annotations
 * Here you will use the Annotated Classes for Spring Framework 2.5.x, in this portlet Spring Framework 3.2.3.RELEASE is used.
 * You can also follow the documentation contained in the official Spring Framework doc site.
 * http://static.springsource.org/spring/docs/3.2.x/spring-framework-reference/html/portlet.html
 */
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

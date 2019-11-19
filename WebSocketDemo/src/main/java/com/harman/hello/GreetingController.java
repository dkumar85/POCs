package com.harman.hello;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {
	
	/*
	 * The @MessageMapping annotation ensures that if a message is sent to
	 * destination "/hello", then the greeting() method is called. After the 1
	 * second delay, the greeting() method creates a Greeting object and returns it.
	 * The return value is broadcast to all subscribers to "/topic/greetings" as
	 * specified in the @SendTo annotation. Note that the name from the input
	 * message is sanitized since in this case it will be echoed back and
	 * re-rendered in the browser DOM on the client side.
	 */
	
	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting (HelloMessage message) throws Exception{
		Thread.sleep(1000);
		return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!!");
	}

}

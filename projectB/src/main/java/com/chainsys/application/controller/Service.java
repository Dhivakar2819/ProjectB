package com.chainsys.application.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
@RestController

public class Service {
	@RequestMapping("/welcome")
public String welcomePage()
{
	return "<h1>Welcome</h1>";
}
	@RequestMapping("/home")
	public String homePage() {
		String html = "<div> HTML is used to specify whether your web content should be recognized as a paragraph, list, heading, link, image, multimedia player, form, or one of many other available elements or even a new element that you define.</div>";
		return html;
	}
	@RequestMapping("/getdata")
	public String getData(@RequestParam(value = "city",defaultValue = "madurai")String city)
	{
		return "<h1>welcome to "+city+"</h1>";
	}
}


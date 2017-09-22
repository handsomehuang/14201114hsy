package com.nchu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		System.out.println("index");

		return "index";
	}

	@RequestMapping("home")
	public String home() {
		return "index";
	}

	@RequestMapping("business")
	public String business() {
		return "business/business";
	}
}

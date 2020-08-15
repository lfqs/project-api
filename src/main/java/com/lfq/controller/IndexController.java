package com.lfq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lfq.config.SystemConfig;

@Controller
public class IndexController {

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("api","/doc.html");//项目api接口地址
		model.addAttribute("fileIndex","/fileIndex");
		return "index";
	}
	
	@GetMapping("fileIndex")
	public String fileIndex(Model model) {
		model.addAttribute("path",SystemConfig.getName());
		model.addAttribute("upfile","/upfile");
		model.addAttribute("index","/");
		return "fileIndex";
	}
	
	@GetMapping("upfile")
	public String upfile(Model model) {
		model.addAttribute("fileIndex","/fileIndex");
		return "upfile";
	}
	
}

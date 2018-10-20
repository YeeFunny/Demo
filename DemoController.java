package com.java.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.java.dto.Student;

@RequestMapping("/demo")
@Controller
public class DemoController {

	@RequestMapping("addpage")
	public String demo() {
		return "addPage";
	}
	
	
//	@RequestMapping(path="1", params="param")
//	public String demo1(@RequestParam("param") String param, Model model) {
//		model.addAttribute("param", param);
//		return "demo";
//	}
	
	@RequestMapping(path="1")
	public String demo7(@RequestParam Map<String, String> param, Model model) {
		model.addAttribute("param", param);
		return "demo";
	}
	
	@RequestMapping(path= "1/{param}", params="param")
	public String demo8(@PathVariable("param") String param, Model model) {
		model.addAttribute("param", param + param);
		return "demo";
	}
	
//	@RequestMapping(path= "1/{param1}", params="param1")
//	public String demo2(@PathVariable("param1") String param1, Model model) {
//		model.addAttribute("param", param1 + param1);
//		return "demo";
//	}
	
	@RequestMapping(path = "add", method = RequestMethod.POST)
	public String demo3(Student student, SessionStatus status) {
		return student.getName().equals("admin") ? "admin" : "student";
	}
	
	@RequestMapping("4")
	public String demo4(Model model) {
		model.addAttribute("source", "From model");
        return "demo2";
	}
	
	@RequestMapping("5")
	public String demo5(ModelMap map) {
		String source = "From ModelMap";
	    map.addAttribute("source", source);
	    return "demo2";
	}
	
	@RequestMapping("6")
	public ModelAndView demo6(ModelAndView model) {
		model.setViewName("demo2");
		model.addObject("source", "From ModelAndView");
		return model;
	}
}
package com.nuaa.control;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nuaa.bean.Student;
import com.nuaa.util.ApplicationContextAwareUtil;


@Controller
@RequestMapping("/controlhandler")
public class ControlHandler {
	
	@RequestMapping(value="/helloworld", method = RequestMethod.GET,produces="application/json")
	@ResponseBody
	public Student helloWorld(){
		Student student=(Student)ApplicationContextAwareUtil.getBean("student");
		return student;
	}
	
	@RequestMapping(value="/helloworld", method = RequestMethod.POST,produces="application/json")
	@ResponseBody
	public Student helloWorld(@RequestBody Student student){
		student.setName(student.getName()+(new Date()));
		return student;
	}

}
package com.nuaa.control;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nuaa.bean.Student;


@Controller
@RequestMapping("/controlhandler")
public class ControlHandler {
	
	@RequestMapping(value="/helloworld", method = RequestMethod.GET,produces="application/json")
	@ResponseBody
	public Student helloWorld(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-common.xml"); 
		Student student=(Student)applicationContext.getBean("student");
		return student;
	}
	
	@RequestMapping(value="/helloworld", method = RequestMethod.POST,produces="application/json")
	@ResponseBody
	public Student helloWorld(@RequestBody Student student){
		student.setName(student.getName()+(new Date()));
		return student;
	}

}

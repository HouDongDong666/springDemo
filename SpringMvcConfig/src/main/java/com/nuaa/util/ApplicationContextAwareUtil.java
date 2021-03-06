package com.nuaa.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextAwareUtil implements ApplicationContextAware{
	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		ApplicationContextAwareUtil.applicationContext= arg0;
		
	}

	public static Object getBean(String paramString)
	  {
	    return applicationContext.getBean(paramString);
	  }
}

<?xml version="1.0" encoding="UTF-8"?>
<beans:beans xmlns="http://www.springframework.org/schema/mvc"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:beans="http://www.springframework.org/schema/beans"
	xsi:schemaLocation="
        http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-3.1.xsd
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.1.xsd
        http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-3.0.xsd
       	http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.1.xsd
	 	http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.1.xsd 
  	 	http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-3.1.xsd 
    	http://www.springframework.org/schema/tx  http://www.springframework.org/schema/tx/spring-tx-3.1.xsd">
	<bean
		class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping">
	</bean>

	<bean
		class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter">
		<property name="messageConverters">
			<list>
				<bean
					class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter" />
			</list>
		</property>
		<property name="customArgumentResolvers">
			<list>
				<bean
					class="com.jackie.springmvc.MethodArgumentResolver.CurrentUserHandlerMethodArgumentResolver" />
			</list>
		</property>

	</bean>

 	<beans:bean id="conversionService"
		class="org.springframework.context.support.ConversionServiceFactoryBean">
	</beans:bean>
	
	<annotation-driven conversion-service="conversionService">
		<message-converters>
			<beans:bean
				class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter" />
		</message-converters>
		<argument-resolvers>
			<beans:bean class="com.jackie.springmvc.MethodArgumentResolver.CurrentUserHandlerMethodArgumentResolver" />
		</argument-resolvers>
		<return-value-handlers>
			<beans:bean
				class="com.jackie.springmvc.MethodReturnValueHandler.PrefixHandlerMethodReturnValueHandler" />
		</return-value-handlers>
	</annotation-driven>
</beans:beans>

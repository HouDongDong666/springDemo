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

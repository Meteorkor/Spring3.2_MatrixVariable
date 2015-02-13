##SetUp
Spring 3.2
``
<annotation-driven enableMatrixVariables="true" />
``

``
<?xml version="1.0" encoding="UTF-8"?>
<beans:beans xmlns="http://www.springframework.org/schema/mvc"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:beans="http://www.springframework.org/schema/beans"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-3.2.xsd
		http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.2.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.2.xsd">
``
		
``		
	@RequestMapping(value="books/{pathNumber}/{pathName}", method=RequestMethod.GET)
	public @ResponseBody String getMatrixVal_2_1( 
			@MatrixVariable(pathVar="pathNumber", value="bookId") String bookId, 			@MatrixVariable(pathVar="pathName", value="bookName") String bookName )
	
``
	
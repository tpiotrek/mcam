<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<spring:message var="email" code="form.email" />
<spring:message var="password" code="form.password" />
<spring:message var="login" code="form.login" />

<form:form action="${baseUrl}login/process" 
	  	   method="POST"
	  	   modelAttribute="login">
	<form:errors path="*" />	  	   
	<ul>
		<li>
			<label>${email}</label>
			<form:input path="username"/>
		</li>
		<li>
			<label>${password}</label>
			<form:password path="password" />
		</li>
		<li>
			<input type="submit" name="submit" value="${login}" />
		</li>
	</ul>
</form:form>
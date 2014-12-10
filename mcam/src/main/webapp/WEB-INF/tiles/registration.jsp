<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<spring:message var="fname" code="form.fname" />
<spring:message var="lname" code="form.lname" />
<spring:message var="email" code="form.email" />
<spring:message var="vemail" code="form.vemail" />
<spring:message var="password" code="form.password" />
<spring:message var="vpassword" code="form.vpassword" />
<spring:message var="reset" code="form.reset" />
<spring:message var="submit" code="form.submit" />

<form:form action="${baseUrl}registration/process" 
		   method="POST" 
		   modelAttribute="registration">
	<ul>
		<li>
			<form:label path="email">${email}</form:label>
			<form:input path="email" />
			<form:errors path="email" />
		</li>
		<li>
			<form:label path="vemail">${vemail}</form:label>
			<form:input path="vemail" />
			<form:errors path="vemail" />
		</li>
		<li>
			<form:label path="password">${password}</form:label>
			<form:password path="password" />
			<form:errors path="password" />
		</li>
		<li>
			<form:label path="vpassword">${vpassword}</form:label>
			<form:password path="vpassword" />
			<form:errors path="vpassword" />
		</li>
		<li>
			<form:label path="fname">${fname}</form:label>
			<form:input path="fname" />
			<form:errors path="fname" />
		</li>
		<li>
			<form:label path="lname">${lname}</form:label>
			<form:input path="lname" />
			<form:errors path="lname" />
		</li>
	</ul>
	<form:button>${submit}</form:button>
	<input type="reset" value="${reset}" />
</form:form>
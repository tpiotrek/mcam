<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<spring:message var="fname" code="form.fname" />
<spring:message var="lname" code="form.lname" />
<spring:message var="email" code="form.email" />
<spring:message var="vemail" code="form.vemail" />
<spring:message var="password" code="form.password" />
<spring:message var="vpassword" code="form.vpassword" />

<div id="form_user">
	<f:form action="${baseUrl}${actionUrl}" 
			method="POST"
			commandName="formUser">
		<ul>
			<li>
				<f:label path="email">${email}</f:label>
				<f:input path="email" />
				<f:errors path="email" />
			</li>
			<li>
				<f:label path="vemail">${vemail}</f:label>
				<f:input path="vemail" />
				<f:errors path="vemail" />
			</li>
			<li>
				<f:label path="password">${password}</f:label>
				<f:password path="password" />
				<f:errors path="password" />
			</li>
			<li>
				<f:label path="vpassword">${vpassword}</f:label>
				<f:password path="vpassword" />
				<f:errors path="vpassword" />
			</li>
			<li>
				<f:label path="fname">${fname}</f:label>
				<f:input path="fname" />
				<f:errors path="fname" />
			</li>
			<li>
				<f:label path="lname">${lname}</f:label>
				<f:input path="lname" />
				<f:errors path="lname" />
			</li>
		</ul>
		<input name="submit" value="" />
		<input name="" value="" />			
	</f:form>
</div>
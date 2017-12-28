<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Home</h1>

	<ol>
		<c:forEach items="${users}" var="each" varStatus="index">
			<li>${each.username}</li>
		</c:forEach>
	</ol>

	<form action="/admin/addUser" method="post">

		username:<input name="username" type="text" placeholder="username">
		<br> password:<input name="password" type="text"
			placeholder="password"> <br> email:<input name="email"
			type="text" placeholder="email"> <br>
		<button>Submit</button>
	</form>


</body>
</html>
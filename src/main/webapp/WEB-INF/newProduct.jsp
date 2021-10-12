<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>New Product</h1>
		<form:form action="/create/product" method="post"
			modelAttribute="product">
			<div>
				<label>Name:</label>
				<form:input path="name" />
				<form:errors path="name" />
			</div>
			<div>
				<label>Description:</label>
				<form:input path="description" />
				<form:errors path="description" />
			</div>
			<div>
				<label>Price:</label>
				<form:input type="number" step=".01" path="price" />
				<form:errors path="price" />
			</div>
			<input type="submit" value="Add New Product!" />
		</form:form>
	</div>
</body>
</html>
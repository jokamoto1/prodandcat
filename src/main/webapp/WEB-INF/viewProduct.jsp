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
		<h1 class="text-center">
			<c:out value="${product.name }"></c:out>
		</h1>
		<div class="d-flex justify-content-center">
			<div>
				<h3>Add a category</h3>
				<form:form method="post" action="/product/category/${product.id}">
					<select name="categoryId">
						<c:forEach items="${categories }" var="oneCat">

							<c:if test="${!product.categories.contains(oneCat)}">
								<option value="${oneCat.id}"><c:out
										value="${oneCat.name }"></c:out></option>
							</c:if>

						</c:forEach>
					</select>
					<input type="submit" value="Add Category">
				</form:form>
			</div>
			<div>
				<h3>Current categories</h3>
				<c:forEach items="${product.categories}" var="oneCurCat">
					<div class="d-flex">
						-
						<c:out value="${oneCurCat.name }" />
						<form action="/delete/${product.id}" method="post">
							<input type="hidden" name="_method" value="delete"> <input
								type="submit" value="delete">
								<input type="hidden" name="categoryId" value="${oneCurCat.id}">
						</form>
					</div>
				</c:forEach>

			</div>
		</div>
	</div>
</body>
</html>
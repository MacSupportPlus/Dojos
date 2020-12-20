<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
	<script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<title>Dojos</title>
</head>
<body>
<div class="container">
	<div class="col-sm-4">
		<form:form action="/dojos/create" method="post" modelAttribute="newDojo">
			<h1>Create Dojo</h1>
				<div class= "form-group">
					<label>Name:</label>
					<form:input path="name" class="form-control"/>
				</div>
					<input type="submit" value="Add Dojo" class="btn btn-dark" />
		</form:form>
	</div>
		
	
	<div class="col-sm-4">
		<form:form action="/ninjas/create" method="post" modelAttribute="newNinja">
			<h1>Create Ninja</h1>
				<div class= "form-group">
					<label>Dojo:</label>
					<form:select path="dojo" class="form-control">
						<c:forEach items="${allDojos}" var="dojo">
							<option value="${dojo.id}">${dojo.name}</option>
						</c:forEach>
					</form:select>
				</div>
				<div class= "form-group">
					<label>First Name</label>
					<form:input path="firstName" class="form-control"/>
				</div>
				<div class= "form-group">
					<label>Last Name:</label>
					<form:input path="lastName" class="form-control"/>
				</div>
				<div class= "form-group">
					<label>Age:</label>
					<form:input path="age" class="form-control"/>
				</div>
					<input type="submit" value="Add Ninja" class="btn btn-dark" />
		</form:form>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</div>
</body>
</html>
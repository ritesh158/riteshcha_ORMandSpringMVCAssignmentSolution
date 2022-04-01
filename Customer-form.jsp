<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title><c:out value="${newCustomer ? 'Add Customer' : 'Update Customer'}" /></title>
</head>
<body>
	<div class="container">
		<table class="table table-bordered table-striped">
			<tr>
				<th style="background-color: #00FF99">
					<h1>Customer Relationship Management</h1>
				</th>
			</tr>
		</table>
		<h2>
			<c:out value="${newCustomer ? 'Add Customer' : 'Update Customer'}" />
		</h2>

		<form action="/CustomerManagement/customer/save" method="POST">
			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${Customer.id}" />

			<div class="form-inline">
				<input type="text" name="firstName" value="${Customer.firstName}"
					class="form-control mb-4 col-4" placeholder="FirstName">
			</div>

			<div class="form-inline">
				<input type="text" name="lastName" value="${Customer.lastName}"
					class="form-control mb-4 col-4" placeholder="LastName">
			</div>

			<div class="form-inline">
				<input type="text" name="email" value="${Customer.email}"
					class="form-control mb-4 col-4" placeholder="Email">
			</div>

			<button type="submit" class="btn btn-primary">Save</button>
			<a href="/CustomerManagement/customer/list" class="btn btn-danger">Cancel</a>
		</form>
	</div>
</body>
</html>
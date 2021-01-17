<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<title>menu-item-list-admin</title>
<link rel="stylesheet" href="style/style.css">
<script src="js/script.js"></script>
</head>

<body>

	<header>
	<h1>truYum</h1>
	<img src="/images/truyum-logo-light.png" height="43" width="46">
	<nav> <a href="/show-menu-list-admin">Menu</a> </nav> </header>

	<h1 class="page-title">Menu Items</h1>

	<table>
		<thead>
			<tr>
				<th class="first-column">Name</th>
				<th class="price-column">Price</th>
				<th>Active</th>
				<th>Date of Launch</th>
				<th>Category</th>
				<th>Free Delivery</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${not empty menuItemListAdmin}">
				<c:forEach var="menuItem" items="${menuItemListAdmin}">
					<tr>
						<td class="first-column">${menuItem.name}</td>
						<td class="price-column">Rs. ${menuItem.price}</td>
						<c:if test="${menuItem.active == true}">
							<c:set var="active" scope="session" value="Yes" />
						</c:if>
						<c:if test="${menuItem.active == false}">
							<c:set var="active" scope="session" value="No" />
						</c:if>
						<td>${active}</td>
						<td>${menuItem.dateOfLaunch}</td>
						<td>${menuItem.category}</td>
						<c:if test="${menuItem.freeDelivery == true}">
							<c:set var="freeDelivery" scope="session" value="Yes" />
						</c:if>
						<c:if test="${menuItem.freeDelivery == false}">
							<c:set var="freeDelivery" scope="session" value="No" />
						</c:if>
						<td>${freeDelivery}</td>
						<td><a href="/show-edit-menu-item?menuItemId=${menuItem.id}">Edit</a></td>

					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>

	<footer>
	<p>Copyright &#169; 2019</p>
	</footer>

</body>

</html>
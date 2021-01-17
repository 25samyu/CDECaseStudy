<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>menu-item-list-customer</title>
<link rel="stylesheet" href="style/style.css">
<script src="js/script.js"></script>
</head>
<body>
	<header>
	<h1>truYum</h1>
	<img src="/images/truyum-logo-light.png" height="43" width="46">
	<nav> <a href="/show-menu-list-customer">Menu</a> <a
		href="/show-cart">Cart</a> </nav> </header>
	<h1 class="page-title">Menu Items</h1>
	<c:if test="${not empty addCartStatus}">
		<c:if test="${addCartStatus == true}">
			<p id="customer-message" class="status-message">Item added to
				Cart Successfully</p>
		</c:if>
	</c:if>
	<table id="cart-table">
		<thead>
			<tr>
				<th class="first-column">Name</th>
				<th>Free Delivery</th>
				<th class="price-column">Price</th>
				<th>Category</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${not empty menuItemListCustomer}">
				<c:forEach var="menuItemCustomer" items="${menuItemListCustomer}">
					<tr>
						<td class="first-column">${menuItemCustomer.name}</td>
						<c:if test="${menuItemCustomer.freeDelivery == true}">
							<c:set var="freeDeliveryCust" scope="session" value="Yes" />
						</c:if>
						<c:if test="${menuItemCustomer.freeDelivery == false}">
							<c:set var="freeDeliveryCust" scope="session" value="No" />
						</c:if>
						<td>${freeDeliveryCust}</td>
						<td class="price-column">Rs. ${menuItemCustomer.price}</td>
						<td>${menuItemCustomer.category}</td>

						<td><a href="/add-to-cart?menuItemId=${menuItemCustomer.id}">Add
								to Cart</a></td>

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
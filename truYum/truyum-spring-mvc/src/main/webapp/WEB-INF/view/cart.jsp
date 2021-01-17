<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>cart</title>
    <link rel="stylesheet" href="/style/style.css">
    <script src="js/script.js"></script>
</head>
<body>
    <header>
        <h1>truYum</h1>
	<img src="/images/truyum-logo-light.png" height="43" width="46">
        <nav>
            <a href="/show-menu-list-customer">Menu</a>
            <a href="/show-cart">Cart</a>
        </nav>
    </header>
    <h1 class="page-title">Cart</h1>
    <c:if test="${not empty removeCartItemStatus}">
			<c:if test="${removeCartItemStatus == true}">
	    <p id="customer-message" class="status-message">Item removed from Cart Successfully</p>
	    </c:if>
	    </c:if>
    <table>
        <thead>
            <tr>
                <th class="first-column">Name</th>
                <th>Free Delivery</th>
                <th class="price-column">Price</th>
            </tr>
        </thead>
        <tbody>
			<c:if test="${not empty cart.menuItemList}">
				<c:forEach var="menuItem" items="${cart.menuItemList}">
					<tr>
						<td class="first-column">${menuItem.name}</td>		
						<c:if test="${menuItem.freeDelivery == true}">
							<c:set var="freeDelivery" scope="session" value="Yes" />
						</c:if>
						<c:if test="${menuItem.freeDelivery == false}">
							<c:set var="freeDelivery" scope="session" value="No" />
						</c:if>
						<td>${freeDelivery}</td>
						<td class="price-column">Rs. ${menuItem.price}</td>
						
						<td><a href="/remove-cart-item?menuItemId=${menuItem.id}">Delete</a></td>

					</tr>
				</c:forEach>
			</c:if>
		</tbody>

        <tfoot>        
        <tr class="cart-foot">
            <td></td>
            <td> <label class="cart-foot">Total</label></td>
            <td> <output class="cart-foot" id="total">${cart.total}</output></td>
        </tr>
        </tfoot>
    </table>
    <footer>
        <p>Copyright &#169; 2019</p>
    </footer>
</body>
</html>
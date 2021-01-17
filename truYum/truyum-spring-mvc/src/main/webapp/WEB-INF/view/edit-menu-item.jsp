<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    
<head>
    <title>edit-menu-item</title>
    <link rel="stylesheet" href="style/style.css">
    <script src="js/script.js"></script>
</head>
    
<body>
    
    <header>
        <h1>truYum</h1>
	    <img src="/images/truyum-logo-light.png" height="43" width="46">

        <nav>
            <a href="/show-menu-list-admin">Menu</a>
        </nav>
    </header>
    
    <h1 class="page-title">Edit Menu Item</h1>

    <form:form id="menuItemForm" name="menuItemForm" method="POST" action="/edit-menu-item" modelAttribute="menuItem">
    <form:hidden path="id" value="${menuItem.id}"></form:hidden>
        <form:label class="edit-menu-label" path="name">Name</form:label><br>
        <form:input value="${menuItem.name}" type="text" path="name" name="title"></form:input>
        <br>
        <form:errors path="name" class="error-message"></form:errors>
        <br><br><br>

        <form:label name="edit-menu-label" path="price">Price(Rs.)</form:label>
        <form:label name="inStock-label" path="active">Active</form:label>
        <form:label name="dateOfLaunch-label" path="dateOfLaunch">Date of Launch</form:label>
        <form:label name="category-label" path="category">Category</form:label><br>

        
        <form:input value="${menuItem.price}" path="price" class="second-row" type="text" name="price"></form:input>
        <c:if test="${menuItem.active == true}">
        <form:radiobutton path="active" name="inStock" id="activeYes" value="Yes" checked="checked"></form:radiobutton><span>Yes</span>
        <form:radiobutton path="active" name="inStock" id="activeNo" value="No"></form:radiobutton><span class="second-row">No</span>
	    </c:if>
	    <c:if test="${menuItem.active == false}">
	    <form:radiobutton path="active" name="inStock" id="activeYes" value="Yes" ></form:radiobutton><span>Yes</span>
	    <form:radiobutton path="active" name="inStock" id="activeNo" value="No" checked="checked"></form:radiobutton><span class="second-row">No</span>
	    </c:if>
	    <fmt:formatDate value="${menuItem.dateOfLaunch}" pattern="dd-MM-yyyy" var="formattedDate"/>
        <form:input path="dateOfLaunch" value="${formattedDate}" class="second-row" type="text" name="dateOfLaunch"></form:input>
        
        
        
        
        <form:select value="${menuItem.category}" name="category" path="category">
            <option>Starters</option>
            <option>Main Course</option>
            <option>Dessert</option>
            <option>Drinks</option>
        </form:select>
        
        <br>
                <form:errors path="price" class="error-message"></form:errors>
                <form:errors path="dateOfLaunch" class="error-message" id="date-error"></form:errors>
        
        <br><br><br>
        <c:if test="${menuItem.freeDelivery == true}">
        <form:checkbox path="freeDelivery" name="freeDelivery" checked="checked"></form:checkbox>
        </c:if>
        <c:if test="${menuItem.freeDelivery == false}">
        <form:checkbox path="freeDelivery" name="freeDelivery"></form:checkbox>
        </c:if>
        <form:label path="freeDelivery" name="freeDelivery-label">Free Delivery</form:label>
        
        <br><br><br><br>
        
        <input type="submit" name="submit" value="Save">

    </form:form>
    <footer>
        <p>Copyright &#169; 2019</p>
    </footer>
    
</body>
    
</html>
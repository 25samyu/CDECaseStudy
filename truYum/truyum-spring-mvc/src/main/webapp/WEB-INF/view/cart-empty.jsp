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
    <strong>No items in cart. Use 'Add to cart' option in 
        <a href="/show-menu-list-customer">Menu Item List</a>
    </strong>
    <footer>
        <p>Copyright &#169; 2019</p>
    </footer>
</body>
</html>
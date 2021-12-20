<!DOCTYPE html>
<html>
 <head>
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
  <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
  <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
      pageEncoding="ISO-8859-1"%>
  <%@ page isELIgnored="false" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 </head>
 <body>
  <jsp:include page="header.jsp"></jsp:include>
  <b><h4 style="text-align:right">welcome ${sessionScope.user.userName}</h4></b>
  <jsp:include page="user-menu.jsp"></jsp:include>
  <div class="container">
   <div class="row">
	<table class="table table-striped table-condensed">
	 <thead>
	  <tr>
	   <th>Product Id</th>
	   <th>Product Name</th>
	   <th>Price</th>
	   <th>Vendor</th>
	   <th>Quantity</th>
	   <th>Warranty</th>
	   <th>Operations</th>
	  </tr>
	 </thead>
	 <c:forEach var="product" items="${sessionScope.productList}" varStatus="c">
	 <tbody>
	  <tr>
	   <td>${product.productId}</td>
	   <td>${product.productName}</td>
	   <td>${product.price}</td>
	   <td>${product.vendor}</td>
	   <td>${product.quantity}</td>
	   <td>${product.warranty}</td>
	   <td>
	    <a href="${pageContext.request.contextPath}/select?id=${product.productId}"><i class="fa fa-edit">Edit</i></a> |
		<a href="${pageContext.request.contextPath}/delete?id=${product.productId}"><i class="fa fa-remove">Delete</i></a>
	    </td>
	   </tr>
	  </tbody>
	 </c:forEach>
    </table>
   </div>
  </div>
 </body>
</html>
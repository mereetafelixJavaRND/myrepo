<!DOCTYPE html>
 <html>
  <head>
   <meta charset="ISO-8859-1">
   <title>Library Management System</title>
   <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page isELIgnored="false" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <style type="text/css">
    table, th, td {
     border: 1px solid white;
     border-collapse: collapse;
    }
    th, td {
     background-color: PowderBlue;
    }
  </style>
 </head>
 <body>
 <jsp:include page="format.jsp"></jsp:include>
  <div class="container" align="center">
   <div class="row">
    <table class="table table-striped table-condensed">
     <thead>
	  <tr>
	   <th>Book Id</th>
	   <th>Title</th>
	   <th>Year Of Publish</th>
	   <th>ISBN</th>
	   <th>Available No</th>
	   <th>Return Date</th>
	   <th>Author</th>
	   <th>Publisher</th>
	  <th>Issue  |  Return</th>
	  </tr>
	 </thead>    
      <c:forEach var="book" items="${books}" varStatus="c">
       <c:url var="issueLink" value="issueBookForm">
		<c:param name="id" value="${book.id}"></c:param>
	   </c:url>
	   <c:url var="returnLink" value="showFormForReturn">
		<c:param name="id" value="${book.id}"></c:param>
	   </c:url>
	  <tbody>
	   <tr>
	    <td>${book.id}</td>
	    <td>${book.title}</td>
	    <td>${book.year}</td>
	    <td>${book.isbn}</td>
	    <td>${book.availableNo}</td>
	    <td>${book.user.date}</td>
	    <td>${book.author.name}</td>
	    <td>${book.publisher.name}</td>
	    <td> <a class='btn btn-info btn-xs' href="${issueLink}"><span class="glyphicon glyphicon-edit"></span>Issue  |</a>
	     <a href="${returnLink}" class="btn btn-danger btn-xs"  ><span
	     class="glyphicon glyphicon-remove"></span> Return</a></td>
       </tr>
      </tbody>
     </c:forEach>
    </table>
   </div>
  </div>
 </body>
</html>
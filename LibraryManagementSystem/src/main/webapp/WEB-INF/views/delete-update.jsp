<!DOCTYPE html>
 <html>
  <head>
   <meta charset="ISO-8859-1">
   <title>Library Management System </title>
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
	     <th>Title</th>
	     <th>Year Of Publish</th>
	     <th>ISBN</th>
	     <th>Available No</th>
	     <th>Author</th>
	     <th>Publisher</th>
	     <th>Delete  |  Update</th>	 
	   </tr>
	  </thead>
      <c:forEach var="book" items="${books}" varStatus="c">
        <c:url var="deleteLink" value="deleteBook">
		 <c:param name="id" value="${book.id}"></c:param>
		</c:url>
		<c:url var="updateLink" value="showFormForUpdateBook">
		 <c:param name="id" value="${book.id}"></c:param>
		</c:url>
	 <tbody>
	  <tr>
	   <td>${book.title}</td>
	   <td>${book.year}</td>
	   <td>${book.isbn}</td>
	   <td>${book.availableNo}</td>
	   <td>${book.author.name}</td>
	   <td>${book.publisher.name}</td>	   
	   <td>
	    <a class='btn btn-info btn-xs' href="${updateLink}"><span class="glyphicon glyphicon-edit"></span>Update</a>
	    <a href="${deleteLink}" class="btn btn-danger btn-xs"  onclick="if (!(confirm('Are you sure you want to delete this Book?'))) return false"><span
	     class="glyphicon glyphicon-remove"></span> Delete</a>
	    </td>
       </tr>
      </tbody>
     </c:forEach>
    </table>
   </div>
  </div>
 </body>
</html>
<!DOCTYPE html>
 <html lang="en">
  <head>
    <%@ page  isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <title>Library Management System</title>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
   <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
   <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
   <style type="text/css">
    .error{
     color: red;
    }
  </style>
 </head>
 <body>
  <jsp:include page="format.jsp"></jsp:include>
   <div class="container" align="center">
    <h2>Add Book Form</h2>
     <hr>
      <form:form action="addBook" modelAttribute="book" method="post">
       <table>
        <tr>
         <td><label for="title">Title:   </label></td>
         <td><form:input path="title"  placeholder="Enter Title"/></td>
         <td><form:errors path="title" cssClass="error"></form:errors></td>
        </tr>
        <tr>
         <td><label>Year Of Publish:</label></td>
         <td><form:input path="year" placeholder="Enter Year Of Publish"/></td>
         <td><form:errors path="year" cssClass="error"></form:errors></td>
       </tr>
       <tr>
        <td><label>ISBN:</label></td>
        <td><form:input path="isbn" placeholder="Enter ISBN"/></td>
        <td><form:errors path="isbn" cssClass="error"></form:errors></td>
      </tr>
      <tr>
       <td><label>Available No:</label></td>
       <td><form:input path="availableNo" placeholder="Enter Available No"/></td>
       <td><form:errors path="availableNo" cssClass="error"></form:errors></td>
     </tr>
     <tr>
      <td><label>Author:</label></td>
      <td><form:input path="author" placeholder="Enter Author"/></td>
     </tr>
     <tr>
      <td><label>Publisher:</label></td>
      <td><form:input path="publisher" placeholder="Enter Publisher"/></td>
     </tr>
     <tr>
      <td> <button type="submit" class="btn btn-primary">Add</button></td>
     </tr>
    </table>  
   </form:form> 
  </div>
 </body>
</html>

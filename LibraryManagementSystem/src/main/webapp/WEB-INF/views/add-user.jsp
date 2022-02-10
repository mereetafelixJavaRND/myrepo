<!DOCTYPE html>
<html lang="en">
 <head>
  <title>Library Management System</title>
   <%@ page  isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
   <h2>Add User Form</h2>
   <hr>
   <form:form action="addUser" modelAttribute="user" method="post">
    <table>
     <tr>
      <td><label for="name">Name:   </label></td>
      <td><form:input path="name"  placeholder="Enter Name"/></td>
      <td><form:errors path="name" cssClass="error"></form:errors></td>
     </tr> 
     <tr>
      <td><label>User Name:</label></td>
      <td><form:input path="userName" placeholder="Enter User Name"/></td>
      <td><form:errors path="userName" cssClass="error"></form:errors></td>
     </tr>
     <tr>
      <td><label>Password:</label></td>
      <td><form:input path="password" placeholder="Enter Password" type="password"/></td>
      <td><form:errors path="password" cssClass="error"></form:errors></td>
     </tr>
     <tr>
      <td><label>Email:</label></td>
      <td><form:input path="email" placeholder="Enter Email" type="email"/></td>
     </tr>
     <tr>
      <td><label>Expiry Date:</label></td>
      <td><form:input path="date" type="date" name="date" placeholder="Enter Expiry Date"/></td>
    </tr>
     <tr>
       <td> <button type="submit" class="btn btn-primary">Add</button></td>
     </tr>
    </table>  
   </form:form> 
  </div>
 </body>
</html>

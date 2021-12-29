<!DOCTYPE html>
 <html>
  <head>
   <meta charset="ISO-8859-1">
   <title>SPORT MANAGEMENT</title>
   <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page isELIgnored="false" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
   <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
   <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  </head>
  
  <body>
   <div class="container">
    <div class="row">
     <table class="table table-striped table-condensed">
      <tr>
       <td>Countries : </td>
       <td> ${list}</td>
      </tr>
     </table>
    </div>
   </div>
 </body>
</html>
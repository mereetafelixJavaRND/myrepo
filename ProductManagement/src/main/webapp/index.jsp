<html>
 <head>
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
  <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
  <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <%@ page isELIgnored="false" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 </head>
 <body>
  <jsp:include page="header.jsp"></jsp:include>
  <b><h4 style="text-align:right">welcome ${sessionScope.user.userName}</h4></b>
  <jsp:include page="user-menu.jsp"></jsp:include>
 </body>
</html>

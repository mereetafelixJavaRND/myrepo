<!DOCTYPE html>
 <html>
  <head>
   <meta charset="ISO-8859-1">
   <title>SPORT MANAGEMENT</title>
   <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
   <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
   <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  </head>
  
  <body>
   <form action="country">
    <div id="login-column" class="col-md-6">
     <div id="login-box" class="col-md-12">
      <div class="form-group">
		1. India
	  </div>
	  <div class="form-group">
		2. China
	  </div>
	  <div class="form-group">
		3. UAE
	  </div>
	  <div class="form-group">
		4. UK
	  </div>
	  <div class="form-group">
		5. Switzerland
      </div>
      <div class="form-group">
		Search By CountryId:<input type="text" name="id" class="form-control"/> 
	  </div>
	  <div class="form-group">
		<input type="submit" value="submit" name="submit" class="btn btn-info btn-md"/> 
	  </div>
	  <div class="form-group">
		<a href="searchLang.jsp">Search By LangId</a>
	  </div>
	 </div>
	</div>
   </form>
 </body>
</html>
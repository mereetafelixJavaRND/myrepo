<!DOCTYPE html>
<html lang="en">
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
  <div class="signup-form">
    <form action ="product">
     <div class="form-group">
       <div class="row">
          <div class="col-md-3 ">
              <div id="box" class="col-md-12">
                 Product Name:<input type="text" class="form-control" name="pname"
                 required="required" placeholder="Enter Product Name">
               </div>
           </div>
         </div>
     </div>
     <div class="form-group">
      <div class="row">
       <div class="col-md-3">
        <div id="box" class="col-md-12">
          Price:<input type="text" class="form-control" name="price"
          placeholder="Enter Price" required="required">
         </div>
        </div>
       </div>
     </div>
     <div class="form-group">
      <div class="row">
       <div class="col-md-3">
        <div id="box" class="col-md-12">  
          Quantity In Stock:
          <div>
           <select name="quantity" style="width: 290px">
            <option value=" "> </option>
            <option value="50">50</option>
            <option value="100">100</option>
            <option value="150">150</option>
            <option value="200">200</option>
          </select>
         </div>
        </div>
       </div>
      </div>
     </div>
     <div class="form-group">
      <div class="row">
       <div class="col-md-3">
        <div id="box" class="col-md-12">
         Vendor:<input type="text" placeholder="Vendor"
         name="vendor" required="required" class="form-control">
        </div>
       </div>
      </div>
     </div>
     <div class="form-group">
     <div class="row">
      <div class="col-md-3">
       <div id="box" class="col-md-12">  
        Warranty:
         <div>  
          <select name="warranty" style="width: 290px">
           <option value=" "> </option>
      	   <option value="0">0</option>
           <option value="1">1</option>
           <option value="2">2</option>
           <option value="3">3</option>
           <option value="4">4</option>
           <option value="5">5</option>
          </select>
         </div>
        </div>
       </div>
      </div>
     </div> 
     <div class="form-group">
      <div class="row">
       <div class="col-md-3">
        <div id="box" class="col-md-12">
         <input type="submit" name="submit" class="btn btn-info btn-md" value="Add">
        </div>
       </div>
      </div>
     </div>
   </form>
  </div>
 </body>
</html>
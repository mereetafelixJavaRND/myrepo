<!DOCTYPE html>
<html lang="en">
 <head>
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
  <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
  <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 </head>
 <body>
  <jsp:include page="menu.jsp"></jsp:include>
  <div class="signup-form">
   <div class="row">
    <div class="col-md-3 ">
     <div id="box" class="col-md-12">
      <h2>Register</h2>
     </div>
    </div>
   </div>
   <form action ="register">
    <div class="form-group">
     <div class="row">
      <div class="col-md-3 ">
       <div id="box" class="col-md-12">
         Name: <input type="text" class="form-control" name="name"
         required="required" placeholder="Enter Name">
       </div>
      </div>
     </div>
    </div>
    <div class="form-group">
     <div class="row">
      <div class="col-md-3">
       <div id="box" class="col-md-12">
         Mobile Number: <input type="text" class="form-control" name="phone"
          placeholder="Mobile Number" required="required">
        </div>
       </div>
      </div>
     </div>
     <div class="form-group">
      <div class="row">
       <div class="col-md-3">
        <div id="box" class="col-md-12">
         Email: <input type="text" class="form-control" name="email"
         placeholder="Email" required="required">
        </div>
       </div>
      </div>
     </div>
     <div class="form-group">
      <div class="row"> 
       <div class="col-md-3">
        <div id="box" class="col-md-12">
         User Name:  <input type="text" placeholder="User Name"
         name="username" required="required" class="form-control">
        </div>
       </div>
      </div>
     </div>
     <div class="form-group">
      <div class="row">
       <div class="col-md-3">
         <div id="box" class="col-md-12">
          Password: <input type="password" placeholder="Password"
          name="password" required="required" class="form-control">
         </div>
        </div>
       </div>
      </div>
      <div class="form-group">
      <div class="row">
       <div class="col-md-3">
        <div id="box" class="col-md-12">
         <input type="submit" name="submit" class="btn btn-info btn-md" value="submit">
        </div>
       </div>
      </div>
     </div>
    </form>    
  </div>
 </body>
</html>
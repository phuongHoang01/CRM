<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 
</head>
<body>

<!-- Page Content -->
	<div id="page-wrapper">
		<div class="container">
  <div class="row mt-5">
    <div class="col-md-5 m-auto mt-5" style="  margin-left: 342px; margin-top: 127px;">
      <h3 class="text-center">ĐĂNG NHẬP HỆ THỐNG</h3>
      <h4>${message01}</h4>
      <div class="p-4 border mt-4">
        <form action="<%=request.getContextPath() %>/Login" method="post">
            <div class="form-group">
              <label>Email</label>
              <input type="email" class="form-control" name="email" placeholder="admin@gmail.com">
            </div>
            <div class="form-group">
              <label>Mật khẩu</label>
              <input type="password" class="form-control" name="password" placeholder="admin">
            </div>
            <button type="submit" class="btn btn-primary">Đăng nhập</button>
          </form>
      </div>
      </div>
  </div>
</div>
		
	</div>
	<!-- /#page-wrapper -->
	</div>
</body>
</html>

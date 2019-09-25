<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Page Content -->
	<div id="page-wrapper">
		<div style="text-align: center; padding-top: 82px; padding-bottom: 0">
			<h1>Chỉnh sửa thông tin người dùng</h1>
		</div>
		<form class="container" style="padding-top: 29px; width: 50%"
			action='<c:url value="${UrlConst.USER_EDIT}">
		<c:param name="id" value="${user.id}"/>
		</c:url>'
			method="post">
			<div class="form-group">
				<label for="fullName">Full name:</label> <input type="text"
					class="form-control" id="fullName" name="fullName"
					value="${user.fullName}">
			</div>
			<div class="form-group">
				<label for="email">Email address:</label> <input type="email"
					class="form-control" id="email" name="email" value="${user.email}">
			</div>

			<div class="form-group">
				<label for="avatar">Avatar:</label> <input type="text"
					class="form-control" id="avatar" name="avatar"
					value="${user.avatar}">
			</div>

			<label for="roleID">Select Role:</label>
			<select class="form-control form-control-line" name="role">
				<c:forEach items="${roles}" var="item">
					<option value="${item.id}">${item.description}</option>
				</c:forEach>

			</select> 
			
		
				<button style="margin-top: 26px;border-radius: 21px" type="submit" class="btn btn-info btn-block">Update</button>
				
			



		</form>
	</div>
	<!-- /.container-fluid -->
	<footer class="footer text-center"> 2018 &copy; myclass.com </footer>
	</div>
	<!-- /#page-wrapper -->
	</div>

</body>
</html>
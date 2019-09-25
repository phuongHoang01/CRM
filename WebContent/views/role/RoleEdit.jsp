<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.CRM.CONST.UrlConst" %>
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
			<h1>Chỉnh sửa quyền hệ thống</h1>
		</div>
		<form class="container" style="padding-top: 29px; width: 50%"
			action='<c:url value="${UrlConst.ROLE_EDIT }">
		<c:param name="id" value="${roleToEdit.id}"/>
		</c:url>'
			method="post">
			<div class="form-group">
				<label for="fullName">Tên quyền:</label> <input type="text"
					class="form-control" id="fullName" name="name"
					value="${roleToEdit.name}">
			</div>
			<div class="form-group">
				<label for="email">Mô tả:</label> <input type="text"
					class="form-control" id="email" name="description" value="${roleToEdit.description}">
			</div>

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
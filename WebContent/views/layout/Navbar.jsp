<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body>
<!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top m-b-0">
            <div class="navbar-header"> <a class="navbar-toggle hidden-sm hidden-md hidden-lg "
                    href="javascript:void(0)" data-toggle="collapse" data-target=".navbar-collapse"><i
                        class="fa fa-bars"></i></a>
                <div class="top-left-part"><a class="logo" href="index.html"><b><img
                                src="<%=request.getContextPath()%>/assets/plugins/images/pixeladmin-logo.png" alt="home" /></b><span
                            class="hidden-xs"><img src="<%=request.getContextPath()%>/assets/plugins/images/pixeladmin-text.png" alt="home" /></span></a>
                </div>
                <ul class="nav navbar-top-links navbar-left m-l-20 hidden-xs">
                    <li>
                        <form role="search" class="app-search hidden-xs">
                            <input type="text" placeholder="Search..." class="form-control"> <a href=""><i
                                    class="fa fa-search"></i></a>
                        </form>
                    </li>
                </ul>
                <ul class="nav navbar-top-links navbar-right pull-right">
                
                    <li>
	                    <div class="dropdown">
						  <a href="javascript:void(0)" class="dropdown-toggle profile-pic" data-toggle="dropdown">
						  	<img src='<c:url value="/assets/plugins/images/users/varun.jpg"/>' alt="user-img"
                                width="36" class="img-circle">
                                <b class="hidden-xs">
						  			${User_login.fullName}
						  		</b>
						  	<span class="caret"></span>
						  </a>
						  <ul class="dropdown-menu">
						    <li><a href="#">${User_login.description}</a></li>
						    <li><a href='<c:url value="/Logout"></c:url>'>Đăng xuất</a></li>
						  </ul>
						</div>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-header -->
            <!-- /.navbar-top-links -->
            <!-- /.navbar-static-side -->
        </nav>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
        
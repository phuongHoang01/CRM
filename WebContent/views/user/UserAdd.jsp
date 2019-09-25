<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.CRM.CONST.UrlConst" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" type="image/png" sizes="16x16" href="<%=request.getContextPath()%>/assets/plugins/images/favicon.png">
    <title>Pixel Admin</title>
    <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath()%>/assets/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Menu CSS -->
    <link href="<%=request.getContextPath()%>/assets/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css" rel="stylesheet">
    <!-- animation CSS -->
    <link href="<%=request.getContextPath()%>/assets/css/animate.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="<%=request.getContextPath()%>/assets/css/style.css" rel="stylesheet">
    <!-- color CSS -->
    <link href="<%=request.getContextPath()%>/assets/css/colors/blue-dark.css" id="theme" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>

<body>
   
        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">Thêm mới thành viên</h4>
                    </div>
                </div>
                <!-- /.row -->
                <!-- .row -->
                <div class="row">
                    <div class="col-md-2 col-12"></div>
                    <div class="col-md-8 col-xs-12">
                        <div class="white-box">
                            <form class="form-horizontal form-material" method ="POST" action='<c:url value="${UrlConst.USER_ADD }"></c:url>'>
                                <div class="form-group">
                                    <label class="col-md-12">Full Name</label>
                                    <div class="col-md-12">
                                        <input type="text" placeholder="Johnathan Doe" name="fullName"
                                            class="form-control form-control-line"> </div>
                                </div>
                                <div class="form-group">
                                    <label for="example-email" class="col-md-12">Email</label>
                                    <div class="col-md-12">
                                        <input type="email" placeholder="johnathan@admin.com"
                                            class="form-control form-control-line" name="example-email"
                                            id="example-email"> </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Password</label>
                                    <div class="col-md-12">
                                        <input type="password" name = "password" value="password" class="form-control form-control-line">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Avatar</label>
                                    <div class="col-md-12">
                                        <input name ="avatar" type="text" 
                                            class="form-control form-control-line"> </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-12">Select Role</label>
                                    <div class="col-sm-12">
                                        <select class="form-control form-control-line" name="role">
                                        	<c:forEach items="${roles}" var="item">
                                        		<option value="${item.id}">${item.description}</option>
                                        	</c:forEach>
                                           
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <button type="submit" class="btn btn-success">Add User</button>
                                        <a href="user-table.html" class="btn btn-primary">Quay lại</a>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="col-md-2 col-12"></div>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
            <footer class="footer text-center"> 2018 &copy; myclass.com </footer>
        </div>
        <!-- /#page-wrapper -->
    </div>
      <!-- /#wrapper -->
    <!-- jQuery -->
    <script src="<%=request.getContextPath()%>/assets/plugins/bower_components/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath()%>/assets/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- Menu Plugin JavaScript -->
    <script src="<%=request.getContextPath()%>/assets/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js"></script>
    <!--slimscroll JavaScript -->
    <script src="<%=request.getContextPath()%>/assets/js/jquery.slimscroll.js"></script>
    <!--Wave Effects -->
    <script src="<%=request.getContextPath()%>/assets/js/waves.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="<%=request.getContextPath()%>/assets/js/custom.min.js"></script>

</body>

</html>
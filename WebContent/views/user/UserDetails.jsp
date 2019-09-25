<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" type="image/png" sizes="16x16"
	href="<%=request.getContextPath()%>/assets/plugins/images/favicon.png">
<title>Pixel Admin</title>
<!-- Bootstrap Core CSS -->
<link
	href="<%=request.getContextPath()%>/assets/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Menu CSS -->
<link
	href="<%=request.getContextPath()%>/assets/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css"
	rel="stylesheet">
<!-- animation CSS -->
<link href="<%=request.getContextPath()%>/assets/css/animate.css"
	rel="stylesheet">
<!-- Custom CSS -->
<link href="<%=request.getContextPath()%>/assets/css/style.css"
	rel="stylesheet">
<!-- color CSS -->
<link
	href="<%=request.getContextPath()%>/assets/css/colors/blue-dark.css"
	id="theme" rel="stylesheet">
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
						<h4 class="page-title">Chi tiết thành viên</h4>
					</div>
				</div>
				<!-- /.row -->
				<!-- .row -->
				<div class="row">
					<div class="col-md-4 col-xs-12">
						<div class="white-box">
							<div class="user-bg">
								<img width="100%" alt="user"
									src="<%=request.getContextPath()%>/assets/plugins/images/large/img1.jpg">
								<div class="overlay-box">
									<div class="user-content">
										<a href="javascript:void(0)"><img
											src="<%=request.getContextPath()%>/assets/plugins/images/users/genu.jpg"
											class="thumb-lg img-circle" alt="img"></a>
										<h4 class="text-white">User Name</h4>
										<h5 class="text-white">info@myadmin.com</h5>
									</div>
								</div>
							</div>
							<div class="user-btm-box">
								<div class="col-md-4 col-sm-4 text-center">
									<p class="text-purple">
										<i class="ti-facebook"></i>
									</p>
									<h4>20%</h4>
									<h6>Chưa thực hiện</h6>
								</div>
								<div class="col-md-4 col-sm-4 text-center">
									<p class="text-blue">
										<i class="ti-twitter"></i>
									</p>
									<h4>50%</h4>
									<h6>Đang thực hiện</h6>
								</div>
								<div class="col-md-4 col-sm-4 text-center">
									<p class="text-danger">
										<i class="ti-dribbble"></i>
									</p>
									<h4>30%</h4>
									<h6>Hoàn thành</h6>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-8 col-xs-12">
						<div class="white-box">
							<form class="form-horizontal form-material">
								<div class="form-group">
									<label class="col-md-12">Full Name</label>
								</div>
								<div class="form-group">
									<label for="example-email" class="col-md-12">Email</label>
								</div>
								<div class="form-group">
									<label class="col-md-12">Password</label>
								</div>
								<div class="form-group">
									<label class="col-md-12">Phone No</label>
								</div>
								<div class="form-group">
									<label class="col-sm-12">Select Country</label>
								</div>
								<div class="form-group">
									<label class="col-sm-12">Select Country</label>
								</div>
							</form>
						</div>
					</div>
				</div>
				<br />
				<!-- /.row -->
				<!-- BEGIN DANH SÁCH CÔNG VIỆC -->
				<h4>DANH SÁCH CÔNG VIỆC</h4>
				<div class="row">
					<div class="col-md-4">
						<div class="white-box">
							<h3 class="box-title">Chưa thực hiện</h3>
							<div class="message-center">
								<a href="#">
									<div class="mail-contnet">
										<h5>Pavan kumar</h5>
										<span class="mail-desc">Just see the my admin!</span> <span
											class="time">9:30 AM</span>
									</div>
								</a> <a href="#">
									<div class="mail-contnet">
										<h5>Sonu Nigam</h5>
										<span class="mail-desc">I've sung a song! See you at</span> <span
											class="time">9:10 AM</span>
									</div>
								</a>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="white-box">
							<h3 class="box-title">Đang thực hiện</h3>
							<div class="message-center">
								<a href="#">
									<div class="mail-contnet">
										<h5>Pavan kumar</h5>
										<span class="mail-desc">Just see the my admin!</span> <span
											class="time">9:30 AM</span>
									</div>
								</a> <a href="#">
									<div class="mail-contnet">
										<h5>Sonu Nigam</h5>
										<span class="mail-desc">I've sung a song! See you at</span> <span
											class="time">9:10 AM</span>
									</div>
								</a>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="white-box">
							<h3 class="box-title">Đã hoàn thành</h3>
							<div class="message-center">
								<a href="#">
									<div class="mail-contnet">
										<h5>Pavan kumar</h5>
										<span class="mail-desc">Just see the my admin!</span> <span
											class="time">9:30 AM</span>
									</div>
								</a> <a href="#">
									<div class="mail-contnet">
										<h5>Sonu Nigam</h5>
										<span class="mail-desc">I've sung a song! See you at</span> <span
											class="time">9:10 AM</span>
									</div>
								</a>
							</div>
						</div>
					</div>
				</div>
				<!-- END DANH SÁCH CÔNG VIỆC -->
			</div>
			<!-- /.container-fluid -->
			<footer class="footer text-center"> 2018 &copy; myclass.com
			</footer>
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->
	<!-- jQuery -->
	<script
		src="<%=request.getContextPath()%>/assets/plugins/bower_components/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script
		src="<%=request.getContextPath()%>/assets/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- Menu Plugin JavaScript -->
	<script
		src="<%=request.getContextPath()%>/assets/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js"></script>
	<!--slimscroll JavaScript -->
	<script
		src="<%=request.getContextPath()%>/assets/js/jquery.slimscroll.js"></script>
	<!--Wave Effects -->
	<script src="<%=request.getContextPath()%>/assets/js/waves.js"></script>
	<!-- Custom Theme JavaScript -->
	<script src="<%=request.getContextPath()%>/assets/js/custom.min.js"></script>
</body>

</html>
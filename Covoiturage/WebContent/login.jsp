<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<!-- Make IE8 behave like IE7, necessary for charts -->
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
		
		<title>Covoiturage Admin Control Panel</title>
		
		<!-- CSS -->
		<link rel="stylesheet" type="text/css" media="screen" href="resources/css/reset.css" />
		<link rel="stylesheet" type="text/css" media="screen" href="resources/css/main.css" />
		<link rel="stylesheet" type="text/css" media="screen" href="resources/css/custom-theme/jquery-ui-1.8.1.custom.css" />
		
		<!-- IE specific CSS stylesheet -->
		<!--[if IE]>
			<link rel="stylesheet" type="text/css" media="screen" href="resources/css/ie.css" />
		<![endif]-->
		
		<!-- This stylesheet contains advanced CSS3 features that do not validate yet -->
		<link rel="stylesheet" type="text/css" media="screen" href="resources/css/css3.css" />
		
		<!-- JavaScript -->
		<script type="text/javascript" src="resources/js/jquery-1.4.2.min.js"></script>
		<script type="text/javascript" src="resources/js/jquery-ui.min.js"></script>
		<script type="text/javascript" src="resources/js/jquery.wysiwyg.js"></script>
		<script type="text/javascript" src="resources/js/excanvas.js"></script>
		<script type="text/javascript" src="resources/js/jquery.visualize.js"></script>
		<script type="text/javascript" src="resources/js/script.js"></script>
	</head>

	<body>
		<div id="bokeh"><div id="container">
			
			<div id="header">
				<h1 id="logo">Covoiturage Admin Control Panel</h1>
			</div><!-- end #header -->
			
			<div id="content">
			
				<h2><img src="resources/images/icons/user_32.png" alt="Login" />Login</h2>
			
				<div id="login">
					
					<div class="content-box">
						<div class="content-box-header">
							<h3>Login</h3>
						</div>
					
						<div class="content-box-content">
						
							<div style="display:none" class="notification information">Just click login to go forward.</div>
						
							<form action="login">
								<p>
									<label>Username</label>
									<input id="username" name="username" type="text" />
								</p>
						
								<p>
									<label>Password</label>
									<input id="password" name="password" type="password" />
								</p>
						
								<input type="submit" value="Login" />
							</form>
						</div>
					</div><!-- end .content-box -->
				</div><!-- end #login -->
											
			</div><!-- end #content -->
			
			<div id="push"></div><!-- push footer down -->
			
		</div></div><!-- end #container -->
		
		<div id="footer">
			Coivoiturage Admin Control Panel | Designed by <a href="">hk</a> 2013
		</div><!-- end #footer and #bokeh -->
		
	</body>
</html>
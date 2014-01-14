<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<!-- Make IE8 behave like IE7, necessary for charts -->
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7">
		
		<title>Admin Control Panel</title>
		
		<!-- CSS -->
		<link rel="stylesheet" type="text/css" media="screen" href="resources/css/reset.css">
		<link rel="stylesheet" type="text/css" media="screen" href="resources/css/main.css">
		<link rel="stylesheet" type="text/css" media="screen" href="resources/css/custom-theme/jquery-ui-1.8.1.custom.css">
		
		<!-- IE specific CSS stylesheet -->
		<!--[if IE]>
			<link rel="stylesheet" type="text/css" media="screen" href="resources/css/ie.css" />
		<![endif]-->
		
		<!-- This stylesheet contains advanced CSS3 features that do not validate yet -->
		<link rel="stylesheet" type="text/css" media="screen" href="resources/css/css3.css">
		
		<!-- JavaScript -->
		<script type="text/javascript" src="resources/js/jquery-1.4.2.min.js"></script>
		<script type="text/javascript" src="resources/js/jquery-ui.min.js"></script>
		<script type="text/javascript" src="resources/js/jquery.wysiwyg.js"></script>
		<script type="text/javascript" src="resources/js/jquery.rounded.js"></script>
		<script type="text/javascript" src="resources/js/excanvas.js"></script>
		<script type="text/javascript" src="resources/js/jquery.visualize.js"></script>
		<script type="text/javascript" src="resources/js/script.js"></script>
	</head>
<body>
		<div id="bokeh"><div id="container">
			
			<div id="header">
				<h1 id="logo">Admin Control Panel </h1>
				
				<div id="header_buttons">
					
					<div class="modal"><a href="#modal" rel="modal"><img src="resources/images/icons/envelope.png" alt="3 Messages">3</a>	
					<div class="modalbox">
						<div class="modalhead">
							<img src="resources/images/modaltop.png" alt="Modal arrow">
							Mailbox
						</div>
						
						<div class="modalcontent">
							<div class="message">
								<div class="author"><a href="#">Teun</a></div>
								<div class="content">This skin can be easily styled!</div>
								<div class="datetime">16-05 - 08:16</div>
							</div>
							
							<div class="message">
								<div class="author"><a href="#">Pieter</a></div>
								<div class="content">It can also be styled very easily.</div>
								<div class="datetime">11-05 - 16:27</div>
							</div>
								
							<div class="message">
								<div class="author"><a href="#">Jane Doe</a></div>
								<div class="content">This template uses a lot of nice CSS3 effects.</div>
								<div class="datetime">10-05 - 18:42</div>
							</div>
						</div>
							
						<div class="modalfoot">
							<img src="resources/images/icons/newmessage.png" alt="New message"> New message
						</div>
					</div>
				</div>				
					<div class="modal"><a href="#modal2" rel="modal">modal box test</a>	
					<div class="modalbox">
						<div class="modalhead">
							<img src="resources/images/modaltop.png" alt="Modal arrow">
							Mailbox 2
						</div>
						
						<div class="modalcontent">
							<div class="message">
								<div class="author"><a href="#">Pieter</a></div>
								<div class="content">It can also be styled very easily.</div>
								<div class="datetime">11-05 - 16:27</div>
							</div>
								
							<div class="message">
								<div class="author"><a href="#">Jane Doe</a></div>
								<div class="content">This template uses a lot of nice CSS3 effects.</div>
								<div class="datetime">10-05 - 18:42</div>
							</div>
						</div>
							
						<div class="modalfoot">
							<img src="resources/images/icons/newmessage.png" alt="New message"> New message
						</div>
					</div>
				</div>
					<a href="#">logout</a>
					<a href="#">view website</a>
					
				</div><!-- end #header_buttons -->
				
				<!-- Modal box -->
				
				
				<!-- Modal box 2 -->
				
				
				<!-- Navigation -->
				<ul id="main-nav">
					<li>
						<a href="login.html">
							Dashboard
						</a>
					</li>
						
					<li>
						<a href="#"><!-- use href="#" to indicate there's a submenu -->
							Content
						</a>
						
						<ul style="display: none;">
							<li><a href="#">Pages</a></li>
							<li><a href="#">Articles</a></li>
						</ul>
					</li>
						
					<li>
						<a href="#">
							Layout
						</a>
						
						<ul style="display: none;">
							<li><a href="#">Edit CSS</a></li>
							<li><a href="#">Manage Themes</a></li>
						</ul>
					</li>
						
					<li>
						<a href="#" class="current">
							Users
						</a>
						
						<ul style="display: block;">
							<li><a href="#">Permissions</a></li>
							<li><a href="#" class="current">Manage Users</a></li>
							<li><a href="#">Manage Usergroups</a></li>
						</ul>
					</li>
						
					<li>
						<a href="#">
							Settings
						</a>
						
						<ul style="display: none;">
							<li><a href="#">Account settings</a></li>
							<li><a href="#">Domain settings</a></li>
						</ul>
					</li>
				</ul><!-- end #nav -->
				
			<h2><img src="resources/images/icons/tools_32.png" alt="Manage Users">Manage Users</h2></div><!-- end #header -->
			
			<div id="content">
			
				
				<div class="clear"></div>
				
				<div class="content-box">
					<div class="content-box-header">
						<h3>Form</h3>
					</div>
					
					<div class="content-box-content">
						<form action="#">
							<fieldset>
								<p>
									<label>Username</label>
									<input id="username" type="text" class="small" style="color: rgb(150, 150, 150);"><!-- add .align-right to align the input elements to the right -->
									<span class="notification information">This is an informative message.</span>
								</p>
									
								<p>
									<label>Real name</label>
									<input id="real_name" type="text" class="medium" value="Bram Jetten"><!-- the value-attribute overwrites the <label>Username</label> -->
									<span class="notification success">Success!</span>
								</p>
									
								<p>
									<label>Birthday</label>
									<input id="birthday" type="text" class="small datepicker hasDatepicker" style="color: rgb(150, 150, 150);"><img class="datepickericon" src="resources/images/icons/calendar.png" alt="calendar">
									<span class="notification error">Error!</span>
									<small>This is a datepicker!</small>
								</p>
								
								<p>
									<label>Select an option</label>
									<div class="skinned-select"><div class="select-text">Option 2</div><select>
										<option>Choose an option...</option>
										<option>Option 1</option>
										<option selected="selected">Option 2</option>
										<option>Option 3</option>
									</select></div>
									<span class="notification warning">Warning!</span>
									<small>Just for the sake of adding a dropdown.</small>
								</p>
									
								<p>
									<div class="wysiwyg" style="width: 914px;"><ul class="panel"><li><a class="bold"><!-- --></a></li><li><a class="italic"><!-- --></a></li><li class="separator"></li><li><a class="undo"><!-- --></a></li><li><a class="redo"><!-- --></a></li><li class="separator"></li><li><a class="createLink"><!-- --></a></li><li><a class="insertImage"><!-- --></a></li><li class="separator"></li><li><a class="h1"><!-- --></a></li><li><a class="h2"><!-- --></a></li><li><a class="h3"><!-- --></a></li><li class="separator"></li><li><a class="html"><!-- --></a></li><li><a class="removeFormat"><!-- --></a></li></ul><div style="clear: both;"><!-- --></div><iframe frameborder="0" id="IFrame" style="min-height: 198px; width: 906px;"></iframe></div><textarea class="wysiwyg" style="display: none;"></textarea>
								</p>
							</fieldset>
						
							<input type="submit" value="Submit">
						</form>
					</div>
				</div>
				
				
							
			</div><!-- end #content -->
			
		<div id="push"></div></div></div><!-- end #bokeh and #container -->
		
		<div id="footer">
			Admin Control Panel | Designed by <a href="">hk</a> 2014
		</div><!-- end #footer -->

	
<div id="ui-datepicker-div" class="ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all ui-helper-hidden-accessible"></div><div id="overlay"></div></body>
</html>
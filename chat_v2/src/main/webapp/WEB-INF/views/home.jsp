<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>

<link href="<c:url value="resources/css/registration.css" />"
	rel="stylesheet">
<link href="<c:url value="resources/css/main.css" />" rel="stylesheet">
<link href="<c:url value="resources/css/main.css" />" rel="stylesheet">

<link href="<c:url value="resources/css/addFoto.css" />"
	rel="stylesheet">
<link href="<c:url value="resources/css/userInfo.css" />"
	rel="stylesheet">
<link href="<c:url value="resources/css/style.css" />" rel="stylesheet">
<link
	href="<c:url value="resources/css/font-awesome-4.7.0/css/font-awesome.css" />"
	rel="stylesheet">
<script type="text/javascript"
	src="<c:url value="resources/js/libraries/jquery-3.3.1.min.js" />"></script>
	





<title>Chat by Alexandr</title>
</head>
<body>

	<div id="form">
		<div class="form_head">
			<ul>
				<li id="form-enter-button">LOG IN</li>
				<li id="form-registration-button">SIGN UP</li>
			</ul>
		</div>

		<form class="form_login form_submit " metod="POST" action="login_user"
			enctype="multipart/form-data">

			<input name="login" type="text" placeholder="Login" /> <input
				name="password" type="password" placeholder="Password" /> <input
				type="submit" value="Login">

		</form>



		<form class="form_registration form_submit" metod="POST"
			action="registration_user" enctype="multipart/form-data">
			<input name="login" type="text" placeholder="Login" /> <input
				name="password" type="password" placeholder="Password" /> <input
				name="name" type="text" placeholder="Name" /> <input name="surname"
				type="text" placeholder="Surname" /> <input name="telephone"
				type="tel" placeholder="Telephone" /> <input name="email"
				type="email" placeholder="Email" /> <input type="submit"
				value="Registration">

		</form>




	</div>

	<div id="main">


				


		<header>
			<div class="header_chatName">Chat v2</div>
			<ul>
				<li>Online</li>
				<li><div class="header_online_ball"></div></li>
				<li><img src="<c:url value="resources/images/man.png" />"
					alt="profile_image" class="profile_image"></li>
				<li id="user_name">${sessinoUser.getLogin()}</li>
				<li><img src="<c:url value="resources/images/exit.png" />"
					alt="Exit" id="exit_buttom"></li>

			</ul>


		</header>

		<div class="content">
			<div class="content_messagelist">
						
				<c:forEach var="item" items="${dao.getMessageDAO().getLast(0)}">
				
				<div class="message_item">
					<img src="<c:url value="resources/images/man.png" />"
						alt="изображение профиля">
					<div class="message_text">${item.getTextMessage()} 
					<span class="message_time">${item.getTimeStamp()}</span>

					</div>
				</div>

				</c:forEach>


			</div>
			<div class="content_send_message">
				<form action="send_message">
					<input type="text"> <input type="submit" value="send">
					${user.getLogin()}
				</form>
			</div>
					

		</div>
		
		
		
		<div class="sidebar">
			<div class="sidebar_header">
				<img src="<c:url value="resources/images/man.png" />"
					alt="Users_ico">Users:
			</div>
			<div class="sidebar_userlist">
			
			
			<c:forEach var="item" items="${dao.getUserDAO().getAllLogged()}">
					
			
				<div class="user_id">
					<span class="user_name">${item.getLogin()}</span>
					<div class="online_ball"></div>

					<div class="userInfo">

						<img src="<c:url value="resources/images/cross-remove-sign.png" />" alt="Выход"
							class="userExit">
						<div class="mainInfo">
							<img src="<c:url value="resources/images/man.png" />" alt="Изображение профиля"> 
							<span>${item.getName()}   ${item.getSurname()} </span>
						</div>

						<div class="allUsersSpans">

							<span>Telephone:${item.getTelephone()}</span> 
							<span>Email: ${item.getEmail()}</span>

						</div>
						<button class="adminButton">BANNED</button>

					</div>

				</div>
				</c:forEach>



			</div>
		</div>


	</div>


	<div class="formAddFoto">

		<input type="file" name="file" id="file" class="input-file"> <label
			for="file" class="btn btn-tertiary js-labelFile"> <i
			class="icon fa fa-check"></i> <span class="js-fileName">Choose
				a file</span>
		</label> <a href="#" class="upload_files button">Download image</a>
		<div class="ajax-reply"></div>

	</div>



	<script src="<c:url value="resources/js/formChoice.js" />"></script>
	<script src="<c:url value="resources/js/downloadFile.js" />"></script>
	<script src="<c:url value="resources/js/loginFormSender.js" />"></script>
	<script src="<c:url value="resources/js/registrationTest.js" />"></script>
	<script src="<c:url value="resources/js/choiseFile.js" />"></script>

</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>

<link href="<c:url value="resources/css/registration.css" />" rel="stylesheet">
<link href="<c:url value="resources/css/style.css" />" rel="stylesheet">
<link href="<c:url value="resources/css/main.css" />" rel="stylesheet">
<link href="<c:url value="resources/css/font-awesome-4.7.0/css/font-awesome.css" />" rel="stylesheet">
<script  type="text/javascript" src="<c:url value="resources/js/jquery-3.3.1.min.js" />"></script>
<script  src="<c:url value="resources/js/javaScript.js" />"></script>
<script  src="<c:url value="resources/js/downloadFile.js" />"></script>
<script  src="<c:url value="resources/js/loginForm.js" />"></script>




	<title>Chat by Alexandr</title>
</head>
<body>

<div id="form">
    <div class="form_head">
         <ul>
                <li id="form-enter-button" >LOG IN</li>
                <li id="form-registration-button">SIGN UP</li>
         </ul>
    </div>
    
    <form class="form_login form_submit " metod="POST"  action="login_user" enctype="multipart/form-data">
       
       <input name="login" type="text" placeholder="Login"/> 
       <input name="password" type="password" placeholder="Password"/> 
       <input type="submit" value="Login" > 
   
    </form>
 


    <form class="form_registration form_submit" metod="POST"  action="registration_user" enctype="multipart/form-data">
        <input name="login"  type="text" placeholder="Login"/>
        <input name="password"  type="password" placeholder="Password"/> 
        <input name="name" type="text" placeholder="Name"/>
        <input name="surname" type="text" placeholder="Surname"/>
        <input name="telephone" type="tel" placeholder="Telephone"/>
        <input name="email" type="email" placeholder="Email" />
        <input  type="submit" value="Registration" >

    </form>




</div>
</body>
</html>

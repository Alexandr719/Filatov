<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>

<link href="<c:url value="resources/css/registration.css" />" rel="stylesheet">

<link href="<c:url value="resources/css/main.css" />" rel="stylesheet">
<link href="<c:url value="resources/css/style.css" />" rel="stylesheet">
<link href="<c:url value="resources/css/font-awesome-4.7.0/css/font-awesome.css" />" rel="stylesheet">
<script  type="text/javascript" src="<c:url value="resources/js/jquery-3.3.1.min.js" />"></script>





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

<div id="main">

    <header>
        <div class="header_chatName">Chat v2</div>
        <ul>
            <li >Online</li>
            <li><div class="header_online_ball"></div></li>
            <li><img src="<c:url value="resources/images/man.png" />" alt="profile_image" class="profile_image"></li>
            <li id="user_name">Filatov Alexandr</li>
            <li><img src="<c:url value="resources/images/man.png" />" alt="Exit" id="exit_buttom"></li>

        </ul>


    </header>

    <div class="content">
    <div class="content_messagelist">
        <div class="message_item">
            <img  src="<c:url value="resources/images/man.png" />" alt="изображение профиля">
             <div class="message_text">Hello
             <span class="message_time">23:01</span>

             </div>
        </div>
        <div class="message_item">
            <img  src="<c:url value="resources/images/man.png" />" alt="изображение профиля">
            <div class="message_text"> Hello

                <span class="message_time">23:01</span>

            </div>
        </div>
       







    </div>
    <div class="content_send_message">
        <form action="#">
            <input type="text">
            <input type="submit" value="send">
        </form>
        
        
        
        
        
        
    </div>

    </div>
    <div class="sidebar">
        <div class="sidebar_header"><img src="<c:url value="resources/images/man.png" />" alt="Users_ico">Users:</div>
        <div class="sidebar_userlist">
            <div class="user_id">
                <span class="user_name">Name Surname</span>
                <div class="online_ball"></div>


            </div>
            <div class="user_id">
                <span class="user_name">Name Surname</span>
                <div class="online_ball active_ball"></div>

            </div>








        </div>
     </div>






</div>





<script  src="<c:url value="resources/js/formChoice.js" />"></script>
<script  src="<c:url value="resources/js/downloadFile.js" />"></script>
<script  src="<c:url value="resources/js/loginFormSender.js" />"></script>
<script  src="<c:url value="resources/js/registrationTest.js" />"></script>

</body>
</html>

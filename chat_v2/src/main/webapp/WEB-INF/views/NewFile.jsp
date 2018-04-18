<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="<c:url value="resources/js/libraries/jquery-3.3.1.min.js" />"></script>
<script type="text/javascript" src="http://ajax.microsoft.com/ajax/jquery/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.templates/beta1/jquery.tmpl.js"></script>
 
	
<title>Insert title here</title>



</head>
<body>
 

 <h1>Cat Photos!</h1>
  
  <div id="pageContent">
 
        <h1>ASP.NET Bookstore</h1>
 
        <div id="bookContainer"></div>
 
    </div>
 
    <script id="bookTemplate" type="text/x-jQuery-tmpl">
        <div>
            <h2>{{= title}}</h2>
           
        </div>
    </script>
 
    
    <script type="text/javascript">
        // Create an array of books
        var books = [
            { title: "ASP.NET 4 Unleashed22", price: 37.79, picture: "AspNet4Unleashed.jpg" },
            { title: "ASP.NET MVC Unleashed", price: 44.99, picture: "AspNetMvcUnleashed.jpg" },
            { title: "ASP.NET Kick Start", price: 4.00, picture: "AspNetKickStart.jpg" },
            { title: "ASP.NET MVC Unleashed iPhone", price: 44.99, picture: "AspNetMvcUnleashedIPhone.jpg" },
        ];
 
        // Render the books using the template
        $("#bookTemplate").tmpl(books).appendTo("#bookContainer");
 
        function formatPrice(price) {
            return "$" + price.toFixed(2);
        }
 
    </script>
 
</body>
</html>
 

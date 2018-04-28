var stompClient = null;
connect();

function insetMessageHtml(messageText, messageTime, pathToPhoto, messageLogin) {

	var message_item = $('<div class="message_item"></div>');
	var message_image = $('<img alt="изображение профиля">');
	var message_text = $('<div class="message_text">');
	var message_time = $('<span class="message_time">');
	var message_login = $('<span class="message_login">');

	message_image.attr("src", pathToPhoto);

	message_login.text(messageLogin);
	message_text.text(messageText);
	message_time.text(messageTime.getHours() + ':' + messageTime.getMinutes()
			+ ':' + messageTime.getSeconds());

	message_text.append(message_time);
	message_item.append(message_image);
	message_item.append(message_login);
	message_item.append(message_text);
	$(".content_messageList").append(message_item);
	$("#content_messageList").scrollTop(
			$('#content_messageList').prop('scrollHeight'));

}
function insetUserToHtml(user){
		var userIsExist = false;

	 $('.user_name').each(function (index, element) {
		 
		  if(element.val() == user.login){
			  userIsExist = true;
		  }
		if(userIsExist){
			
		//лампочка	
			
		}else{
			
			
			var user_id = $('<div class="user_id">');
			var user_name = $('<span class="user_name">'); 
			user_name.text(user.login);
			var online_ball = $('<div class="online_ball">'); 
			user_id.append(user_name);
			user_id.append(online_ball);
			$(".sidebar_userlist").append(user_id);
			
			
		}  
		  
		  
		  
		  
		  
});
	
	
	
	
	
	
	
	
	
	
	
	

//	<div class="userInfo">
//
//		<img src="<c:url value="resources/images/cross-remove-sign.png" />" alt="ÐÑÑÐ¾Ð´"
//			class="userExit">
//		<div class="mainInfo">
//			<img src="<c:url value="${item.getPathToFoto()}" />" alt="ÐÐ·Ð¾Ð±ÑÐ°Ð¶ÐµÐ½Ð¸Ðµ Ð¿ÑÐ¾ÑÐ¸Ð»Ñ"> 
//			<span>${item.getName()}   ${item.getSurname()} </span>
//		</div>
//
//		<div class="allUsersSpans">
//
//			<span>Telephone:${item.getTelephone()}</span> 
//			<span>Email: ${item.getEmail()}</span>
//
//		</div>
//		<button class="adminButton">Ban/Ban off</button>
//
//	</div>


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}









function connect() {

	var socket = new SockJS('/chat/messages');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		stompClient.subscribe('/topic/greetings', function(greeting) {

			showGreeting(JSON.parse(greeting.body));
		});
	});
}

function disconnect() {
	stompClient.disconnect();

}

function sendMessage() {
	var textMessage = $("#message").val();
	stompClient.send("/app/messages", {}, JSON.stringify({
		"user" : {
			"login" : $('#user_name').text()
		},
		'textMessage' : textMessage,
		'action': {'idAction':1}
	}));
	$("#message").val('');
}


function addUser(user){
	
	stompClient.send("/app/messages", {}, JSON.stringify({
		"user" : {
			"login" : user.login
		},
		'textMessage' : $('#user_name').text() + "зашел в чат" ,
		'action': {'idAction':2}
	}));
	
}




function showGreeting(message) {
	
	var pathToPhoto = message.user.pathToFoto;
	var textMessage = message.textMessage;
	var timeStampMessage = message.timeStamp;
	var timeStamp = new Date(timeStampMessage);
	var messageLogin = message.user.login;
	
	
	


	if(message.action.idAction == 1){
		insetMessageHtml(textMessage, timeStamp, pathToPhoto, messageLogin);

		
		
	}else if(message.action.idAction == 2){  //login
	
		insetMessageHtml(textMessage, timeStamp, pathToPhoto, messageLogin);
		insetUserToHtml(message.user);
		
		
	}else{
		console.log("Ошибка")
		
	}
//		
//		
//		
//		insetIntoHtml(textMessage, timeStamp, pathToPhoto, messageLogin);
//	}
//	

	

}
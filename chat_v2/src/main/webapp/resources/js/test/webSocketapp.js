var stompClient = null;
connect();

function insetIntoHtml(messageText, messageTime, pathToPhoto, messageLogin) {

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
	var name = $("#message").val();
	stompClient.send("/app/messages", {}, JSON.stringify({
		"user" : {
			"login" : $('#user_name').text()
		},
		'textMessage' : name
	}));
	$("#message").val('');
}

function showGreeting(message) {

	var pathToPhoto = message.user.pathToFoto;
	var textMessage = message.textMessage;
	var timeStampMessage = message.timeStamp;
	var timeStamp = new Date(timeStampMessage);
	var messageLogin = message.user.login;

	insetIntoHtml(textMessage, timeStamp, pathToPhoto, messageLogin);

}
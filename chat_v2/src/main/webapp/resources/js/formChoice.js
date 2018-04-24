$(document).ready(function() {

	var user;

	$.post("checkSession", function(data) {
		
		data = JSON.parse(data);
		if (data != null) {
			
			user = data;
			showMainClass();
		
			if (user.userRole.nameRole == "ADMIN") {
				showAdminButtons();
			}
			console.log(user.userStatus.nameStatus);
			if (user.userStatus.nameStatus == "BANNED") {
				$("#message").prop("disabled", true); 
				$("#messageSenderId").prop("disabled", true); 
			}
			
			

		} else {
			showRegistrationClass();
		}
	});

	$('#exit_buttom').click(function() {
		pressExitButton();
	});

	$('#message').keypress(function(event) {
		if (event.keyCode == 13) {
			sendMessage();
		}
	});

});
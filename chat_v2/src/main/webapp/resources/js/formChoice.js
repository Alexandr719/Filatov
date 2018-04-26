$(document).ready(function() {


	var user;

	
	$.post("checkSession", function(data) {
	
		if (data.login != null) {
			
			user = data;
			showMainClass();
		
			if (user.userRole.nameRole == "ADMIN") {
				showAdminButtons();
			}
			
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
	$('#buttonScrollPage').click(function() {
		 $("#content_messageList").scrollTop($('#content_messageList').prop('scrollHeight'));
	});
	
	$('#content_messageList').scroll(function(){
		
		
		var divHeight = $('#content_messageList').prop('scrollHeight')
		var divScroll = $("#content_messageList").scrollTop();
		if((divHeight - divScroll) > 1500 ){
			$('#buttonScrollPage').show("slow");
				
		}else{
			$('#buttonScrollPage').hide();
			
					
		}
		});
	
	
	
	
	
	
	
	
	
	
	

});
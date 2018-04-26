function showMainClass(user) {
	  $('#form').hide();
	  $('#main').show();
	  $('.userInfo').hide();
	  $('.formAddFoto').hide();
	  $("#content_messageList").scrollTop($('#content_messageList').prop('scrollHeight'));
	   
	
	  console.log(user);
	  
	 
	  
	  $('.profile_image').click(function() {
			$('.formAddFoto').show();

		});

		$('.upload_files').click(function() {
			uploadImageFile();
			$('.formAddFoto').hide();

		});
		$('.user_name').click(function() {
			$(this).parent().children(".userInfo").show("slow");

		});

		$('.userExit').click(function() {

			$(this).parent().hide("slow");

		});
	  
	  

	  
}





function showRegistrationClass() {
	 $('#main').hide();  
	 $('#form').show();
	 $('.userInfo').hide();
	 $('.formAddFoto').hide();
	  
	  
	  
	  $('.form_registration').hide();
		
		$('#form-enter-button').addClass('active');
		$('#form-enter-button').click(function() {
		    $('.form_login').show();
		    $('.form_registration').hide();
		    $('#form-enter-button').addClass('active');
		    $('#form-registration-button').removeClass('active');
	
		});
		$('#form-registration-button').click(function() {
		    $('.form_registration').show();
		    $('.form_login').hide();
		    $('#form-enter-button').removeClass('active');
		    $('#form-registration-button').addClass('active');
	
		});

	  
	  
	  
	  
	 
}
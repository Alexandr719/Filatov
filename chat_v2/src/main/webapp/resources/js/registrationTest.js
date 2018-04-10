function showMainClass() {
	  $('#form').hide();
	  $('#main').show();
	  $('.userInfo').hide();
	  $('.formAddFoto').hide();
	  
	  
	  
	  $('.profile_image').click(function() {
			$('.formAddFoto').show();

		});

		$('.upload_files').click(function() {
			$('.formAddFoto').hide();

		});
		$('.user_name').click(function() {
			$(this).parent().children(".userInfo").show();

		});

		$('.userExit').click(function() {

			$(this).parent().hide();

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
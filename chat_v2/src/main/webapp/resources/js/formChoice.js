$(document).ready(function () {
	$('.form_registration').hide();
	$('.formAddFoto').hide();
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
	
	
	$('.profile_image').click(function() {
		   $('.formAddFoto').show();
	
	});	
		
 
   $('.upload_files').click(function() {
		   $('.formAddFoto').hide();
	
	});	
		
   $('.sidebar_userlist').click(function() {
	   $('.userInfo').show();

});		
  
   $('.userExit').click(function() {
	   $('.sidebar_userlist').hide();

});	
		
	
	
	

});
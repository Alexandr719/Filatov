$(document).ready(function () {
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

});
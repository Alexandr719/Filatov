$(document).ready(function() {
	
	
	
	$('#exit_buttom').click(function() {
		pressExitButton();

	});
	
	if($('#user_name').text().trim() != ""){
			
		showMainClass();

		
		
	}else{
		
		showRegistrationClass();
		
		
	}
	
	
	
	
	
		
	

});
$(document).ready(function() {
	
	
	
	$('#exit_buttom').click(function() {
		alert("Good Bye");

	});
	
	if($('#user_name').text().trim() != ""){
		console.log("Not null");
		
		showMainClass();

		
		
	}else{
		console.log("NUll");
		showRegistrationClass();
		
		
	}
	
	
	
	
	
		
	

});
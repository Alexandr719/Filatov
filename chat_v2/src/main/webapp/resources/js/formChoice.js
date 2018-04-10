$(document).ready(function() {
	
	
	if($('#user_name').text().trim() != ""){
		console.log("Not null");
		
		showMainClass();
		
		
		
		
		
		
	}else{
		console.log("NUll");
		showRegistrationClass();
		
		
	}
	
	
	
	
	
		
	

});
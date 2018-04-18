function pressExitButton(){
	
	alert("See you later");
	$.post( "logout" );
	showRegistrationClass();
	setTimeout(function() { }, 100);
	location.reload();
	
	
}
function pressExitButton(){
	
	alert("See you later");
	$.post( "exit" );
	showRegistrationClass();
	setTimeout(function() { }, 100);
	location.reload();
	
	
}
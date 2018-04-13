function pressExitButton(){
	
	alert("See you later");
	$.post( "exit" );
	location.reload();
	
}
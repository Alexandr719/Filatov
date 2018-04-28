	$( ".form_submit" ).submit(function( event ) {
		
			event.preventDefault();
		
				
		 
		  $.ajax({
			type:$(this).attr('method'),
			url:$(this).attr('action'),
			data:new FormData(this) ,
			enctype: 'multipart/form-data',
			processData: false,
			contentType: false,
			cache: false,
			
		
			success:function(user){
				
			 if(user.userStatus.nameStatus == "InvalidLoginOrPassword") {
					$( "#errorLoginForm").text("Wrong password or login");
					$( "#errorLoginForm").css( "display", "block" );
								
				}else if(user.userStatus.nameStatus == "InvalidUser"){
					$( "#errorLoginForm").text("User with such login exists");
					$( "#errorLoginForm").css( "display", "block" );
				}			 
			
				else{
					addUser(user);
					location.reload();
				}
				
				
			
			}
		  });
		  
	});
	
	


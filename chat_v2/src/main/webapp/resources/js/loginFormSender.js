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
			
		
			success:function(result){
				
				if(result == "success"){
				   location.reload();
				
				}else if(result == "invalidUserOrPassword") {
					$( "#errorLoginForm").text("Wrong password or login");
					$( "#errorLoginForm").css( "display", "block" );
								
				}else if(result == "invalidUser"){
					$( "#errorLoginForm").text("User with such login exists");
					$( "#errorLoginForm").css( "display", "block" );
				} 
				else{
					alert(result);
				}
				
				
			
			}
		  });
		  
	});
	
	


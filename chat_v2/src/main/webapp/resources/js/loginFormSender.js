$(document).ready(function () {
	
	

	
	$( ".form_submit" ).submit(function( event ) {
		alert("hello51");
		
		
	//	$.post( "registration_user2" );
		event.preventDefault();
		
		
		  var formData = new FormData(this);
//		  var object = {};
		  
		  
		  console.log(formData);		
//		 
//	  dataFromForm.forEach(function(value, key){
//		    object[key] = value;
//		});
//		  
//			  
//		  
//		var formData = JSON.stringify(object);
//		alert(formData);
		
		 
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
					alert("error");
				}
				
				
			
			}
		  });
		  
		  
		 		  
		  
		  
		  
		  
	});
	
	
});

$(document).ready(function () {
	
	$( ".form_submit" ).submit(function( event ) {
		  event.preventDefault();
		  
		  var dataFromForm = new FormData(this);
		  var object = {};
		
		 
	  dataFromForm.forEach(function(value, key){
		    object[key] = value;
		});
		  
			  
		  
		var formData = JSON.stringify(object);
		alert(formData);
		
	
		  $.ajax({
			type:$(this).attr('metod'),
			url:$(this).attr('action'),
			data: ({formData: formData}) ,
			
		
			success:function(result){
				alert(result);
			}
		  });
		  
		  
		 		  
		  
		  
		  
		  
		});
	
	
});

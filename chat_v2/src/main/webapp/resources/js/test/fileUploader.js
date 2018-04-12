function uploadImageFile(){
	
	if($("#file")[0].files[0]== null){
		alert("Choose file");
	}else{
	
			
	 $.ajax({
		    url: "uploadFile",
		    type: "POST",
		    data: new FormData($("#upload-file-form")[0]),
		    enctype: 'multipart/form-data',
		    processData: false,
		    contentType: false,
		    cache: false,
		    success: function () {
		      // Handle upload success
		      // ...
		    },
		    error: function () {
		      // Handle upload error
		      // ...
		    }
		  });
	
	alert("good bye!");
}
}
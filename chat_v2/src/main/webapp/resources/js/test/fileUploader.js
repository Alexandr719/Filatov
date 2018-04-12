function uploadImageFile(){
	
	
	alert("gooo!");
	
	
	
	
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
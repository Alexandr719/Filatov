// Переменная куда будут располагаться данные файлов
$(document).ready(function () {
	alert("hello");
var files;

$('#image_file').change(function(){
    alert("heool");
    files = this.files;
});


$('#image_button').click(function( event ){
    event.stopPropagation(); // Остановка происходящего
    event.preventDefault();  // Полная остановка происходящего

    // Создадим данные формы и добавим в них данные файлов из files
 
    var data = new FormData();
    $.each( files, function( key, value ){
        data.append( key, value );
    });
    alert(data);
    // Отправляем запрос
 
    $.ajax({
    	url: 'addFile',
        type: 'POST',
        data: data,
        cache: false,
        dataType: 'json',
        processData: false, // Не обрабатываем файлы (Don't process the files)
        contentType: false, // Так jQuery скажет серверу что это строковой запрос
        success: function( respond, textStatus, jqXHR ){
        	alert("go here");
            // Если все ОК
 
            if( typeof respond.error === 'undefined' ){
            	
                // Файлы успешно загружены, делаем что нибудь здесь
 
                // выведем пути к загруженным файлам в блок '.ajax-respond'
 
                var files_path = respond.files;
                var html = '';
                $.each( files_path, function( key, val ){ html += val +'<br>'; } )
                $('.ajax-respond').html( html );
            }
            else{
                console.log('ОШИБКИ ОТВЕТА сервера: ' + respond.error );
            }
        },
        error: function( jqXHR, textStatus, errorThrown ){
            console.log('ОШИБКИ AJAX запроса: ' + textStatus );
        }
    });
    alert("download");
 
});





















});
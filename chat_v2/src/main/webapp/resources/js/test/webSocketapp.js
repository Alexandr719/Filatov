   var stompClient = null;
   connect();

        function connect() {
        	
            var socket = new SockJS('/chat/messages');
           stompClient = Stomp.over(socket);
           console.log("In connect2");
            stompClient.connect({}, function(frame) {
                console.log('Connected: ' + frame);
                stompClient.subscribe('/topic/greetings', function(greeting){
                   showGreeting(JSON.parse(greeting.body).content);
                });
            });
        }

        function disconnect() {
            stompClient.disconnect();
            
        }

        function sendMessage() {
            var name =  $("#message").val();
            stompClient.send("/app/messages", {}, JSON.stringify({'textMessage':name }));
            $("#message").val('');
        }

        function showGreeting(message) {
            var response = document.getElementById('response');
            message = JSON.parse(message);
            message = message.textMessage;
            var p = document.createElement('p');
            p.style.wordWrap = 'break-word';
            p.appendChild(document.createTextNode(message));
            response.appendChild(p);
        }
window.addEventListener('load', function() {
    let source = new EventSource('../demo_sse.jsp');
     source.onmessage = function (event) {
         
        document.getElementById("result").innerHTML += event.data + "<br>";
     };
});
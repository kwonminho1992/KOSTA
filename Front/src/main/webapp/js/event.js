//1.문서의 끝까지 해석한 뒤, DOM트리가 완성되고 화면에 렌더링할 준비가 되면
//window 객체의 load 이벤트의 발생함

//DOM트리의 작성이 완료될때까지 기다림
//window객체의 load이벤트의 발생을 감시했다가
//이벤트가 발생하면 function()이 자동 호출됨
window.addEventListener("load", function(){ 
    //DOM트리의 input(type="text")객체를 찾기
    var txtObj = document.querySelector("input[type=text]");   
    
    //DOM트리의 button객체를 찾기
    var btnObj = document.querySelector("button");   

    //button객체의 click event가 발생했을때, function()이 자동호출
    btnObj.addEventListener("click", function(){ 
        alert('클릭되었습니다');
        txtObj.value = '클릭되었습니다';
    });
});

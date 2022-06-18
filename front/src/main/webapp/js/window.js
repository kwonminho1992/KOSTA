var displayTime = function(element) {
    var now = '<h1>';
    var today = new Date();
    var month = today.getMonth()+1;
    var date = today.getDate();
    now += today.getFullYear();
    now += '/';
    now += month<10 ? '0' + month: month;
    now += '/';
    now += date<10 ? '0' + date: date;
    now += ' ';
    now += today.getHours() + " : " + today.getMinutes() + " : " + today.getSeconds() + "</h1>";
    element.innerHTML = now;
};

window.addEventListener("load", function(){ 
    // ---- 새창 띄우기 버튼 ------
    var windowID;
    var openObj = document.querySelector('button.open'); 
    openObj.addEventListener("click", function() {
        var url = 'js_popup.html';
        var target = 'first'; // 해당 페이지를 중복해서 띄울 수 없게 설정
        var feature = 'width=550px, height=550px';
        windowID = window.open(url, target, feature);
        this.style.display = 'none';
        closeObj.style.display = 'inline';
    });

    // ----- 새창 닫기 버튼 -------
    var closeObj = document.querySelector('button.close');
    closeObj.addEventListener("click", function() {
        windowID.close();
        this.style.display = 'none';
        openObj.style.display = 'inline';
    });   

    // ---- timeout(5초후 할일) 버튼 -----
    var timeoutObj = document.querySelector('button.timeout');
    timeoutObj.addEventListener("click", function() {
        window.setTimeout(function(){
            alert('5초 지남');         
        }, 5000);
    });
    
    // --- 현재 시간 ----
    var divObj = document.querySelector('div');

    displayTime(divObj);

    // ---- interval(1초 간격) 버튼 -----
    var intervalID;
    var intervalObj = document.querySelector('button.interval');
    intervalObj.addEventListener("click", function() {
        intervalID = window.setInterval(displayTime, 1000, divObj);          
    }); 
    
    // ----- clear(1초 간격 해제) 버튼 -----------
    var clearObj = document.querySelector('button.clear');
    clearObj.addEventListener("click", function() {
        window.clearInterval(intervalID);          
    }); 
});
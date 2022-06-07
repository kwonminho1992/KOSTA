//1.문서의 끝까지 해석한 뒤, DOM트리가 완성되고 화면에 렌더링할 준비가 되면
//window 객체의 load 이벤트의 발생함

//DOM트리의 작성이 완료될때까지 기다림
//window객체의 load이벤트(dom트리의 완성)의 발생을 감시했다가
//이벤트가 발생하면 function()(callback함수)이 자동 호출됨
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
    var resultNum = 0;
    var operator;
    // ----calculator start----
    var resultObj = this.document.querySelector("div.calculator>div.result");
    //DOM tree에서 class='calculator'인 객체의 자식 객체 중 button만 모두 찾기
    var btnArr = document.querySelectorAll("div.calculator>button");
    // for (var i = 0; i < btnArr.length; i++) { // 방법 1 :  for문 안에 함수를 넣는 방법
    //     //click event가발생했을때, 할일 지정
    //     (function(j){
    //         btnArr[j].addEventListener('click', function() {
    //             resultObj.innerHTML = j + '번 버튼이 클릭되었습니다.';
    //         })  
    //     })(i);
    // }
    
    btnArr.forEach(function(item, index){ // 방법 2 : forEach()를 사용하는 방법
        item.addEventListener('click', function() {
            // resultObj.innerHTML = item.innerHTML + ' 버튼이 클릭되었습니다.';
            var inner = this.innerHTML;
            switch(inner){
                case '+':
                    operator = inner;
                    break;
                case '=':
                    resultObj.innerHTML = resultNum;
                    resultNum = 0;
                    operator = undefined;
                    break;
                default:
                    if (operator == '+') {
                        resultNum += parseInt(inner);
                    } else {
                        resultNum = parseInt(inner);
                    }        
            }
        });
    });
    // ----calculator end----

    // ----checkbox start----
    var cbArr = document.querySelectorAll('div.checkbox input[type=checkbox]');
    cbArr[0].addEventListener('click', function(){
        for(var i = 0; i < cbArr.length; i++) {
            cbArr[i].checked = this.checked;
        }
    });
    // ----checkbox end----
    
    // ----select start----
    var selectProvinceObj = document.querySelector('div.select>select.province');
    var selectDistrictObj = document.querySelector('div.select>select.district');
    selectProvinceObj.addEventListener('click', function(){
        console.log(this.value, '클릭되었습니다');
    });
    selectProvinceObj.addEventListener('change', function(){
        console.log(this.value, '변경되었습니다');
  
        switch(this.value){
            case '경기도':
                selectDistrictObj.innerHTML = '';
                var gyeonggi = '<option>시/군/구 선택</option>';
                gyeonggi+= '<option>성남시</option>';
                gyeonggi+= '<option>광주시</option>';
                gyeonggi+= '<option>용인시</option>';
                gyeonggi+= '<option>안양시</option>';
                selectDistrictObj.innerHTML = gyeonggi;
                selectDistrictObj.style.display = 'inline';
                break;
            case '강원도':
                selectDistrictObj.innerHTML = '';
                var gangwon = '<option>시/군/구 선택</option>';
                gangwon+= '<option>원주시</option>';
                gangwon+= '<option>철원군</option>';
                gangwon+= '<option>강릉시</option>';
                selectDistrictObj.innerHTML = gangwon;
                selectDistrictObj.style.display = 'inline';
                break;
            default:
                selectDistrictObj.innerHTML = '';
                selectDistrictObj.style.display = 'none';
        }
    }); 
    // ----select end----

    // ----keyboard start----
    //DOM tree에서 div.keyboard의 input(type = text) 객체 찾기
    var inputObj = document.querySelector('div.keyboard>input[type=text]');
    inputObj.addEventListener('click', function(){
        console.log(this, "클릭되었습니다.");
    });
    inputObj.addEventListener('focus', function(){
        console.log(this, "focus 받았습니다.");
    });   
    inputObj.addEventListener('keyup', function(event){ //키보드로 값 입력
        alert('입력된 값 : ' + event.key);
        if(event.key == 'Enter') {
        }
    });   
    // ----keyboard end----

    //----submit start----
    //전송관련 이벤트 처리순서 : button의 click 이벤트 -> form의 submit 이벤트 -> submit 이벤트 기본 처리(전송작업 in JS)
    var submitObj = document.querySelector('div.submit>form>button');
    var formObj = document.querySelector('div.submit>form');
    var textSubmitObj = document.querySelector('div.submit>form>input[name=t]');
    // submitObj.addEventListener('click', function(){
    //     alert(this + "전송버튼클릭 event가 발생하였습니다");
    // }); 
    formObj.addEventListener('submit', function(event){
        if (textSubmitObj.value == '') {
            alert('값을 입력하세요');
            event.preventDefault(); // 이벤트의 기본처리를 하지 못하도록 막는 method
        } else {
            alert('form의 submit event가 발생');
        }
    }); 
    //----submit end----

    //----a start----
    //이동관련 이벤트 처리순서 : a객체의 click 이벤트 -> 클릭이벤트 기본처리(이동)
    //event bubbling : 하위객체에서 발생한이벤트가 상위객체로 전파됨 (down -> top)
    var divAObj = document.querySelector('div.a');
    divAObj.addEventListener('click', function(){
        this.style.background = 'blue';
    });  

    var aObj = document.querySelector('a');
    aObj.addEventListener('click', function(event){
        this.style.background = 'red';
        event.preventDefault(); // 이벤트의 기본처리를 하지 못하도록 막는 method
        event.stopPropagation(); // click이벤트가 발생했을때, 상위 객체들에게 해당 이벤트가 전파되지 못하도록 막는 method
    });  
    //----a end----   

});

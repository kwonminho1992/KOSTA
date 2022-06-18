
//1.문서의 끝까지 해석한 뒤, DOM트리가 완성되고 화면에 렌더링할 준비가 되면
//window객체를 ready시킴

//$(document).ready(function() {}); // 아래 코드와 같은 기능 수행
$(function(){
    //DOM트리의 input(type="text")객체를 찾기
    let $txtObj = $("input[type=text]"); //jquery 객체   
    
    //DOM트리의 button객체를 찾기
    var $btnObj = $("button").first();  //jquery객체

    //button객체의 click event가 발생했을때, function()이 자동호출
    $btnObj.click(function(){ 
        alert('클릭되었습니다');
        $txtObj.value = '클릭되었습니다';
    });

    // ----calculator start----
    //DOM트리에서 class속성값이 calculator인 객체의 자식중 모든 button객체 찾기

    //querySelectorAll()의 반환형은 NodeList자료형
    //$()의 반환형은 jquery객체형
    //$()의 결과가 여러객체인 경우 각인덱스의 요소는 js객체이다
    //js객체를 jq객체로 변환하려면 $(js객체)처리 필요하다
    //반복문용 jq메서드는 each()
    
    let $btArr = $('div.calculator>button'); //
    let $resultObj = $('div.calculator>div.result');
    let resultNum = 0; //계산된 결과값
    let operator; //연산자
    $btArr.click(function(){  
        let inner = $(this).html();
       switch(inner){
            case '+':                operator = inner;
            break;
            case '=':
            $resultObj.html(resultNum);
            operator = undefined;
            resultNum = 0;
            break;
            default://숫자버튼들
            $resultObj.html(inner);
            if(operator == '+'){
                resultNum += parseInt(inner);
            }else{
                resultNum = parseInt(inner);
            }
        }
    });
    // ----calculator end----

    // ----checkbox start----
    let $cbArr = $('div.checkbox input[type=checkbox]');
    $($cbArr[0]).click(function(){
        if ($($cbArr[0]).prop('checked') == true) {
            for(var i = 0; i < $cbArr.length; i++) {
                $($cbArr[i]).prop('checked', true);
            }
        } else {
            for(var i = 0; i < $cbArr.length; i++) {
                $($cbArr[i]).prop('checked', false);
            }           
        }
    });
    // ----checkbox end----
    
    // ----select start----
    let $selectProvinceObj = $('div.select>select.province');
    let $selectDistrictObj = $('div.select>select.district');
    $selectProvinceObj.click(function(){
        console.log($(this).val(), '클릭되었습니다');
    });
    $selectProvinceObj.change(function(){
        console.log($(this).val(), '변경되었습니다');
    
        switch($(this).val()){
            case '경기도':
                $selectDistrictObj.empty();
                var gyeonggi = '<option>시/군/구 선택</option>';
                gyeonggi+= '<option>성남시</option>';
                gyeonggi+= '<option>광주시</option>';
                gyeonggi+= '<option>용인시</option>';
                gyeonggi+= '<option>안양시</option>';
                $selectDistrictObj.html(gyeonggi);
                $selectDistrictObj.show();
                break;
            case '강원도':
                $selectDistrictObj.empty();
                var gangwon = '<option>시/군/구 선택</option>';
                gangwon+= '<option>원주시</option>';
                gangwon+= '<option>강릉시</option>';
                gangwon+= '<option>철원군</option>';
                gangwon+= '<option>양구군</option>';
                $selectDistrictObj.html(gangwon);
                $selectDistrictObj.show();
                break;
            default:
                $selectDistrictObj.empty();
                $selectDistrictObj.hide();
        }
    }); 
    // ----select end----

    // ----keyboard start----
    //DOM tree에서 div.keyboard의 input(type = text) 객체 찾기
    let $inputObj = $('div.keyboard>input[type=text]');
    $inputObj.click(function(){
        console.log(this, "클릭되었습니다.");
    });
    $inputObj.focus(function(){
        console.log(this, "focus 받았습니다.");
    });   
    $inputObj.keyup(function(event){ //키보드로 값 입력
        alert('입력된 값 : ' + event.key);
        if(event.key == 'Enter') {
        }
    });   
    // ----keyboard end----

    //----submit start----
    //전송관련 이벤트 처리순서 : button의 click 이벤트 -> form의 submit 이벤트 -> submit 이벤트 기본 처리(전송작업 in JS)
    let $formObj = $('div.submit>form');
    let $textSubmitObj = $formObj.find('input[type=text]');
    let $btnSubmitObj = $formObj.find('button');
    $btnSubmitObj.click(function(){
        console.log('클릭되었습니다')
    });   
    $formObj.submit(function(){
        if ($textSubmitObj.val() == '') {
            alert('값을 입력하세요');
            return false; // 이벤트의 기본처리 & 이벤트 전파 중지
        } else {
            alert('form의 submit event가 발생');
        }
    }); 
    //----submit end----

    //----a start----
    //이동관련 이벤트 처리순서 : a객체의 click 이벤트 -> 클릭이벤트 기본처리(이동)
    //event bubbling : 하위객체에서 발생한이벤트가 상위객체로 전파됨 (down -> top)
    let $divAObj = $('div.a');
    $divAObj.click(function(){
        $(this).css('background','blue');
    });  

    let $aObj = $('a');
    $aObj.click(function(){
        $(this).css('background','red');
        return false; // 이벤트의 기본처리 & 이벤트 전파 중지
    });  
    //----a end----   


    // // -------- htmlCollection & nodeList -----------------
    // var htmlCollection = document.getElementsByTagName('input');
    // var nodeList = document.querySelectorAll('input');
    // console.log(htmlCollection);
    // console.log('----------------');
    // console.log(nodeList);
});

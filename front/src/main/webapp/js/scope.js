var a = 'window 객체의 변수';
console.log(window.a); //window 객체의 변수
console.log(a); //window 객체의 변수

//if, for 등에서의 블럭영역으로 변수를 구분하지 않음
for (var i = 0; i <3; i++) {
    console.log(i); // 0, 1, 2
}
console.log(window.i); //3

//function 블럭에서 선언한 변수는 function 안에서만 사용가능 
var b = function() {
    var lv1 = 'outer local variable';
    var lv2 = function() {
        var inner = 'inner local variable';
        console.log(lv1); // outer local variable
    }
    //console.log(inner); // compile error
}
//console.log(lv1); // compile error

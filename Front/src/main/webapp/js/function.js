var a;
a = function() { // 함수를 구현하여 변수에 대입
    alert("function1");
}
a(); // a 함수를 호출

var b;
b = a;
b(); //a() = b()

var c;
c = function(p) {
    console.log("매개변수 p의 값 : " + p);
    if(typeof(p) == 'function') {
        p();
    }
}
c("hello");
c(999);
c(function(){
    alert("callback function");
});

var d;
d = function(p1, p2, p3) {
    if (typeof(p1) == 'function') {
        p1(p2, p3);
    }
}
d(function(a, b) {
    for (var i = a; i < b; i++) {
        console.log(i);
    }
}, 11, 22);

//java script는 parameter, argument의 숫자가 맞지 않아도
//컴파일오류를 발생시키지 않는다.
var e;
e = function(p1, p2) {
    console.log(p1, p2);
}
e(1, 2); // 1, 2
e(3); //3, undefined
e(4, 5, 6); //4, 5

var f;
f = function() {
    return true;
}
var f1 = f();
if (f1 == true) {
    console.log("f 함수의 return값은 true입니다.");
}
var f2 = f();
console.log(5 + f2); // 5 + 1(true) = 6 출력

var g;
g = function() {
    console.log("반환값이 없는 함수입니다.");
}
var g1 = g();
console.log("g함수의 반환값", g1); // undefined

var h;
h = function() {
    var lv1 = 'local variable1';
    var lv2 = function() {
        var innter = 'local variable2';
        console.log('lv2 함수에서의 lv1', lv1);
        console.log('lv2 함수에서의 inner', ineer);
    }
    lv2();
    //console.log('h 함수에서의 lv1', lv1); //호출 불가능
    //console.log('h 함수에서의 inner', ineer);
}
h();
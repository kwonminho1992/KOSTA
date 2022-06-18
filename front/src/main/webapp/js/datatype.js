var a; /* undefined (변수 선언만 하고, 자료 대입을 안한 경우)*/
console.log(typeof(a));
var a = 123; /* number */
console.log(typeof(a));
a = 'hello'; /* string */
console.log(typeof(a));
a = true; /* boolean */
console.log(typeof(a));
a = function() {}; /* function */
console.log(typeof(a));
a = {}; /* object */
console.log(typeof(a));

/*강제 형변환*/
console.log(typeof(parseFloat('3.6')));
console.log(typeof(parseInt('36')));


/* var, let, const, nothing */
var a = 10;
var a = 'hi'; // var 변수는 재선언이 가능 (window 객체 scope OR function scope에 선언)
console.log(window.a); // hi
var f1 = function (){
    var localVariable = true; // function scope에 선언 
    nothingVariable = true; // window 객체 scope에 선언
    a = true; // a 변수를 덮어써서 window 객체 scope에 선언
    console.log('localVariable : ' + localVariable);
    console.log('nothingVariable : ' + nothingVariable);
    console.log('a : ' + a);
}
f1();
let b = 10;
//let b = 'hello'; // let 변수는 재선언이 불가능 (block scope에 선언)
console.log(window.b); // undefined

const PI = 3.14;
//PI = 1.2;
console.log(PI); // const 변수는 재선언, 값 변경이 불가능

// hoisting : 사용을 먼저하고, 선언을 나중에 하는 기법
hoisting = 'hoisting : 사용을 먼저하고, 선언을 나중에 하는 기법';
console.log(hoisting);
var hoisting;

// hoisting2 = 'hoisting2 : 사용을 먼저하고, 선언을 나중에 하는 기법';
// console.log(hoisting2);
// let hoisting; // let 변수는 hoisting 불가능
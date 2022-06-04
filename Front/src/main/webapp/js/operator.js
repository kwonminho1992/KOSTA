/*
산술연산자 : + - * / %
대입연산자 : = += -= *= /= %=
비교연산자 : > >= < <= == != === !==
논리연산자 : && || !
삼항연산자 : ? :
단항연산자 : ++ --
*/

/*산술연산자*/
var a, b, c;
a = 3;
b = 4;
c = a / b;
console.log(a + " / " + b + " = " + c); /* 0.75 */

b=0;
c = a / b;
console.log(a + " / " + b + " = " + c); /* infinity */
console.log(c++); /* infinity */

b=undefined;
c = a / b;
console.log(a + " / " + b + " = " + c); /* NaN */
console.log(c++); /* NaN */

/*비교연산자*/
console.log(2 == '2', 2 === '2'); /* true, false(===,!==는 자료형까지 비교함) */
console.log(0 == false, 0 === false); /* true, false */

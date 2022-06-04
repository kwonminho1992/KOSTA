var a; /* undefined (변수 선언만 하고, 자료 대입을 안한 경우)*/
console.log(typeof(a));
a = 123; /* number */
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
console.log(typeof(number('3.6')));
console.log(typeof(string(3.6)));
console.log(typeof(parseFloat('3.6')));
console.log(typeof(parseInt('36')));


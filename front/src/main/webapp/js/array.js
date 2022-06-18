// 배열
var arr = [1, 10, 3];

console.log(arr.length); // 3
console.log(arr[0]); // 1

for (var i = 0; i < arr.length; i++) {
    console.log(i + " : " + arr[i]); // 1, 10, 3
}

arr.forEach(function(item, index){
    console.log(index + " : " + item);
}); // for문과 같은 효과

arr.push(7); // arr의 끝에 7 추가  [1, 10, 3, 7]
arr.pop(); // arr의 마지막요소 빼기 [1, 10, 3]
arr.unshift(9); // arr의 맨앞에 9 추가 [9, 1, 10, 3]
arr.shift(); // arr의 첫번째요소 빼기 [1, 10, 3]
arr.indexOf(3); // 3의 index인 2를 반환
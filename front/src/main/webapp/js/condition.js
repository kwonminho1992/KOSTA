var num = 15;
if (num % 2 == 0) {
    console.log("even");
} else {
    console.log("odd");
}
if (num >= 15) {
    console.log("num >= 15");
} else if (num >= 10) {
    console.log("10 <= num < 15");
} else {
    console.log("num < 10");
}

/* 날짜 구하기 */
var today = new Date();
var month = today.getMonth() + 1; // 1월은 0, 2월은 1...
switch(month){
    case 1:
    case 2:    
    case 3:
        console.log('Q1');
        break;
    case 4: 
    case 5:
    case 6: 
        console.log('Q2');
        break;
    case 7:
    case 8: 
    case 9:
        console.log('Q3');
        break;
    case 10: 
    case 11:
    case 12: 
        console.log('Q4');
        break;
}
var hour = today.getHours();
switch(parseInt(hour/12)) {
    case 0:
        console.log("오전");
        break;
    case 1:
        console.log("오후");
        break;
    }
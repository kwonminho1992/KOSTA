$(function(){
    alert(window.location.search);
    let queryString = location.search.substring(1);
    $.ajax({ // 비동기처리
        url: '/back/viewproduct',
        method: 'get',
        data: queryString,
        success: function(jsonObj){
            console.log('status : ' + jsonObj.status);
            console.log('jsonObj.p.productNo : ' + jsonObj.p.productNo);
            if(jsonObj.status == 1) {
                let product_no = jsonObj.p.productNo;
                let product_name = jsonObj.p.productName;
                let product_price = jsonObj.p.productPrice;
                console.log(product_no);
                $('div.viewproduct>div.detail>ul>li>span.producet_no').html(product_no);
                $('div.viewproduct>div.detail>ul>li>span.producet_name').html(product_name);
                $('div.viewproduct>div.detail>ul>li>span.producet_price').html(product_price);
                $('div.viewproduct>img').attr('src', '../images/' + product_no + '.jpg').attr('alt', product_name);
            } else {
                alert(jsonObj.message);
            }
        },
        error: function(jqXHR) {
            console.log(document.location.href);
            alert('error code : ' + jqXHR.status);
        }
    });
});
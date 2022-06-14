$(function(){
    //메뉴 객체들(로그인, 가입, 상품 등)을 찾기
    let $menuObj = $('header>nav>a');
    //section객체의 첫번째 article 찾기
    let $firstArticleObj = $('section>article:first');
    
    //---메뉴 click start----
    //메뉴가 클릭되면 article영역의 innerHTML로 load
    $menuObj.click(function(){
        let url = $(this).attr('href');
        let title = $(this).html();
        $firstArticleObj.load(url, function(responseText, statusText, xhr){
            if (statusText != 'success') {
                if(xhr.status == 404) {
					let msg = title + ' 자원을 찾을 수 없습니다.';
					alert(msg);
				}
            }
        });
        return false;
    });
    
});
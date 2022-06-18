var loadFunction = function(){
	let url = '/back/jsp/score.jsp';
	$('div.result').load(url, function(responseText, statusText, xhr){
		if (statusText != 'success') {
			if(xhr.status == 404) {
				let msg = xhr.status + ' : 자원을 찾을 수 없습니다.';
				alert(msg);
			}
		}
	});
};

$(function(){
    let $form = $('form.ajax_button');
    let url = '/back/jsp/score.jsp';

    $form.submit(function() {
		let score = $('input[name=score]').val();
		let data = 'score=' + score;
        $.ajax({
			url: url,
			method: "get",
			data: data,
			success: function() {
				location.href = '/back/jsp/score.jsp';
				loadFunction();
			},
			error: function(jqXHR, textStatus, errorThrown) {
				errorThrown = "전송실패 ";
				alert(errorThrown + " 사유 : " + jqXHR.status);
			}
		});
		return false; 
    });
});

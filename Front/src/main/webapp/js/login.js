window.addEventListener('load',function() {
    //---아이디 저장 체크박스 객체 찾기
    let cb = this.document.querySelector('form.login>fieldset>input[type=checkbox]');
    //---로그인 버튼 객체 찾기
    let btlogin = this.document.querySelector('form.login>fieldset>input[type=submit]');
    //-- id 입력 객체 찾기
    let inputID = this.document.querySelector('form.login>fieldset>input[name=id]');

    //아이디저장 체크박스가 체크되었다면, 아이디값을 localstorage에 저장
    btlogin.addEventListener('click', function() {
        if(cb.checked) {
            localStorage.setItem("id", inputID.value);
        }
    });
});
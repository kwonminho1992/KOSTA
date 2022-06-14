window.addEventListener('load',function() {
    //---아이디 저장 체크박스 객체 찾기
    let cb = this.document.querySelector('form.login>fieldset>input[type=checkbox]');
    //---로그인 버튼 객체 찾기
    let btlogin = this.document.querySelector('form.login>fieldset>input[type=submit]');
    //-- id 입력 객체 찾기
    let inputID = this.document.querySelector('form.login>fieldset>input[name=id]');

    //아이디저장 체크박스가 체크되었다면, 아이디값을 localstorage에 저장
    //아이디저장 체크박스가 해제되었다면, localstorage의 id값을 삭제
    btlogin.addEventListener('click', function() {
        if(cb.checked) {
            localStorage.setItem("id", inputID.value);
        } else {
            localStorage.removeItem("id");
        }
    });

    //local storage에 'id' 이름의 item이 있다면, input[name=id]객체의 value로 설정하기
    let idValue = this.localStorage.getItem('id');
    if (idValue != null && idValue != '') {
        inputID.value = idValue;
    }
});
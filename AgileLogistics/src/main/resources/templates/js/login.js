function loginBox(){
    document.getElementById("loginFrom").style.display = 'block';
    document.getElementById("registerForm").style.display = 'none';
}
function registerBox(){

    document.getElementById("loginFrom").style.display = 'none';
    document.getElementById("registerForm").style.display = 'block';
}
function reloadCaptcha() {
    var captchaImg = document.getElementById("captchaImg");
    captchaImg.src = "/captcha?t=" + (new Date()).getTime();
}
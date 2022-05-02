// 기본형 ~document.querySelector('.header').style.display = 'none';~
// j쿼리 파일 있을때 같은말 ~$('.header').hide();~

$(function () {
    $('.main_slider').slick({
        arrows: false,
        autoplay: true,
        //    1000=1s js에서는 단위 안 붙임
        autoplaySpeed: 1000,
        vertical: true,
        dots: true,
    });
})
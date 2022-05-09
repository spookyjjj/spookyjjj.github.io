$(function () {
    ////////////////////////////////////////////////
    $('.top_banner i').on('click', function () {
        $('.top_banner').slideUp();
    });
    $('.main_slider').slick({
        arrows: false,
        dots: true,
        autoplay: true,
        pauseOnHover: true,
        pauseOnFocus: false,
    });
    $('.main_slider').on('init reInit afterChange', function () {
        // 슬릭슬라이더에서 정의한 init reInit afterChange이벤트
        console.log('변했네??');
        // 지금 활성화된 슬라이드에 .slick-current라는 class가 붙는데 그걸 그냥 current라고 정의해줌
        let current = $('.slick-current');
        console.log(current);
        // current.addClass('on'); 만하면, 한번 붙으면 그 상태로 유지되니깐
        // 아래처럼 설정해서 .on을 붙었다 뗐다 해줌
        current.addClass('on').siblings().removeClass('on');
    });
    ////////////////////////////////////////////////
})
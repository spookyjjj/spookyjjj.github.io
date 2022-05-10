$(function () {
    ////////////////////////////////////////////////
    $('.top_banner i').on('click', function () {
        $('.top_banner').slideUp();
    });

    // .main_slider 자식으로 figure들이 있어야 그걸 인식해서 slick-slider됨~!!
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

    $('.movie .dec i:nth-of-type(1)').on('click', function () {
        $('.movie video').trigger('play');
    });
    $('.movie .dec i:nth-of-type(2)').on('click', function () {
        $('.movie video').trigger('pause');
    });

    $("#myMovie").YTPlayer({
        videoURL: 'https://youtu.be/G7dUt84Fd_w',
        containment: '.utube', 
        autoPlay: true, 
        mute: true, 
        startAt: 0, 
        opacity: 1, 
        showControls: false,
        playOnlyIfVisible: true,
    });
    $('.utube i:nth-of-type(1)').on('click', function () {
        // YTPPlay 플러그인에서 정의한 명령어 YTPPlay(),YTPPause()..
        $('#myMovie').YTPPlay();
    });
    $('.utube i:nth-of-type(2)').on('click', function () {
        $('#myMovie').YTPPause();
    });

    ////////////////////////////////////////////////
})
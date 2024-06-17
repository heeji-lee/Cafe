$(function(){
    var gnb_height = '100px';  // 1단계 메뉴 높이
    var gnb_dp2_height = '200px'; // 2단계 메뉴 높이
    var $gnb = $('#gnb');

    // gnb 초기화(2단계 메뉴 숨기기)
    $gnb.css('height', gnb_height);

    // 마우스 hover 드롭다운 메뉴
    $gnb.on({
        mouseenter: function(){
            $(this).stop().animate({ height: gnb_dp2_height });
        },
        mouseleave: function(){
            $(this).stop().animate({ height: gnb_height });
        }
    });

});
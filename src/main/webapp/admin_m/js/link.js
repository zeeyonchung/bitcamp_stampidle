/********* header ***********/

$(".logo").click(function() {
	location.href = "../main/main.html"
});


$(".btn_message").click(function() {
	location.href = "../message/message.html"
});


$(".srchList li").click(function() {
	location.href = "../manage/customerdetail.html"
}); /*회원번호에따라.. 나중수정*/



/********* sidebar ***********/

$("#login-btn").click(function() {
	location.href = "../auth/login.html"
});


$(".mn_home").click(function() {
	location.href = "../main/main.html"
});


$(".mn_msg").click(function() {
	location.href = "../message/message.html"
});


$(".stamp").click(function() {
	location.href = "../cardadd/cardadd.html"
});


$(".cafeinfom").click(function() {
	location.href = "../cafeinfo/cafeinfo.html"
});


$(".event").click(function() {
	location.href = "../event/eventlist.html"
});


$(".statis").click(function() {
	location.href = "../manage/manage.html"
});


$(".cstmrList").click(function() {
	location.href = "../manage/manage.html"
});


$("#logout-btn").click(function() {
	location.href = "../auth/login.html"
});



/********* message/message.html ***********/

$('.message .one-msg').click(function() {
	location.href = "../message/messagedetail.html";
}); /*회원번호에따라.. 나중수정*/




/********* message/messagedetail.html ***********/

$('.messagedetail .back-btn').click(function() {
	location.href = "../message/message.html";
});


$('.messagedetail .chat .mewrap img').click(function() {
	location.href = "../manage/customerdetail.html";
});



/********* manage/manage.html ***********/

$('.manage .section.two table tr:not(:first-of-type)').click(function() {
	location.href = "../manage/customerdetail.html";
});


$('.manage .section.three table tr:not(:first-of-type)').click(function() {
	location.href = "../manage/customerdetail.html";
});



/********* manage/customerdetail.html ***********/

$('.customerdetail .cstmer .info .msg-btn').click(function() {
	location.href = "../message/messagedetail.html";
});


/********* cafeinfo/cafeinfo.html ***********/

$('.cafeinfo .introArea .btn-edit').click(function() {
	event.preventDefault();
	location.href = "../cafeinfo/cafeinfoedit.html";
});


/********* cafeinfo/cafeinfoedit.html ***********/

$('.cafeinfoedit .cafe-edit.cafe-edit2').click(function() {
	location.href = "../cafeinfo/cafeinfo.html";
});



/********* cardadd/cardadd.html ***********/

$('.cardadd .btmsubmit').click(function() {
	location.href = "../main/main.html";
});


/********* auth/login.html ***********/

$('.login .login-main .login-btn').click(function() {
	location.href = "../main/main.html";
});


/********* event/eventlist.html ***********/

$('.eventlist li').click(function() {
	location.href = "../event/eventdetail.html";
});


/********* event/eventdetail.html ***********/

$('.eventdetail .add-new-btn').click(function() {
	location.href = "../event/eventadd.html";
});


$('.eventdetail .glyphicon-pencil').click(function() {
	location.href = "../event/eventadd.html";
});

$('.eventdetail .glyphicon-trash').click(function() {
	location.href = "../event/eventlist.html";
});


/********* event/eventadd.html ***********/

$('.eventadd .add-new-btn').click(function() {
	location.href = "../event/eventlist.html";
});
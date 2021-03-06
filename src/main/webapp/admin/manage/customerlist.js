var currPageNo = 1;
var pageSize = 5;



// 
$.getJSON(serverRoot + '/auth/loginUser.json', function(ajaxResult) {
	if (ajaxResult.status != "success") {
		console.log(ajaxResult.data);
		location.href = clientRoot + "/auth/login.html";
		/*로그인 안 했으면 로그인 페이지로 보내기*/
	}
	
	
	
	var cafeMember = ajaxResult.data;
	cafeMemberNo = cafeMember.cafeMemberNo;
	var selectCafeList = null;

	getListSelect(cafeMemberNo, currPageNo, pageSize);
	
	
	$(".dropdown .dropdown-menu .dropdown-item ").click(function(){
		$(".dropdown button").text($(this).text());
		if ($(this).text() == "등록순") {
			selectCafeList = "mcard.birth"
		} else if ($(this).text() == "가나다순") {
			selectCafeList = "memb.name"
		} else if ($(this).text() == "최근방문순") {
			selectCafeList = "memb.tel"
		}
		getListSelect(cafeMemberNo, currPageNo, pageSize, selectCafeList);
	});
	
	
	$('#prevPgBtn').click(function() {
		if (currPageNo > 1) {
			console.log(cafeMemberNo);
			getListSelect(cafeMemberNo, --currPageNo, 5, selectCafeList);
		}
	});

	$('#nextPgBtn').click(function() {
		
		getListSelect(cafeMemberNo, ++currPageNo, 5, selectCafeList);
	});
});




function getListSelect(cafeMemberNo, pageNo, pageSize,selectCafeList) {
	$.getJSON(
		serverRoot + '/customCard/customListSelect.json',
		{
			'cafeMemberNo': cafeMemberNo,
			"pageNo": pageNo,
			"pageSize": pageSize,
			'selectCafeList': selectCafeList
		}, 
		function(ajaxResult) {
		 if (ajaxResult.status != "success") {
			 return;
		 }
		  var list = ajaxResult.data.list;
		  
		  $('#customer-number span').text(list.length);
		  
		  var tbody = $('#list-table > tbody');
		  // 템플릿 텍스트를 처리하여 HTML을 생성해 줄 함수 얻기
		  var template = Handlebars.compile($('#trTemplate').html());
		  
		  // 템플릿 엔진을 통해 생성된 HTML을 tbody에 넣는다.
		  tbody.html(template({"list": list}));
		  
		  $('.tr-link').click(function(event) {
		  	event.preventDefault();
		  	location.href = '../stampidle_cs/customerdetail.html?customMember=' + $(this).attr("data-no");
		  });
		  
		  preparePagingButton(ajaxResult.data.totalCount);
	});
	
	
}



function preparePagingButton(totalCount) {
	if (currPageNo <= 1) {
		$('#prevPgBtn').attr('disabled', true);
	} else {
		$('#prevPgBtn').attr('disabled', false);
	}
	
	var maxPageNo = parseInt(totalCount / pageSize);
	if((totalCount % pageSize) > 0) {
		maxPageNo++;
	}
	
	if (currPageNo >= maxPageNo) {
		$('#nextPgBtn').attr('disabled', true);
	} else {
		$('#nextPgBtn').attr('disabled', false);
	}
	
	$('#pageNo').text(currPageNo);
}

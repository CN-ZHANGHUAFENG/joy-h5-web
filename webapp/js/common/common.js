function pageLinkClick(obj, url, currentPage, pageSize, totalCount) {
	var table = $(obj).parent().parent().parent();
	var searchDiv = $(obj).parent().parent().parent();
	if (searchDiv.attr('searchDiv') !== null
			&& searchDiv.attr('searchDiv') !== undefined
			&& searchDiv.attr('searchDiv') != '') {
		searchDiv = searchDiv.attr('searchDiv');
	} else {
		searchDiv = searchDiv.parent();
	}
	$(searchDiv).jrAjax({
		url : url,
		data : {
			currentPage : currentPage,
			itemPerPage : pageSize,
			totalCount : totalCount
		},
		autoGetParam : true,
		resultAutoProcess : true,
		newdLoading : true,
		loadingType : 'full',
		container : table
	});
}

function goPageLink(obj, url, pageSize, pageNum, totalCount) {
	var currentPage = $(obj).prev().find("input").val();
	if (parseInt(pageNum) < parseInt(currentPage)) {
		$.message
				.alert('info', '提示信息', '当前总页数为：' + pageNum + '页，您输入的页数超过了总页数！');
		return;
	}
	pageLinkClick(obj, url, currentPage, pageSize, totalCount);
}

function searchFun(obj, url, searchDiv) {
	var table = $(obj).parent().parent().parent().next();
	var condition = $(obj).parent().parent().parent().parent();
	if (searchDiv && searchDiv !== undefined && searchDiv !== null) {
		condition = searchDiv;
	}
	$(condition).jrAjax({
		url : url,
		autoGetParam : true,
		resultAutoProcess : true,
		newdLoading : true,
		loadingType : 'full',
		container : table
	});
}

function refreshMenu(url, imgUrl, title, data) {
	if (!(imgUrl === undefined || imgUrl === null || imgUrl == '')) {
		var funImg = $('.titleBar .funImg');
		funImg.empty();
		funImg.append('<img src="' + imgUrl
				+ '" border="0" width=\"20px\" height=\"20px\"/>');
		$('.titleBar .title').html(title);
	}

	$('.panel-window').remove();
	$('.message-window').remove();
	$('.full-window').remove();
	$('.flexselect_dropdown').remove();

	if(imgUrl === undefined || imgUrl === null || imgUrl == ''){
		data = {};
	}
	
	$('.dataDiv').jrAjax({
		url : url,
		data : data,
		container : '.dataDiv',
		newdLoading : true
	});
}

function refreshTableByOrder(obj, url) {
	var table = $(obj).parent().parent().parent().parent().parent();
	$(obj).parent().parent().parent().parent().parent().parent().jrAjax({
		url : url,
		autoGetParam : true,
		resultAutoProcess : true,
		newdLoading : true,
		loadingType : 'full',
		container : table
	});
}

function getBow() {
	var Sys = {};
	var ua = navigator.userAgent.toLowerCase();
	var s;
	(s = ua.match(/msie ([\d.]+)/)) ? Sys.ie = s[1] : (s = ua
			.match(/firefox\/([\d.]+)/)) ? Sys.firefox = s[1] : (s = ua
			.match(/chrome\/([\d.]+)/)) ? Sys.chrome = s[1] : (s = ua
			.match(/opera.([\d.]+)/)) ? Sys.opera = s[1] : (s = ua
			.match(/version\/([\d.]+).*safari/)) ? Sys.safari = s[1] : 0;
	if (Sys.ie && Sys.ie == '6.0')
		return 'IE6';
	else if (Sys.ie && Sys.ie == '7.0')
		return 'IE7';
	else if (Sys.ie && Sys.ie == '8.0')
		return 'IE8';
	else if (Sys.ie && Sys.ie == '9.0')
		return 'IE9';
	else if (Sys.ie && Sys.ie == '10.0')
		return 'IE10';
	else if (Sys.ie && Sys.ie == '11.0')
		return 'IE11';
	else if (Sys.firefox)
		return '-moz-';
	else if (Sys.chrome)
		return '-webkit-';
	else if (Sys.opera)
		return '-o-';
	else if (Sys.safari)
		return '-webkit-';
	else
		return '';
}

function forIE6() {
	var bar = getBow();
	if (bar == 'IE6') {
		$('#forIe6Div').dialog('open', {
			url : 'jsp/updateIE.html',
			title : '更新浏览器',
			needClose : false,
			width : '600',
			height : '200'
		});
		return false;
	}
	return true;
}

function tipTrigger() {
	$('.dataDiv').find("div[id*='TipTrigger']").each(function() {
		$(this).mouseover(function() {
			var top = $(this).offset().top + 5;
			var left = $(this).offset().left + 30;
			var id = $(this).attr('id');
			var divId = id.substring(0, id.length - 7);
			$('#' + divId).css({
				top : top,
				left : left
			});
			$('#' + divId).show();
		}).mouseout(function() {
			var id = $(this).attr('id');
			var divId = id.substring(0, id.length - 7);
			$('#' + divId).hide();
		});
	});
}

function comptime(beginTime, endTime) {
	var beginTimes = beginTime.substring(0, 10).split('-');
	var endTimes = endTime.substring(0, 10).split('-');

	var strSplit = "-";

	if (getBow() == '-moz-') {
		strSplit = "/";
	}

	beginTime = beginTimes[1] + strSplit + beginTimes[2] + strSplit
			+ beginTimes[0] + ' ' + beginTime.substring(10, 19);
	endTime = endTimes[1] + strSplit + endTimes[2] + strSplit + endTimes[0]
			+ ' ' + endTime.substring(10, 19);

	var a = Date.parse(endTime) - Date.parse(beginTime);
	return a;
}

function typeSwitch(jrBtnId,jrBtnAction,cpBtnId,cpBtnAction,selectIndex,listDiv){
	if(selectIndex == 0){
		$('#'+jrBtnId).addClass('change-btn-select');
		showTypeList(jrBtnAction,listDiv);
	}else if(selectIndex == 1){
		$('#'+cpBtnId).addClass('change-btn-select');
		showTypeList(cpBtnAction,listDiv);
	}
	
	$('#'+jrBtnId).click(function(){
		if(!$('#'+jrBtnId).hasClass('change-btn-select')){
			$('#'+jrBtnId).addClass('change-btn-select');
		}
		
		if($('#'+cpBtnId).hasClass('change-btn-select')){
			$('#'+cpBtnId).removeClass('change-btn-select');
		}
		showTypeList(jrBtnAction,listDiv);
	});
	
	$('#'+cpBtnId).click(function(){
		if(!$('#'+cpBtnId).hasClass('change-btn-select')){
			$('#'+cpBtnId).addClass('change-btn-select');
		}
		
		if($('#'+jrBtnId).hasClass('change-btn-select')){
			$('#'+jrBtnId).removeClass('change-btn-select');
		}
		showTypeList(cpBtnAction,listDiv);
	});
}

function showTypeList(url,listDiv){
	$('#'+listDiv).jrAjax({
		url : url,
		autoGetParam : true,
		resultAutoProcess : false,
		newdLoading : false,
		successCallback : function(result) {
			$('#'+listDiv).empty();
			$('#'+listDiv).append(result);
		}
	});
}

function pageChangeFun(url,dataDiv) {
	if(dataDiv === undefined || dataDiv === null || dataDiv == ''){
		dataDiv = '.dataDiv';
	}
	$(dataDiv).jrAjax({
		url : url,
		autoGetParam : false,
		resultAutoProcess : true,
		newdLoading : false
	});
}

function downNginxRes(url) {
	$.ajax({
		url : 'file_download.do',
		type : 'post',
		data : {
			'downloadUrl' : url
		},
		success : function(result) {
			if (result == 'true') {
				location.href = url;
			} else {
				$.message.alert('info', '资源下载', result); // 1 info,2:标题 3:内容
															// 4:回调函数
			}
		}
	});
}

	function refreshCache(key){
		if($("#loadDiv").length > 0){
			var height = $("#loadDiv").innerHeight();
			var width = $("#loadDiv").innerWidth();
			var childrenWidth = $(
			$("#loadDiv").children().get(0)).innerWidth();
			if (childrenWidth > width) {
				width = childrenWidth;
			}
			$("#loadDiv").append("<div class=\"fullLoadingWarp\"><div class=\"fullLoadingBg\"  style=\"width:"
					+ width
					+ "px;height:"
					+ height
					+ "px;\"></div><div class=\"fullLoading\" style=\"width:"
					+ width
					+ "px;height:"
					+ height
					+ "px;line-height:"
					+ height
					+ "px\"><span>数据加载中……</span></div></div>");
		}
		
		$.message.confirm('确认信息', '确定刷新缓存？', function(r){
			 if (r){
				
				 $.ajax({
						url:'channel_refresh.do',
						type:'post',
						data:{'cacheKey':key},
						success:function(data){
							if($("#loadDiv").length > 0){
								$("#loadDiv").find(".fullLoadingWarp").remove();
							}
							var resultJson = eval("(" +data+")" );
							var result = resultJson.result;
							var msg = resultJson.msg;
							 $.message.alert("info","提示",msg);
						}
					});
			 }
	    });
	}
	
	function refreshEhcache(key){
		 
		$.message.confirm('确认信息', '确定刷新缓存？', function(r){
			 if (r){
				 $.ajax({
						url:'appBlackListAction_flushBlackListCache.do',
						type:'post',
						data:{'cacheKey':key},
						success:function(data){
							
							var resultJson = eval("(" +data+")" );
							var result = resultJson.result;
							var msg = resultJson.msg;
							$.message.alert("info","提示",msg);
						}
					});
			 }
	    });
	}
$(document).ready(function() {
	loginSlide();
	loginCoopera();
});

function loginSlide() {
	var slideHandler = $(".slideImg");
	var divImgs = slideHandler.find("div");

	divImgs.css({
		'opacity' : '0',
		'filter' : 'Alpha(opacity=0)'
	});
	divImgs.eq(0).css({
		'opacity' : '1',
		'filter' : 'Alpha(opacity=100)'
	});

	var picNum = parseInt(divImgs.length);
	var sildeBottomDiv = $("<div class=\"slideBtn\"></div>");
	slideHandler.append(sildeBottomDiv);
	for ( var index = 1; index <= picNum; index++) {
		sildeBottomDiv.append("<span>" + index + "</span>");
	}

	var sildeButtons = sildeBottomDiv.find('span');
	sildeButtons.eq(0).attr('class', 'current');

	var timer = null;

	sildeButtons.mouseover(function() {
		var nextIndex = $(this).index();
		var curIndex = sildeButtons.filter(".current").index();
		if (nextIndex != curIndex) {
			showNext(curIndex, nextIndex);
		}
	});

	slideHandler.mouseover(function() {
		clearTimeout(timer);
	}).mouseleave(function() {
		timer = setInterval(function() {
			var curIndex = sildeButtons.filter(".current").index();
			var nextIndex = (curIndex + 1) % picNum;
			showNext(curIndex, nextIndex);
		}, 5000);
	}).mouseleave();

	function showNext(curIndex, nextIndex) {
		sildeButtons.removeClass("current").eq(nextIndex).attr('class',
				'current');
		divImgs.eq(curIndex).stop(true, true).animate({
			"opacity" : 0
		}, 1000);
		divImgs.eq(nextIndex).stop(true, true).animate({
			"opacity" : 1
		}, 1000);
	}
}

function loginCoopera() {
	var manufacturers = $(".manufacturers");
	var slideHandler = manufacturers.find('.slideIcon');
	var liImgs = slideHandler.find("li");
	var slideWidth = liImgs.length * 191;
	if (liImgs.length <= 5) {
		manufacturers.find('.preIcon').remove();
		manufacturers.find('.nextIcon').remove();
		slideHandler.css({
			'width' : slideWidth + 'px'
		});
		manufacturers.css({
			'width' : slideWidth + 'px'
		});
		return;
	}

	var slideUl = manufacturers.find('ul');
	slideUl.css({
		'width' : slideWidth + 'px'
	});

	var liWidth = slideUl.find('li').eq(0).outerWidth(true);

	var timer = null;
	manufacturers.mouseover(function() {
		clearTimeout(timer);
	}).mouseleave(function() {
		timer = setInterval(function() {
			nextCooperaIcon();
		}, 5000);
	}).mouseleave();

	manufacturers.find('.preIcon').bind('click', function() {
		var lastLi = slideUl.find('li:last');
		slideUl.css({
			'margin-left' : '-' + liWidth + 'px'
		});
		lastLi.prependTo(slideUl);
		slideUl.stop(true, true).animate({
			"margin-left" : 0
		});
	});
	manufacturers.find('.nextIcon').bind('click', function() {
		nextCooperaIcon();
	});

	function nextCooperaIcon() {
		slideUl.stop(true, true).animate({
			"margin-left" : '-' + liWidth + 'px'
		}, function() {
			var firstLi = slideUl.find('li').eq(0);
			firstLi.appendTo(slideUl);
			slideUl.css({
				'margin-left' : 0
			});
		});
	}
}
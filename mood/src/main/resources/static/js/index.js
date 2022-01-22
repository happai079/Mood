/**
 * index.js
 */

$(function(){
	$('.sideMenuBar').on('click', () => {
		$('#sideMenuBox').toggleClass('show');
	});

	$('.myPage').on('click', () => {
		$('#myPageBox').toggleClass('show');
	});
});
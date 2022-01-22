/**
 * profile.js
 */
 
 $(function(){
	$("#file").on('change',function(){
	  var fileName = $("#file").val();
	  $(".upload-name").val(fileName);
	});
	
	let body = $('body');
	let modal = $('#modal');
	
	$('.updateProfile').on('click', function(){
		$('#sideMenuBox').removeClass('show');
		$('#myPageBox').removeClass('show');
		modal.fadeIn();
		body.css('overflow', 'hidden');
	});
	
	$('.cancle').on('click', function(){
		modal.fadeOut();
		body.css('overflow', 'auto');		
	});
});
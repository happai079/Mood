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
	
	
	// submit 시 formData 만들어서 ajax로 이미지 전송
	$('#profileUpdate').on('submit', function(){
		var formData = new FormData($(this)[0]);
		$.ajax({
			type: 'post',
			url: 'updateMember',
			data: formData,
			processData: false,
            contentType: false,
            success: function () {
                console.log("completed!");
            },
            error: function () {
                alert("failed! ")
            }
		})
	});
});
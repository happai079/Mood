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
		location.reload();		
	});
	
	// submit 시 formData 만들어서 ajax로 이미지 전송
	$('#profileUpdate').on('submit', function(){
		event.preventDefault();
		var formData = new FormData($(this)[0]);
		$.ajax({
			type: 'post',
			url: 'updateMember',
			data: formData,
			processData: false,
            contentType: false,
            success: function (result) {
                alert("회원정보 수정 성공!");
                if(result != null){
					$('.profileImg').attr('src', 'image/'+result[0]);
					$('#name').val() = result[1];
				}	
            },
            error: function () {
                alert("failed! ")
            }
		})
	});
});
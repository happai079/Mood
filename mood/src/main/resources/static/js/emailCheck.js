/**
 * emailCheck.js
 */
 
 $(function(){
	$('#emailCheck').on('click',function(){
		let email = $('#email').val();
		if(email != ""){
			$.ajax({
				type: 'post',
				url: 'emailCheck',
				data: {"memEmail": email},
				dataType: 'text',
				success: function(result){
					if(result == "no_use"){
						alert("사용할 수 없는 이메일입니다.");
						$('#email').focus();
					}else{
						alert("사용 가능한 이메일입니다.");
						$('#isUseable').attr('value','true');
						$('#pw').focus();
					}
				},
				error: function(){
					alert("전송 실패");
				}
			});
		}else{
			alert("email을 입력해주세요.");
			$('#email').focus();
		}
	});
});
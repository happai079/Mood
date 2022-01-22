/**
 * login.js
 */

$(function(){
	$('#logoBox').on('click', () => {
		location.href = '../index.html';
	});
	// 로그인 유효성 검사
	$('.loginForm').submit(function(){
		event.preventDefault();
		
		// 로그인 ajax
		$.ajax({
			type:'post',
			url:'login',
			data: {'memEmail': $('#email').val(),
				   'memPwd': $('#pw').val()},
			dataType: 'text',
			success: function(result){
				if(result == "success"){
					$('#alert').removeClass('show');
					alert("로그인 성공!\nhome 페이지로 이동합니다.");
					location.href="/";
				}else{
					$('#alert').addClass('show');
					$('#alert.show').text("이메일과 비밀번호가 일치하지 않습니다.");
					$('#email').focus();
				}
			},
			error:function(data, textStatus){
				alert("전송 실패");
			}
		});
	})
});
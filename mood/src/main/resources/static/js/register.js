/**
 * register.js
 */

$(function() {
	// 엔터키 눌렀을 때 무조건 submit 안 되도록
	$(document).on('keydown', function(e){
		if(e.keycode == 13) e.preventDefault();
	})
	
	// 비밀번호 입력으로 넘어갈 때 이메일 중복체크 확인
	$('#pw').on('focusin', () => {
		if($('#isUseable').val() == 'false') {
			alert("이메일 중복체크를 해주세요.");
			$('#email').focus();
		}
	})
	
	// 비밀번호 확인으로 넘어가면 비밀번호 유효성 검사
	$('#confirm-pw').on('focusin', ()=>{
		checkPW();
	})
	
	// submit 될때 비밀번호 확인 유효성 검사 -> 회원가입 ajax
	$('.registerForm').submit(function(){
		if(!confirmPW()) return false; 
	}); 

	/* 비밀번호 유효성 검사 */
	function checkPW(){
		const pw = $('#pw').val();
		const num = pw.search(/[0-9]/g);
		const eng = pw.search(/[a-z]/ig);
		const spe = pw.search(/[`~!@@#$%^&*|\\\'\";:\/?]/gi);
		
		if(pw.length < 6 || pw.length > 12){
			$('#alert').addClass('show');
			$('#alert.show').text("6자리 ~ 12자리 이내로 입력해주세요.");
			$('#pw').text("");
			$('#pw').focus();
			return false;
		}else if(pw.search(/\s/) != -1){
			$('#alert').addClass('show');
			$('#alert.show').text("공백없이 입력해주세요.");
			$('#pw').text("");
			$('#pw').focus();
			return false;
		}else if(num < 0 || eng < 0 || spe < 0 ){
			$('#alert').addClass('show');
			$('#alert.show').text("영문, 숫자, 특수문자를 혼합하여 입력해주세요.");
			$('#pw').text("");
			$('#pw').focus();
			return false;
		}else{
			$('#alert').removeClass('show');
			return true;
		}
	};
	
	
	/* 비밀번호 확인 유효성 검사 */
	function confirmPW(){
		const pw = $('#pw').val();
		const confpw = $('#confirm-pw').val();
		
		if(pw !== confpw){
			$('#confirm-alert').addClass('show');
			$('#confirm-alert.show').text("비밀번호 확인이 일치하지 않습니다.");
			$('#confrim-pw').focus();
			return false;
		}else{
			$('#confirm-alert').removeClass('show');
			return true;
		}
		
	};
});
/**
 * gallery.js
 */

$(function(){
	const cardCount = $('.photoCard').length;
	const cardMargin = 30;
	let currentIdx = 0;
	
	function moveSlide(num) {
		const cardWidth = $('.photoCard').width();
		const moveLeft = -num * (cardWidth + cardMargin);
		$('.slidePanel').animate({'left': moveLeft},'slow');
	}
	
	/* next 버튼 클릭 */
	$('.nextSlideBtn').on('click', () => {
		if(currentIdx < cardCount -3){
			currentIdx += 1;
			moveSlide(currentIdx);
		}else {
			currentIdx = 0;
			moveSlide(currentIdx);
		}
	});
	
	/* prev 버튼 클릭 */
	$('.prevSlideBtn').on('click', () => {
		if(currentIdx > 0){
			currentIdx -= 1;
			moveSlide(currentIdx);
		}else {
			currentIdx = cardCount -3;
			moveSlide(currentIdx);
		}
	});
});
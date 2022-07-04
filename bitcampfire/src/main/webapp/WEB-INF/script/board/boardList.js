/**
 * 
 */

$(document).on('click', 'span.listPage', function(){
	alert('span tag clicked!!');
	let clickedVal = $(this).text().trim();
	let curPage = parseInt($('span#currentPaging').text());
	let nextPage;
			
	console.log("click a tag : " + clickedVal); 
	
		if(clickedVal.includes('다음') || clickedVal.includes('이전')){
			if(clickedVal.includes('다음')){
				nextPage = curPage + 1;
			}else if(clickedVal.includes('이전')){
				nextPage = curPage - 1;
			}
		}else{
			nextPage = clickedVal;
		}
	console.log("next page : " + nextPage);
	/*$('#pg').val(nextPage);*/
	/*$('#forTrigger').trigger('custom');*/
	location.href='/semiproject/boardList/list?pg='+nextPage;

});

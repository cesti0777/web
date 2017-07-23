/* 1. html 모든 tag와 하위 text 들은 부모, 자식, 자손과 같은 tree 구조
 * 2. DOM API
 * 		- 문서의 특정 위치의 데이터 또는 구조를 동적으로 변경하는 표준 기술
 * 3.  변수명 권장 명명 규칙
 * 		- $변수명 : html의 일부 구조를 보유하고 재사용 하려는 주 목적의 변수명들
 *  */
$(document).ready(function(){
 
	var v = false;    
	var $f,  $m;
	
	//remove() 함수는 삭제와 동시에 반환을 합니다 따라서 $f변수는 삭제된 요소를 보유한 변수 차후에 재사용 가능
	/* $("button#vegOn") : button tag중에 id값이 vegOn인 tag
	 * 
	 * $f = $(".fish").parent().parent().remove();	
	 * 	1. $(".fish")
	 * 			- <li class="fish">연어</li>
	 * 			- <li class="fish">구운 송어</li>
	 * 2. $(".fish").parent()
	 * 			- <ul class="menu_list">
							<li class="fish">연어</li>
							<li>백포도주</li>
							<li>소금</li>
							<li>후추</li>
						</ul>
			- <ul class="menu_list">
							<li class="fish">구운 송어</li>
							<li>민트</li>
							<li>케이퍼 즙</li>
							<li>올리브</li>
							<li>토마토</li>
							<li>레몬</li>
							<li>올리브 오일</li>
							<li>감자</li>
						</ul>		
				
	 * 3. $(".fish").parent().parent()
	 * 		- <li>데친 연어
						<ul class="menu_list">
							<li class="fish">연어</li>
							<li>백포도주</li>
							<li>소금</li>
							<li>후추</li>
						</ul>
					</li>
			- <li>구운 송어...
	 * 4. $f = $(".fish").parent().parent().remove()
	 * 			- 해당 tag들 삭제, 단 삭제된 구조들은 $f 변수가 보유
	 * 			- 삭제한 li tag는 두개 
	 * 
	 *  
	 *  
	 * $(".meat").after("<li class='tofu'>두부</li>"); 
	 *  1. $(".meat").
	 *  	 <li class="meat">양 어깨 고기</li>
	 *  	<li class="meat">퀴토 햄</li>
	 * 2. after("<li class='tofu'>두부</li>")
	 * 		<li class="meat">양 어깨 고기</li>
	 * 			<li class='tofu'>두부</li>
	 *  	<li class="meat">퀴토 햄</li>
	 *  		<li class='tofu'>두부</li>
	 *  
	 * 3. $m = $(".meat").remove();
	 * 		- 해당 고기들 삭제
	 * 			<li class='tofu'>두부</li> 들이 고기 대신 위치에 셋팅 완료
	 * 
	 * 4. $(".tofu").parent().parent().addClass("veg_leaf");
	 * 		- class 속성이 tofu인 부모의 부모에게 class="veg_leaf" 설정함을 의미
	 *  	- my_style.css 파일의 class="veg_leaf" 설정 정보 적용
	 *  따라서 잎사리 이미지가 보여짐
	 *  */
	
	$("button#vegOn").click(function(){
 		if (v == false){
 		 	$f = $(".fish").parent().parent().remove();	
			$(".meat").after("<li class='tofu'>두부</li>");
			$m = $(".meat").remove();
			$(".tofu").parent().parent().addClass("veg_leaf");
			v = true;
		}// end if
	});//end veg button


	//??? 메뉴 초기화 구성 함수
	/* 나뭇잎 이미지 제거 및 tofu[두부] 삭제
	*/
	$("button#restoreMe").click(function(){
		if (v == true){
			$(".menu_entrees").prepend($f);
			$(".tofu").parent().parent().removeClass("veg_leaf");
			$(".tofu").each(function(i){//매우 사용 빈도가 높음
				$(this).after($m[i]);
			});
			$(".tofu").remove();
			v = false;
		}
	});
});

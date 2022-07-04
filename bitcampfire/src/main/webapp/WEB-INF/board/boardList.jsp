<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 풍혁 (220704) : 상단 네비게이션 --> 
<div class="nav" role="navigation">
	    <a class="create btn btn-success btn-wide pull-right" href="/board/write"><i class="fa fa-pencil"></i> 새 글 쓰기</a>
	    
	    <h4>Q&amp;A</h4>
	    <form id="category-filter-form" name="category-filter-form" method="get" action="/board/questions"> <!-- 풍혁(220704) : 검색 url 태워야합니다.   -->
		    <div class="category-filter-wrapper">
	            <div class="category-filter-query pull-right">
	                <div class="input-group input-group-sm">
	                    <input type="search" name="query" id="search-field" class="form-control" placeholder="검색어" value="">
	                    <span class="input-group-btn">
	                        <button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
	                    </span>
	                </div>
	            </div>
	            <ul class="list-sort pull-left">
	            	<!-- 정렬할 때  -->
	            	<li><a href="/board/questions?query=&amp;sort=id&amp;order=desc" data-sort="id" data-order="desc" class="category-sort-link active">최신순</a></li>
	                <li><a href="/articles/questions?query=&amp;sort=voteCount&amp;order=desc" data-sort="voteCount" data-order="desc" class="category-sort-link ">추천순</a></li>
	                <li><a href="/articles/questions?query=&amp;sort=noteCount&amp;order=desc" data-sort="noteCount" data-order="desc" class="category-sort-link ">댓글순</a></li>
	                <li><a href="/articles/questions?query=&amp;sort=scrapCount&amp;order=desc" data-sort="scrapCount" data-order="desc" class="category-sort-link ">스크랩순</a></li>
	                <li><a href="/articles/questions?query=&amp;sort=viewCount&amp;order=desc" data-sort="viewCount" data-order="desc" class="category-sort-link ">조회순</a></li>
	            </ul>
	            <input type="hidden" name="sort" id="category-sort-input" value="id"> <!-- 실제로 hidden type을 사용하네요  -->
	            <input type="hidden" name="order" id="category-order-input" value="desc">
		    </div>
		</form>
	</div>
<!-- 풍혁 (220704) : 상단 네비게이션 --> 
<!-- <h3>Q&A</h3>
<input type="button" value="새 글 쓰기">

<div id = "sortConditionList" >
	<span id = "sortListByTime" class = "sortCondition"><a href="#">최신순 </a></span>
	<span id = "sortListByRecommend" class = "sortCondition"><a href="#">추천순</a></span>
	<span id = "sortListByScrap" class = "sortCondition"><a href="#">스크랩순</a></span>
	<span id = "sortListByView" class = "sortCondition"><a href="#">조회순</a></span>
	
	<span><input type="text" placeholder="검색어" id = "listSearchKeyword"><input type="button" value="검색하기" id = "listSearchButton"></span>
</div>
 -->

<!-- 풍혁(220703) : user가 작성한  table이 들어오게 됩니다.  -->
<!-- 풍혁(220703) : 공지 tr 은 항상 상단 고정이라서 일단 이 코드 유지하면서 가보겠습니다. -->
<!-- 풍혁(220704) : table tag에서 okky 따라서 ul tag로 수정해보겠습니다.  -->
<div class="panel panel-default questions-panel">
	<ul class="list-group ">
	
	</ul>
</div>
<table id ="boardlistTable">
	<tr>
		<th class = "notice_th" id = "thSubject">
			<span id = "tdSeq">#seqNo.162263</span><span id = "categoryTag"> TechQnA </span> <br>
			<span id = "boardSubject">[태그 잊지말고 달기] Q&A 좋은 답글 달리는 꿀팁!</span>
		</th>
		<th class = "notice_th" id = "thRecommend">
			<span id = "boardRecommend"><img alt="thumbs_up.jpg" src="#">rcmd_num(ex86</span>
		</th>
		<th class = "notice_th" id = "thState">
			<span id = "boardState">bootstrapState</span>
		</th>
		<th class = "notice_th" id = "thAuthor">
			<span id = "boardAuthor"> <img alt="user_icon.jpg" src="#"> master_id<br><span id = "boardLogdate">2017-11-06 11:25:10</span> </span>
		</th>
	</tr>
	${userWriteTableList}
</table>
<!-- 풍혁(220703) : 공지 tr 은 항상 상단 고정이라서 일단 이 코드 유지하면서 가보겠습니다. -->


<!-- 풍혁(220703) : user가 작성한 table sample 입니다. 삭제 예정입니다. -->
<table id = "userWriteTalbe" class = "boardTable">
	<tr>
		<td id = "td_subject">
			<span id = "tdSeq">#seqNo.1262263</span><span id = "categoryTag"> TechQnA </span> <br>
			<span id = "boardSubject">project진행에 관련해서 질문이 있습니다..!</span>
		</td>
		<td id = "td_recommend">
			<span id = "boardRecommend"><img alt="thumbs_up.jpg" src="#">rcmd_num(ex86</span>
		</td>
		<td id = "td_state">
			<span id = "boardState">bootstrapState</span>
		</td>
		<td id = "td_author">
			<span id = "boardAuthor"> <img alt="user_icon.jpg" src="#"> author_id<br><span id = "boardLogdate">2017-11-06 11:25:10</span> </span>
		</td>
	</tr>
</table>
<!-- 풍혁(220703) : user가 작성한 table sample 입니다. 삭제 예정입니다. -->

<!-- 풍혁(220703) : boardList page 입니다. hr tag는 잠시구분을 위한 선입니다.(삭제예정) -->
<!-- 풍혁(220703) : page a 태그는  href로 이동하지 않고 jquery로 click event를 통해 구현하겠습니다.-->
<hr>
${boardPagingList}


<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/semiProject/script//boardList.js"></script>
</body>
</html>

<!-- 1.state랑 글 td의 색을 통일하고 있다. --> 
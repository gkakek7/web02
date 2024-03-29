<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<ul>
	<li>
		<a href="javascript:;" data-go-link="/">INDEX</a>
	</li>
	<li>
		<a href="javascript:;" data-go-link="/member/memberList.do">회원관리</a>
	</li>
	<li>
		<a href="javascript:;" data-go-link="/prod/prodList.do">상품관리</a>
	</li>
	<li>
		<a href="${pageContext.request.contextPath}/09/propView.do">프로퍼티관리</a>
	</li>
	<li>
		<a href="${pageContext.request.contextPath}/12/jdbcDesc.do">프로퍼티목록조회</a>
	</li>	
	<li>
		<a href="${pageContext.request.contextPath}/10/mbtiForm.do">MBTI 조회</a>
	</li>
	<li>
		<a href="${pageContext.request.contextPath}/buyer/buyerList.do">제조사</a>
	</li>
</ul>
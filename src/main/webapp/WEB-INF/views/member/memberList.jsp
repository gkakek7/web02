<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table class="table table-bordered">
	<thead>
		<tr>
			<th>일련번호</th>
			<th>회원명</th>
			<th>이메일</th>
			<th>휴대폰</th>
			<th>주소1</th>
			<th>마일리지</th>
		</tr>
	</thead>
	<tbody>
<!-- 		screen size : 3, block size : 3 -->
	<c:choose>
		<c:when  test="${not empty memberList}">
			<c:forEach items="${memberList}" var="member">
				<tr>
					<td>${member.rnum}</td>
					<td>${member.memName}</td>
					<td>${member.memMail}</td>
					<td>${member.memHp}</td>
					<td>${member.memAdd1}</td>
					<td>${member.memMileage}</td>
				</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td colspan="6">조건에 맞는 회원이 없음.</td>
			</tr>
		</c:otherwise>
	</c:choose>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="6">
				<form id="submitForm" action='<c:url value='/member/memberList.do'/>'>
					<input type="text" name="page"/>
					<input type="text" name="searchType" value="${condition.searchType}"/>
					<input type="text" name="searchWord" value="${condition.searchWord}"/>
				</form>
				<div data-pg-role="searchUI" data-pg-target="#submitForm">
					<select name="searchType" data-pg-init-value="${condition.searchType }">
						<option value>전체</option>
						<option value="name">이름</option>
						<option value="address">주소</option>
					</select>
					<input type="text" name="searchWord" data-pg-init-value="${condition.searchWord}"/>
					<button type="button" data-pg-role="searchBtn">검색</button>
				</div>
				${pagingHTML} 
			</td>
		</tr>
	</tfoot>
</table>
<script src="<c:url value='/resorces/js/app/common/paging.js'/>"></script>
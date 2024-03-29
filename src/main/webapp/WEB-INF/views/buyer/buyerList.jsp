<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<a href="javascript:;" data-go-link="/buyer/buyerInsert.do">신규제조사등록</a>
<table class="table table-bordered">
	<thead>
		<tr>
			<th>제조사코드</th>
			<th>제조사명</th>
			<th>제조사분류</th>
			<th>은행</th>
			<th>계좌번호</th>
			<th>계좌주</th>
			<th>우편번호</th>
			<th>주소1</th>
			<th>주소2</th>
			<th>전화번호</th>
			<th>팩스번호</th>
			<th>이메일</th>
			<th>담당자</th>
			<th>내선번호</th>
			<th>이메일2</th>
			<th>담당자2</th>
			<th>내선번호2</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${not empty buyerList}">
			<c:forEach items="${buyerList}" var="buyer">
				<tr>
					<td>${buyer.buyerId}</td>
					<c:url value="/buyer/buyerView.do" var="viewUrl">
						<c:param name="what" value="${buyer.buyerId}"/>
					</c:url>
					<td><a href="${viewUrl}">${buyer.buyerName}</a></td>
					<td>${buyer.buyerLgu}</td>
					<td>${buyer.buyerBank}</td>
					<td>${buyer.buyerBankno}</td>
					<td>${buyer.buyerBankname}</td>
					<td>${buyer.buyerZip}</td>
					<td>${buyer.buyerAdd1}</td>
					<td>${buyer.buyerAdd2}</td>
					<td>${buyer.buyerComtel}
					<td>${buyer.buyerFax}</td>
					<td>${buyer.buyerMail}</td>
					<td>${buyer.buyerCharger}</td>
					<td>${buyer.buyerTelext}</td>
					<td>${buyer.buyerMail2}</td>
					<td>${buyer.buyerCharger2}</td>
					<td>${buyer.buyerTelext2}</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty buyerList}">
			<tr>
				<td colspan="17">상품 없음.</td>
			</tr>
		</c:if>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="17">
				<form id="searchForm" action='<c:url value='/buyer/buyerList.do'/>'>
					<input type="text" name="page" /> 
					<input type="text"name="buyerLgu" value="${condition.buyerLgu}" /> 
					<input type="text"name="buyerAddr1" value="${condition.buyerAddr1}" /> 
					<input type="text" name="buyerName" value="${condition.buyerName}" />
				</form>
				<div data-pg-role="searchUI" data-pg-target="#searchForm">
					<select name="buyerLgu" data-pg-init-value="${condition.buyerLgu}">
						<option value>분류선택</option>
						<c:forEach items="${lprodList}" var="lprod">
							<option value="${lprod.lprodGu }">${lprod.lprodNm }</option>
						</c:forEach>
					</select> 
					<input type="text" name="buyerAddr1" value="${condition.buyerAddr1}" placeholder="주소검색"/>
					<input type="text" name="buyerName" value="${condition.buyerName}" placeholder="제조사 검색"/>
					<button data-pg-role="searchBtn">검색</button>
				</div> ${pagingHTML}
			</td>
		</tr>
	</tfoot>
</table>
<script src="<c:url value='/resorces/js/app/common/paging.js'/>"></script>

<!-- 검색조건 : 상품분류코드, 제조사코드, 상품명, 전체 : 상품분류코드, 제조사코드, 상품명, 전체(searchType) -->
<!-- 검색단어(searchWord) -->
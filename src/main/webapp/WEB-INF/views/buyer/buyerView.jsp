<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table class="table table-bordered">
	<tr>
		<th>제조사코드</th>
		<td>${buyer.buyerId }</td>
	</tr>
	<tr>
		<th>제조사명</th>
		<td>${buyer.buyerName }</td>
	</tr>
	<tr>
		<th>제조사분류</th>
		<td>${buyer.lprod.lprodNm }</td>
	</tr>
	<tr>
		<th>은행</th>
		<td>${buyer.buyerBank }</td>
	</tr>
	<tr>
		<th>계좌번호</th>
		<td>${buyer.buyerBankno }</td>
	</tr>
	<tr>
		<th>계좌주</th>
		<td>${buyer.buyerBankname }</td>
	</tr>
	<tr>
		<th>우편번호</th>
		<td>${buyer.buyerZip }</td>
	</tr>
	<tr>
		<th>주소1</th>
		<td>${buyer.buyerAdd1 }</td>
	</tr>
	<tr>
		<th>주소2</th>
		<td>${buyer.buyerAdd2 }</td>
	</tr>
	<tr>
		<th>전화번호</th>
		<td>${buyer.buyerComtel }</td>
	</tr>
	<tr>
		<th>팩스번호</th>
		<td>${buyer.buyerFax }</td>
	</tr>
	<tr>
		<th>이메일</th>
		<td>${buyer.buyerMail }</td>
	</tr>
	<tr>
		<th>이메일2</th>
		<td>${buyer.buyerMail2 }</td>
	</tr>
	<tr>
		<th>담당자</th>
		<td>${buyer.buyerCharger }</td>
	</tr>
	<tr>
		<th>담당자2</th>
		<td>${buyer.buyerCharger2 }</td>
	</tr>
	<tr>
		<th>내선번호</th>
		<td>${buyer.buyerTelext }</td>
	</tr>
	<tr>
		<th>내선번호2</th>
		<td>${buyer.buyerTelext2 }</td>
	</tr>
	<tr>
		<th>거래품목</th>
		<td>
			<table class="table table-bordered">
				<thead class="table-light">
					<tr>
						<th>상품명</th>
						<th>구매가</th>
						<th>판매가</th>
						<th>세일가</th>
						<th>마일리지</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${not empty buyer.prodList }">
						<c:forEach items="${buyer.prodList }" var="prod">
							<tr>
								<c:url value="/prod/prodView.do" var="viewUrl">
									<c:param name="what" value="${prod.prodId }" />
								</c:url>
								<td><a href="${viewUrl }">${prod.prodName}</a></td>
								<td>${prod.prodCost }</td>
								<td>${prod.prodPrice }</td>
								<td>${prod.prodSale }</td>
								<td>${prod.prodMileage }</td>
							</tr>
						</c:forEach>
					</c:if>
					<c:if test="${empty buyer.prodList }">
						<tr>
							<td colspan="5">거래품목없음</td>
						</tr>
					</c:if>
				</tbody>
			</table>
		</td>
	</tr>
	<tr>
		<td colspan="2"><a class="btn btn-primary" data-go-link="/buyer/buyerList.do">제조사목록</a> 
		<a class="btn btn-primary" href="javascript:;" onclick="history.back();">뒤로가기</a>
			<c:url value="/buyer/buyerUpdate.do" var="updateUrl">
				<c:param name="what" value="${buyer.buyerId }" />
			</c:url> <a class="btn btn-primary" href="${updateUrl}">상품수정</a></td>
	</tr>
</table>
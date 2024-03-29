<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<form method="post">
	<table>
		<tr>
			<th>제조사명</th>
			<td><input type="text" name="buyerName" required
				value="${buyer.buyerName}" class="form-control" /><span
				class="text-danger">${errors.buyerName}</span></td>
		</tr>
		<tr>
			<th>분류</th>
			<td><select name="buyerLgu">
					<option value>분류선택</option>
					<c:forEach items="${lprodList}" var="lprod">
						<option value="${lprod.lprodGu }">${lprod.lprodNm }</option>
					</c:forEach>
			</select><span class="text-danger">${errors.prodLgu}</span></td>
		</tr>
		<tr>
			<th>은행</th>
			<td><input type="text" name="buyerBank"
				value="${buyer.buyerBank}" class="form-control" /><span
				class="text-danger">${errors.buyerBank}</span></td>
		</tr>
		<tr>
			<th>계좌번호</th>
			<td><input type="text" name="buyerBankno"
				value="${buyer.buyerBankno}" class="form-control" /><span
				class="text-danger">${errors.buyerBankno}</span></td>
		</tr>
		<tr>
			<th>계좌주</th>
			<td><input type="text" name="buyerBankname"
				value="${buyer.buyerBankname}" class="form-control" /><span
				class="text-danger">${errors.buyerBankname}</span></td>
		</tr>
		<tr>
			<th>우편번호</th>
			<td><input type="text" name="buyerZip" value="${buyer.buyerZip}"
				class="form-control" /><span class="text-danger">${errors.buyerZip}</span></td>
		</tr>
		<tr>
			<th>주소1</th>
			<td><input type="text" name="buyerAdd1"
				value="${buyer.buyerAdd1}" class="form-control" /><span
				class="text-danger">${errors.buyerAdd1}</span></td>
		</tr>
		<tr>
			<th>주소2</th>
			<td><input type="text" name="buyerAdd2"
				value="${buyer.buyerAdd2}" class="form-control" /><span
				class="text-danger">${errors.buyerAdd2}</span></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><input type="text" name="buyerComtel" required
				value="${buyer.buyerComtel}" class="form-control" /><span
				class="text-danger">${errors.buyerComtel}</span></td>
		</tr>
		<tr>
			<th>팩스번호</th>
			<td><input type="text" name="buyerFax" required
				value="${buyer.buyerFax}" class="form-control" /><span
				class="text-danger">${errors.buyerFax}</span></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="text" name="buyerMail" required
				value="${buyer.buyerMail}" class="form-control" /><span
				class="text-danger">${errors.buyerMail}</span></td>
		</tr>
		<tr>
			<th>담당자</th>
			<td><input type="text" name="buyerCharger"
				value="${buyer.buyerCharger}" class="form-control" /><span
				class="text-danger">${errors.buyerCharger}</span></td>
		</tr>
		<tr>
			<th>내선번호</th>
			<td><input type="text" name="buyerTelext"
				value="${buyer.buyerTelext}" class="form-control" /><span
				class="text-danger">${errors.buyerTelext}</span></td>
		</tr>
		<tr>
			<th>이메일2</th>
			<td><input type="text" name="buyerMail2"
				value="${buyer.buyerMail2}" class="form-control" /><span
				class="text-danger">${errors.buyerMail2}</span></td>
		</tr>
		<tr>
			<th>담당자2</th>
			<td><input type="text" name="buyerCharger2"
				value="${buyer.buyerCharger2}" class="form-control" /><span
				class="text-danger">${errors.buyerCharger2}</span></td>
		</tr>
		<tr>
			<th>내선번호2</th>
			<td><input type="text" name="buyerTelext2"
				value="${buyer.buyerTelext2}" class="form-control" /><span
				class="text-danger">${errors.buyerTelext2}</span></td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="등록">
			</td>
		</tr>
	</table>
</form>
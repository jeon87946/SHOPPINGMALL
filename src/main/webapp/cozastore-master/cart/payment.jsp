<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="kr">
<head>
<meta charset="UTF-8">
<title>주문서</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>	
<script>
 let checkForm = function() {
	
	let f = document.orderSheet
	
	if(f.receive.value == ''){
		alert('수령인을 입력해주세요')
		f.receive.focus()
		return false
	}
	if(f.name.value == ''){
		alert('이름을 입력해주세요')
		f.name.focus()
		return false
	}
	if(f.number1.value == ''){
		alert('전화번호를 입력해주세요')
		f.number1.focus()
		return false
	}
	if(f.number2.value == ''){
		alert('전화번호를 입력해주세요')
		f.number2.focus()
		return false
	}
	if(f.number3.value == ''){
		alert('전화번호를 입력해주세요')
		f.number3.focus()
		return false
	}
	if(f.post.value == ''){
		alert('주소를 입력해주세요')
		f.post.focus()
		return false
	}
} 
	/* let checkForm = function() {
		
		let f = document.orderSheet
		
		if(isNull(f.receive, '아이디를 입력해주세요')) {
			return false
		}
		if(isNull(f.pwd, '비밀번호를 입력해주세요')) {
			return false
		}
		if(isNull(f.name, '이름을 입력해주세요')) {
			return false
		}
		if(isNull(f.callno, '전화번호를 입력해주세요')) {
			return false
		}
		return true
	} */
</script>

<script>
function sample6_execDaumPostcode() {
    new daum.Postcode(
    {
        oncomplete : function(data) {
           var fullAddr = ''; // 최종 주소 변수
           var extraAddr = ''; // 조합형 주소 변수
           // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
           if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
               fullAddr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                fullAddr = data.jibunAddress;
            }
            // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
            if (data.userSelectedType === 'R') {
                //법정동명이 있을 경우 추가한다.
                if (data.bname !== '') {
                     extraAddr += data.bname;
                }
                // 건물명이 있을 경우 추가한다.
                if (data.buildingName !== '') {
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                fullAddr += (extraAddr !== '' ? ' (' + extraAddr + ')' : '');
            }
            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
            document.getElementById('sample6_address').value = fullAddr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById('sample6_address2').focus();
        }
    }).open();
}
</script>
</head>
<body>
 <header class="header-v4">
	<div>
		<jsp:include page="../include/topMenu.jsp"></jsp:include>
	</div>
</header> 

	<section>
	<div align="center">
	<hr>
	<h2>주문서 작성</h2>
	<hr>
	<form name = "orderSheet" action="/ShoppingMall/paymentpro.do" method="post" onsubmit="return checkForm()">
		<table style ="width:50%" border="1">
		
				<%--  <c:forEach var="user" items="${LOGIN_USER}"> --%>
			<tr>
				<th width="50%">수령인</th>
				<td>
					<input type="text" name="receive">
				</td>
			</tr>
			
			<tr>
				<th width="10%">휴대전화</th>
				<td>
				
				
					<input type="text" name="number1" size="7%" placeholder="예시) 011"> -
					<input type="text" name="number2" size="7%" placeholder="0000"> -
					<input type="text" name="number3" size="7%" placeholder="0000">
				</td>
			</tr>
				 <%-- </c:forEach> --%>
			<tr>
				<th width="50%">이메일</th>
				<td>
					<input type="text" name="email" size="30%" placeholder="예시) naver@naver.com">
				</td>
			</tr>
			
			<tr>
				<th width="50%">배송메시지
				<td>
					<input type="text" name="orderMsg" size="50%" placeholder="예시: 부재시 문앞에 두고 가주세요">
				</td>
				</th>
			</tr>	
</table>
<table border="1">
			<TH>우편번호</TH>
			  <TD>
			    <input type="text" name="post" size="7" id="sample6_postcode" placeholder="우편번호">
			    <input type="button" class="btn btn-primary btn-sm" value="우편번호찾기" onclick="sample6_execDaumPostcode()">
			  </TD>
			</TR>
			<TR>
			  <TH>주소</TH>
			  <TD>
			    <input type="text" name="basicAddr" size="40" id="sample6_address" placeholder="주소">
			    <br>
			    <input type="text" name="detailAddr" size="40" id="sample6_address2" placeholder="상세주소">
			  </TD>
			</TR>
				
			<br>
</table>	
		<c:forEach var="cart" items="${LoginCart}">
			<input type="hidden"  name="itemPrice" value= "${cart.itemPrice}">
			<input type="hidden"  name="itemName" value= "${cart.itemName}">
			<input type="hidden"  name="itemCnt" value= "${cart.itemCnt}">
			<input type="hidden"  name="itemCode" value= "${cart.itemCode}">
			<input type="hidden"  name="id" value= "${cart.id}">
		</c:forEach>
		<c:if test="${not empty order}">
		 	<input type="hidden"  name="itemPrice" value= "${order.itemPrice}">
			<input type="hidden"  name="itemName" value= "${order.itemName}">
			<input type="hidden"  name="itemCnt" value= "${order.itemCnt}">
			<input type="hidden"  name="itemCode" value= "${order.itemCode}">
			<input type="hidden" name="id" value="NonMember">
		</c:if>	
				<td>결제방법 : </td>
				<td><input type="radio" value="무통장" checked/>무통장</td>		
			<br>
			<button type="submit">결제</button>

			
</form>
</section>
</div>	
 <!-- Footer -->
	<footer>
		<jsp:include page="../include/footer.jsp" />
	</footer>
</body>
</html> 	
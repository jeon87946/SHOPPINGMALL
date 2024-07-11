<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="kr">
<head>
<meta charset="UTF-8">
<title>주문서</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style>
	 body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f9;
    margin: 0;
    padding: 0;
    display: block;
    justify-content: center;
    align-items: center;
    height: 100vh;
	} 
	
    .order-container {
    background-color: #ffffff;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    width: 300px;
    margin:auto;
	}
	
	.order-container h1 {
    text-align: center;
    color: #333333;
}

.order-form {
    display: flex;
    flex-direction: column;
}

.order-form label {
    margin-bottom: 5px;
    color: #555555;
}

.order-form input,
.order-form select {
    margin-bottom: 15px;
    padding: 10px;
    border: 1px solid #cccccc;
    border-radius: 5px;
}

.order-form button {
    background-color: #007bff;
    color: #ffffff;
    padding: 10px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

.order-form button:hover {
    background-color: #0056b3;
}
.logo {
	background-size: 100px;
	background-position: top 100px;
}
 </style>   	
<script>
 let checkForm = function() {
	
	let f = document.orderSheet
	
	if(f.receive.value == ''){
		alert('수령인을 입력해주세요')
		f.receive.focus()
		return false
	}
	
	if(f.phone.value == ''){
		alert('전화번호를 입력해주세요')
		f.phone.focus()
		return false
	}
	if(f.Email.value == ''){
		alert('이메일을 입력해주세요')
		f.email.focus()
		return false
	}
	if(f.postcode.value == ''){
		alert('우편번호를 입력해주세요')
		f.postcode.focus()
		return false
	}
	if(f.homeAddress.value == ''){
		alert('주소를 입력해주세요')
		f.home_address.focus()
		return false
	}
	if(f.detailAddress.value == ''){
		alert('상세주소를 입력해주세요')
		f.detail_Address.focus()
		return false
	}
} 

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
	<div align="center" class="order-container">
	<h1>주문서 작성</h1>
	<form class="order-form" name = "orderSheet" action="/ShoppingMall/paymentpro.do" method="post" onsubmit="return checkForm()">
		<!-- <table style ="width:50%" border="1"> -->
		
		<%-- <c:forEach var="user" items="${LOGIN_USER}"> --%>
				<label for="receive">이름</label>
				<input type="text" name="receive" size="20%" value="${LOGIN_USER.name}">
				
				<label for="phone">휴대전화</label>
				<input type="text" name="phone" size="20%" value="${LOGIN_USER.phone}">
				
				<label for="Email">이메일</label>
				<input type="text" name="Email" size="30%" placeholder="예시) naver@naver.com" value="${LOGIN_USER.email}">
			
				<label for="orderMge">배송메시지</label>
				<input type="text" name="orderMsg" size="50%" placeholder="예시: 부재시 문앞에 두고 가주세요">

			<label for="postcode">우편번호</label>
			    <input type="text" name="postcode" size="7" id="sample6_postcode" placeholder="우편번호"  value="${LOGIN_USER.postcode}">
			    <input type="button" class="btn btn-primary btn-sm" value="우편번호찾기" onclick="sample6_execDaumPostcode()">
			 <label for="homeAddress">주소</label>
			    <input type="text" name="homeAddress" size="40" id="sample6_address" placeholder="주소" value="${LOGIN_USER.homeAddress}">
			 <label for="detailAddress">상세주소</label>
			    <br>
			    <input type="text" name="detailAddress" size="40" id="sample6_address2" placeholder="상세주소" value="${LOGIN_USER.detailAddress}">
			<%-- </c:forEach> --%>
			<table>
			<tr>
			<th>결제방법 : </th>
			<td><input type="radio" value="무통장" checked/>무통장
				<!-- <input type="radio" value="카드" />카드 -->
			</td>
			</tr>		
			</table>
				
		<c:forEach var="order" items="${orderList}">
			<input type="hidden"  name="itemPrice" value= "${order.itemPrice}">
			<input type="hidden"  name="itemName" value= "${order.itemName}">
			<input type="hidden"  name="itemCnt" value= "${order.itemCnt}">
			<input type="hidden"  name="itemCode" value= "${order.itemCode}">
		</c:forEach>
			
			<button type="submit">주문하기</button>

			
</form>
</div>	
</section>
 <!-- Footer -->
	 <footer>
		<jsp:include page="../include/footer.jsp" />
	</footer> 
	
</body>
</html> 	
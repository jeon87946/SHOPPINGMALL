<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">

<body>
<script>
	let checkForm = function() {
		
		let f = document.joinForm
		
		if(f.id.value == ''){
			alert('아이디를 입력해주세요')
			f.id.focus()
			return false
		}
		if(f.name.value == ''){
			alert('이름을 입력해주세요')
			f.name.focus()
			return false
		}
		if(f.password.value == ''){
			alert('비밀번호를 입력해주세요')
			f.password.focus()
			return false
		}
		if(f.userAge.value == ''){
			alert('나이를 입력해주세요')
			f.password.focus()
			return false
		}
	}
</script>
</head>
	<header class="header-v4">
	<div>
		<jsp:include page="../include/topMenu.jsp"></jsp:include>
	</div>
	</header>

	<section>
		<div align = "center">
		<br>
		<hr>
		<h2> 회원가입 </h2>
		<br>
		<hr>
		<form action = "/ShoppingMall/joinpro.do" method="post" name="joinForm"
		onsubmit="return checkForm()">
		<table style= "width:40%" border="1">
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="id" size = "50" placeholder="아이디"> 
					<button type="button">중복확인</button>
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="userName" size = "50" placeholder="이름">	
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="userPassword" size = "50" placeholder="비밀번호">	
				</td>
			</tr>
			<tr>
				<th>나이</th>
				<td>
					<input type="text" name="userAge" size = "30" placeholder="나이">	
				</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
					<select name="userSex"><option>M<option>F</select><br>
					<br>
					
			</tr>
			<tr>
				<th>전화번호</th>
				<td>
					<input type="text" name="userNumber1" size = "7" placeholder="ex)010"> -	
					<input type="text" name="userNumber2" size = "7" placeholder=" 0000"> -	
					<input type="text" name="userNumber3" size = "7" placeholder=" 0000">	
				</td>
			</tr>
		</table>
		<button type="submit">완료</button>			
		</form>
		</div>
	</section>
	<footer>
		<jsp:include page="../include/footer.jsp" />
	</footer>
</body>
</html>
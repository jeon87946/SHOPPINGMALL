<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">

<body>
 <script>
	let checkForm = function() {
		
		let f = document.loginForm
		
		if(f.id.value == ''){
			alert('아이디를 입력해주세요')
			f.id.focus()
			return false
		}
		if(f.userPassword.value == ''){
			alert('비밀번호를 입력해주세요')
			f.userPassword.focus()
			return false
		}
	}
</script>
</head>
	<header class="header-v4">
	<div>
		<jsp:include page="../../include/topMenu.jsp"></jsp:include>
	</div>
	</header>
	<section>
		<div align = "center">
		<br>
		<hr>
		<h2> LOGIN </h2>
		<br>
		<hr>
		<form action = "/ShoppingMall/loginpro.do" method="post" name = "loginForm" 
		onsubmit="return checkForm()">
			<table style ="width:40%" border="1">
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" name="id" placeholder="아이디">
					</td>
				</tr>	
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" name="userPassword" placeholder="비밀번호">
					</td>
				</tr>
			</table>
			<button type="submit">로그인</button>		
		</form>
		</div>
	</section>
	<footer>
		<jsp:include page="../../include/footer.jsp" />
	</footer>
	

</body>
</html>
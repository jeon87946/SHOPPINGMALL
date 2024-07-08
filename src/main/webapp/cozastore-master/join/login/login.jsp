<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
<head>
	<meta charset="UTF-8">
    <title>Login Page</title>
    <style>
	.login-container {
			top: 50%;
			left: 50%;
            width: 300px;
		    height: 350px;
		    display: flex;
		    justify-content: center;
		    align-items: center;
		    flex-direction: column;
		    border: 1px solid lightgrey;
		    border-radius: 5px;
			margin: 0 auto;
        }
        .login-container h2 {
            margin-bottom: 20px;
            text-align: center;
		    justify-content: center;
		    align-items: center;
        }
        .login-container button:hover {
            background-color: #00a2b8;
        }
        
        .login-container button {
            width: 100%;
            padding: 10px;
            background-color: #00bcd4;
            border: none;
            border-radius: 5px;
            color: white;
            font-size: 16px;
            cursor: pointer;
        }
         .login-container .forgot-password {
            text-align: center;
            margin-top: 20px;
        }
	</style>
	
 <script>
	let checkForm = function() {
		
		let f = document.loginForm
		
		if(f.id.value == ''){
			alert('아이디를 입력해주세요')
			f.id.focus()
			return false
		}
		if(f.Password.value == ''){
			alert('비밀번호를 입력해주세요')
			f.Password.focus()
			return false
		}
	}
</script>
</head>
<body>
	<header class="header-v4">
	<div>
		<jsp:include page="../../include/topMenu.jsp"></jsp:include>
	</div>
	</header>
	<section>
		<div align = "center" class="login-container">
		<br>
		<hr>
		<h2> 로그인 </h2>
		<br>
		<hr>
		<form action = "/ShoppingMall/loginpro.do" method="post" name = "loginForm" 
		onsubmit="return checkForm()">
			<table style ="width:40%" border="1">
				<tr>
					<td>
						<input type="text" name="id" placeholder="아이디">
					</td>
				</tr>
				</table>
				<hr>
				<table style ="width:40%" border="1">
				<tr>
					<td>
						<input type="password" name="Password" placeholder="비밀번호">
					</td>
				</tr>
			</table>
			<br>
			<button type="submit">로그인</button>		
		</form>
		</div>
	</section>
	<footer>
		<jsp:include page="../../include/footer.jsp" />
	</footer>
	

</body>
</html>
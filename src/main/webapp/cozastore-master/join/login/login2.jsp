<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	
	<%-- header>
	<div>
		<jsp:include page="../../include/topMenu.jsp"></jsp:include>
	</div>
	</header> --%>
	
    <meta charset="UTF-8">
    <title>Login Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .login-container {
            background-color: #0a2c55;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
        }
        .login-container h2 {
            color: white;
            margin-bottom: 20px;
            text-align: center;
        }
        .login-container input[type="email"],
        .login-container input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: none;
            border-bottom: 2px solid #ccc;
            background: none;
            color: white;
            font-size: 16px;
        }
        .login-container input[type="email"]:focus,
        .login-container input[type="password"]:focus {
            border-bottom: 2px solid #00bcd4;
            outline: none;
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
        .login-container button:hover {
            background-color: #00a2b8;
        }
        .login-container .forgot-password {
            text-align: center;
            margin-top: 20px;
        }
        .login-container .forgot-password a {
            color: #00bcd4;
            text-decoration: none;
        }
    </style>
</head>
	
<body>
    <div class="login-container">
        <form action="loginProcess.jsp" method="post">
            <h2>Login</h2>
            <input type="email" name="email" placeholder="Email" required>
            <input type="password" name="password" placeholder="Password" required>
            <button type="submit">LOG IN</button>
            <div class="forgots-password">
                <a href="#">Forgot Password?</a>
   </div>
        </form>
    </div>
    <%-- <footer>
		<jsp:include page="../../include/footer.jsp" />
	</footer> --%>
</body>
</html>
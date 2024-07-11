<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<body><!-- class="animsition" --> 
	
		<!-- Header desktop -->
		<div class="container-menu-desktop">
			
			<!-- Topbar -->
			<div class="top-bar">
				<div class="content-topbar flex-sb-m h-full container">
					<div class="left-top-bar">
					</div>
					<div class="right-top-bar flex-w h-full">
				<c:choose>
					<c:when test="${not empty LOGIN_USER}">
						<a href="/ShoppingMall/mypage.do" class="flex-c-m trans-04 p-lr-25">
							마이페이지
						</a>
						<a href="/ShoppingMall/logout.do"  class="flex-c-m trans-04 p-lr-25">로그아웃</a>
					</c:when>
					<c:otherwise>
						<a href="/ShoppingMall/login.do" class="flex-c-m trans-04 p-lr-25">
							로그인
						</a>
						<a href="http://172.31.9.180:8080/ShoppingMall-total/SignUpForm.do" class="flex-c-m trans-04 p-lr-25">
							가입하기
						</a>
					</c:otherwise>
				</c:choose>		
						<!-- <a href="#" class="flex-c-m trans-04 p-lr-25">
							문의하기
						</a> -->

						

						<tr>
						<td rowspan="2">
							<div style="height:25px; width:100px; text-align: center"></div>
						</td>
						<td align = "right">
							<c:if test ="${not empty LOGIN_USER}">
							
								[${LOGIN_USER.name} 님 ]
							</c:if>
							<c:if test = "${empty LOGIN_USER}">
								GUEST
							</c:if>	
						</td>	
					</tr>
					</div>
				</div>
			</div>
			
<div class="wrap-menu-desktop">
				<nav class="limiter-menu-desktop container">
					
					<!-- Logo desktop -->		
					<a href="/ShoppingMall/index.do" class="logo">
						<img src="/ShoppingMall/cozastore-master/images/logo.png" alt="IMG-LOGO">
					</a>

					<!-- Menu desktop -->
					<div class="menu-desktop">
						<ul class="main-menu">
							<li class="active-menu">
								<a href="/ShoppingMall/index.do">Home</a>
								<ul class="sub-menu">
									<!-- <li><a href="index.jsp">Homepage 1</a></li> -->
									<!-- <li><a href="home-02.jsp">Homepage 2</a></li> -->
									<li><a href="/ShoppingMall/cozastore-master/view/home-03.jsp">STORE</a></li>
								</ul>
							</li>

							<li>
								<a href="/ShoppingMall/product.do">상품</a>
							</li>

						<c:choose>
							<c:when test="${not empty LOGIN_USER}">
							<li><!-- data-label1="hot" -->
								<a href="/ShoppingMall/shopping-cart.do">장바구니</a>
							</li>
							</c:when>
						</c:choose>	

							<!-- <li>
								<a href="blog.jsp">Blog</a>
							</li>

							<li>
								<a href="about.jsp">About</a>
							</li>

							<li>
								<a href="/ShoppingMall/cozastore-master/contact/contact.jsp">Contact</a>
							</li> -->
						</ul>
					</div>	

					<!-- Icon header -->
					<div class="wrap-icon-header flex-w flex-r-m">
						<div class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 js-show-modal-search">
							<i class="zmdi zmdi-search"></i>
						</div>

						<div class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 js-show-modal-search data-notify="-">
							<i class="zmdi zmdi-shopping-cart"></i>
						</div>

						<div class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 js-show-modal-search" data-notify="0" >
							<i class="zmdi zmdi-favorite-outline"></i>
						</div>
					</div>
				</nav>
			</div>	
		</div>			
</header>		


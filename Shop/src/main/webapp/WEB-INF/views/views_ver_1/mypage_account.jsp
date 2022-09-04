<%@page import="com.shop.biz.util.AdminUtil"%>
<%@page import="com.shop.biz.account.impl.AccountDAO"%>
<%@page import="com.shop.biz.account.AccountVO"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%
	// 세션에 저장된 회원 정보를 꺼낸다. 
	AccountVO account = (AccountVO) session.getAttribute("account");
%>
<%
	AdminUtil adminUtil = new AdminUtil();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>Untitled 3</title>

<style>
a {text-decoration:none;}
</style>
</head>

<body link="#000000" alink="#000000" vlink="#000000" >


        <!-- ***** MAIN TABLE ***** -->
        <table width="1000" height="700" border="0" align="center">
            <tr><!--상단-->
                <td height="120">
                    <!--상단 테이블 구성-->
                    <!-- <table width="1200" height="120", border="0" bgcolor="#E2E0E5"> -->
                    <table width="1200" height="120", border="0" bgcolor="#FFFFFF">
                        <tr>
                            <td colspan="5" height="20" align="right">
                            <%
                            	if (session.getAttribute("accountAcc_Id") == null || session.getAttribute("accountAcc_Id").equals("")) {
                            %>
                            <a href="/Shop/login.do">로그인</a> 
                            <a href="/Shop/signin.do">회원가입</a> 
                            장바구니 
                            <%
                            	} else {
                            %>
                            <a href="/Shop/logout.do">로그아웃</a> 
                            장바구니 
                            <%
                            	if (!(session.getAttribute("accountAcc_Id") == null || session.getAttribute("accountAcc_Id").equals(""))) {
                            		if (adminUtil.isIdAdmin(session.getAttribute("accountAcc_Id").toString())) {
                            			%>
                        					<a href="/Shop/adminpage.do">관리자페이지</a> 
                        				<%
                            		}
                            		else {
                            			%>
                            				<a href="/Shop/mypage.do">마이페이지</a> 
                            			<%
                            		}
                            	}
                            %>
                            <%
                            	} 
                            %>
                            리뷰 
                            고객센터 
                            </td>
                        </tr>

                        <tr>
                            <td width="120" height="80"> <!--logo-->
                            </td>

                            <td style="width: 50px"> <!--blank-->
                            </td>

                            <td> <!--navigation-->
                                <!--내비게이션 테이블 구성-->
                                <table width="900" height="80" border="0">
                                    <tr>
                                    	<td width=180 height=80><a href="/Shop/productlist.do?category_1=1&category_2=0"><img src="/myimages/shop/180x80xSHOP_Hangul_1.png"  width=180 height=80/></a></td>
                                        <td width=180 height=80><a href="/Shop/productlist.do?category_1=2&category_2=0"><img src="/myimages/shop/180x80xSHOP_Hangul_2.png"  width=180 height=80/></a></td>
                                        <td width=180 height=80><a href="/Shop/productlist.do?category_1=3&category_2=0"><img src="/myimages/shop/180x80xSHOP_Hangul_3.png"  width=180 height=80/></a></td>
                                        <td width=180 height=80><a href="/Shop/productlist.do?category_1=4&category_2=0"><img src="/myimages/shop/180x80xSHOP_Hangul_4.png"  width=180 height=80/></a></td>
                                        <td width=180 height=80><a href="/Shop/productlist.do?category_1=5&category_2=0"><img src="/myimages/shop/180x80xSHOP_Hangul_5.png"  width=180 height=80/></a></td>
                                    </tr>
                                </table>
                            </td>

                            <td width="50"> <!--blank-->                           
                            </td> 

                            <td width="100"> <!--short cut button-->
                            </td>
                        </tr>

                        <tr>
                            <td colspan="5" height="20"></td>
                        </tr>
                    </table>
                </td>
            </tr>


			<tr><!--메인이미지-->
                <td height="50">
                	<table width="100%" height="100%" border="1">
                		<tr>
                			<td width="20%" height="50%">
                			<a href="/Shop/mypage_account.do">
                			내 정보 수정
                			</a>
                			</td>
                			<td width="20%" height="50%">
                			<a href="/Shop/mypage_delivery.do">
                			내 주문/배송
                			</a>
                			</td>
                			<td width="20%" height="50%">
                			<a href="/Shop/mypage_review.do">
                			내 리뷰 관리
                			</a>
                			</td>
                			<td width="20%" height="50%">
                			</td>
                			<td width="20%" height="50%">
                			</td>
                		</tr>

                	</table>
                </td>
            </tr>
            
			<tr>
                <td height="50">
                	<table width="100%" height="100%" border="0">
                		<tr>
                			<td width="20%" height="50%">
                			</td>
                		</tr>

                	</table>
                </td>
            </tr>
            <tr><!--메인이미지-->
                <td height="500" valign="top" align="left">
	                	마이페이지 페이지 
	                	<br/><br/>
	                	<form action="updateAccount_pw_only.do" method="post">
	                	아이디 : <%= session.getAttribute("accountAcc_Id").toString() %> <br/>
	                	비밀번호 : <input type="password" name="acc_pw"></input> 
	                	<input type="submit" value="수정하기" /></form> 
	                	<form action="updateAccount_except_pw.do" method="post">
	                	주소 : <input type="text" size="150" name="acc_address" value="${account.acc_address }"/><br/>
	                	휴대전화 : <input type="text" size="20" name="acc_phone_mobile" value="${account.acc_phone_mobile }"/> <br/>
	                	집전화 : <input type="text" size="20" name="acc_phone_home" value="${account.acc_phone_home }"/> (*입력하지 않으셔도 괜찮습니다.) <br/>
	                	
	                	<br/>
	                	
	                	쇼핑몰 포인트 : ${account.acc_points } 포인트<br/>
	                	
	                	<br/><br/>
	                	<input type="submit" value="수정하기" />
	                	</form>
	                	
	                	<br/>
	                	<br/>
	                	<form action="deleteAccount.do" method="post">
	                	<input type="submit" value="회원 탈퇴하기" />
	                	</form>
	                	
	                	<br/>
	                	<br/>
                </td>
            </tr>


            <tr><!--컨텐츠-->
                <td height="300">
                    <!--컨텐츠 내부 테이블-->
                    <table width="1200" height="600" border="0">
                        <tr height="300">
                            <td width="300">
                            	<img src="/myimages/shop/630x900_TEST.png"  width=300 height=428/>
                            </td>
                            <td width="300">
								<img src="/myimages/shop/630x900_TEST_2.png"  width=300 height=428/>
                            </td>

                            <td width="300">
								<img src="/myimages/shop/630x900_TEST_3.png"  width=300 height=428/>
                            </td>
                            
                            <td width="300">
								<img src="/myimages/shop/630x900_TEST_4.png"  width=300 height=428/>
                            </td>

                        </tr>

                        <tr height="300">
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>

                        </tr>
                    </table>
                </td>
            </tr>


            <tr><!--하단-->
                <td height="80"></td>
            </tr>
            
        </table>
</body>

</html>

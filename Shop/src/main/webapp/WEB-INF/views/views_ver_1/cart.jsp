<%@page import="com.shop.biz.util.AdminUtil"%>
<%@page import="com.shop.biz.tempcart.TempCartProductVO"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	AdminUtil adminUtil = new AdminUtil();
%>
<%
	List<TempCartProductVO> listTempCartProductVoInSession = new ArrayList<TempCartProductVO>();

	if (session.getAttribute("TempCartList") != null) {
		listTempCartProductVoInSession = (List<TempCartProductVO>)session.getAttribute("TempCartList");
	}

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
                			
                			</td>
                			<td width="20%" height="50%">
                			
                			</td>
                			<td width="20%" height="50%">
                			
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
	                	장바구니 페이지 
	                	<br/><br/>
	                	<input type="button" value="전부 선택"/> <input type="button" value="전부 선택해제"/> <br/><br/>
	                	
	                	<%
	                		for(int i = 0; i < listTempCartProductVoInSession.size(); i++) {
	                	%>
	                		<input style="zoom:2.0;" type="checkbox" class="checkbox"/> <br/> 
		                	상품 <%= i + 1 %> <br/>
		                	<img src="<%= listTempCartProductVoInSession.get(i).getPrd_image_path() %>" width="100"/><br/>
		                	상품명: <%= listTempCartProductVoInSession.get(i).getPrd_name() %><br/>
		                	사이즈: <%= listTempCartProductVoInSession.get(i).getPrd_size() %><br/>
		                	색상: <%= listTempCartProductVoInSession.get(i).getPrd_color() %><br/>
		                	구입가: <%= listTempCartProductVoInSession.get(i).getPrd_price_2() %>원<br/>
		                	<input type="button" value="장바구니에서 빼기"/>
		                	<br/>
		                	<br/>
	                	<%
	                		}
	                	%>
	                	
	                	<br/><br/>  
	                	<input type="button" value="전부 장바구니에서 빼기"/> <input type="button" value="결제하기(*)"/>
	                	 
                </td>
            </tr>


            


            <tr><!--하단-->
                <td height="80"></td>
            </tr>
            
        </table>
</body>

</html>

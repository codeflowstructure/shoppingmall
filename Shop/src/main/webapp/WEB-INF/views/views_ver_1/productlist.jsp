<%@page import="com.shop.biz.util.AdminUtil"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.shop.biz.data.ProductDataConverter"%>
<%@page import="com.shop.biz.data.ProductDAOUser"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.shop.biz.product.ProductVO"%>
<%@page import="com.shop.biz.util.AdminUtil"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<%
	AdminUtil adminUtil = new AdminUtil();
%>

<%
	String StrCategory_1 = "5";
	if (request.getParameter("category_1") != null) {
		StrCategory_1 = request.getParameter("category_1").toString();
	}
	String StrCategory_2 = "0";
	if (request.getParameter("StrCategory_2") != null) {
		StrCategory_2 = request.getParameter("StrCategory_2").toString();
	}
	
	ProductDataConverter productDataConverter = new ProductDataConverter();

%>
<%
	//ProductDAOUser productDAOUser = new ProductDAOUser();

	//List<ProductVO> ListProductVO = productDAOUser.get_List_Product_with_category_1_category_2(StrCategory_1, StrCategory_2);
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
                <td height="100">
                	<table width="100%" height="100%" border="1">
                		<tr>
                			
                			<td width="20%" height="50%">
                			<a href="/Shop/productlist.do?category_1=<%= StrCategory_1 %>&category_2=1">
                			<%= productDataConverter.getCategory_2_Name_if_not_empty(StrCategory_1, 0) %>
                			</a>
                			</td>
                			<td width="20%" height="50%">
                			<a href="/Shop/productlist.do?category_1=<%= StrCategory_1 %>&category_2=2">
                			<%= productDataConverter.getCategory_2_Name_if_not_empty(StrCategory_1, 1) %>
                			</a>
                			</td>
                			<td width="20%" height="50%">
                			<a href="/Shop/productlist.do?category_1=<%= StrCategory_1 %>&category_2=3">
                			<%= productDataConverter.getCategory_2_Name_if_not_empty(StrCategory_1, 2) %>
                			</a>
                			</td>
                			<td width="20%" height="50%">
                			<a href="/Shop/productlist.do?category_1=<%= StrCategory_1 %>&category_2=4">
                			<%= productDataConverter.getCategory_2_Name_if_not_empty(StrCategory_1, 3) %>
                			</a>
                			</td>
                			<td width="20%" height="50%">
                			<a href="/Shop/productlist.do?category_1=<%= StrCategory_1 %>&category_2=5">
                			<%= productDataConverter.getCategory_2_Name_if_not_empty(StrCategory_1, 4) %>
                			</a>
                			</td>
                		</tr>
                		<tr>
                			<td width="20%" height="50%">
                			<a href="/Shop/productlist.do?category_1=<%= StrCategory_1 %>&category_2=6">
                			<%= productDataConverter.getCategory_2_Name_if_not_empty(StrCategory_1, 5) %>
                			</a>
                			</td>
                			<td width="20%" height="50%">
                			<a href="/Shop/productlist.do?category_1=<%= StrCategory_1 %>&category_2=7">
                			<%= productDataConverter.getCategory_2_Name_if_not_empty(StrCategory_1, 6) %>
                			</a>
                			</td>
                			<td width="20%" height="50%">
                			<a href="/Shop/productlist.do?category_1=<%= StrCategory_1 %>&category_2=8">
                			<%= productDataConverter.getCategory_2_Name_if_not_empty(StrCategory_1, 7) %>
                			</a>
                			</td>
                			<td width="20%" height="50%">
                			<a href="/Shop/productlist.do?category_1=<%= StrCategory_1 %>&category_2=9">
                			<%= productDataConverter.getCategory_2_Name_if_not_empty(StrCategory_1, 8) %>
                			</a>
                			</td>
                			<td width="20%" height="50%">
                			<a href="/Shop/productlist.do?category_1=<%= StrCategory_1 %>&category_2=10">
                			<%= productDataConverter.getCategory_2_Name_if_not_empty(StrCategory_1, 9) %>
                			</a>
                			</td>
                		</tr>

                	</table>
                </td>
            </tr>


            <tr><!--컨텐츠-->
                <td height="300">
                    <!--컨텐츠 내부 테이블-->
                    <table width="1200" height="600" border="1">
                    
                    <!-- 
                    <c:forEach items="${productList }" var="product" varStatus="status">
                    <c:if test="${status.index } % 4 = 0">
						<tr height="300"></c:if>
						<td width="300" align="center" valign="middle">
                            <a href="/Shop/productdetail.do?category_1=<%= StrCategory_1 %>&category_2=<%= StrCategory_2%>&product_id=<%=1%>">
                            <img src="${product.prd_image_path }"  width="300" height="428"/><br/>
                            ${product.prd_name} <br/>
                            ${product.prd_price_1} <br/>
                            ${product.prd_price_2} <br/>
                            </td>
						<c:if test="${status.index } % 4 = 0"></tr></c:if>
					</c:forEach> -->
					
					<%
						ArrayList<ProductVO> productList = (ArrayList)request.getAttribute("productList");
					%>
					
					<%
						
					
						for	(int i = 0; i < 4; i++) {
							%>
							<tr height="300">
							<%
							for (int j = 0; j < 4; j++) {
								
								if((i * 4 + j) < productList.size()) {
								%>
								
								<td width="300" align="center" valign="middle">
	                            <a href="/Shop/productdetail.do?category_1=<%= StrCategory_1 %>&category_2=<%= StrCategory_2%>&product_id=<%=String.valueOf(productList.get(i * 4 + j).getPrd_id()) %>">
	                            <img src=<%=productList.get(i * 4 + j).getPrd_image_path() %>  width="300" height="428"/><br/>
	                             <%=productList.get(i * 4 + j).getPrd_name() %> <br/>
	                             
	                            정상가: <s><%=productList.get(i * 4 + j).getPrd_price_1() %> 원</s> <br/>
	                            <font color="#ff0000">
	                            할인가: <%=productList.get(i * 4 + j).getPrd_price_2() %> 원 <br/>
	                            </font>
	                            </a>
	                            </td>
								
								<% } else { 
									
								%>
								
								
	                            <td width="300">
	                            </td> 
								
								<%}
							}
							%>
							</tr>
							<%
						}
					%>
					
                    
                    
                    <!--
                        <tr height="300">
                            <td width="300" align="center" valign="middle">
                            <a href="/Shop/productdetail.do?category_1=<%= StrCategory_1 %>&category_2=<%= StrCategory_2%>&product_id=<%=1%>">
                            <img src="/myimages/shop/630x900_TEST.png"  width="300" height="428"/><br/>
                            옷 이름 <br/>
                            가격1 <br/>
                            가격2 <br/>
                            </td>

                            <td width="300">
                            </td>

                            <td width="300">
                            </td>
                            
                            <td width="300">
                            </td>

                        </tr>

                        <tr height="300">
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>

                        </tr>
                        <tr height="300">
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>

                        </tr>
                        <tr height="300">
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>

                        </tr>
					-->

                    </table>
                </td>
            </tr>


            <tr><!--하단-->
                <td height="80"></td>
            </tr>
            
        </table>

</body>

</html>

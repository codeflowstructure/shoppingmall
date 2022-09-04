<%@page import="com.shop.biz.product.ProductVO"%>
<%@page import="com.shop.biz.util.AdminUtil"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	AdminUtil adminUtil = new AdminUtil();
%>
<%
	ProductVO product = new ProductVO();

	if (request.getAttribute("product") != null) {
		product = (ProductVO)request.getAttribute("product");
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
	            <td>
	                <table width="1200" height="400" border="1">
	                	<tr>
	                		<td width="600" height="700">
	                		
	                		
	                		
	                		
	                		<img src="${product.prd_image_path}"  width="600"/>
	                		</td>
	                		
	                		
	                		<td width="600" height="700" align="left" valign="top">
	                		
	                		<form action="productdetail_addcart.do" method="post">
	                		<input type="hidden" name="prd_no" value="${product.prd_no}"/>
	                		<input type="hidden" name="prd_name" value="${product.prd_name}"/>
	                		<input type="hidden" name="prd_image_path" value="${product.prd_image_path}"/>
	                		<input type="hidden" name="prd_price_1" value="${product.prd_price_1}"/>
	                		<input type="hidden" name="prd_price_2" value="${product.prd_price_2}"/>
	                		상품명: ${product.prd_name}
	                		<br/>
	                		정상가: <s>${product.prd_price_1}원</s>
	                		<br/>
	                		<font color="#ff0000">
	                		할인가: ${product.prd_price_2}원
	                		</font>
	                		<br/>
	                		
	                		상품사이즈(옵션): 
	                		<select name="prd_size">
	                		<% if (product.getPrd_size().contains("S")) { %>
	                		<option value="S">S</option>
	                		<% } if (product.getPrd_size().contains("M")) { %>
	                		<option value="M">M</option>
	                		<% } if (product.getPrd_size().contains("L")) { %>
	                		<option value="L">L</option>
	                		<% } if (product.getPrd_size().contains("FREE")) { %>
	                		<option value="FREE">FREE</option>
	                		<% } %>
	                		</select>
	                		<br/>
	                		상품색상(옵션): 
	                		<select name="prd_color">
	                		
	                		<% if (product.getPrd_color().contains("화이트")) { %>
	                		<option value="화이트">화이트</option>
	                		<% } if (product.getPrd_color().contains("블랙")) { %>
	                		<option value="블랙">블랙</option>
	                		<% } if (product.getPrd_color().contains("그레이")) { %>
	                		<option value="그레이">그레이</option>
	                		<% } if (product.getPrd_color().contains("핑크")) { %>
	                		<option value="핑크">핑크</option>
	                		<% } if (product.getPrd_color().contains("크림")) { %>
	                		<option value="크림">크림</option>
	                		<% } if (product.getPrd_color().contains("베이지")) { %>
	                		<option value="베이지">베이지</option>
	                		<% } if (product.getPrd_color().contains("브라운")) { %>
	                		<option value="브라운">브라운</option>
	                		<% } if (product.getPrd_color().contains("소라")) { %>
	                		<option value="소라">소라</option>
	                		<% } if (product.getPrd_color().contains("기타")) { %>
	                		<option value="기타">기타</option>
	                		<% } %>
	                		
	                		</select>
	                		<br/>
	                		<input type="hidden" name="prd_option" value="${product.prd_option}"/>
	                		
	                		상품설명: 
	                		<br/>
	                		
	                		<br/>
	                		
	                		<input type="submit" value="장바구니 담기"/> 
	                		
	                		</form>
	                		
	                		</td>
	                	</tr>
	                </table>
                </td>
            </tr>


            <tr><!--컨텐츠-->
                <td height="300">
                    <!--컨텐츠 내부 테이블-->
                    <table width="1200" height="300" border="1">
                        <tr height="250">
                            <td width="300">
                            </td>

                            <td width="300">
                            </td>

                            <td width="300">
                            </td>
                            
                            <td width="300">
                            </td>

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

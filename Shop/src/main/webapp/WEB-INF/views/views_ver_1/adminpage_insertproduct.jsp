<%@page import="com.shop.biz.util.AdminUtil"%>
<%@page contentType="text/html; charset=UTF-8"%>
    
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
                			<a href="/Shop/adminpage_insertproduct.do">
                			상품 등록
                			</a>
                			</td>
                			<td width="20%" height="50%">
                			<a href="/Shop/adminpage_trade.do">
                			상품 주문 조회
                			</a>
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
	                	관리자페이지 상품 등록 페이지 
	                	<br/><br/>
	                	
	                	<form action="adminpage_insertproduct_proc.do" method="post" enctype="multipart/form-data">
	                	상품ID: (*자동으로 숫자 값으로 부여됩니다.) <br/>
	                	상품명: <input type="text" name="prd_name" /><br/>
	                	상품종류: <br/> 
	                	<input type="radio" name="prd_type" value="1110" /> 아우터-재킷 <br/>  
	                	<input type="radio" name="prd_type" value="1120" /> 아우터-가디건 <br/>
	                	<input type="radio" name="prd_type" value="1210" /> 상의-긴팔 <br/>
	                	<input type="radio" name="prd_type" value="1220" /> 상의-반팔 <br/>
	                	<input type="radio" name="prd_type" value="1310" /> 하의-치마 <br/>
	                	<input type="radio" name="prd_type" value="1320" /> 하의-바지 <br/>
	                	<input type="radio" name="prd_type" value="1400" /> 원피스-원피스 <br/>
	                	<input type="radio" name="prd_type" value="1000" /> 여성정장-미분류 <br/>
	                	<input type="radio" name="prd_type" value="1100" /> 아우터-미분류 <br/>
	                	<input type="radio" name="prd_type" value="1200" /> 상의-미분류 <br/>
	                	<input type="radio" name="prd_type" value="1300" /> 하의-미분류 <br/>
	                	<input type="radio" name="prd_type" value="9000" checked="checked" /> 그 외 <br/>
	                	상품옵션(*없을 수 있습니다.): <input type="text" name="prd_option" /><br/>
	                	사이즈(*S/M/L/XL/FREE 중 해당하는 것(들)에 모두 문자열로 입력하고 슬래시(/)로 열거해주세요.): <input type="text" name="prd_size" /><br/>
	                	색상(*화이트/블랙/그레이/핑크/크림/베이지/브라운/소라/기타 중 해당하는 것(들)에 모두 문자열로 입력하고 슬래시(/)로 열거해주세요.): <input type="text" name="prd_color" /><br/>
	                	가격(일반 가격): <input type="text" name="prd_price_1" /><br/>
	                	가격(할인 가격): <input type="text" name="prd_price_2" /><br/>
	                	상세설명(*없을 수 있습니다.): <br/><textarea name="prd_desc" cols="150" rows="10" ></textarea><br/>
	                	상품 이미지 파일 첨부하기(*): <input type="file" name="prd_image_file" /><br/> 
	                	
	                	<br/>
	                	
	                	<input type="submit" value="상품 등록하기"/> 
	                	
	                	</form>
                </td>
            </tr>


            <tr><!--컨텐츠-->
                <td height="300">
                    <!--컨텐츠 내부 테이블-->
                    <table width="1200" height="600" border="0">
                        <tr height="300">
                            <td width="300">
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
                    </table>
                </td>
            </tr>


            <tr><!--하단-->
                <td height="80"></td>
            </tr>
            
        </table>
</body>

</html>

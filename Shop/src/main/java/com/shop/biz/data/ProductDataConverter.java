package com.shop.biz.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDataConverter {
	public Map<String, List<String>> product_category_1_to_category_2;
	
	public ProductDataConverter() {
		initData(); 
		
	}
	
	private void initData() {
		product_category_1_to_category_2 = new HashMap<>();
		
		ArrayList product_category_2_names_of_category_1_value_of_1 = new ArrayList<>();
		ArrayList product_category_2_names_of_category_1_value_of_2 = new ArrayList<>();
		ArrayList product_category_2_names_of_category_1_value_of_3 = new ArrayList<>();
		ArrayList product_category_2_names_of_category_1_value_of_4 = new ArrayList<>();
		ArrayList product_category_2_names_of_category_1_value_of_5 = new ArrayList<>();
		
		product_category_1_to_category_2.put("1", product_category_2_names_of_category_1_value_of_1);
		product_category_1_to_category_2.put("2", product_category_2_names_of_category_1_value_of_2);
		product_category_1_to_category_2.put("3", product_category_2_names_of_category_1_value_of_3);
		product_category_1_to_category_2.put("4", product_category_2_names_of_category_1_value_of_4);
		product_category_1_to_category_2.put("5", product_category_2_names_of_category_1_value_of_5);
		
		product_category_2_names_of_category_1_value_of_1.add("재킷");
		product_category_2_names_of_category_1_value_of_1.add("가디건");
		
		product_category_2_names_of_category_1_value_of_2.add("긴팔");
		product_category_2_names_of_category_1_value_of_2.add("반팔");
		
		product_category_2_names_of_category_1_value_of_3.add("치마");
		product_category_2_names_of_category_1_value_of_3.add("바지");
		
		product_category_2_names_of_category_1_value_of_4.add("원피스");
		
		product_category_2_names_of_category_1_value_of_5.add("전체 BEST");
		product_category_2_names_of_category_1_value_of_5.add("최근 BEST");
		product_category_2_names_of_category_1_value_of_5.add("그 외 (총류)");
	}
	
	public String getCategory_2_Name_if_not_empty(String P_Str_Category_1, int P_I_PositionIndex) {
		String name_of_category_2 = "";
		
		List names_of_category_1 = product_category_1_to_category_2.get(P_Str_Category_1);
		
		try {
		
			name_of_category_2 = names_of_category_1.get(P_I_PositionIndex).toString();
		} catch	(IndexOutOfBoundsException ex) {
			//
		} catch (Exception e) {
			//
		} 
		
		return name_of_category_2;
	}
	
	public static List<Integer> Convert_Category_1_Category_2_To_ProductType_No(String P_Str_Category_1, String P_Str_Category_2)
	{
		List<Integer> result = new ArrayList<Integer>();
		
		int ProductType_No = 9000; // 그 외(미분류 총류)
		
		int I_Category_1 = Integer.parseInt(P_Str_Category_1);
		int I_Category_2 = Integer.parseInt(P_Str_Category_2);
		
		switch (I_Category_1) {
		case 1:
			// 아우터 
			switch (I_Category_2) {
			case 0:
				// 종합 (*다 합쳐놓은 거랑 미분류인 거랑 다르지 않나? 카테고리에서 종합은 다 합쳐놓은 것이고, 데이터베이스에 상품은 종합에는 해당하지 않을 것입니다. 즉, 하위 카테고리 전부 다 해당시켜야 합니다.)
				// 어디에서 어떻게 이 문제를 처리할 것인지... 
				// 1안: 여기서 return 을 List로 처리한다. (V 채택됨.) 
				// 2안: 여기서는 empty(아마도)로 처리하고, 다른 곳에서 하위 항목 분류번호를 다 가지고 온다.
				result.add(1100);
				result.add(1110);
				result.add(1120);
				break;
			case 1:
				result.add(1110);
				break;
			case 2:
				result.add(1120);
				break;
			default:
				break;
			}
			break;


		case 2:
			// 상의 
			switch (I_Category_2) {
			case 0:
				result.add(1200);
				result.add(1210);
				result.add(1220);
				break;
			case 1:
				result.add(1210);
				break;
			case 2:
				result.add(1220);
				break;
			default:
				break;
			}
			break;

		case 3:
			// 하의 
			switch (I_Category_2) {
			case 0:
				result.add(1300);
				result.add(1310);
				result.add(1320);
				break;
			case 1:
				result.add(1310);
				break;
			case 2:
				result.add(1320);
				break;
			default:
				break;
			}
			break;

		case 4:
			// 원피스 
			switch (I_Category_2) {
			case 0:
				result.add(1400);
				break;
			case 1:
				result.add(1400);
				break;
			default:
				break;
			}
			break;
			
		default:
			result.add(1000);
			result.add(1100);
			result.add(1110);
			result.add(1120);
			result.add(1200);
			result.add(1210);
			result.add(1220);
			result.add(1300);
			result.add(1310);
			result.add(1320);
			result.add(1400);
			result.add(9000);
			break;
		}
		
		return result;
	}
	
	public static String Convert_ProductType_No_To_Category_1_Category_2_CombineString(int P_ProductType_No)
	{
		String Category_1_Category_2_CombineString = "5_3";
		
		switch (P_ProductType_No) {
		case 1000:
			// 여성정장(총류)
			Category_1_Category_2_CombineString = "5_3";
			break;
		case 1100:
			// 아우터(대분류)
			Category_1_Category_2_CombineString = "1_0";
			break;
		case 1110:
			// 재킷(중분류)
			Category_1_Category_2_CombineString = "1_1";
			break;
		case 1120:
			// 가디건(중분류)
			Category_1_Category_2_CombineString = "1_2";
			break;
		case 1200:
			// 상의(대분류)
			Category_1_Category_2_CombineString = "2_0";
			break;
		case 1210:
			// 반팔(중분류)
			Category_1_Category_2_CombineString = "2_1";
			break;
		case 1220:
			// 긴팔(중분류)
			Category_1_Category_2_CombineString = "2_2";
			break;
		case 1300:
			// 하의(대분류)
			Category_1_Category_2_CombineString = "3_0";
			break;
		case 1310:
			// 치마(중분류)
			Category_1_Category_2_CombineString = "3_1";
			break;
		case 1320:
			// 바지(중분류)
			Category_1_Category_2_CombineString = "3_2";
			break;
		case 1400:
			// 원피스(중분류)
			Category_1_Category_2_CombineString = "4_1";
			break;
		case 9000:
			// 그 외(총류)
			Category_1_Category_2_CombineString = "5_3";
			break;

		default:
			break;
		}
		
		return Category_1_Category_2_CombineString;
	}
}

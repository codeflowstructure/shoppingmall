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
		
		product_category_2_names_of_category_1_value_of_1.add("��Ŷ");
		product_category_2_names_of_category_1_value_of_1.add("�����");
		
		product_category_2_names_of_category_1_value_of_2.add("����");
		product_category_2_names_of_category_1_value_of_2.add("����");
		
		product_category_2_names_of_category_1_value_of_3.add("ġ��");
		product_category_2_names_of_category_1_value_of_3.add("����");
		
		product_category_2_names_of_category_1_value_of_4.add("���ǽ�");
		
		product_category_2_names_of_category_1_value_of_5.add("��ü BEST");
		product_category_2_names_of_category_1_value_of_5.add("�ֱ� BEST");
		product_category_2_names_of_category_1_value_of_5.add("�� �� (�ѷ�)");
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
		
		int ProductType_No = 9000; // �� ��(�̺з� �ѷ�)
		
		int I_Category_1 = Integer.parseInt(P_Str_Category_1);
		int I_Category_2 = Integer.parseInt(P_Str_Category_2);
		
		switch (I_Category_1) {
		case 1:
			// �ƿ��� 
			switch (I_Category_2) {
			case 0:
				// ���� (*�� ���ĳ��� �Ŷ� �̺з��� �Ŷ� �ٸ��� �ʳ�? ī�װ����� ������ �� ���ĳ��� ���̰�, �����ͺ��̽��� ��ǰ�� ���տ��� �ش����� ���� ���Դϴ�. ��, ���� ī�װ� ���� �� �ش���Ѿ� �մϴ�.)
				// ��𿡼� ��� �� ������ ó���� ������... 
				// 1��: ���⼭ return �� List�� ó���Ѵ�. (V ä�õ�.) 
				// 2��: ���⼭�� empty(�Ƹ���)�� ó���ϰ�, �ٸ� ������ ���� �׸� �з���ȣ�� �� ������ �´�.
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
			// ���� 
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
			// ���� 
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
			// ���ǽ� 
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
			// ��������(�ѷ�)
			Category_1_Category_2_CombineString = "5_3";
			break;
		case 1100:
			// �ƿ���(��з�)
			Category_1_Category_2_CombineString = "1_0";
			break;
		case 1110:
			// ��Ŷ(�ߺз�)
			Category_1_Category_2_CombineString = "1_1";
			break;
		case 1120:
			// �����(�ߺз�)
			Category_1_Category_2_CombineString = "1_2";
			break;
		case 1200:
			// ����(��з�)
			Category_1_Category_2_CombineString = "2_0";
			break;
		case 1210:
			// ����(�ߺз�)
			Category_1_Category_2_CombineString = "2_1";
			break;
		case 1220:
			// ����(�ߺз�)
			Category_1_Category_2_CombineString = "2_2";
			break;
		case 1300:
			// ����(��з�)
			Category_1_Category_2_CombineString = "3_0";
			break;
		case 1310:
			// ġ��(�ߺз�)
			Category_1_Category_2_CombineString = "3_1";
			break;
		case 1320:
			// ����(�ߺз�)
			Category_1_Category_2_CombineString = "3_2";
			break;
		case 1400:
			// ���ǽ�(�ߺз�)
			Category_1_Category_2_CombineString = "4_1";
			break;
		case 9000:
			// �� ��(�ѷ�)
			Category_1_Category_2_CombineString = "5_3";
			break;

		default:
			break;
		}
		
		return Category_1_Category_2_CombineString;
	}
}

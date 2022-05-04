package datastructure;

import java.util.ArrayList;
import java.util.List;

public class GenericCollectionTest {

	public static void main(String[] args) {
		// Element generic
		List list1;
		List<String> list2; //element generic 표기법, String type의 요소만 저장 가능하다는 의미

		list1 = new ArrayList();
		list2 = new ArrayList<String>(); //element generic 표기법, String type의 요소만 저장 가능하다는 의미
		
		list1.add(new String("abc"));
		list1.add(new Integer(20));
		list1.add(new Boolean(true));
		
		String s1 = (String) list1.get(0); // 정상실행
		String s2 = (String) list1.get(1); // ClassCastException 예외 발생
		String s3 = (String) list1.get(2);
		
		
		list2.add(new String("string"));
		list2.add("word");
//		list2.add(new Integer(123)); //Integer type은 String type이 아니므로 compile error
	}

}

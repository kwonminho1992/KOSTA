package String;


import java.util.Date;
/**
  기본형은 메서드가 없다
  int i = 34;
  i.toString(); (X)
  
  기본형과 참조형은 형변환불가
  String s = i; (X) 
  String s = (String)i; (X)
  
  기본형->String으로 바꿔주는 메서드를 활용
    String s = String.valueOf(i); i는 숫자 삼십사, s는 문자열 "34"
  String->기본형으로 바꿔주는 메서드를 활용
    int j = Integer.parseInt(s); s는 문자열 "34", j는 숫자 삼십사
  
  기본형->참조형으로 바꿔주는 방법
    Integer inte = new Integer(i);  
  참조형->기본형으로 바꿔주는 방법  
    int k = inte.intValue();
    
 * @author KOSTA
 *
 */
public class WrapperTest {
	public static void main(String[] args) {
		int i = 34;
		Integer inte = new Integer(i); // Integer class : 기본형 int의 사용을 도와주는 wapper class
		inte.toString();
		System.out.println(inte.MAX_VALUE); // 기본형 int로 표현할 수 있는 최대값
		System.out.println(inte.MIN_VALUE); // 기본형 int로 표현할 수 있는 최소값

		Object[] arr = new Object[5];
		arr[0] = new String("문자열");
		arr[1] = new Date();
		arr[2] = new Integer(1); // Object(참조형)의 배열에 대입하기 위해 참조형 Integer로 선언하여 대입함

		// auto boxing & auto unboxing
		arr[3] = 1; // 1은 기본형인 int type이므로 컴파일러에 의해 Integer type으로 형변환됨 (auto boxing)

		// int j = arr[2]; // arr[2]는 Object type이므로 기본형인 int type의 변수에 대입 불가능
		int j = (Integer) arr[2]; // 컴퍼일러에 의해 int j = Integer.intvalue()의 방식으로 대입함 (auto unboxing)
		int k = (int) arr[2]; // (auto unboxing)
	}
}

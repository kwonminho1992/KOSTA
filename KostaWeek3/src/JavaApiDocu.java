import java.text.DecimalFormat;
import java.text.FieldPosition;

public class JavaApiDocu {

	public static void main(String[] args) {
		// 베트남 동화(VND)로 숫자를 출력하기 
		// 숫자를 출력할때, comma 추가 & 앞에 VND 추가
		
		int num1 = 1000000000; // 숫자
		
		DecimalFormat formatter = new DecimalFormat("#,###.####; (#,###.####)"); // 출력 포멧 설정 (양수; 음수)
		StringBuffer sb = new StringBuffer("VND "); //숫자를 출력할때 앞에 추가할 스트링 (베트남 동화)
		FieldPosition fp = new FieldPosition(0); // identifier 
		System.out.println(formatter.format(num1, sb, fp)); // return formatted string from number
	}
}

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;

public class JavaApiDocu {

	public static void main(String[] args) {	
		int num = 10000; // formatting할 숫자
		DecimalFormat formatter = new DecimalFormat("#,###"); // 3자리마다 콤마 찍기
		
		StringBuffer sb = new StringBuffer("KRW "); // 숫자 앞에 붙일 텍스트
		FieldPosition fp = new FieldPosition(NumberFormat.INTEGER_FIELD); 
		System.out.println(formatter.format(num, sb, fp));
	}
}

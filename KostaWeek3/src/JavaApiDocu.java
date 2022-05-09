import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class JavaApiDocu {

	public static void main(String[] args) {
		// 현재 날짜 & 시간 출력하기 (yyyy-mm-dd hh:mm:ss form)
		System.out.println(LocalDateTime.now()); // 현재 날짜 & 시간

		//출력 포멧 설정
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MM dd EEE HH mm ss", Locale.KOREA); // 형식은 구글검색으로 찾기
		System.out.println(dtf);
		Date date = new Date();
	}

}

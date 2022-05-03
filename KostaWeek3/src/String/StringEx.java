package String;

public class StringEx {

	public static void main(String[] args) {
//		// String class의 활용
//		String s1 = new String("가나다");
//		String s2 = new String("가나다");
//		String s3 = "가나다";
//		String s4 = "가나다";
//		
//		System.out.println(s1 == s2); // false
//		System.out.println(s1 == s3); // false
//		System.out.println(s3 == s4); // true
//		System.out.println("");
//		System.out.println(s1.equals(s2)); // true
//		System.out.println(s1.equals(s3)); // true
//		System.out.println(s3.equals(s4)); // true
//		System.out.println("");
//		System.out.println(s1 + "라마바"); // s1에 "라마바" 합침 -> "가나다라마바"라는 내용의 string 객체가 또 생성됨
//		System.out.println(s1); // 가나다
//		
//		s1.substring(1, 3); //문자열의 1번째 문자부터 2번째 문자까지 잘라냄
//		System.out.println("");
//		char c = s1.charAt(0); 
//		System.out.println("charAt(0) : " + c); // 가
//		int size = s1.length(); //length of String
//		System.out.println("length() : " + size); // 3
//		
//		System.out.println("");
//		
//		//Palindrome문자열
//		String palindrome = "ABCBA";		
//		int start = 0; // palindrome 문자열의 first index
//		int end = palindrome.length() - 1; // palindrome 문자열의 last index
//		int half = palindrome.length() / 2; // 반복문이 돌 때, 메모리 낭비를 막기 위해 pelindrome의 길이를 변수로 저장 
//		for (; start < half; start++, end--) {  
//			if (palindrome.charAt(start) != palindrome.charAt(end)) { // 문자값이 같은지 아닌지 검사, 같지 않으면 result = false & 반복문 종료
//				break;
//			}
//		}
//		// 결과
//		if (start == half) {
//			System.out.println("palindrome");
//		} else {
//			System.out.println("is not palindrome");
//		}
		
		// split String
		String url = "https://news.naver.com/main/main.naver?mode=LSD&mid=shm&sid1=105";
		url = "https://news.naver.com";
		String hostName; // news.naver.com/
		String path; // main/main.naver?
		String queryString; // mode=LSD&mid=shm&sid1=105
		String[] arr = url.split("\\?", 2); // 정규표현식 : 실제 index 문자는 ?임
		
		System.out.println("arr[0] : " + arr[0]); 
		if (arr.length >= 2) { // url에 '?'가 없을때의 예외를 피하기 위함
			System.out.println("arr[1]" + arr[1]);
		}
		
		String hostNamePath = arr[0]; // https://news.naver.com/main/main.naver / https://news.naver.com
		
		//indexOf method : 해당문자가 없는 경우 -1를 return함
		int beginIndex = hostNamePath.indexOf(":"); //5, :의 위치 반환 (https://news.naver.com/main/main.naver)
		int endIndex = hostNamePath.indexOf("/", 8); //22, 8번 index를 시작 위치로 하여 가장 가까운 /의 위치 반환
		if (endIndex != -1) { // .com 이후 부분에서 '/'가 없을때의 예외를 피하기 위함
			hostName = hostNamePath.substring(beginIndex, endIndex); //hostNamePath 변수에서 필요한 부분만 잘라오기
		} else {
			hostName = hostNamePath.substring(beginIndex); //hostNamePath 변수에서 필요한 부분만 잘라오기
		}
		path = hostNamePath.substring(endIndex + 1); //hostNamePath 변수에서 필요한 부분만 잘라오기
		queryString = arr[1];
		String[] queryStringArr = queryString.split("&");
		for(int index=0; index<queryStringArr.length; index++) {
			String q = queryStringArr[index];
			//TODO
			String []qArr = q.split("=",2);
			String qName = qArr[0];
			String qValue = qArr[1];
			System.out.println("쿼리스트링 이름은" + qName + ", 값은" + qValue); 
			                                                                //쿼리스트링 이름은mode, 값은LSD
            																//쿼리스트링 이름은mid, 값은shm
																			//쿼리스트링 이름은sid1, 값은105		
		}


	}
}

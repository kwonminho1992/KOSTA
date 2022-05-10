package io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class KeyboardTest {

	public static void main(String[] args) {
		//keyboard로 문자를 입력하면 해당되는 문자의 1byte의 유니코드가 출력
		InputStream is = System.in; // InputStream = node stream (자원과 직접 만나는 stream)
//		try { //(윈도우 기준) cntl + z 를 입력하면 readValueByByte을 -1이라 간주함 (*참고 : 키보드로 입력하는 값은 모두 문자로 간주됨) 
//			int readValueByByte = -1;
//			while((readValueByByte = is.read()) != -1) { //readValueByByte변수에 is.read()를 대입시킨 후, 그것이 -1이 아니면 반복문을 계속 돌림
//				// byte단위로 읽기
//				System.out.println("InputStream : " + readValueByByte + "=" + (char)readValueByByte);	
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		//keyboard로 문자를 입력하면 해당되는 문자의 유니코드가 출력
//		Reader reader = new InputStreamReader(is); // InputStreamReader = filter stream (데이터를 가공하는 stream)
//		try {
//			int readValueByChar = -1; //(윈도우 기준) cntl + z 를 입력하면 readValueByChar을 -1이라 간주함 (*참고 : 키보드로 입력하는 값은 모두 문자로 간주됨) 
//			while((readValueByChar = reader.read()) != -1) { //readValueByChar변수에 reader.read()를 대입시킨 후, 그것이 -1이 아니면 반복문을 계속 돌림
//				// char단위로 읽기
//				System.out.println("InputStreamReader : " + readValueByChar + "=" + (char)readValueByChar);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		Reader reader = new InputStreamReader(is); // InputStreamReader = filter stream (데이터를 가공하는 stream)
		try {
			int readCnt = -1; //(윈도우 기준) cntl + z 를 입력하면 readCnt를 -1이라 간주함 (*참고 : 키보드로 입력하는 값은 모두 문자로 간주됨) 
			char[] cbuf = new char[5]; // read() method에 넣을 array
			int off = 0; // array의 시작점
			int len = cbuf.length; // array의 길이
			while((readCnt = reader.read(cbuf, off, len)) != -1) { //readCnt변수에 reader.read()를 대입시킨 후, 그것이 -1이 아니면 반복문을 계속 돌림
				// cbuf array의 길이 단위로 읽기
				// 문제 발생 :  줄이 바뀔때 이전 문자열의 값을 지우지 않고, 새로운 문자를 덮어씀
//				System.out.println("InputStreamReader(cubf[]) : " + new String(cbuf));
//				System.out.println("---------");
				//해결방법 : 줄이 바뀔때마다 cubf 배열을 새로만듦				
//				System.out.println(new String(cbuf, off, cbuf.length));
				System.out.println(new String(cbuf, off, readCnt));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

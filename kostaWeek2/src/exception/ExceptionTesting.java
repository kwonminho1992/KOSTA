package exception;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;

public class ExceptionTesting {
	public static void test(int i) {
		int j = 99 % i;
		System.out.println("99를 " + i + "로 나눈 나머지값은 " + j);
	}
	public static void main(String[] args) {
		//예외처리 예시
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요:"); 
		// 0 입력시 java.lang.ArithmeticException: / by zero exception 발생
		// 문자열, 실수형 입력시 java.util.InputMismatchException 발생
		int i = 1;
		FileInputStream fis = null;
		try {
			i = sc.nextInt();
			fis = new FileInputStream("a.txt"); // a.txt 파일을 자바에 연결
			int readValue = fis.read(); //a.csv 파일의 내용을 1byte 읽기
			System.out.println("파일의 1byte 내용 : " + readValue);
		} catch (InputMismatchException e) { // InputMismatchException 예외 발생시, 해당 구문 실행
			System.out.println("문자, 실수를 입력하면 안됩니다. i = 1로 설정합니다.");
		} catch (FileNotFoundException e) { // FileNotFoundException 예외 발생시, 해당 구문 실행
			System.out.println("a.txt 파일을 찾을 수 없습니다");
		} catch (IOException e) { // IOException 예외 발생시, 해당 구문 실행
			System.out.println("IOException 발생");
		} finally { // 예외의 발생여부와 관계없이 실행되는 부분 (특히 csv파일, txt파일 같은 외부 리소스와의 연결을 끊기에 적합한 위치)
			test(i);
			System.out.println("finally구문 실행");
			try {
				if (fis != null) {
					fis.close(); //파일 리소스(a.txt)와의 연결 해제					
				}
			} catch (IOException e) { // IOException 예외 발생시, 해당 구문 실행
				System.out.println("IOException 발생");
			}
		}
		System.out.println("계산끝");
		
	}
}


//package exception;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.InputMismatchException;
//import java.util.Scanner;
//
//public class ExceptionTest {
//	public static void test(int i) {
//		if(i !=0 ) {
//			int j = 99 % i;//i가 0인 경우 ArithmeticException발생
//			System.out.println("99를 " + i + "로 나눈 나머지값은 " + j);
//		}else {
//			System.out.println("0으로는 나눌 수 없습니다");
//		}
//	}
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.print("숫자를 입력하세요:");
//		int i = 1;
//		FileInputStream fis = null;
//		try {
//			i = sc.nextInt(); //숫자입력되지 않으면 InputMismatchException발생
//			fis = new FileInputStream("a.txt");//파일자원과의 연결
//			int readValue = fis.read(); //파일내용 1byte읽기
//			System.out.println("파일의 1바이트내용=" + readValue);
//		}catch(FileNotFoundException e) {
//			System.out.println("a.txt파일이 없습니다");
//		}catch(IOException e) {
//			
//		}catch(InputMismatchException e) {
//			System.out.println("숫자로 입력하세요. 숫자가 아니어서 1로 대신합니다");
//		}finally {
//			System.out.println("finally블럭입니다");
//			if(fis != null) {
//				try {
//					fis.close();//파일자원과의 연결해제
//				}catch(IOException e) {
//					
//				}
//			}			
//		}
//		test(i);
//		System.out.println("끝");
//	}
//}
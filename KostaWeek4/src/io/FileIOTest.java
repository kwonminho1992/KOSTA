package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIOTest {
	public static String fileName = "file_io_test.txt";

	public static void readAndWriteFileByByte() {//파일 읽기/쓰기 by byte
		/*
		 * resource : "file_io_test.txt"
		 * node stream : FileInputStream (파일자원을 byte단위로 읽음)
		 * destination : "file_io_test_copy.txt"
		 * node stream : FileOutputStream (파일자원을 byte단위로 씀)
		 */
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(fileName); // file resource와의 연결 (FileInputStream : byte단위로 읽기)
			// * no argument in append : 해당 파일이 없는 경우, argument에 넣은 파일 이름대로 새로 생성함 (기존 파일이 있는 경우, 삭제하고 새로 생성)
			// * argument in append : 기존 파일을 삭제하지 않고, 이어서 작성
			fos = new FileOutputStream("file_io_test_copy.txt", true); // file resource와의 연결 (FileOutputStream : byte단위로 쓰기)
			int readValue = -1;
			while ((readValue = fis.read()) != -1) {//readValue변수에 fis.read()를 대입시킨 후, 그것이 -1이 아니면 반복문을 계속 돌림
				fos.write(readValue); //readValue를 a_copy.txt 파일에 작성
			}			
		} catch (FileNotFoundException e) { // 하위 Exception, 먼저 수행해야함
			System.out.println(fileName + "이 없습니다.");
			//예외메시지를 출력하지 말고, a.txt를 생성하는건 어떨까? (사용자에게 오류메시지를 많이 띄우는건 좋은 방법이 아님)
		} catch (IOException e) { // 상위 Exception, 나중에 수행해야함
			e.printStackTrace();
		}
	}
	
	public static void readAndWriteFileByChar() {//파일 읽기/쓰기 by char
		/*
		 * resource : "file_io_test.txt"
		 * node stream : FileReader (파일자원을 char단위로 읽음)
		 * destination : "file_io_test_copy.txt"
		 * node stream : FileWriter (파일자원을 char단위로 씀)
		 */
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader(fileName); // file resource와의 연결 (FileReader : char단위로 읽기)
			// * no argument in append : 해당 파일이 없는 경우, argument에 넣은 파일 이름대로 새로 생성함 (기존 파일이 있는 경우, 삭제하고 새로 생성)
			// * argument in append : 기존 파일을 삭제하지 않고, 이어서 작성
			fw = new FileWriter("file_io_test_copy.txt", true); // file resource와의 연결 (FileWriter : char단위로 쓰기)
			int readValue = -1;
			while ((readValue = fr.read()) != -1) {//readValue변수에 fr.read()를 대입시킨 후, 그것이 -1이 아니면 반복문을 계속 돌림
				fw.write(readValue); //readValue를 JVM에 있는 buffer에 저장 (파일에 직접 쓰는건 아님)
			}			
			//fw.flush(); //buffer에 저장된 내용을 파일에 작성 (buffer가 꽉채워지면 자동으로 flush됨
		} catch (FileNotFoundException e) { // 하위 Exception, 먼저 수행해야함
			System.out.println(fileName + "이 없습니다.");
			//예외메시지를 출력하지 말고, a.txt를 생성하는건 어떨까? (사용자에게 오류메시지를 많이 띄우는건 좋은 방법이 아님)
		} catch (IOException e) { // 상위 Exception, 나중에 수행해야함
			e.printStackTrace();
		} finally { // 안정적인 코드 >>>>> 단순한 코드
			if (fr != null) {
				try {
					fr.close(); // 파일과의 연결 끊기
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fw != null) {				
				try {
					fw.close(); // flush한 다음 파일과의 연결 끊기
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		readAndWriteFileByChar();
		readAndWriteFileByByte();
	}

}

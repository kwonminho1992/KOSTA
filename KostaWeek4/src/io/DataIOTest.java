package io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//Data 파일 읽고 쓰기
//https://www.freecodecamp.org/news/dat-file-how-to-open-the-dat-file-format-extension/#:~:text=A%20DAT%20file%20is%20a,any%20other%20type%20of%20file.
public class DataIOTest {
	public static void write(String fileName) {
		/*
		 * destination : fileName
		 * nod stream : FileOutputStream
		 * filter stream : DataOutputStream
		 */
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream(fileName);
			dos = new DataOutputStream(fos);
			//datatype 별로 쓰기 가능 (but 일반 편집기에선 내용을 읽기가 불가능)
			dos.writeInt(10);
			dos.writeBoolean(false);
			dos.writeDouble(1.2);
			dos.writeUTF("UTF-8 포맷으로 쓰기&읽기"); // write String by UTF-8 encoding
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (dos != null) {
				try {
					dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}	
			}
		}
	}
	
	public static void read(String fileName) {
		/*
		 * resource : fileName
		 * nod stream : FileInputStream
		 * filter stream : DataInputStream
		 */
		FileInputStream fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream(fileName);
			dis = new DataInputStream(fis);
			//data 읽기
			int intValue = dis.readInt();
			boolean booleanValue = dis.readBoolean();
			double doubleValue = dis.readDouble();
			String stringValue = dis.readUTF(); // read String by UTF-8 encoding
			System.out.println("intValue : " + intValue);
			System.out.println("booleanValue : " + booleanValue);
			System.out.println("doubleValue : " + doubleValue);
			System.out.println("stringValue : " + stringValue);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (dis != null) {
				try {
					dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}		
		}	
	}
	
	public static void main(String[] args) {
		String fileName = "data_stream_test.dat";
		write(fileName);
		read(fileName);
	}
}

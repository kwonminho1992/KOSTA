package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;



/**
 * 
 * reflection의 사용처 : 서버관리
 *
 */
public class ReflectionTest {
	public static void reflect(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class clazz = Class.forName(className);
		Object obj = clazz.newInstance();
		Method[] methodArr = clazz.getDeclaredMethods();
		for(int i=0; i<methodArr.length; i++) {
			Method m = methodArr[i];
			if(m.getName().equals("toString")) {
				Object returnValue = m.invoke(obj); //method 호출
				System.out.println(returnValue);
			}
		}
	}
	
	//실행부
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//		Product p = new Product("D0001", "아메리카노", 1500); 
//		System.out.println(p.toString());
		
		Scanner sc = new Scanner(System.in);
		System.out.print("클래스이름을 입력하세요 ex)java.lang.String\n");
		String className = sc.nextLine();
		reflect(className);
	}

}

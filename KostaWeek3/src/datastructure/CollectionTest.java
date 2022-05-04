package datastructure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class A {
	//field
	private int i;
	//constructor
	public A (int i) {
		this.i = i;
	}
	@Override
	public int hashCode() {// 같은 data type, 같은 값이지만 객체만 다를 경우, 중복으로 판단하기 위한 메서드
		return Objects.hash(i);
	}
	@Override
	public boolean equals(Object obj) {// 같은 data type, 같은 값이지만 객체만 다를 경우, 중복으로 판단하기 위한 메서드
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		A other = (A) obj;
		return i == other.i; // return this.hashCode() == other.hashCode()
	}
	@Override
	public String toString() {
		return "A [i=" + i + "]";
	}
	
}
public class CollectionTest {
	//Collection (List, Set)
	static Integer inte = new Integer(1);
	public static void test (Collection c) {
		c.add(new String("One")); // add의 datatype : Object, string -> object으로 upcasting됨
		c.add(new Integer(20));
		c.add(3); //컴파일 시 Integer type으로 auto boxing됨
		c.add(2);
		c.add(inte); // Integer type
		c.add(inte.intValue()); // Set에는 저장 안됨 (중복으로 판단)
		c.add(inte.longValue()); // long type으로 반환 (값은 같으나 data type이 다르므로 중복으로 판단하지 않음)
		c.add(new Long(1)); // Set에는 저장 안됨 (중복으로 판단)
		c.add(new A(40)); // 다른 객체이므로 중복으로 판단 안함
		c.add(new A(40)); // 다른 객체이므로 중복으로 판단 안함
		
		System.out.println("자료수 : " + c.size());
		System.out.println(c); //c.toString() method 자동 호출
		System.out.println("hashCode()");
		System.out.println("inte : " + inte.hashCode()); // 1 (Integer)
		System.out.println("inte.intValue() : " + new Integer (inte.intValue()).hashCode()); // 1 (Integer)
		System.out.println("inte.longValue() : " + new Long (inte.longValue()).hashCode()); // 1 (Long)
		System.out.println("new Long(1) : " + new Long (1).hashCode()); // 1 (Long)
	}
	//Map
	public static void test (Map m) {
		m.put("first", "one"); //key(first) : value(value)
		m.put(new Integer (2), "Integer two"); //m.toString() method 자동 호출
		m.put("third", "two"); // value 값은 중복되도 상관없음
		m.put("first", "four"); // key 값이 중복되므로 기존에 저장된 자료에 덮어쓰기함 
		m.put(new A(5), 123);
		m.put(new A(5), 12345); // key 값이 중복되므로 기존에 저장된 자료에 덮어쓰기함 
		m.put(2, "int two"); // key 값이 중복되므로 기존에 저장된 자료에 덮어쓰기함 
				
		System.out.println("자료수 : " + m.size());
		System.out.println(m);
	}
	
	//main method
	public static void main(String[] args) {
		test(new ArrayList());  // 자료수 : 10, [One, 20, 3, 2, 1, 1, 1, 1, A [i=40], A [i=40]]
		test(new HashSet());  // 자료수 : 7, [1, 1, 2, 3, 20, One, A [i=40]]
		test(new HashMap());  // 자료수 : 4, {2=int two, third=two, A [i=5]=12345, first=four}
	}

}

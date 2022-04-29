package interfacepractice;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * Event programming의 절차 
 * 1. 이벤트가 발생될 곳(event source)을 결정 ex. btnReady
 * 2. 이벤트의 종류를 결정 ex. action event(click시의 event)
 * 3. 이벤트가 발생되었을 때 할 일(event handler)을 작성 
 * ex. class MyHandler implements ActionListener {
 * 	     public void actionPerformed (ActionEvent e) {
 *          System.out.println("준비되었습니다");
 * 		 }
 * 	   }
 * 4. event source와 event handler를 연결 ex. btnReady.add~~~(new MyHandler());
 */

//action handler (이름이 있는 버전이라 재사용성은 높으나 이벤트 프로그래밍에선 재사용성이 불필요함)
//class MyHandler implements ActionListener { // interface
//	public void actionPerformed (ActionEvent e) {
//        System.out.println("준비되었습니다");
//	}
//}
//class MyRunHandler implements ActionListener{ 
//	private JTextField jtf;
//	public MyRunHandler(JTextField jtf) {
//		this.jtf = jtf;
//	}
//	public void actionPerformed(ActionEvent e) {
//		jtf.setText("달립니다");
//	}
//}

public class Race {
	//field
	private JFrame jf;
	private JButton btnReady;
	private JButton btnStart;
	private JTextField jtf;
	//constructor
	public Race() {
		//User Interface 설정하기
		jf = new JFrame("Running"); //Jframe object 생성 (GUI기능 수행)
		btnReady = new JButton("Ready"); // button 기능 수행하는 object 생성 (이벤트가 발생할 곳)
		btnStart = new JButton("Start"); // button 기능 수행하는 object 생성 (이벤트가 발생할 곳)
		jtf = new JTextField(10); //텍스트 필드 생성
		
		Container c = jf.getContentPane(); // 액자(화면)의 뒷판 생성
		c.setLayout(new FlowLayout()); // Layout 설정하기 - 버튼이 생성되는대로 차례대로 나타남(by FlowLayout class) 
		c.add(btnReady); //액자의 뒷판에 버튼 생성
		c.add(btnStart); //액자의 뒷판에 버튼 생성
		c.add(jtf); // 액자의 뒷판에 텍스트 필드 생성
//		MyHandler myHandler = new MyHandler(); // myHandler object 생성 (event handler) *이름이 있는 class가 있는 방식
//		btnReady.addActionListener(myHandler); //event source와 event handler를 연결 *이름이 있는 class가 있는 방식
		//btnReady.addActionListener(new ActionListener()); //interface를 new keyword로 객체 생성할 순 없음. 반드시 하위 클래스를 만들어 구현해야함
		btnReady.addActionListener( //event source와 event handler를 연결 *메서드 안에 객체 생성 (중첩클래스의 로컬클래스 개념), 이름이 없는 class로 생성
				new ActionListener() { //actionListener를 적용한 객체가 생성됨 (객체의 이름은 없음)
					public void actionPerformed(ActionEvent e) { //btnReady를 클릭하면 "준비되었습니다"가 출력
						jtf.setText("준비되었습니다");
					}
				}
		);

		btnStart.addActionListener( //event source와 event handler를 연결 *메서드 안에 객체 생성 (중첩클래스의 로컬클래스 개념), 이름이 없는 class로 생성
				new ActionListener() { //actionListener를 적용한 객체가 생성됨 (객체의 이름은 없음)
					public void actionPerformed(ActionEvent e) { //btnStart를 클릭하면 "달립니다"가 출력
						jtf.setText("달립니다");
					}
				}
		);
		
		
		jf.setSize(500, 300); // window 창 크기 설정
		jf.setVisible(true); // window 창 띄우기
	}
	
	//main method (실행부)
	public static void main (String[] args) {
		new Race(); //create object
	}
}




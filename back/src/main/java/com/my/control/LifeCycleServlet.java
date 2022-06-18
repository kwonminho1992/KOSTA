package com.my.control;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleServlet
 */
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifeCycleServlet() {
    	System.out.println("LifeCycleServlet 객체의 constructor 호출");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		//초기화는 생성자가 아닌 init() 메서드에 설정할것
		//parameter for ServletContext
		super.init(config);
    	System.out.println("LifeCycleServlet 객체의 init() 호출");
    	ServletContext sc = this.getServletContext();
    	String developer = sc.getInitParameter("developer");
    	System.out.println("developer : " + developer);
    	
    	//parameter for Servlet
    	String fileName = this.getInitParameter("fileName");
    	System.out.println("file name : " + fileName);
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
    	System.out.println("LifeCycleServlet 객체의 destroy() 호출");	
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LifeCycleServlet 객체의 service() 호출");
		super.service(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LifeCycleServlet 객체의 doGet() 호출");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LifeCycleServlet 객체의 doPost() 호출");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		System.out.println("요청전달데이터 : id = " + id + ", pwd = " + pwd);
	}

}

package com.my.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestServlet
 */
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestServlet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuffer url = request.getRequestURL();
		String contextPath = request.getContextPath();
		String servletPath = request.getServletPath();
		System.out.println("url = " + url);
		System.out.println("contextPath = " + contextPath);
		System.out.println("servletPath = " + servletPath);
		
		/*
		 * http://localhost:8888/Back/requestservlet : opt = null
		 * http://localhost:8888/Back/requestservlet?opt=add : opt = add
		 * http://localhost:8888/Back/requestservlet?opt : opt = ""
		 */
		String opt = request.getParameter("opt");
		System.out.println("요청전달데이터 opt = " + opt);
		if(opt.equals("add")) {
			System.out.println("You have chosen registration work");
		}
		
		/*
		 * http://localhost:8888/Back/requestservlet?c=c1&c=c2 : c = c1, c2
		 * http://localhost:8888/Back/requestservlet?c= : cArr.length = 0
		 * http://localhost:8888/Back/requestservlet : cArr = null
		 */
		String[] cArr = request.getParameterValues("c");
		if (cArr != null) {
			for (String c : cArr) {
				System.out.println("요청전달데이터 c" + c);
			}
		}
	}
}
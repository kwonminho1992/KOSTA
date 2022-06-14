package com.my.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//응답 형식 설정 (MIME;encoding)
		response.setContentType("application/json;charset=UTF-8"); // MIME방식 : html / default encoding : ISO_88859_1
		PrintWriter out = response.getWriter();
		
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
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		System.out.println("요청전달데이터 id = " + id + "\n요청전달데이터 pwd = " + pwd);
		if(id.equals("id1") && pwd.equals("p1")) {
			// 로그인 성공 {"status":1}
			out.print("{\"status\": 1}");
			System.out.println("로그인 성공 {\"status\": 1}");
		} else {
			// 로그인 실패 {"status":2}
			out.print("{\"status\": 2}");
			System.out.println("로그인 실패 {\"status\": 2}");
		}

	}
}

package com.my.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.dto.Product;

//attribute 공부

public class MoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opt = request.getParameter("opt");
		
		if ("forward".equals(opt)) {	
			//요청 속성 (속성이름 : 'test', 값 : product 객체) 추가
			Product sample = new Product("F0001", "샌드위치", 3000);
			request.setAttribute("test", sample);
			
			//forward전의 응답
			PrintWriter out = response.getWriter();
			out.print("BEFORE FORWARD");
			
			// attribute 전달
			String path = "/duplicationcheck"; // front end에서의 경로찾기와는 달리, 현재 경로에 있는 duplicationcheck 를 찾음 
			RequestDispatcher rd = request.getRequestDispatcher(path); // 페이지를 path로 이동 
			rd.forward(request, response); // DuplicationCheckServlet에 move의 request를 전달 (돌아오지 않음)
										   // DuplicationCheckServlet과 MoveServlet에서 같이 사용 가능

			//forward후의 응답
			out.print("AFTER FORWARD");
			
		} else if ("redirect".equals(opt)) {
			response.sendRedirect("https:/www.google.com");
		} else if ("include".equals(opt)) {
			//include전의 응답
			PrintWriter out = response.getWriter();
			out.print("BEFORE INCLUDE");
			
			String path = "/duplicationcheck"; // front end에서의 경로찾기와는 달리, 현재 경로에 있는 duplicationcheck 를 찾음 
			RequestDispatcher rd = request.getRequestDispatcher(path); // 페이지를 path로 이동 
			rd.include(request, response);
			
			//include후의 응답
			out.print("AFTER INCLUDE");
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<ul>");
			out.print("<li>");
			out.print("<a href=\"move?opt=forward\">FORWARD</a>"); 
			out.print("</li>");
			out.print("<li>");
			out.print("<a href=\"move?opt=redirect\">REDIRECT</a>"); 
			out.print("</li>");
			out.print("<li>");
			out.print("<a href=\"move?opt=include\">INCLUDE</a>"); 
			out.print("</li>");
			out.print("</ul>");

		}
		
		
	}

}

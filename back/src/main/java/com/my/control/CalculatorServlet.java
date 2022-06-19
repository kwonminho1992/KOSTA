package com.my.control;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CalculatorServlet() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		Cookie[] cookies = request.getCookies(); // 쿠키요청
		
		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");
		
		int v = 0;
		if(!v_.equals("")) {
			v = Integer.parseInt(v_);
		}
		if (op.equals("=")) {
			int x = 0;
			for (Cookie c : cookies) {
				if(c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;
				}
			}
			
			int y = v;
			
			String operator = "";
			for (Cookie c : cookies) {
				if(c.getName().equals("op")) {
					operator = c.getValue();
					break;
				}
			}
			
			int result = 0;
			if (operator.equals("+")) {
				result = x + y;
			} else {
				result = x - y;
			}
			response.getWriter().println("result is " + result);
			
		} else {
			Cookie valueCookie = new Cookie("value", String.valueOf(v));
			Cookie opCookie = new Cookie("op", String.valueOf(op));
			response.addCookie(valueCookie); // 쿠키를 response에 header에 심어 전달
			response.addCookie(opCookie); // 쿠키를 response에 header에 심어 전달
		}	
	}
}

package com.my.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String buildingno = request.getParameter("buildingno");

		System.out.println("id : " + id + ", pwd : " + pwd + ", name : " + name + ", addr : " + addr +
				", buildingno : " + buildingno);
		// 로그인 성공 {"status":1}
		out.print("{\"status\": 1, \"message\": \"success???\"}");
		System.out.println("로그인 성공 {\"status\": 1}");
	}

}

package com.my.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseServlet
 */
public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseServlet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//응답 형식 설정 (MIME;encoding)
		response.setContentType("text/html;charset=UTF-8"); // MIME방식 : html / default encoding : ISO_88859_1
		
		PrintWriter out = response.getWriter();
		//System.out의 datatype = PrintStream
		out.print("<html>");
		out.print("<body>");
		for (int i = 1; i <= 6; i++) {
			out.println("<h" + i + ">");
			out.println("Title(제목) " + i);
			out.println("</h" + i + ">");
		}
		out.print("</body>");
		out.print("</html>"); 
	}
}
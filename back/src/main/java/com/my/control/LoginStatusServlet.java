package com.my.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;


public class LoginStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginStatusServlet() {
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//응답 형식 설정 (MIME;encoding)
		response.setContentType("application/json;charset=UTF-8"); 
		PrintWriter out = response.getWriter();
		ObjectMapper mapper = new ObjectMapper(); // 객체를 json 형식으로 바꾸기
		Map<String, Object>map = new HashMap<>(); 

		
		//session (클라이언트 별) 객체 얻기
		HttpSession session = request.getSession();
		
//		out.print(session.isNew());
//		out.print(session.getId());
//		out.print(session.getLastAccessedTime());
		
		String loginedId = (String) session.getAttribute("loginInfo");
		if(loginedId == null) {
			map.put("status", 1);
		} else {
			map.put("status", 0);		
		}
		String result = mapper.writeValueAsString(map);
		out.print(result);
	}

}

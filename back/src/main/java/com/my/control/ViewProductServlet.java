package com.my.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.dto.Product;
import com.my.exception.FindException;
import com.my.repository.ProductOracleRepository;
import com.my.repository.ProductRepository;

public class ViewProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewProductServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 처리순서
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//1. front로부터 productNo 받기
		String productNo = request.getParameter("product_no");
		System.out.println(productNo);
		//2. DB에서 상품 검색
		ProductRepository repository = new ProductOracleRepository();
		String result = "";
		try {
			Product p = repository.selectByProductNo(productNo);
			Map<String, Object> map = new HashMap<>();
			map.put("status", 1);
			map.put("message", "상품이 없습니다");
			map.put("p", p);
			ObjectMapper mapper = new ObjectMapper(); // 객체를 json 형식으로 바꿈
			result = mapper.writeValueAsString(map);
			System.out.println("result : " + result);
			
			//3. request의 속성을 정하기
			request.setAttribute("product_no", p.getProductNo());
			
			//4. 프론트페이지로 이동 
			String path = "/frontend/html/viewproduct.html";
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);

			
		} catch (FindException e) {
			e.printStackTrace();
		} 	
			out.print(result);
		
	}
}

package com.my.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.dto.Product;
import com.my.exception.FindException;
import com.my.repository.ProductOracleRepository;
import com.my.repository.ProductRepository;
import com.my.sql.MyConnection;


public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductListServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		ProductRepository repository = new ProductOracleRepository();	
		List<Product> products;
		try {
			products = repository.selectAll();
		} catch (FindException e) {
			e.printStackTrace();
			products = new ArrayList<>(); // 껍데기만 생성하고 끝냄
		}
				
		
		String result = "[";
		for (int i = 0; i < products.size(); i++) {
//		Map<String, Object> map = products.get(i); //map 사용시 필요한 코드
			result += "{";
			result += "\"productNo\": \"" + products.get(i).getProductNo() + "\",";
			result+= "\"productName\": \"" + products.get(i).getProductName() + "\",";
			result += "\"productPrice\": \"" + products.get(i).getProductPrice() + "\",";
			result += "\"productInfo\": \"" + products.get(i).getProductInfo() + "\",";
			result += "\"productMfd\": \"" + products.get(i).getProductMfd() + "\"";
			result += "}";
			if (i != products.size() - 1) {
				result += ",";
			}	
		}
		result += "]";
		System.out.println("productListServlet : " + result);
		out.println(result);
	}

}

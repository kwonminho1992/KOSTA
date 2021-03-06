package com.my.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.my.dto.Product;
import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.sql.MyConnection;

public class ProductOracleRepository implements ProductRepository{

	@Override
	public void insert(Product product) throws AddException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(String modifiedProductNo, String modifiedProductName, int modifiedProductPrice)
			throws AddException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> selectAll() throws FindException {
		List<Product> products = new ArrayList<>();
		
		//Database
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectProductAllSQL = "SELECT * FROM product ORDER BY product_no ASC";
		try {
			con = MyConnection.getConnection(); // 예전에 DB연결용으로 만든 MyConnection class 를 활용함
			pstmt = con.prepareStatement(selectProductAllSQL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String productNo = rs.getString("product_no");
				String productName = rs.getString("product_name");
				int productPrice = rs.getInt("product_price");
				String productInfo = rs.getString("product_info");
				java.sql.Date productMfd = rs.getDate("product_mfd");
				
				Product product = new Product(productNo, productName, productPrice, productInfo, productMfd);
				products.add(product);
			}
			if (products.size() == 0) {
				throw new FindException("상품이 없습니다.");
			}
			return products;
		} catch (SQLException e) {
			throw new FindException(e.getMessage());
		} finally {
			MyConnection.close(rs, pstmt, con);
			System.out.println("DB와의 연결을 해제하였습니다.");
		} 
	}

	@Override
	public Product selectByProductNo(String productNo) throws FindException {		
		//Database
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectProductNoSQL = "SELECT * FROM product WHERE product_no = ?";
		try {
			con = MyConnection.getConnection(); // 예전에 DB연결용으로 만든 MyConnection class 를 활용함
			pstmt = con.prepareStatement(selectProductNoSQL);
			pstmt.setString(1, productNo);
			rs = pstmt.executeQuery();
			System.out.println("productNo : " + productNo);
			if (rs.next()) {
				String productName = rs.getString("product_name");
				System.out.println("productName : " + productName);
				int productPrice = rs.getInt("product_price");
				String productInfo = rs.getString("product_info");
				java.sql.Date productMfd = rs.getDate("product_mfd");
				Product product = new Product(productNo, productName, productPrice, productInfo, productMfd);
				return product;
			} else {
				throw new FindException("없는 상품번호 입니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		} finally {
			MyConnection.close(rs, pstmt, con);
			System.out.println("DB와의 연결을 해제하였습니다.");
		} 
	}

	@Override
	public List<Product> selectByProductNoOrName(String keyword) throws FindException {
		// TODO Auto-generated method stub
		return null;
	}

	
}

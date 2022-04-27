package com.my.repository;

import com.my.dto.Product;

/**
 * add, revise, inquire, delete products in repository
 * @author kwonminho
 *
 */
public class ProductRepository {
	//field
	private Product[] products; //repository
	private int count; //number of products registered in repository

	//constructor1 - can deposit n products 
	public ProductRepository(int n) {
		this.products = new Product[n];
	}
	//constructor2 - default value : 5 (can deposit 5 products)
	public ProductRepository() {
		this.products = new Product[5];
	}

	
	/**
	 * add products into repository
	 * @param product
	 */
	public void insert(Product products) {
		try {
			this.products[count] = products;
			count++;
			//this.products[count++] = products; //-> bad code. unary operator is dangerous with other operators
			//System.out.println("등록된 상품종류의 개수 : " + count);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ERROR : repository is full! current number of products : " + count);
		}
	}
	
	/**
	 * @return all deposited products in the repository
	 */
	public Product[] selectAll () {
		Product[] result = new Product[count];
		for (int i = 0; i < count; i++) {
			result[i] = products[i];
		}
		return result;
//		return products; // if deposited not maximum products, occur NullPointerException error
	}
	
	/**
	 * 
	 * @return count
	 */
	public int getCount() {
		return count;
	}
}


package productmanagement;
/**
 * add, revise, inquire, delete products in repository
 * @author kwonminho
 *
 */
public class ProductRepository {
	//field
	Product[] products; //repository
	int count; //number of products registered in repository

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
	void insert(Product products) {
		this.products[count] = products;
		count++;
		
	}
	
}

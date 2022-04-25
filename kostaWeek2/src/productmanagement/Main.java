package productmanagement;

import java.util.Date;

/**
 * Main class
 * @author Kwon Minho
 *
 */
public class Main {

	public static void main(String[] args) {
		// Run the program
		ProductRepository repository = new ProductRepository(); // create repository can store maximum 5 products
		//ProductRepository repository2 = new ProductRepository(10); // create repository can store maximum 10 products
		
		Product p1 = new Product("D0001", "아메리카노", 1000);
		repository.insert(p1);
		
		repository.insert(new Product("F0001", "스콘", 1500, new Date()));
		
	}

}

package classPractice;

import java.util.Date;

import com.my.dto.Product; // Data Transfer Object (자료전달용 객체)
import com.my.repository.ProductRepository; // repository (자료 저장소)

/**
 * Main class
 * @author Kwon Minho
 *
 */
public class ProductManager {

	public static void main(String[] args) {
		// Run the program
		ProductRepository repository = new ProductRepository(); // create repository can store maximum 5 products
		//ProductRepository repository2 = new ProductRepository(10); // create repository can store maximum 10 products
		
		Product p1 = new Product("D0001", "아메리카노", 1000);
		repository.insert(p1);
		
		repository.insert(new Product("D0002", "아이스아메리카노", 1500, new Date()));
		repository.insert(new Product("D0003", "라떼", 1500, "두유로 만듦"));
		repository.insert(new Product("D0004", "아이스라떼", 1500, new Date()));
		System.out.println("등록된 상품종류의 개수 : " + repository.getCount());

		Product[] products = repository.selectAll(); // products : all products information deposited
		for (int i = 0; i < products.length; i++) {
			products[i].print(); // print information of the product
		}
		
	}

}
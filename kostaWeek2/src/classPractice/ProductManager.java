package classpractice;

import java.util.Date;

import com.my.dto.Product; // Data Transfer Object (자료전달용 객체)
import com.my.exception.AddException;
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
		try {
			for (int i = 0; i < 20; i++) { // 반복문 내부, 외부에서 예외처리를 하느냐에 따라 결과가 달라짐
//				try {
					repository.insert(new Product("D000" + (i + 1), "아이스아메리카노", 1500, new Date()));			
//				} catch (ArrayIndexOutOfBoundsException e) { // 배열의 범위를 벗어남
//					System.out.println("ERROR : repository is full! current number of products");
//					//e.printStackTrace();
//					throw new AddException(); // 강제 예외발생
//				}
			}
		} catch (AddException e) { // AddException 예외 catch
			e.printStackTrace(); // AddException 예외 상세 미시지 출력
//			e.getMessage(); // AddException 예외 상세 미시지 출력
		}
		System.out.println("등록된 상품종류의 개수 : " + repository.getCount());

		Product[] products = repository.selectAll(); // products : all products information deposited
		for (int i = 0; i < products.length; i++) {
			products[i].print(); // print information of the product
		}
		
	}

}
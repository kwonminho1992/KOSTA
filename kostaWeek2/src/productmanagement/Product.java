package productmanagement;

import java.util.Date;

/**
 * Object of project
 * --상품--
 * 상품번호 : "F0001"(food), "G0001"(goods), "D0001"(drink) - String
 * 상품명 :  "스콘"           "머그1", "머그2"   "아메리카노" - String
 * 가격  :   1000            2000, 2500      1000 - int
 * 상품상세정보 : "~~"         "~~", "~~"      "~~"  - String
 * 상품제조일자 : 2022/04/20    2022/04/21    2022/04/23 - Date
 * @author kwon minho
 *
 */
public class Product {
	// field
	String productNo;
	String productName;
	int productPrice;
	String productInfo;
	Date productMfd;
	// constructor
	public Product(String productNo, String productName, int productPrice) {
		this.productNo = productNo;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	public Product(String productNo, String productName, int productPrice, Date productMfd) {
		super();
		this.productNo = productNo;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productMfd = productMfd;
	}
}

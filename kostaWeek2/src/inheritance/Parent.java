package inheritance;
/**
 * Parent class for inheritance
 * @author kwon minho
 *
 */
public class Parent {
	//field
	private String p1;
	private int money;
	//constructor
	public Parent(String p1, int money) {
		this.p1 = p1;
		this.money = money;
	}
	public Parent() {
	}
	//method
	public void pm() {
		System.out.println("method of parent");
	}
	public String getP1() {
		return p1;
	}
	public void setP1(String p1) {
		this.p1 = p1;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
}


import java.util.Map;

public class Struct {

	public static void main(String[] args) {
		// Map
		int[] arr = new int[10];
		//store data
		Map map = new java.util.HashMap();
		map.put("name", "Kwon Minho");
		map.put("address", "Bundang");		
		map.put("sal", 3000);
		System.out.println("map size : " + map.size());
		//get data
		System.out.println(map.get("name"));
		System.out.println(map.get("sal"));
		
	
		
	}
}

package tv;

public class WatchTV {
	
	public static void main(String[] args) {
		TV tv = new TV(); //create object (TV)
		TV tv2 = new TV(); // create 2nd object (TV)
		
		tv.power = true; // power of the TV
		
		boolean power = tv.isPower(); // turn on TV = true, turn off TV = false
		if (power == true) { // if turns the TV on
			System.out.println("turn on");
			tv.setChannel(7); // set channel 7 
			tv.volumeUp(); // increase 1 volume
			System.out.println("current channel : " + tv.getChannel() + "\ncurrent volume : " + tv.getVolume());
		} else { // if turns the TV off
			System.out.println("turn off");
		}
	}

	
	// memory
	
	// stack :
	// tv(refer value of isPower in heap)
	
	// heap :
	// TV (isPower method)
}

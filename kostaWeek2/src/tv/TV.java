/**
 * TV package : operating TV
 */
package tv;
/**
class for creating TV object 
@author Kwon Minho
@version 1.0
*/
public class TV {
	//variables
	private boolean power;
	private int channel = 0;
	private int volume = 0;
	
	/**
	 * set power variable == true
	 * @return power (true)
	 */
	public boolean powerOn() {
		this.power = true;
		return power;
	}
	
	/**
	 * @return return power is true or not
	 */
	// * variables are registered in each INSTANCE, not class
	public boolean isPower() { //turn on TV = true / turn off TV = false
		return this.power;
	}
	
	/**
	 * set channel number by user's input
	 * @param channel : channel number
	 */
	public void setChannel (int channel) { // set channel number from user's input
		if (channel >= 0) { // minus channel number is not available
			this.channel = channel;
		} else {
			System.out.println("minus channel number is not available");
			return;
		}
	}
	
	/**
	 * @return current channel number
	 */
	public int getChannel () { // get current channel number
		return this.channel;
	}
	
	/**
	 * 1 volume up
	 */
	public void volumeUp() { // increase 1 volume
		this.volume++;
	}
	
	/**
	 * @return get current volume
	 */
	public int getVolume() { // get current volume
		return this.volume;
	}
}


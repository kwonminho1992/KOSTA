package world.asia;

public class Korea {
	String language;
	String capital;
	int population;

	public void setPopulation (int population) {
		if (population < 1) {
			System.out.println("population must be at least 1");
			return;
		} else {
			this.population = population;
		}
	}
}

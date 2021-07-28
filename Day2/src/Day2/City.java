package Day2;

public class City {
	private String name;
	private String countryCode;
	private int population;
	
	public City(String name, String countryCode, String population) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.countryCode = countryCode;
		this.population = Integer.parseInt(population);
	}
	
	public String getCountryCode() {
		return countryCode;
	}
	public String getName() {
		return name;
	}
	public int getPopulation() {
		return population;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	@Override
	public String toString() {
		return name+", " +population;
	}

}

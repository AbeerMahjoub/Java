package Day2;

public class Country {
	
	private String name;
	private String countryCode;
	
	public Country(String name, String countryCode) {
		this.name = name;
		this.countryCode = countryCode;
	}
	
	public String getName() {
		return name;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}

}

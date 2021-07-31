package Pyramids;

public class Pyramid {
	
	private String name;
	private String modernName;
	private String site;
	private double height;
	
	public Pyramid(String name, String modernName,  String site, String height) {
		this.name = name;
		this.modernName = modernName;
		this.site = site;
		this.height = Double.parseDouble(height);
	}
	
	
	public String getName() {
		return name;
	}
	
	public String getModernName() {
		return modernName;
	}
	
	public String getSite() {
		return site;
	}
	public double getHeight() {
		return height;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Pyramid" +" -> "+ name;
	}

}

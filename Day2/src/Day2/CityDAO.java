package Day2;
import java.io.FileInputStream;
import java.util.*;

public class CityDAO {
	private  List<City> cities = new ArrayList<>();
	public  CityDAO(String fname) {
		
		Scanner sc;
		try {
			
			 sc = new Scanner(new FileInputStream(fname));
			 sc.nextLine();
			 sc.useDelimiter(",");
				while(sc.hasNextLine()) {
					String line = sc.nextLine();
					String[] fields = line.split(",");
					if (fields.length ==5) {
						City c = new City(fields[1], fields[2], fields[4]);
						cities.add(c);
					}
	
				}
			}
		catch (Exception e) {
		
			//System.out.println(e.getMessage());
		}
		
	}
	public List<City> getCities() {
		return cities;
	}
}

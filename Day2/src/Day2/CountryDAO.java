package Day2;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class CountryDAO {
	    private List<Country> countries = new ArrayList<>();
		public CountryDAO(String fname){
			
			Scanner sc;
			try {
				sc = new Scanner(new FileInputStream(fname));
				sc.nextLine();
				 sc.useDelimiter(",");
				while(sc.hasNext()) {
					String line = sc.nextLine();
					String[] fields = line.split(",");
					if(fields.length == 2) {
						Country c = new Country(fields[0], fields[1]);
						countries.add(c);
					}
				}
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		public List<Country> getCountries() {
			return countries;
		}
}

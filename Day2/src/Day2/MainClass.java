package Day2;

import java.util.*;
import java.util.stream.Collectors;

public class MainClass {
	
	public static void main(String[] args) {
		CityDAO dao1 = new CityDAO("C:\\Users\\M.user\\Desktop\\cities.csv");
		List<City> cities = dao1.getCities();
		
			
		//System.out.println(cities);
		//System.out.println(cities.size()); // many lines discarded while reading 
		CountryDAO dao2 = new CountryDAO("C:\\Users\\M.user\\Desktop\\countries.csv");
		List<Country> countries = dao2.getCountries();
		countries.stream().forEach(System.out::println); // showin
		//System.out.println(countries.size()); 
		
		
		//one -make map for country and corresponding cities
		HashMap<Country, List<City>> hmap = new HashMap<>();
		for(Country co: countries) {
			List<City> lst = new ArrayList<>();
			for(City c: cities) {
				if(co.getCountryCode().equals(c.getCountryCode())) {
					lst.add(c);
				}
				
			}
			if (lst.size() >0)
			hmap.put(co, lst);
			
		}
		
	
		
	
		// sorting for population.
		 hmap.forEach((k,v) -> v.stream()
								.sorted(Comparator.comparing(City::getPopulation)));
		 
		 HashMap<Country, List<City>> sortedh = new HashMap<>();
		 hmap.forEach((k, v)-> sortedh.put(k, v.stream()
				 								.sorted(Comparator.comparing(City::getPopulation))
				 								.collect(Collectors.toList())
				 )
		 );
		 System.out.println("here");
		 System.out.println(sortedh);
		
		
				
		 	/*
								
		hmap.entrySet().forEach(entry -> {
		    System.out.println(entry.getKey() + "\n " + entry.getValue());
		});
		*/
		
		//highest population in each country
		
		
		HashMap<Country, City> highstPopPerC = new HashMap<Country, City>();
			
		hmap.forEach((Country, Cities) -> highstPopPerC.put(Country, Cities.stream()
																.reduce((c1, c2)-> c1.getPopulation() >= c2.getPopulation() ? c1 : c2)
																.get()
						));
		
		
			
		
		
		
		highstPopPerC.entrySet().forEach(entry -> System.out.println(entry.getKey() +"\n"+ entry.getValue()));
		
		

							
		

	
		
		
	}

}

package Day2;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class CityDAO1 {
    private List<City> cities = new ArrayList<>();
    public CityDAO1(String fname){
        Scanner sc;
        
        
        try{
        sc = new Scanner(new FileInputStream(fname));
      System.out.println(sc.hasNext());
        sc.nextLine();
        //sc.useDelimiter(",");
        while(sc.hasNext()){
            //System.out.println(sc.next());
            
            String line = sc.nextLine();
            String[] fields = line.split(",");
            if(fields.length <5) continue;
            for (String f: fields){
                f = f.trim();
            }
            City c = new City(fields[1], fields[2], fields[4]);
            cities.add(c);
            //break;
        }
      
        } catch(Exception e){
             
        }
        
        
    }

    public List<City> getCities() {
        return cities;
    }
    
    public void show(){
        for(int i= 0; i< cities.size(); i++){
            System.out.println(cities.get(i));
            System.out.println();
        }
    }
    
}
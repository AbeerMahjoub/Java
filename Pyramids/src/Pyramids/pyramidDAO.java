package Pyramids;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;


public class pyramidDAO {
	private List<Pyramid> pyramids = new ArrayList<>();
	private List<String> lines = new ArrayList<String>();
	public pyramidDAO(String fname) {
		File file = new File(fname);
		try {
			lines = Files.readAllLines(file.toPath());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		for(int i =1; i< lines.size(); i++) {
			String line = lines.get(i);
			String[] fields = line.split(",");
			/*
			for(int j=0; j< fields.length; j++) {
				
			}*/
			if(fields[0].isEmpty() || fields[2].isEmpty() || fields[4].isEmpty() || fields[7].isEmpty()) continue;
			Pyramid p = new Pyramid(fields[0], fields[2], fields[4], fields[7]);
			pyramids.add(p);
			
		
		}
		
		
		
		
		
	}
	
	public List<Pyramid> getPyramids() {
		return pyramids;
	}
	

}

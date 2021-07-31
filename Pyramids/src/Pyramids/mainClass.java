package Pyramids;

import java.util.List;
import java.util.stream.Collectors;

public class mainClass {
	public static void main(String[] args) {
		pyramidDAO dao = new pyramidDAO("C:\\Users\\M.user\\Desktop\\pyramids.csv");
		List<Pyramid> pyramids = dao.getPyramids();
		// show size of pyramids list
		System.out.println(pyramids.size());
		// show first two pyramids
		showN(pyramids, 2);
		
		//lab4 
		
		var heights = pyramids.stream().map(Pyramid::getHeight).sorted().collect(Collectors.toList());
		
				//median 
		int count = heights.size();
		if(count%2 ==0) {
			var median = (heights.get(count/2) + heights.get(count/2 + 1)) /2;
			System.out.println(median);
			
		}else {
			var median = heights.get(count/2);
			System.out.println(median);
		}
	
		
				// lower and upper quartile
	
		var h1 = heights.subList(0, count/2 );
		var h2 = heights.subList(count/2 +1, heights.size());
		var q1 = (h1.get(h1.size()/2) + h1.get(h1.size()/2 +1)) /2;
		var q3 = (h2.get(h2.size()/2) + h2.get(h2.size()/2 +1)) /2;
		System.out.println(h1 .size());
		System.out.println(h2.size());
		System.out.println(q1);
		System.out.println(q3);

	


		
		
		
	}
	
	public static void showN(List lst, int n) {
		for(int i = 0; i<n; i++) {
			System.out.println(lst.get(i));
		}
	}
}

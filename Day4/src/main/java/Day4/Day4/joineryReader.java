package Day4.Day4;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import joinery.DataFrame;

public class joineryReader {
	public static void main(String[] args) {
		try {
			//first df
			DataFrame<Object> df1 = DataFrame.readCsv("C:\\Users\\M.user\\Desktop\\titanic.csv");
			// second df
			DataFrame<Object> df2 = DataFrame.readCsv("C:\\Users\\M.user\\Desktop\\titanic.csv");
			
			//keep name, survived, sex, age in df1
			df1 = df1.retain("name", "survived", "sex", "age");
			
			//keep name and embarked in df2
			df2 = df2.retain("name", "embarked");
			
			//show data types
			System.out.println("Data Types:\n"+ df1.types());
			
			//show data stat. 
			System.out.println("\nData Statistics:\n"+ df1.describe());
			
			//groupby gender type
			DataFrame<Object> groupByGender = df1.groupBy(row -> row.get(2)).mean();
			System.out.println("\nGrouped by Gender Type:\n"+ groupByGender);
			
			//encoding sex column
			List<Object> gender = df1.col("sex");
			gender = gender.stream().map(g -> g.equals("female")? 1:0)
									.collect(Collectors.toList());
			//System.out.println(gender);
			
			//adding to df1
			df1.add("gender", gender);
			System.out.println(df1.head());
			
			//remove the "sex" column
			df1 = df1.drop("sex");
			System.out.println(df1.head());
			
			
			//merging df1, df2 --> need to remove duplicates first
		
			df1 = df1.drop("name").add("name", df1.col("name").stream().distinct().collect(Collectors.toList()));
			DataFrame<Object> merged = df1.join(df2);
			System.out.println("\n Merged data frame using name column: \n"+ merged.head());
			
			//joining df1, df2
			DataFrame<Object> joined = df1.join(df2);
			System.out.println("\n Joined Data Frame:\n"+joined.head());
			
			
			
			
			
			

			
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	


}

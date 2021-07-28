package Day4.Day4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.formula.functions.Column;

import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.NumberColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;

public class TablesawReader 
{
    public static void main(String[] args ){
    	try {
			Table df1 = Table.read().csv("C:\\Users\\M.user\\Desktop\\titanic.csv");
			
			//Data Structure
			System.out.println("Data Structure: \n"+ df1.structure());
			
			//Data ststistics
			System.out.println("\n Data Statistics: \n"+ df1.summary());
			
			//show first five rows
			System.out.println("\n First 5 rows:\n "+ df1.first(5));
			
			//encode "sex" column
			StringColumn sexCol = (StringColumn) df1.column("sex");
			//System.out.println(gender);
			List<Integer> gender = new ArrayList<>();
			//gender.add(df1.column("sex").map(o -> o.equals("female")? 1: 0));
			for (String g : sexCol) {
				if(g.equals("female")) gender.add(1);
				else gender.add(0);
			}
			
			NumberColumn genderCol = DoubleColumn.create("gender", gender);
			df1.addColumns(genderCol); //adding new col
			df1.removeColumns("sex"); //remove old column
			
			System.out.println(df1.first(5));
			
			//join
			Table df2 = Table.read().csv("C:\\Users\\M.user\\Desktop\\titanic.csv");
			df2 = df2.select("name", "survived", "age");
			df1 = df1.select("ticket");
			Table joined = df1.concat(df2);
			System.out.println(joined.first(5));
					
			
			
			
			
			
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
}

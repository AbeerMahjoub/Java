package Day5;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.Locale.Category;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.MapperBuilder;
import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.Styler.LegendPosition;
public class Xchart {
	
	
	public static void main(String[] args) {
		List<TitanicPassenger> passengers = new ArrayList<>();
		ObjectMapper omap = new ObjectMapper();
		omap.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			FileInputStream titanicFile = new FileInputStream("C:\\Users\\M.user\\Desktop\\titanic.json");
			passengers = omap.readValue(titanicFile, new TypeReference<List<TitanicPassenger>>() {});
			
			//System.out.println(passengers);
			//get 20 ages
			List<Float> ages = passengers.stream().map(TitanicPassenger::getAge).limit(20).collect(Collectors.toList());
			List<String> names = passengers.stream().map(TitanicPassenger::getName).limit(20).collect(Collectors.toList());
			
			//histogram
			CategoryChart chart = new CategoryChartBuilder ().width (1024).height (768).title ("Age Histogram").xAxisTitle ("Names").yAxisTitle ("Age").build ();
			
			chart.getStyler().setLegendPosition(LegendPosition.InsideNW);
			chart.getStyler().setHasAnnotations(true);
			chart.getStyler().setStacked(true);
			
			chart.addSeries("PassengersAge", names, ages);
			new SwingWrapper(chart).displayChart();
			
			//pie chart
			//List<String> pclasses = passengers.stream().map(TitanicPassenger::getPclass).limit(20).collect(Collectors.toList());
			Map<String, Long> groupedByClass = passengers.stream()
													.collect(Collectors.groupingBy(TitanicPassenger::getPclass, Collectors.counting()));
			
			PieChart pchart = new PieChartBuilder().width(1024).height(768).title("Passengers Classes").build();
			
			Color[] slColors = new Color[] {new Color(180, 160, 10), new Color(200, 110, 50), new Color(30, 160, 170)};
			pchart.getStyler().setSeriesColors(slColors);
			 
			pchart.addSeries("First Class", groupedByClass.get("1"));
			pchart.addSeries("Second Class", groupedByClass.get("2"));
			pchart.addSeries("Third Class", groupedByClass.get("3"));
			
			new SwingWrapper(pchart).displayChart();

			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

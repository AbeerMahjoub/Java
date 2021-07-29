package jupai7.sm;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;

import smile.data.DataFrame;
import smile.data.Tuple;
import smile.io.Read;

public class PassengerProviderTest {
	private DataFrame passengerTestDataFrame;
	 public DataFrame readCSV(String path) {
	        CSVFormat format = CSVFormat.DEFAULT.withFirstRecordAsHeader ();
	        DataFrame df = null;
	        try {
	            df = Read.csv (path, format);
	            System.out.println(df.summary ());
	            df = df.select ("Name", "Pclass", "Age", "Sex");
	            System.out.println(df.summary ());
	        } catch (IOException | URISyntaxException e) {
	            e.printStackTrace ();
	        }
	        passengerTestDataFrame = df;
	        // System.out.println (df.summary ());
	        return df;
	    }
	    public DataFrame getPassengerTestDataFrame() {
	        return passengerTestDataFrame;
	    }
	    public List<Passenger> getPassengerList() {
	        assert passengerTestDataFrame != null;
	        List<Passenger> passengers = new ArrayList<> ();
	        ListIterator<Tuple> iterator = passengerTestDataFrame.stream ().collect (Collectors.toList ()).listIterator ();
	        while (iterator.hasNext ()) {
	            Tuple t = iterator.next ();
	            Passenger p = new Passenger ();
	            Passenger.id += 1;
	            p.passengerId = Passenger.id;
	            p.setPclass ((Integer) t.get ("pclass"));
	            p.setName ((String) t.get ("name"));
	            p.setSex ((String) t.get ("sex"));
	            p.setAge ((Double) t.get ("age"));
	            p.setSibSp ((Integer) t.get ("sibsp"));
	            p.setParch ((Integer) t.get ("parch"));
	            p.setTicket ((String) t.get ("ticket"));
	            p.setFare ((Double) t.get ("fare"));
	            p.setCabin ((String) t.get ("cabin"));
	            p.setEmbarked ((String) t.get ("embarked"));
	            p.setBoat ((String) t.get ("boat"));
	            p.setBody ((Integer) t.get ("body"));
	            p.setHomeDest ((String) t.get ("home.dest"));
	            passengers.add (p);
	        }
	        return passengers;
	    }

}

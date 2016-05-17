import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {


	public static void main(String[] args) {

		final String filename = "iris.data";
		final int ValueInRow = 4;
		final double Theta = 0.04;
		final int EraSize = 500;
		final int WTASize = 3;
		final int CountOfDataRows = 150;
		final int NetworkFeedSize = 110;
		
		FileReader fileReader = new FileReader(filename);
		ArrayList<double[]> learningSet = new ArrayList<>();
		try {
			learningSet = fileReader.getSetFromFile(CountOfDataRows, ValueInRow, ",");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			
		WTA network = new WTA(WTASize);
		network.learn_network(learningSet, EraSize, Theta);
		double[] respond = network.feed(learningSet.get(NetworkFeedSize));
		for (int i = 0; i < respond.length; i++) {
			System.out.println(respond[i]);
		}
			

		
	}
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
	
	private static Scanner input;

	private File file;
	
	public FileReader( String fileName) {
		file = new File(fileName);
	}
	
	public ArrayList<double[]> getSetFromFile(int CountOfDataRows, int ValueInRow, String splitCharacter) throws FileNotFoundException {
		input = new Scanner(file);
		ArrayList<double[]> learningSet = new ArrayList<double[]>();
		for (int i = 0; i < CountOfDataRows; i++) {
			String row = input.nextLine();
			String[] data = row.split(",");
			double temp[] = new double[ValueInRow];
			for (int j = 0; j < ValueInRow; j++) {
				temp[j] = Double.parseDouble(data[j]);
			}
			learningSet.add(temp);
		}
	
		return learningSet;
	}

}

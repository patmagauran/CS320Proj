package cs320proj.loading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Loader {

	public Loader() {

	}

	public List<ProcessRecord> loadFile(String fileName) throws Exception {
		List<String> lines = readFileLines(fileName);
		List<ProcessRecord> records = new ArrayList<>(lines.size());
		for (String line : lines) {
			records.add(parseLine(line));
		}
		return records;
	}

	private ProcessRecord parseLine(String line) throws Exception {
		String[] lineArr = line.split(" ");
		int priority = 0;
		if (lineArr.length < 2) {
			throw new Exception("Only one field provided in process record line!");
		}
		if (lineArr.length > 3) {
			throw new Exception("More than 2 fields provided in process record line!");

		}
		if (lineArr.length > 2) {
			try {
				priority = Integer.parseInt(lineArr[2]);
			} catch (NumberFormatException e) {
				throw new Exception("Third Field should be a number!", e);
			}

		}

		long runTime = 0L;
		try {
			runTime = Long.parseLong(lineArr[1]);
		} catch (NumberFormatException e) {
			throw new Exception("Second Field should be a number!", e);
		}
		return new ProcessRecord(runTime, lineArr[0], priority);
	}

	private List<String> readFileLines(String fileName) throws Exception {
		try {
			List<String> listOfStrings
					= new ArrayList<String>();

			//"textFile.txt"
			BufferedReader bf = new BufferedReader(
					new FileReader(fileName));

			// read entire line as string
			String line = bf.readLine();

			// checking for end of file
			while (line != null) {
				listOfStrings.add(line);
				line = bf.readLine();
			}
			bf.close();
			return listOfStrings;
			/*// storing the data in arraylist to array
			String[] array
					= listOfStrings.toArray(new String[0]);

			// printing each line of file
			// which is stored in array
			for (String str : array) {
				System.out.println(str);
			}*/
		} catch (IOException e) {
			throw new Exception("Couldn't Read file",e);
		}
	}

}

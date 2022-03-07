package logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadData {

	@SuppressWarnings("unused")
	static ArrayList<String> readFileData() {
		ArrayList<String> dataArray = new ArrayList<>();
		try {
			File myObj = new File("Resources\\data.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				if (data.contains("Pin")) {
					continue;
				} else {
					dataArray.add(data);
					System.out.println();
				}
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return dataArray;
	
	}
}

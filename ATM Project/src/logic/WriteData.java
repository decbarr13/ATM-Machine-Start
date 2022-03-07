package logic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javafx.scene.control.TextField;

public class WriteData {

	static void writeToFile(TextField userInputCardNo, TextField userInputPin, String fullName) {
		try {
			FileWriter myWriter = new FileWriter("Resources\\data.txt", true);
			BufferedWriter bw = new BufferedWriter(myWriter);
			bw.newLine();
			bw.write(fullName + "," + userInputCardNo.getText() + "," + userInputPin.getText());
			bw.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}
}

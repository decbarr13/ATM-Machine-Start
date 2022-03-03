package logic;

import java.util.ArrayList;

import javafx.scene.control.TextField;

public class SignIn {

	public static void checkingLoginDetails(TextField userInputCardNo, TextField userInputPin) {
		boolean accountExists = SignUp.checkingExisitngData(userInputCardNo);
		if (accountExists) {
			boolean correctInput = checkingPin(userInputCardNo, userInputPin);
			if(correctInput) {
				System.out.println("Match");
			}
			else {
				System.out.println("Pin or CardNumber is wrong");
			}
			
		} else {
			System.out.println("Account Doesnt Exist");
		}
	}

	private static boolean checkingPin(TextField userInputCardNo, TextField userInputPin) {
		ArrayList<String> dataArray = new ArrayList<>();
		dataArray = ReadData.readFileData();
		String combinedInput = userInputCardNo.getText() + "," + userInputPin.getText();
		for (String data : dataArray) {
			if (data.equals(combinedInput)) {
				return true;
			}
		}
		return false;

	}
}

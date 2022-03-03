package logic;

import java.util.ArrayList;

import javafx.scene.control.TextField;

public class SignUp {
	public static void creatingAccount(TextField userInputCardNo, TextField userInputPin) {
		boolean cardNoCheck = LoginChecks.CardNumberCheck(userInputCardNo.getText());
		boolean pinCheck = LoginChecks.pinNumberCheck(userInputPin.getText());
		boolean accountExists = false;
		accountExists = checkingExisitngData(userInputCardNo);
		if (accountExists) {
			System.out.println("AccountNumber already exists");
		} else if(!cardNoCheck) {
			System.out.println("Card Number is invalid");
		} else if(!pinCheck) {
			System.out.println("Pin Number Invalid");
		}
		else {
			WriteData.writeToFile(userInputCardNo, userInputPin);
		}
	}

	static boolean checkingExisitngData(TextField userInputCardNo) {
		ArrayList<String> dataArray = new ArrayList<>();
		dataArray = ReadData.readFileData();
		for (String data : dataArray) {
			String[] userInfo = data.split(",");
			if (userInfo[0].equals(userInputCardNo.getText())) {
				return true;
			}
		}
		return false;
	}

}

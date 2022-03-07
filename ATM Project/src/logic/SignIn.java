package logic;

import java.util.ArrayList;

import gui.MenuScreen;
import javafx.scene.control.TextField;
import popups.ErrorPopUp;

public class SignIn {

	public static void checkingLoginDetails(TextField userInputCardNo, TextField userInputPin) {
		boolean cardNoCheck = LoginChecks.CardNumberCheck(userInputCardNo.getText());
		boolean pinCheck = LoginChecks.pinNumberCheck(userInputPin.getText());
		boolean correctInput = checkingPin(userInputCardNo, userInputPin);
		if(cardNoCheck) {
			if (pinCheck) {
				boolean accountExists = SignUp.checkingExisitngData(userInputCardNo);
				if (accountExists) {
					if(correctInput) {
						String accountDataFull = returnData(userInputCardNo, userInputPin);
						String[] accountDataSplit = accountDataFull.split(",");
						String name = accountDataSplit[0];
						String cardNo = accountDataSplit[1];
						String pin = accountDataSplit[2];
						Accounts account = new Accounts(cardNo,pin,name);
						MenuScreen.start(account);
					}
				else {
						ErrorPopUp.showError("Account Number and Pin do not match");
					}
					
				} else {
					ErrorPopUp.showError("Account Number is not on system");
				}
				
			}
		}
	}

	private static boolean checkingPin(TextField userInputCardNo, TextField userInputPin) {
		ArrayList<String> dataArray = new ArrayList<>();
		dataArray = ReadData.readFileData();
		String combinedInput = userInputCardNo.getText() + "," + userInputPin.getText();
		for (String data : dataArray) {
			if (data.contains(combinedInput)) {
				return true;
			}
		}
		return false;

	}
	
	private static String returnData(TextField userInputCardNo, TextField userInputPin) {
		ArrayList<String> dataArray = new ArrayList<>();
		dataArray = ReadData.readFileData();
		String combinedInput = userInputCardNo.getText() + "," + userInputPin.getText();
		for (String data : dataArray) {
			if (data.contains(combinedInput)) {
				return data;
			}
		}
		return null;
	}
}

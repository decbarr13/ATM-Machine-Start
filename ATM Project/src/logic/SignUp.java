package logic;

import java.io.File;
import java.util.ArrayList;

import javafx.scene.control.TextField;
import popups.ErrorPopUp;

public class SignUp {
	public static boolean creatingAccount(TextField userInputCardNo, TextField userInputPin, String fullName) {
		boolean cardNoCheck = LoginChecks.CardNumberCheck(userInputCardNo.getText());
		boolean pinCheck = LoginChecks.pinNumberCheck(userInputPin.getText());
		boolean accountExists = false;
		accountExists = checkingExisitngData(userInputCardNo);
		if (accountExists) {
			ErrorPopUp.showError("Account Already Exists");
		} else if (!cardNoCheck) {
			ErrorPopUp.showError("The format you have entered for CardNo or Pin is incorrect \n"
					+ "Please input CardNo in format : '1111-1111-1111-1111' \n" + "And pin in format: '1234' \n"
					+ "NOTE WE ONLY ACCEPT NUMERICAL VALUES");
		} else if (!pinCheck) {
			ErrorPopUp.showError("The format you have entered for CardNo or Pin is incorrect \n"
					+ "Please input CardNo in format : '1111-1111-1111-1111' \n" + "And pin in format: '1234' \n"
					+ "NOTE WE ONLY ACCEPT NUMERICAL VALUES");
		} else {
			WriteData.writeToFile(userInputCardNo, userInputPin, fullName);
			createAccountHistoryFile(fullName, userInputCardNo.getText());
			createAccountInfoFile(fullName, userInputCardNo.getText());
			System.out.println();
			return true;
			
		}
		return false;
	}

	private static void createAccountInfoFile(String fullName, String accountNumber) {
		String fileName = "\\" + fullName + accountNumber + "history.txt";
		String path = "C:\\Users\\decla\\git\\ATMMachineRepository\\ATM Project\\Resources\\Account Info";
		try {
			File file = new File(path + fileName);
			file.createNewFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void createAccountHistoryFile(String fullName, String accountNumber) {
		String fileName = "\\" + fullName + accountNumber + "history.txt";
		String path = "C:\\Users\\decla\\git\\ATMMachineRepository\\ATM Project\\Resources\\history";
		try {
			File file = new File(path + fileName);
			file.createNewFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static boolean checkingExisitngData(TextField userInputCardNo) {
		ArrayList<String> dataArray = new ArrayList<>();
		dataArray = ReadData.readFileData();
		for (String data : dataArray) {
			String[] userInfo = data.split(",");
			if (userInfo[1].equals(userInputCardNo.getText())) {
				return true;
			}
		}
		return false;
	}

}

package logic;


import popups.ErrorPopUp;
public class LoginChecks {

	final static int LENGTH_OF_CARD_NUMBER = 19;
	final static int FIRST_DASH = 4;
	final static int SECOND_DASH = 9;
	final static int THIRD_DASH = 14;
	final static int LENGTH_OF_PIN_NUMBER = 4;

	public static boolean CardNumberCheck(String UserInputCardNo) {
		String[] onlyNumbers = UserInputCardNo.split("-");
		String numbers = "";
		for(String set:onlyNumbers) {
			numbers += set;
		}
		if(UserInputCardNo.length() != LENGTH_OF_CARD_NUMBER) {
			ErrorPopUp.showError("Incorrect Format for Card number, please enter in format 1111-1111-1111-1111 \n"
					+ "NOTE ONLY NUMERICAL VALUES ARE ACCEPTED");
			return false;
		}
		else if((UserInputCardNo.charAt(FIRST_DASH) != '-') || 
				(UserInputCardNo.charAt(SECOND_DASH)!= '-') ||
				(UserInputCardNo.charAt(THIRD_DASH) != '-')) {
			ErrorPopUp.showError("Incorrect Format for Card number, please enter in format 1111-1111-1111-1111 \n"
					+ "NOTE ONLY NUMERICAL VALUES ARE ACCEPTED");
			return false;
		}
		else if (numbers.matches("[0-9]+")== false) {
			System.out.println("Can only contain numbers");
			return false;			
		}
		return true;
	}

	public static boolean pinNumberCheck(String UserInputPin) {
		if(UserInputPin.length() != LENGTH_OF_PIN_NUMBER) {
			ErrorPopUp.showError("Incorrect Format for pin, please enter in format 1111 \n"
					+ "NOTE ONLY NUMERICAL VALUES ARE ACCEPTED");
			return false;
		}else if(UserInputPin.matches("[0-9]+")== false) {
			ErrorPopUp.showError("Incorrect Format for pin, please enter in format 1111 \n"
					+ "NOTE ONLY NUMERICAL VALUES ARE ACCEPTED");
			return false;
		}
		else {
			return true;
		}
	}
}

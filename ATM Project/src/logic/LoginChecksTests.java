package logic;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class LoginChecksTests {

	@Test
	public void CardNumberPerfectInputTest() {
		System.out.println("Test 1");
		assertTrue(LoginChecks.CardNumberCheck("4444-4444-4444-4444"));
	}
	@Test
	public void CardNumberTooLongInputTest() {
		System.out.println("Test 2");
		assertFalse(LoginChecks.CardNumberCheck("4444-4444-4444-4444-4444"));
	}
	@Test
	public void CardNumberIncorrectCharacterTest() {
		System.out.println("Test 3");
		assertFalse(LoginChecks.CardNumberCheck("4444-4444-4444-4aaa"));
	}
	@Test
	public void CardNumberCheck1IncorrectFormatTest() {
		System.out.println("Test 4");
		assertFalse(LoginChecks.CardNumberCheck("4444-44445444454444"));
	}
	@Test
	public void PerfectPinInputTest() {
		System.out.println("Test5");
		assertTrue(LoginChecks.pinNumberCheck("1234"));
	}
	@Test
	public void TooLongPinInputTest() {
		System.out.println("Test6");
		assertFalse(LoginChecks.pinNumberCheck("12345"));
	}
	@Test
	public void WrongFormatPinInputTest() {
		System.out.println("Test7");
		assertFalse(LoginChecks.pinNumberCheck("1a2b"));
	}


}

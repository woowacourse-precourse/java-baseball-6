package baseball.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

	public void validateThreeDigitInput(String number) {
		String regex = "^\\d{3}$";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(number);

		if (!matcher.matches()) {
			throw new IllegalArgumentException();
		}
	}
}

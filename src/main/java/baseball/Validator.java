package baseball;

import java.util.Arrays;

public class Validator {
	public static void validateNumbers(String numbers) {
		if (numbers.split("").length > 3) {
			throw new IllegalArgumentException();
		}
		Arrays.stream(numbers.split(""))
			  .forEach(it -> {
				  try {
					  Integer.parseInt(it);
				  } catch (NumberFormatException ex) {
					  throw new IllegalArgumentException();
				  }
			  });
	}

	public static void validateIsRestart(String isRestart) {
		if (!isRestart.equals("1") && !isRestart.equals("2")) {
			throw new IllegalArgumentException();
		}
	}

	private Validator() {
	}
}

package baseball.validators;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class NumberValidatorTest {

	private final NumberValidator numberValidator = new NumberValidator();

	@Test
	void InValidPlayGame() {
		String blank = "";
		assertThrows(IllegalArgumentException.class, () -> numberValidator.isValidPlayGame(blank));

		assertThrows(IllegalArgumentException.class, () -> numberValidator.isValidPlayGame(null));

		String length2 = "12";
		assertThrows(IllegalArgumentException.class, () -> numberValidator.isValidPlayGame(length2));

		String isNotNumeric = "뿌뿌뿌";
		assertThrows(IllegalArgumentException.class, () -> numberValidator.isValidPlayGame(isNotNumeric));

		String hasDuplicateNumbers = "119";
		assertThrows(IllegalArgumentException.class, () -> numberValidator.isValidPlayGame(hasDuplicateNumbers));
	}

	@Test
	void InValidPlayAgain() {
		String blank = "";
		assertThrows(IllegalArgumentException.class, () -> numberValidator.isValidPlayAgain(blank));

		String isNotNumeric = "재도전";
		assertThrows(IllegalArgumentException.class, () -> numberValidator.isValidPlayAgain(isNotNumeric));

		String isNotOneOrTwo = "3";
		assertThrows(IllegalArgumentException.class, () -> numberValidator.isValidPlayAgain(isNotOneOrTwo));
	}

	@Test
	void isNotBlankOrNull_false_blank() {
		String test = "";

		boolean actualResult = numberValidator.isNotBlankOrNull(test);

		assertThat(actualResult).isFalse();
	}

	@Test
	void isNotBlankOrNull_false_null() {
		String test = null;

		boolean actualResult = numberValidator.isNotBlankOrNull(test);

		assertThat(actualResult).isFalse();
	}


	@Test
	void isNotBlankOrNull_true() {
		String test = "123";

		boolean actualResult = numberValidator.isNotBlankOrNull(test);

		assertThat(actualResult).isTrue();
	}

	@Test
	void isNumeric_false_String() {
		String test = "나이스";

		boolean actualResult = numberValidator.isNumeric(test);

		assertThat(actualResult).isFalse();
	}

	@Test
	void isNumeric_false_with_Zero() {
		String test = "012";

		boolean actualResult = numberValidator.isNumeric(test);

		assertThat(actualResult).isFalse();
	}

	@Test
	void isNumeric_true() {
		String test = "123";

		boolean actualResult = numberValidator.isNumeric(test);

		assertThat(actualResult).isTrue();
	}

	@Test
	void hasDuplicateNumbers_false() {
		String test = "112";

		boolean actualResult = numberValidator.hasDuplicateNumbers(test);

		assertThat(actualResult).isFalse();
	}

	@Test
	void hasDuplicateNumbers_true() {
		String test = "123";

		boolean actualResult = numberValidator.hasDuplicateNumbers(test);

		assertThat(actualResult).isTrue();
	}

	@Test
	void isStringOfLength3_false_1() {
		String test = "1";

		boolean actualResult = numberValidator.isStringOfLength3(test);

		assertThat(actualResult).isFalse();
	}

	@Test
	void isStringOfLength3_false_2() {
		String test = "7777777";

		boolean actualResult = numberValidator.isStringOfLength3(test);

		assertThat(actualResult).isFalse();
	}

	@Test
	void isStringOfLength3_true() {
		String test = "134";

		boolean actualResult = numberValidator.isStringOfLength3(test);

		assertThat(actualResult).isTrue();
	}

	@Test
	void isOneOrTwo_false() {
		String test = "3";

		boolean actualResult = numberValidator.isOneOrTwo(test);

		assertThat(actualResult).isFalse();
	}

	@Test
	void isOneOrTwo_true() {
		String test = "1";

		boolean actualResult = numberValidator.isOneOrTwo(test);

		assertThat(actualResult).isTrue();
	}
}
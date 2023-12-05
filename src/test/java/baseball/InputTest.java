package baseball;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class InputTest {
	Input input = new Input();
	@Test
	void TestisNotDuplicateWhenUserInputIsDuplicate(){
		String duplicateValue = "111";
		assertThrows(IllegalArgumentException.class, () -> {
			input.isNotDuplicate(duplicateValue);
		});
	}

	@Test
	void testIsNotDuplicateWhenUserInputIsNotDuplicate() {
		String nonDuplicateValue = "123";
		assertDoesNotThrow(() -> {
			input.isNotDuplicate(nonDuplicateValue);
		});
	}

	@Test
	void testIsNumber(){
		String notNumber = "abc";
		assertThrows(IllegalArgumentException.class, () -> {
			input.isNumber(notNumber);
		});
	}
}

package baseball.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class UserInputTest {

	@Test
	void getNumbers() {
		UserInput userInput = spy(new UserInput());
		doReturn("123").when(userInput).getUserInput();
		List<Integer> expectedResult = Arrays.asList(1, 2, 3);

		List<Integer> actualResult = userInput.getNumbers();

		assertThat(expectedResult).isEqualTo(actualResult);
	}

	@Test
	void askToPlayAgain() {
		UserInput userInput = spy(new UserInput());
		doReturn("1").when(userInput).getUserInput();

		boolean actualResult = userInput.askToPlayAgain();

		assertThat(actualResult).isTrue();
	}
}
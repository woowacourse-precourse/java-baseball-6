package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class BallsTest {

	Balls answer;

	@BeforeEach
	public void setUp() {
		answer = Balls.of(List.of(1, 2, 3));
	}

	@Test
	void ballsOfTestWithDuplicateNumbers() {
		List<Integer> numbers = Arrays.asList(1, 2, 2);
		assertThrows(IllegalArgumentException.class, () -> Balls.of(numbers));
	}

	@Test
	void ballsOfTestWithInvalidSize() {
		List<Integer> numbers = Arrays.asList(1, 2);
		assertThrows(IllegalArgumentException.class, () -> Balls.of(numbers));
	}
}
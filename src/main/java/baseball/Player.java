package baseball;

import java.util.Arrays;
import java.util.List;

public class Player {
	public List<Integer> numbers;

	public void init(String numbers) {
		this.numbers = Arrays.stream(numbers.split(""))
							 .map(Integer::parseInt)
							 .toList();
	}
}

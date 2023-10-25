package baseball.domain.computer;

import java.util.HashMap;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerFactory {

	private ComputerFactory() {
		throw new AssertionError();
	}

	public static Computer getInstance(final int size) {
		final Map<Integer, Integer> numbers = new HashMap<>();
		int index = 0;
		while (numbers.size() < size) {
			final int number = Randoms.pickNumberInRange(1, 9);
			if (!numbers.containsKey(number)) {
				numbers.put(number, index);
				index++;
			}
		}
		return new Computer(numbers);
	}
}

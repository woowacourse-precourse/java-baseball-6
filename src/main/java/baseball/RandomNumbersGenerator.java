package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumbersGenerator implements NumbersGenerator {

	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;
	private static final int SIZE_NUMBERS = 3;


	@Override
	public Numbers generateNumbers() {
		List<Integer> numbers = new ArrayList<>();

		while (numbers.size() < SIZE_NUMBERS) {
			Integer number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
			if (!numbers.contains(number)) {
				numbers.add(number);
			}
		}

		return new Numbers(NumberGenerator.generateBall(numbers));
	}
}
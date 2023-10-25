package baseball.global.utils.generator;

import baseball.global.constant.CommonNumberType;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

	private static final int MIN_RANGE_OF_DIGITS = 1;
	private static final int MAX_RANGE_OF_DIGITS = 9;

	@Override
	public List<Integer> generate() {
		List<Integer> numbers = new ArrayList<>();
		while (numbers.size() < CommonNumberType.LENGTH_OF_NUMBERS.getValue()) {
			int randomNumber = getRandomNumber();
			if (!numbers.contains(randomNumber)) {
				numbers.add(randomNumber);
			}
		}
		return numbers;
	}

	private int getRandomNumber() {
		return Randoms.pickNumberInRange(
				MIN_RANGE_OF_DIGITS,
				MAX_RANGE_OF_DIGITS
		);
	}
}

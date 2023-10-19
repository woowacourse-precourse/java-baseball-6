package baseball;

import java.util.List;

public class Validator {
	public void validateBaseballNumber(List<Integer> baseballNumber) {
		int count = (int) baseballNumber.stream()
				.distinct()
				.count();
		if (count != 3) {
			throw new IllegalArgumentException("중복된 숫자가 포함되어 있습니다.");
		}
	}
}

package baseball.domain;

import java.util.List;

public class NumbersValidator {
	public static void validateDuplicateNumber(List<Integer> numbers) {
		if (numbers.size() != numbers.stream().distinct().count()) {
			throw new IllegalArgumentException("숫자는 중복되면 안됩니다.");
		}
	}
}

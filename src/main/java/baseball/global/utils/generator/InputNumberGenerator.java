package baseball.global.utils.generator;

import baseball.global.constant.OutputType;
import baseball.global.utils.ConsoleUtil;
import java.util.List;

public class InputNumberGenerator implements NumberGenerator {

	@Override
	public List<Integer> generate() {
		String input = ConsoleUtil.input();
		try {
			return input.chars()
					.map(Character::getNumericValue)
					.boxed()
					.toList();
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(OutputType.EXCEPTION.getComment());
		}
	}
}

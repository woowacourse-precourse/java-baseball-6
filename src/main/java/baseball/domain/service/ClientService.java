package baseball.domain.service;

import baseball.global.constant.CommonStringType;
import baseball.global.constant.OutputType;
import baseball.global.utils.ConsoleUtil;
import java.util.List;

public class ClientService {

	public List<Integer> getCommonInput() {
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

	public String getRestartInput() {
		String input = ConsoleUtil.input();
		validateRestartInput(input);
		return input;
	}

	private void validateRestartInput(String input) {
		if (!input.equals(CommonStringType.RESTART.getContent()) && !input.equals(
				CommonStringType.FINISH.getContent())) {
			throw new IllegalArgumentException(OutputType.EXCEPTION.getComment());
		}
	}
}

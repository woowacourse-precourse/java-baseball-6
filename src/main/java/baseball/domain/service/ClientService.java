package baseball.domain.service;

import baseball.global.constant.CommonStringType;
import baseball.global.constant.OutputType;
import baseball.global.utils.ConsoleUtil;

public class ClientService {

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

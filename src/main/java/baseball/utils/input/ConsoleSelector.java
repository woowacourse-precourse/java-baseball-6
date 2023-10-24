package baseball.utils.input;

import static java.lang.Boolean.FALSE;

import baseball.exception.argument.NotSupportOptionException;
import baseball.support.EndOptions;
import baseball.utils.validator.InputSizeValidator;
import baseball.utils.converter.NumberSourceConverter;
import baseball.utils.converter.NumbersConverter;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class ConsoleSelector implements Selector {

	private final Long selectNumbersSize;

	public ConsoleSelector(Long selectNumbersSize) {
		this.selectNumbersSize = selectNumbersSize;
	}

	@Override
	public List<Long> selectNumbers() {
		String input = Console.readLine();
		Long source = NumberSourceConverter.from(input);

		List<Long> numbers = NumbersConverter.from(source);

		InputSizeValidator.isSame(selectNumbersSize, (long) numbers.size());

		return numbers;
	}

	@Override
	public Long selectEndOption() {
		String input = Console.readLine();
		Long source = NumberSourceConverter.from(input);
		validateOption(source);

		return source;
	}

	private void validateOption(Long source) {
		if (FALSE.equals(EndOptions.isSupport(source))) {
			throw new NotSupportOptionException();
		}
	}

	@Override
	public Long getSelectNumbersSize() {
		return selectNumbersSize;
	}
}

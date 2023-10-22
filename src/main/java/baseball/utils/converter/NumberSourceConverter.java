package baseball.utils.converter;

import baseball.exception.argument.InputTypeException;
import baseball.exception.state.UtilityClassConstructorException;

public class NumberSourceConverter {

	private NumberSourceConverter() {
		throw new UtilityClassConstructorException();
	}

	public static Long from(String source) {
		try {
			return Long.valueOf(source);
		} catch (NumberFormatException e) {
			throw new InputTypeException();
		}
	}
}

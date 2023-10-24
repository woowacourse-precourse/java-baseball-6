package baseball.support;

import baseball.exception.argument.NotSupportOptionException;
import java.util.Arrays;

public enum EndOptions {
	CONTINUE(1L),
	END(2L);

	private final Long number;

	EndOptions(Long number) {
		this.number = number;
	}

	public static EndOptions valueOf(Long option) {
		for (EndOptions endOptions : EndOptions.values()) {
			if (endOptions.number.equals(option)) {
				return endOptions;
			}
		}
		throw new NotSupportOptionException();
	}

	public Long getNumber() {
		return number;
	}

	public static Boolean isSupport(Long source) {
		return Arrays.stream(EndOptions.values())
				.anyMatch(endOptions -> endOptions.getNumber().equals(source));
	}
}

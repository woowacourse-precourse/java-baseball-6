package baseball.global.utils.generator;

import java.util.Collections;
import java.util.List;

public class IntendedNumberGenerator implements NumberGenerator {

	private final List<Integer> input;

	public IntendedNumberGenerator(List<Integer> input) {
		this.input = input;
	}

	@Override
	public List<Integer> generate() {
		return Collections.unmodifiableList(input);
	}
}

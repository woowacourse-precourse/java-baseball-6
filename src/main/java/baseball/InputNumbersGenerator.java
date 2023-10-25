package baseball;

import java.util.List;

public class InputNumbersGenerator implements NumbersGenerator {
	@Override
	public Numbers generateNumbers() {
		List<Integer> inputNumbers = InputView.selectNumbers();
		return new Numbers(NumberGenerator.generateBall(inputNumbers));
	}
}

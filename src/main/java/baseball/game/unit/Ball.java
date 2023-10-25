package baseball.game.unit;

import java.util.ArrayList;
import java.util.List;

public class Ball {

	private final List<Integer> value;


	public static Ball newBall() {
		return new Ball();
	}

	private Ball() {
		value = new ArrayList<>();
	}

	public void changedValue(
			int firstValue,
			int secondValue,
			int thirdValue) {
		value.clear();
		value.add(firstValue);
		value.add(secondValue);
		value.add(thirdValue);
	}

	public int getValue(int sequence) {
		return value.get(sequence);
	}
}

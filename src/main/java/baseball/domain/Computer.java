package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import baseball.domain.balls.Balls;
import baseball.domain.balls.BallsRule;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

	private final Balls balls;

	public Computer() {
		this.balls = new Balls(new ArrayList<>(createRandomNumbers()));
	}

	private List<Integer> createRandomNumbers() {
		List<Integer> numbers = new ArrayList<>();
		while (needsMoreNumber(numbers)) {
			int randomNumber = createRandomNumber();
			if (canAddRandomNumber(numbers, randomNumber)) {
				numbers.add(randomNumber);
			}
		}
		return List.copyOf(numbers);
	}

	private boolean needsMoreNumber(final List<Integer> numbers) {
		return numbers.size() < BallsRule.BALLS_SIZE.getValue();
	}

	private int createRandomNumber() {
		return Randoms.pickNumberInRange(BallsRule.MIN_NUMBER.getValue(), BallsRule.MAX_NUMBER.getValue());
	}

	private boolean canAddRandomNumber(final List<Integer> numbers, final int randomNumber) {
		return !numbers.contains(randomNumber);
	}

	public Balls getBalls() {
		return balls;
	}

}

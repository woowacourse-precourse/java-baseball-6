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
		while (numbers.size() < BallsRule.BALLS_SIZE.getValue()) {
			int randomNumber = Randoms.pickNumberInRange(
					BallsRule.MIN_NUMBER.getValue(), BallsRule.MAX_NUMBER.getValue());
			if (!numbers.contains(randomNumber)) {
				numbers.add(randomNumber);
			}
		}
		return List.copyOf(numbers);
	}

	public Balls getBalls() {
		return balls;
	}

}

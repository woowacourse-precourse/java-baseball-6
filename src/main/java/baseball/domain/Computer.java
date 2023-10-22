package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

	private static final int SIZE = 3;
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;

	private final Balls balls;

	public Computer() {
		this.balls = new Balls(createRandomNumbers());
	}

	private List<Integer> createRandomNumbers() {
		List<Integer> numbers = new ArrayList<>();
		while (numbers.size() < SIZE) {
			int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
			if (!numbers.contains(randomNumber)) {
				numbers.add(randomNumber);
			}
		}
		return numbers;
	}

	public Balls getBalls() {
		return balls;
	}

}

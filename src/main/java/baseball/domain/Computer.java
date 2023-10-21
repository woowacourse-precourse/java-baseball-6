package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		Set<Integer> randomNumbers = new HashSet<>();
		while (randomNumbers.size() < SIZE) {
			randomNumbers.add(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
		}
		return randomNumbers.stream()
							.toList();

	}

}

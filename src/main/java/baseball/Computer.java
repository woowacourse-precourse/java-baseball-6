package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Computer {
	private List<Integer> answer;

	public Computer() {
		answer = new ArrayList<>();
		while (answer.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!answer.contains(randomNumber)) {
				answer.add(randomNumber);
			}
		}
	}

	public List<Integer> calculateResult(List<Integer> trial) {
		int ballCount = 0;
		int strikeCount = 0;
		for (int i = 0; i < 3; i++) {
			Integer current = trial.get(i);
			if (answer.contains(current)) {
				if (Objects.equals(answer.get(i), current)) {
					strikeCount++;
					continue;
				}
				ballCount++;
			}
		}
		return List.of(ballCount, strikeCount);
	}
}

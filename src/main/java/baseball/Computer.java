package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

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

	public boolean isMisMatch(List<Integer> player) {
		return false;
	}
}
